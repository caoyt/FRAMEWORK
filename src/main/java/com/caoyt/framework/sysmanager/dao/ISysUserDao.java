package com.caoyt.framework.sysmanager.dao;

import com.caoyt.framework.base.IBaseDao;
import com.caoyt.framework.pojo.TSysUser;

/**
 * 用户DAO接口
 * 
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 下午11:15:55
 */
public interface ISysUserDao extends IBaseDao<TSysUser>{
	/**
	 * 根据用户名和密码获取用户对象
	 * 
	 * @param username 用户名
	 * @param password 加密密码
	 * @return
	 */
	public TSysUser getSysUserByNameAndPassword(String username, String password);
	
	
}
