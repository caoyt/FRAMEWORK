package com.caoyt.framework.sysmanager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caoyt.framework.pojo.TSysDept;
import com.caoyt.framework.sysmanager.dao.ISysDeptDao;
import com.caoyt.framework.sysmanager.service.ISysDeptService;

@Service
@Transactional
public class SysDeptServiceImpl implements ISysDeptService{

	@Resource 
	private ISysDeptDao sysDeptDao;

	@Override
	public List<TSysDept> getAll() {
		return this.sysDeptDao.getAll();
	}

	@Override
	public TSysDept getById(Long id) {
		return this.sysDeptDao.getById(id);
	}

	@Override
	public void save(TSysDept sysDept) {
		this.sysDeptDao.save(sysDept);
	}
	
	
	
	
}
