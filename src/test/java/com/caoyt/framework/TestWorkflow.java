package com.caoyt.framework;

import java.util.List;

import org.jbpm.api.Configuration;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.junit.Test;

public class TestWorkflow {
	
	private ProcessEngine processEngine = Configuration.getProcessEngine();
	
	@Test
	public void deleteAll(){
		//查询出指定key的所有版本的流程定义
		List<ProcessDefinition> list = processEngine.getRepositoryService().createProcessDefinitionQuery()
				.list();
		
		//循环删除指定key的所有版本的流程定义,如果有关联的执行信息,会被同时删除
		for (ProcessDefinition pd : list) {
			processEngine.getRepositoryService().deleteDeploymentCascade(pd.getDeploymentId());
		}
		
		
	}
}
