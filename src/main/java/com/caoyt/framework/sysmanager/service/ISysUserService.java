package com.caoyt.framework.sysmanager.service;

import java.util.List;

import com.caoyt.framework.pojo.TSysUser;

public interface ISysUserService {
	
	void save(TSysUser sysUser);
	
	TSysUser getById(Long id);
	
	List<TSysUser> getAll();
}
