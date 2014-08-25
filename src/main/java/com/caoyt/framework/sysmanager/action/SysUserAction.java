package com.caoyt.framework.sysmanager.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;

import com.caoyt.framework.base.impl.ModelDrivenBaseAction;
import com.caoyt.framework.pojo.TSysUser;
import com.caoyt.framework.sysmanager.service.ISysUserService;

/**
 * 用户Action
 * 
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 下午10:17:05
 */

@Namespace("/sys/user")
@Scope("prototype")
@Action("sysUser")
@Results( {
		@Result(name = "redirect_list", location = "sysUser!list.action", type = "redirectAction"),
		@Result(name = "list", location = "list.jsp", type = "dispatcher")
		
})
public class SysUserAction extends ModelDrivenBaseAction<TSysUser> {

	private static final long serialVersionUID = 1L;

	
	//service
	
	@Resource
	private ISysUserService sysUserService;

	
	
	//property
	
	
	private List<TSysUser> userList;
	

	/**
	 * 返回到增加用户页面
	 * 
	 * @return
	 */
	public String addUI() {

		return "addUI";
	}

	/**
	 * 增加用户处理
	 * 
	 * @return
	 */
	public String addUser() {
		this.model.setRegisterDate(new Date());
		this.model.setIsValid(0);
		this.sysUserService.save(this.model);
		
		return "redirect_list";
	}
	
	
	/**
	 * 用户列表
	 * 
	 * @return
	 */
	public String list(){
		
		this.userList = this.sysUserService.getAll();
		
		return "list";
	}
	

	public String index() {

		System.out.println("=--==index======");

		return "index";
	}

	
	
	public List<TSysUser> getUserList() {
		return userList;
	}

	public void setUserList(List<TSysUser> userList) {
		this.userList = userList;
	}
	

}
