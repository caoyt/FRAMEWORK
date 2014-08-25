package com.caoyt.framework.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 2014-8-20 下午03:56:20
 * 
 *       申请模版
 * 
 */
@Entity
@Table(name="WORKFLOW_T_APPLICATION_TEMPLATE")
public class TApplicationTemplate implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	// 文件显示名称
	private String name;
	// 流程定义key
	private String processDefinitionKey;
	// 文件路径
	private String path;

	public TApplicationTemplate() {
	}

	public TApplicationTemplate(Long id, String name,
			String processDefinitionKey, String path) {
		this.id = id;
		this.name = name;
		this.processDefinitionKey = processDefinitionKey;
		this.path = path;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="PROCESS_DEFINITION_KEY")
	public String getProcessDefinitionKey() {
		return processDefinitionKey;
	}

	public void setProcessDefinitionKey(String processDefinitionKey) {
		this.processDefinitionKey = processDefinitionKey;
	}

	@Column(name="PATH")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
