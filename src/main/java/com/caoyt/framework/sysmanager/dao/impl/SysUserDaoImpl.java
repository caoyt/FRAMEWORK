package com.caoyt.framework.sysmanager.dao.impl;

import org.springframework.stereotype.Repository;

import com.caoyt.framework.base.impl.BaseDaoImpl;
import com.caoyt.framework.pojo.TSysUser;
import com.caoyt.framework.sysmanager.dao.ISysUserDao;

/**
 * 用户DAO实现
 * 
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 下午11:31:20
 */
@Repository
public class SysUserDaoImpl extends BaseDaoImpl<TSysUser> implements ISysUserDao{

	@Override
	public TSysUser getSysUserByNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
