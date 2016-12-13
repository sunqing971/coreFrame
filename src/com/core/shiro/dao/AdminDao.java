package com.core.shiro.dao;

import java.io.Serializable;

import com.core.base.dao.BaseDao;
import com.core.shiro.entity.Admin;

public interface AdminDao extends BaseDao<Admin>{
	public Admin findByLoginname(String loginName);  
}
