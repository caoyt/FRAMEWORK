package com.caoyt.framework.workflow.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.caoyt.framework.base.impl.BaseDaoImpl;
import com.caoyt.framework.pojo.TApplication;
import com.caoyt.framework.pojo.TApproveInfo;
import com.caoyt.framework.pojo.TSysUser;
import com.caoyt.framework.pojo.TaskView;
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
public class ApplicationServiceImpl extends BaseDaoImpl<TApplication> implements IApplicationService {

	@Resource
	private IApplicationDao applicationDao;

	@Resource
	private ProcessEngine processEngine;

	@Override
	public void submit(TApplication application) {
		// 申请时间
		application.setApplyTime(new Date());

		// 标题的格式为：{模板名称}_{申请人姓名}_{申请时间}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		application.setTitle(application.getApplicationTemplate().getName() // 
				+ "_" + application.getSysUser().getName() // 
				+ "_" + dateFormat.format(application.getApplyTime()));

		// 申请状态
		application.setStatus(TApplication.STATUS_RUNNING);

		//保存申请信息
		applicationDao.save(application);

		// 工作流
		//获取模版中保存的流程定义的key
		String key = application.getApplicationTemplate().getProcessDefinitionKey();

		// 设置流程变量
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("application", application);
//		variables.put("current_complete_loginName", application.getSysUser().getLoginName());
		

		// 启动流程实例
		ProcessInstance pi = this.processEngine.getExecutionService().startProcessInstanceByKey(key, variables);

		
		// 办理第一个任务---提交申请
		Task task = this.processEngine.getTaskService().createTaskQuery()//
				.processInstanceId(pi.getId()) // 查询出本流程实例中当前仅有的一个任务“提交申请”
				.uniqueResult();
		this.processEngine.getTaskService().completeTask(task.getId());
	}

	@Override
	public List<TApplication> getAll() {
		return this.applicationDao.getAll();
	}

	@Override
	public List<TaskView> getMyTaskViewList(TSysUser currentLoginUser) {

		// 查询个人任务列表
		String userId = currentLoginUser.getLoginName(); // 约定：使用loginName作为JBPM的用户标识符
		List<Task> taskList = this.processEngine.getTaskService().findPersonalTasks(userId);

		// 找出每个任务对应的申请信息
		List<TaskView> resultList = new ArrayList<TaskView>();
		for (Task task : taskList) {
			TApplication application = (TApplication) this.processEngine.getTaskService().getVariable(task.getId(), "application");
			resultList.add(new TaskView(task, application));
		}

		return resultList;
	}
	
	
	@Override
	public void approve(TApproveInfo approveInfo, String taskId) {
		
		//保存审核信息
		getSession().save(approveInfo);
		
		
		//办理任务,并维护申请状态
		Task task = this.processEngine.getTaskService().getTask(taskId); //一定要先取出任务,再完成任务,否则拿不到任务(历史任务)
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("taskId", taskId);
		variables.put("approveInfo", approveInfo);
		
		this.processEngine.getTaskService().setVariables(taskId, variables);
		
		//办理任务
		this.processEngine.getTaskService().completeTask(taskId);
		
		//获取所属的流程实例,如果取不到,代表流程已经结束
		ProcessInstance pi = this.processEngine.getExecutionService().findProcessInstanceById(task.getExecutionId());
		
		TApplication application = approveInfo.getApplication();
		
		
		/**
		 	业务分析：
		 		1.是否同意
		 			1.1不同意：判断是否是最后一个节点
		 				如果不是最后一个节点，那么直接结束流程实例，并维护申请信息状态--不通过；
		 				如果是最后一个节点，维护申请信息就可以了，避免重复结束流程实例--不通过
		 				
		 			1.2同意：判断是否是最后一个节点，
		 				如果是最后一个节点，维护申请信息状态--通过
		 				如果不是最后一个节点，不用管，让其继续执行
		 	
		 
		 */
		
		if(!approveInfo.isApproval()){
			//不同意
			if(null != pi){
				//不是最后一个节点
				this.processEngine.getExecutionService().endProcessInstance(task.getExecutionId(), ProcessInstance.STATE_ENDED);
			}
			application.setStatus(TApplication.STATUS_REJECTED);
		}else{
			//同意
			if(null == pi){
				application.setStatus(TApplication.STATUS_APPROVED);
			}
		}
		
		getSession().update(application);
		
		
	}
	
	

	@Override
	public TApplication getById(Long id) {
		return this.applicationDao.getById(id);
	}

	

}
