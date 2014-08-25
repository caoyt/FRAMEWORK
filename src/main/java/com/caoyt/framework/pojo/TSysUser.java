package com.caoyt.framework.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 系统用户实体类
 * 
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 下午10:52:24
 */
@Entity
@Table(name = "T_SYS_USER")
public class TSysUser implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	//用户真实姓名
	private String name;
	
	//登录名
	private String loginName;
	
	//密码
	private String password;
	
	//性别
	private Integer gender;
	
	//手机号
	private String phoneNumber;
	
	//邮箱
	private String email;

	//描述
	private String description;
	
	//注册时间
	private Date registerDate;
	
	//是否有效
	private Integer isValid;

	public TSysUser() {
	}

	public TSysUser(String name, String loginName, String password,
			Integer gender, String phoneNumber, String email,
			String description, Date registerDate, Integer isValid) {
		this.name = name;
		this.loginName = loginName;
		this.password = password;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.description = description;
		this.registerDate = registerDate;
		this.isValid = isValid;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID",nullable = false)
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

	@Column(name = "LOGIN_NAME")
	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "GENDER")
	public Integer getGender() {
		return gender;
	}


	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(name = "PHONE_NUMBER")
	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "REGISTER_DATE")
	@Temporal(TemporalType.DATE)
	public Date getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Column(name = "IS_VALID")
	public Integer getIsValid() {
		return isValid;
	}


	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	
}
