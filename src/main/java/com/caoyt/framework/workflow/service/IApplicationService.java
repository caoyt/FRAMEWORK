package com.caoyt.framework.workflow.service;

import java.util.List;

import com.caoyt.framework.base.IBaseDao;
import com.caoyt.framework.pojo.TApplication;
import com.caoyt.framework.pojo.TApproveInfo;
import com.caoyt.framework.pojo.TSysUser;
import com.caoyt.framework.pojo.TaskView;

/**
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 2014-8-21 下午02:11:24
 * 
 * 申请service
 * 
 */
public interface IApplicationService extends IBaseDao<TApplication>{
	/**
	 * 提交申请
	 * 	1.保存申请信息
	 * 	2.启动流程,开始流转
	 * 
	 * @param application
	 */
	void submit(TApplication application);
	
	
	List<TApplication> getAll();
	
	
	/**
	 * @param currentLoginUser 当前登录用户
	 * @return 个人任务列表信息
	 */
	List<TaskView> getMyTaskViewList(TSysUser currentLoginUser);
	
	TApplication getById(Long id);
	
	/**
	 * @param approveInfo 审核信息
	 * @param taskId 任务ID
	 */
	void approve(TApproveInfo approveInfo, String taskId);
	
}
