package com.caoyt.framework.sysmanager.service;

import java.util.List;

import com.caoyt.framework.pojo.TSysUser;

public interface ISysUserService {
	
	void save(TSysUser sysUser);
	
	TSysUser sysUser(Long id);
	
	List<TSysUser> getAll();
	
	TSysUser getById(Long id);
}
