package com.caoyt.framework.workflow.action;

import java.io.File;
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
import com.caoyt.framework.pojo.TSysUser;
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
	@Result(name="list", location="list.jsp"),
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
	
	
	private File upload;
	private String uploadFileName;
	
	private String templateId;
	
	private List<TApplication> applicationList;
	
	
	
	
	
	/**
	 * 提交申请页面 
	 */
	public String addUI(){
		
		return "addUI";
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
	
	
	

}
