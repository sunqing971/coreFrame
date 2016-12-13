package com.core.base.dao;

import java.io.Serializable;
import java.util.List;

/**
 * dao 通用操作  
 * @author sunyt 20161212
 * @param <T>
 */
public interface BaseDao<T> {

	public void save(T entity);  
	  
    public void update(T entity);  
  
    public void delete(Serializable id);  
  
    public T findById(Serializable id);  
  
    public List<T> findByHQL(String hql, Object... params);  
    
}
