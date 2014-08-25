package com.caoyt.framework.base.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.caoyt.framework.base.IBaseDao;


/**
 * 公共接口实现类
 * 
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 下午11:27:17
 * @param <T> BaseDaoImpl传过来什么类型的IBaseDao中的方法就用什么类型的
 */
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements IBaseDao<T>{

	@Resource 
	private SessionFactory sessionFactory;
	
	protected Class<T> clazz;
	
	
	
	public BaseDaoImpl() {
		//通过反射得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) pt.getActualTypeArguments()[0];

	}

	public void save(T entity) {
		this.getSession().save(entity);
	}

	public void delete(Long id) {
		Object obj = this.getById(id);
		this.getSession().delete(obj);
	}

	public void update(T entity) {
		this.getSession().update(entity);
	}

	public T getById(Long id) {
		
		if(null == id){
			return null;
		}
		
		return (T)this.getSession().get(clazz, id);
	}

	public List<T> getByIds(Long[] ids) {
		
		if(null == ids || ids.length == 0){
//			return null; 如何需要返回null，并且返回类型为集合的时候，不要直接返回null，
//			因为这样的话，调用此方法在判断是否为null的时候需要做两个步骤，判断是否为null和.size()是否大于0
//			return new ArrayList<T>();  这样的写还得创建一个对象
			return Collections.EMPTY_LIST;
		}
		
		return this.getSession()
		.createQuery("FROM " + clazz.getSimpleName() + " WHERE ID IN (:ids)")
		.setParameterList("ids", ids)
		.list();
	}

	
	public List<T> getAll() {
		return this.getSession().createQuery("FROM " + clazz.getSimpleName()).list();
	}
	
	/**
	 * @return 获取当前可用的session对象
	 */
	protected Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}

}
