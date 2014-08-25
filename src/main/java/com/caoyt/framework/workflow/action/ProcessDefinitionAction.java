package com.caoyt.framework.workflow.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;

import com.caoyt.framework.base.impl.BaseAction;
import com.caoyt.framework.workflow.service.IProcessDefinitionService;

/**
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 2014-8-20 上午10:44:24
 * 
 * 流程定义Action
 * 
 */
@Namespace("/workflow/pd")
@Scope("prototype")
@Action("processDefinition")
@Results({
	@Result(name="download",type="stream",params={"inputName","inputStream","contentType","image/png"}),
	@Result(name="addUI",location="addUI.jsp"),
	@Result(name="toList",location="processDefinition!list.action",type="redirectAction"),
	@Result(name="list",location="list.jsp")
})
public class ProcessDefinitionAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	
	//service
	
	@Resource
	private IProcessDefinitionService processDefinitionService;
	
	
	//property
	private List<ProcessDefinition> listPd;
	private File upload;
	private String uploadFileName;
	private String key;
	private String processDefinitionId;
	private InputStream inputStream;
	
	public String addUI(){
		
		return "addUI";
	}
	
	/**
	 * 部署流程定义
	 * 
	 * @return
	 */
	public String deploy(){
		ZipInputStream zipInputStream = null;
		try {
			zipInputStream = new ZipInputStream(new FileInputStream(upload));
			this.processDefinitionService.deploy(zipInputStream);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			try {
				if(null != zipInputStream){
					zipInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return "toList";
	}
	
	/**
	 * 查询最新版本的所有流程定义
	 * @return
	 */
	public String list(){
		
		this.listPd = processDefinitionService.findAllByLastVersion();
		return "list";
	}
	
	
	
	/**
	 * 根据指定的key,删除流程定义
	 * @return
	 */
	public String deleteByKey(){

		try {
			this.processDefinitionService.deleteByKey(URLDecoder.decode(key, "utf8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "toList";
	}
	
	/**
	 * 下载流程图
	 * 
	 * @return
	 */
	public String downloadProcessImage(){
		try {
			inputStream = this.processDefinitionService.getProcessImageResourceAsStream(URLDecoder.decode(processDefinitionId,"utf8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "download";
	}

	
	
	
	//============get/set==============
	public List<ProcessDefinition> getListPd() {
		return listPd;
	}

	public void setListPd(List<ProcessDefinition> listPd) {
		this.listPd = listPd;
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getProcessDefinitionId() {
		return processDefinitionId;
	}

	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}
	
	
	
	
	
	
}
