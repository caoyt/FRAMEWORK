package com.caoyt.framework.workflow.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caoyt.framework.pojo.TApplication;
import com.caoyt.framework.workflow.dao.IApplicationDao;
import com.caoyt.framework.workflow.service.IApplicationService;

/**
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 2014-8-21 下午03:07:25
 * 
 *       申请service
 * 
 */
@Service
@Transactional
public class ApplicationServiceImpl implements IApplicationService {

	@Resource
	private IApplicationDao applicationDao;

	@Resource
	private ProcessEngine processEngine;

	@Override
	public void submit(TApplication application) {
		// 申请时间
		application.setApplyTime(new Date());

		// 标题的格式为：{模板名称}_{申请人姓名}_{申请时间}
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		application.setTitle(application.getApplicationTemplate().getName()
				+ "_" + application.getSysUser().getName() + "_"
				+ dateFormat.format(application.getApplyTime()));

		// 申请状态
		application.setStatus(TApplication.STATUS_RUNNING);

		applicationDao.save(application);

		// 工作流
		String key = application.getApplicationTemplate().getProcessDefinitionKey();

		// 流程变量
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("application", application);
		variables.put("current_user_loginName", application.getSysUser().getLoginName());

		// 启动流程实例
		ProcessInstance pi = this.processEngine.getExecutionService().startProcessInstanceByKey(key,variables);

		// 提交申请
		Task task = this.processEngine.getTaskService().createTaskQuery()//
				.processInstanceId(pi.getId()) // 查询出本流程实例中当前仅有的一个任务“提交申请”
				.uniqueResult();
		this.processEngine.getTaskService().completeTask(task.getId());
	}

	@Override
	public List<TApplication> getAll() {
		return this.applicationDao.getAll();
	}

	
	
	
	
}
