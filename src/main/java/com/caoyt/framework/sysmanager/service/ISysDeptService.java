package com.caoyt.framework.sysmanager.service;

import java.util.List;

import com.caoyt.framework.pojo.TSysDept;

public interface ISysDeptService {
	void save(TSysDept sysDept);
	
	TSysDept getById(Long id);
	
	List<TSysDept> getAll();
}
