package com.caoyt.framework.workflow.service;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.jbpm.api.ProcessDefinition;

/**
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 2014-8-20 上午10:52:09
 * 
 * 流程定义Service
 * 
 */
public interface IProcessDefinitionService {
	
	/**
	 * 部署流程
	 * @param zipInputStream zip文件流
	 */
	void deploy(ZipInputStream zipInputStream);
	
	/**
	 * @return 获取所有最新版本的流程定义
	 */
	List<ProcessDefinition> findAllByLastVersion();
	
	/**
	 * 删除流程定义
	 * 
	 * @param key
	 */
	void deleteByKey(String key);
	
	/**
	 * @param processDefintionId 流程定义ID
	 * @return 流程图
	 */
	InputStream getProcessImageResourceAsStream(String processDefintionId);
}
