package com.caoyt.framework.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 2014-8-21 下午01:35:17
 * 
 *       审批信息
 * 
 */
@Entity
@Table(name="WORKFLOW_T_APPROVEINFO")
public class TApproveInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	// 审批哪个申请
	private TApplication application;

	// 审批人
	private TSysUser sysUser;

	// 审批时间
	private Date approveTime;

	// 是否通过
	private boolean approval;

	// 审批意见
	private String comment;

	public TApproveInfo() {
	}

	public TApproveInfo(Long id, TApplication application, TSysUser sysUser,
			Date approveTime, boolean approval, String comment) {
		this.id = id;
		this.application = application;
		this.sysUser = sysUser;
		this.approveTime = approveTime;
		this.approval = approval;
		this.comment = comment;
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
	@JoinColumn(name="APPLICATION_ID")
	public TApplication getApplication() {
		return application;
	}

	public void setApplication(TApplication application) {
		this.application = application;
	}

	@ManyToOne
	@JoinColumn(name="USER_ID")
	public TSysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(TSysUser sysUser) {
		this.sysUser = sysUser;
	}

	@Column(name="APPROVE_TIME")
	public Date getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}

	@Column(name="APPROVAL")
	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	@Column(name="COMMENT")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
