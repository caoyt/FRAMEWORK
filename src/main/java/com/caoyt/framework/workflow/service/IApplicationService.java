package com.caoyt.framework.workflow.service;

import java.util.List;

import com.caoyt.framework.pojo.TApplication;

/**
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 2014-8-21 下午02:11:24
 * 
 * 申请service
 * 
 */
public interface IApplicationService {
	/**
	 * 提交申请
	 * 	1.保存申请信息
	 * 	2.启动流程,开始流转
	 * 
	 * @param application
	 */
	void submit(TApplication application);
	
	
	List<TApplication> getAll();
	
	
	
}
