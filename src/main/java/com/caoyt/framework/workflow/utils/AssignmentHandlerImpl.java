package com.caoyt.framework.workflow.utils;

import java.util.Map;

import org.jbpm.api.model.OpenExecution;
import org.jbpm.api.task.Assignable;
import org.jbpm.api.task.AssignmentHandler;

/**
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 2014-8-21 下午05:48:06
 * 
 * 办理人处理
 * 
 */
public class AssignmentHandlerImpl implements AssignmentHandler{

	private static final long serialVersionUID = 1L;

	@Override
	public void assign(Assignable assignable, OpenExecution execution)
			throws Exception {
		
		Map<String, Object> variables = (Map<String, Object>) execution.getProcessInstance().getVariables();
		//获取流程变量
		String current_user_loginName = (String) variables.get("current_user_loginName");
		String parent_user_loginName = null;
		if("zs".equals(current_user_loginName)){
			parent_user_loginName = "ls";
			assignable.setAssignee(parent_user_loginName);
			variables.put("current_user_loginName", parent_user_loginName);
		}
		
		if("ls".equals(current_user_loginName)){
			parent_user_loginName = "zl";
			assignable.setAssignee(parent_user_loginName);
			variables.put("current_user_loginName", parent_user_loginName);
		}
		
		
		
		
	}
	

}
