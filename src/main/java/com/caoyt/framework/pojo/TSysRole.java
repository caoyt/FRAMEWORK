package com.caoyt.framework.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统角色实体类
 * 
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 下午10:52:51
 */
@Entity
@Table(name = "T_SYS_ROLE")
public class TSysRole implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	//角色名称
	private String name;
	
	//角色代码
	private String code;
	
	//创建时间
	private Date createDate;
	
	//描述
	private String description;
	
	

	public TSysRole() {
	}

	public TSysRole(Long id, String name, String code, Date createDate,
			String description) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.createDate = createDate;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
