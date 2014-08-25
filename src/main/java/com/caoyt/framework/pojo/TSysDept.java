package com.caoyt.framework.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 系统部门实体类
 * 
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 下午11:26:18
 */
@Entity
@Table(name="T_SYS_DEPT")
public class TSysDept implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	//上级部门
	private TSysDept parentId;
	
	//部门名称
	private String name;
	
	//名称代码
	private String code;
	
	//部门描述
	private String description;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	//默认级联刷新
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="PARENT_ID")
	public TSysDept getParentId() {
		return parentId;
	}

	public void setParentId(TSysDept parentId) {
		this.parentId = parentId;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
