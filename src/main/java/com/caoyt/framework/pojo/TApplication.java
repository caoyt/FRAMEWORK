package com.caoyt.framework.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 2014-8-21 下午01:27:39
 * 
 *       申请信息
 * 
 */
@Entity
@Table(name="WORKFLOW_T_APPLICATION")
public class TApplication implements Serializable {

	private static final long serialVersionUID = 1L;

	// 申请状态
	public static final String STATUS_RUNNING = "审批中";
	public static final String STATUS_APPROVED = "已通过";
	public static final String STATUS_REJECTED = "未通过";

	private Long id;

	// 申请所是使用的模版
	private TApplicationTemplate applicationTemplate;

	// 审批信息
	private Set<TApproveInfo> approveInfo;

	// 申请人
	private TSysUser sysUser;

	// 标题
	private String title;

	// 申请时间
	private Date applyTime;

	// 文档存储路径
	private String path;

	// 当前状态
	private String status;

	public TApplication() {
	}

	public TApplication(Long id, TApplicationTemplate applicationTemplate,
			Set<TApproveInfo> approveInfo, TSysUser sysUser, String title,
			Date applyTime, String path, String status) {
		this.id = id;
		this.applicationTemplate = applicationTemplate;
		this.approveInfo = approveInfo;
		this.sysUser = sysUser;
		this.title = title;
		this.applyTime = applyTime;
		this.path = path;
		this.status = status;
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

	@ManyToOne
	@JoinColumn(name="APPLICATIONTEMPLATE_ID")
	public TApplicationTemplate getApplicationTemplate() {
		return applicationTemplate;
	}

	public void setApplicationTemplate(TApplicationTemplate applicationTemplate) {
		this.applicationTemplate = applicationTemplate;
	}

	
	@OneToMany(mappedBy="application")
	@OrderBy(value="approveTime ASC") //排序
	public Set<TApproveInfo> getApproveInfo() {
		return approveInfo;
	}

	public void setApproveInfo(Set<TApproveInfo> approveInfo) {
		this.approveInfo = approveInfo;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	public TSysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(TSysUser sysUser) {
		this.sysUser = sysUser;
	}

	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="APPLY_TIME")
	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	@Column(name="PATH")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
