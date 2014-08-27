package com.caoyt.framework.sysmanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caoyt.framework.pojo.TSysUser;
import com.caoyt.framework.sysmanager.dao.ISysUserDao;
import com.caoyt.framework.sysmanager.service.ISysUserService;

@Service
@Transactional
public class SysUserServiceImpl implements ISysUserService{

	@Resource 
	private ISysUserDao sysUserDao;
	
	@Override
	public void save(TSysUser sysUser) {
		
		this.sysUserDao.save(sysUser);
	}

	@Override
	public TSysUser getById(Long id) {
		return this.sysUserDao.getById(id);
	}

	@Override
	public List<TSysUser> getAll() {

		return this.sysUserDao.getAll();
	}

	@Override
	public TSysUser sysUser(Long id) {
		return null;
	}

	
	
}
