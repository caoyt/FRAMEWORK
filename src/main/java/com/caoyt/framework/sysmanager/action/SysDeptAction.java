package com.caoyt.framework.sysmanager.action;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;

import com.caoyt.framework.base.impl.ModelDrivenBaseAction;
import com.caoyt.framework.pojo.TSysDept;
import com.caoyt.framework.sysmanager.service.ISysDeptService;

/**
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 2014-8-19 下午04:48:44
 * 
 *       部门Action
 * 
 */
@Namespace("/sys/dept")
@Scope("prototype")
@Action("sysDept")
@Results( { 
	@Result(name = "addui", location = "addUI.jsp") ,
	@Result(name = "list", location = "list.jsp") ,
	@Result(name = "redirect_list", location = "sysDept!list.action", type = "redirectAction") 
})
public class SysDeptAction extends ModelDrivenBaseAction<TSysDept> {

	private static final long serialVersionUID = 1L;

	@Resource
	private ISysDeptService sysDeptService;
	
	
	private List<TSysDept> deptList;
	
	private Long parent_id;
	

	public String addUI() {

		return "addui";
	}

	public String addDept() {
		TSysDept sysDept = this.sysDeptService.getById(this.parent_id);
		this.model.setParentId(sysDept);
		this.sysDeptService.save(this.model);
		
		
		return "redirect_list";
	}
	
	public String list(){
		
		this.deptList = this.sysDeptService.getAll();
		
		
		
		return "list";
	}

	public List<TSysDept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<TSysDept> deptList) {
		this.deptList = deptList;
	}

	public Long getParent_id() {
		return parent_id;
	}

	public void setParent_id(Long parentId) {
		parent_id = parentId;
	}

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString().replace('-', '0'));
	}
}
