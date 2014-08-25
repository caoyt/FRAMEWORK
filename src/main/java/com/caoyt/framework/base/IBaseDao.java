package com.caoyt.framework.base;

import java.util.List;

/**
 * DAO的公共接口
 * 
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 下午10:56:57
 */
public interface IBaseDao<T> {
	/**
	 * 保存
	 * 
	 * @param entity 实体对象
	 */
	void save(T entity);

	/**
	 * 根据ID删除对象
	 * 
	 * @param id 记录ID
	 */
	void delete(Long id);

	/**
	 * 更新
	 * 
	 * @param entity 实体对象
	 */
	void update(T entity);

	/**
	 * 根据ID获取对象
	 * 
	 * @param id 记录ID
	 */
	T getById(Long id);

	/**
	 * 根据多个ID的值获取多个对象
	 * 
	 * @param ids 多个id
	 * @return 集合
	 */
	List<T> getByIds(Long[] ids);

	/**
	 * @return 所有
	 */
	List<T> getAll();
}
