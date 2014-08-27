package com.caoyt.framework.web.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caoyt.framework.base.impl.BaseDaoImpl;
import com.caoyt.framework.pojo.TApplicationTemplate;
import com.caoyt.framework.web.service.IApplicationTemplateService;

@Service
@Transactional
public class ApplicationTemplateServiceImpl extends BaseDaoImpl<TApplicationTemplate> implements IApplicationTemplateService{
	
}
