package com.caoyt.framework.web.action;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;

import com.caoyt.framework.base.impl.ModelDrivenBaseAction;
import com.caoyt.framework.pojo.TApplicationTemplate;
import com.caoyt.framework.utils.Constant;
import com.caoyt.framework.utils.FileHandlerUtils;
import com.caoyt.framework.web.service.IApplicationTemplateService;
import com.caoyt.framework.workflow.service.IProcessDefinitionService;

/**
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 2014-8-20 下午04:10:16
 * 
 * 模版文件处理Action
 * 
 */
@Namespace("/web/template")
@Scope("prototype")
@Action("appTemplate")
@Results({
	@Result(name="addUI", location="addUI.jsp"),
	@Result(name="toList", location="appTemplate!list.action", type="redirectAction"),
	@Result(name="list", location="list.jsp")
})
public class ApplicationTemplateAction extends ModelDrivenBaseAction<TApplicationTemplate>{

	private static final long serialVersionUID = 1L;

	
	
	//service
	@Resource
	private IApplicationTemplateService applicationTemplateService;
	
	@Resource
	private IProcessDefinitionService processDefinitionService;
	
	
	
	//property
	private List<TApplicationTemplate> appTemplateList;
	private List<ProcessDefinition> pdList;
	private Long appTemplateId;
	
	private File upload;
	private String uploadFileName;
	
	private InputStream inputStream;
	
	
	/**
	 * 跳转到增加页面
	 * @return
	 */
	public String addUI(){
		this.pdList = this.processDefinitionService.findAllByLastVersion();
		return "addUI";
	}
	
	
	/**
	 * 文件上传处理
	 * 
	 * @return
	 */
	public String uploadHandler(){
		// 项目路径
		String realPath = ServletActionContext.getServletContext().getRealPath(File.separator);
		// 保存路径
		String targetFilePath = Constant.ROOT_PATH + File.separator + Constant.TEMPLATE_PATH;
		String result = FileHandlerUtils.uploadFile(upload, uploadFileName, realPath+targetFilePath);
		
		if ("0".equals(result)) {
			System.out.println("=====exception====");
		}else if ("-1".equals(result)) {
			System.out.println("=====not exists======");
		}else{
			System.out.println("=====result file name======");
			
			this.model.setPath(result);
			this.applicationTemplateService.save(this.model);
		}
		
		
		return "toList";
	}
	
	
	/**
	 * 模版列表
	 * 
	 * @return
	 */
	public String list(){
		this.appTemplateList = this.applicationTemplateService.getAll();
		return "list";
	}
	
	
	/**
	 * 删除模版
	 * 
	 * @return
	 */
	public String delTemplate(){
		this.applicationTemplateService.delete(appTemplateId);
		return "toList";
	}
	
	
	/**
	 * 更新模版
	 * @return
	 */
	public String update(){
		
		return "";
	}
	
	
	/**
	 * 下载模版
	 * 
	 * @return
	 */
	public String downloadHandler(){
		
		
		String path = this.applicationTemplateService.getById(Long.valueOf(ServletActionContext.getRequest().getParameter("id"))).getPath();
		
		
		FileHandlerUtils.downloadFile(path);
		
		return null;
	}


	
	
	//==============get/set======================

	public List<TApplicationTemplate> getAppTemplateList() {
		return appTemplateList;
	}


	public void setAppTemplateList(List<TApplicationTemplate> appTemplateList) {
		this.appTemplateList = appTemplateList;
	}


	public Long getAppTemplateId() {
		return appTemplateId;
	}


	public void setAppTemplateId(Long appTemplateId) {
		this.appTemplateId = appTemplateId;
	}


	public List<ProcessDefinition> getPdList() {
		return pdList;
	}


	public void setPdList(List<ProcessDefinition> pdList) {
		this.pdList = pdList;
	}


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


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	
	
}
