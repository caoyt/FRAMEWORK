package com.caoyt.framework.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统用户与角色中间表
 * 
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 下午10:58:01
 */
@Entity
@Table(name = "T_SYS_USER_ROLE")
public class TSysUserRole implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Long userId;
	
	private Long roleId;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="USER_ID")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name="ROLE_ID")
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	
	
	
}
