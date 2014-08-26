package com.caoyt.framework.base.impl;

import java.lang.reflect.ParameterizedType;

import com.caoyt.framework.pojo.TSysUser;
import com.caoyt.framework.utils.Constant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author caoyt(曹颖桐)
 * @param <T>
 * @email caoyingtong@41zone.cc
 * @date 2014-8-5 下午9:26:39
 * 
 *       action基础类
 * 
 */
public class ModelDrivenBaseAction<T> extends BaseAction implements ModelDriven<T> {

	private static final long serialVersionUID = 1L;
	
	protected T model = null;
	

	public ModelDrivenBaseAction() {
		
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class clazz = (Class) pt.getActualTypeArguments()[0];
		
		try {
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public T getModel() {
		return model;
	}

	
	/**
	 * @return 当前登录用户
	 */
	public TSysUser getCurrentUser(){
		return (TSysUser) ActionContext.getContext().getSession().get(Constant.USER);
	}

	
	
}
