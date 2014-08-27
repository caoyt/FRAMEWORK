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
		
		/**
		 	业务分析：
		 		1.获取流程变量，获取“当前办理人”变量
		 			1.1如果为null,代表是启动流程实例的时候调用了此方法,那么设置“当前办理人”流程变量和设置办理人为当前登录用户
		 			1.2如果不为null,就代表是在执行“办理任务”的时候调用了此方法
		 				1.2.1办理任务的时候执行此方法的时候,需要获取“当前办理人”流程变量的值,然后据此获取这个用户的上级领导
		 					然后设置为办理人和设置“当前办理人”流程变量
		 		2.最后保存流程变量
		 
		 */
		
		

		Map<String, Object> variables = (Map<String, Object>) execution.getVariables();
		
		//获取流程变量
		String current_complete_loginName = (String) variables.get("current_complete_loginName");
		String parent_user_loginName = null;
		
		if(null == current_complete_loginName || "".equals(current_complete_loginName)){
			//当前登录用户
			parent_user_loginName = "zs";
			assignable.setAssignee(parent_user_loginName);
			variables.put("current_complete_loginName", parent_user_loginName);
		}else if("zs".equals(current_complete_loginName)){
			parent_user_loginName = "ls";
			assignable.setAssignee(parent_user_loginName);
			variables.put("current_complete_loginName", parent_user_loginName);
		}else if("ls".equals(current_complete_loginName)){
			parent_user_loginName = "zl";
			assignable.setAssignee(parent_user_loginName);
			variables.put("current_complete_loginName", parent_user_loginName);
		}
		
		
		
		execution.setVariables(variables);
		
		
		
 	}
	

}
