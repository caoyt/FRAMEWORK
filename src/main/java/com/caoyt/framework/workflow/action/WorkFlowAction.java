package com.caoyt.framework.workflow.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;

import com.caoyt.framework.base.impl.BaseAction;
import com.caoyt.framework.pojo.TApplication;
import com.caoyt.framework.pojo.TApplicationTemplate;
import com.caoyt.framework.pojo.TApproveInfo;
import com.caoyt.framework.pojo.TSysUser;
import com.caoyt.framework.pojo.TaskView;
import com.caoyt.framework.sysmanager.service.ISysUserService;
import com.caoyt.framework.utils.Constant;
import com.caoyt.framework.utils.FileHandlerUtils;
import com.caoyt.framework.web.service.IApplicationTemplateService;
import com.caoyt.framework.workflow.service.IApplicationService;


/**
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 2014-8-21 下午02:07:42
 * 
 * 流程处理action
 * 
 */
@Namespace("/workflow/handler")
@Scope("prototype")
@Action("workflow")
@Results({
	@Result(name="addUI", location="addUI.jsp"),
	@Result(name="approveUI", location="approveUI.jsp"),
	@Result(name="list", location="list.jsp"),
	@Result(name="myTaskList", location="myTaskList.jsp"),
	@Result(name="toMyTaskList", location="workflow!myTaskList.action", type="redirectAction"),
	@Result(name="toList", location="workflow!myApplicationList.action", type="redirectAction")
})
public class WorkFlowAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	
	//service
	@Resource
	private ISysUserService sysUserService;
	
	@Resource
	private IApplicationTemplateService applicationTemplateService;
	
	@Resource
	private IApplicationService applicationService;
	
	
	
	
	//property
	private File upload;
	private String uploadFileName;
	
	private String templateId;
	
	private List<TApplication> applicationList;
	
	private List<TaskView> taskView;
	
	
	private Long applicationId;
	private String taskId;
	private boolean approval;
	private String comment;
	
	
	
	/**
	 * 提交申请页面 
	 */
	public String addUI(){
		
		return "addUI";
	}
	
	/**
	 * 审批处理页面 
	 */
	public String approveUI(){
		
		return "approveUI";
	}
	
	/**
	 * 提交申请
	 */
	public String submit(){

		String root = ServletActionContext.getServletContext().getRealPath(File.separator);
		
		String targetFilePath = root + Constant.APPLY_FILE_PATH;
		
		String result = FileHandlerUtils.uploadFile(this.upload, this.uploadFileName, targetFilePath);
		if("-1".equals(result)){
			System.out.println("======文件不存在=======");
		}else if ("0".equals(result)) {
			System.out.println("=======exception=======");
		}else{
			TSysUser sysUser = sysUserService.getById(7L);
			
			//获取申请所用的模版
			TApplicationTemplate applicationTemplate = applicationTemplateService.getById(Long.valueOf(templateId));
			
			TApplication application = new TApplication();
			application.setSysUser(sysUser); //实际中这里是获取当前登录的用户
			application.setApplicationTemplate(applicationTemplate); //设置当前申请所使用的模版
			application.setPath(result);
			
			applicationService.submit(application);
		}
		
		return "toList";
	}
	
	
	/**
	 * 我的申请列表 
	 */
	public String myApplicationList(){
		
		this.applicationList = this.applicationService.getAll();
		
		return "list";
	}
	

	/**
	 * 待我审批(我的任务列表)
	 */
	public String myTaskList(){
		TSysUser sysUser = this.sysUserService.getById(8L);
		this.taskView = this.applicationService.getMyTaskViewList(sysUser);
		
		return "myTaskList";
	}
	
	/**
	 * 审批任务 
	 */
	public String approveHandler(){
		
		System.out.println("approval-->"+approval);
		System.out.println("taskId-->"+taskId);
		
		TSysUser sysUser = this.sysUserService.getById(8L);
		TApplication application = this.applicationService.getById(applicationId);
		
		TApproveInfo approveInfo = new TApproveInfo();
		approveInfo.setApproval(approval);
		approveInfo.setApproveTime(new Date());
		approveInfo.setComment(comment);
		approveInfo.setSysUser(sysUser); //设置当前登录用户
		approveInfo.setApplication(application);
		
		//审批
		this.applicationService.approve(approveInfo, taskId);
		
		
		return "toMyTaskList";
	}
	
	
	//===============get/set===============

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public List<TApplication> getApplicationList() {
		return applicationList;
	}

	public void setApplicationList(List<TApplication> applicationList) {
		this.applicationList = applicationList;
	}

	public List<TaskView> getTaskView() {
		return taskView;
	}

	public void setTaskView(List<TaskView> taskView) {
		this.taskView = taskView;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	

}
