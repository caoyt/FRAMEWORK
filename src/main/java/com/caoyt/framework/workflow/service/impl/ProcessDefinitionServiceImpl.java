package com.caoyt.framework.workflow.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessEngine;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caoyt.framework.workflow.service.IProcessDefinitionService;

@Service
@Transactional
public class ProcessDefinitionServiceImpl implements IProcessDefinitionService{

	@Resource 
	private ProcessEngine processEngine;
	
	

	@Override
	public void deploy(ZipInputStream zipInputStream) {
		//部署流程定义
		this.processEngine.getRepositoryService()
			.createDeployment()
			.addResourcesFromZipInputStream(zipInputStream)
			.deploy();
	}

	
	@Override
	public void deleteByKey(String key) {
		//根据指定的key获取所有相关的流程定义
		List<ProcessDefinition> list = this.processEngine.getRepositoryService().createProcessDefinitionQuery()
			.processDefinitionKey(key)
			.list();
		
		//根据每个流程定义的部署对象ID删除流程定义及关联信息
		for (ProcessDefinition pd : list) {
			this.processEngine.getRepositoryService().deleteDeploymentCascade(pd.getDeploymentId());
		}
		
	}

	@Override
	public List<ProcessDefinition> findAllByLastVersion() {
		//获取所有的流程定义,根据version排序,把最新的版本放到最后面
		List<ProcessDefinition> list = this.processEngine.getRepositoryService()
			.createProcessDefinitionQuery()
			.orderAsc(ProcessDefinitionQuery.PROPERTY_VERSION)
			.list();
		
		//把流程定义放到map中,这样相同的key只有一个值(最后加入的那个,也就是最新版本的)
		Map<String, ProcessDefinition> map = new HashMap<String, ProcessDefinition>();
		
		for (ProcessDefinition pd : list) {
			map.put(pd.getKey(), pd);
		}
		
		return new ArrayList<ProcessDefinition>(map.values());
		
	}

	@Override
	public InputStream getProcessImageResourceAsStream(String processDefinitionId) {
		
		//查询出对应的流程定义
		ProcessDefinition pd = this.processEngine.getRepositoryService().createProcessDefinitionQuery()
			.processDefinitionId(processDefinitionId)
			.uniqueResult();
		
		
		//根据流程定义获取流程部署对象ID和图片资源名称
		return this.processEngine.getRepositoryService().getResourceAsStream(pd.getDeploymentId(), pd.getImageResourceName());
		
	}

}
