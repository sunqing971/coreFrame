package com.core.shiro.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.core.base.dao.impl.BaseDaoImpl;
import com.core.shiro.dao.AdminDao;
import com.core.shiro.entity.Admin;

@Repository(value = "adminDao")  
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao{

	@Override
	public Admin findByLoginname(String loginName) {
		String hql=" from Admin where loginname=? ";
		Query query=getSession().createQuery(hql);
		query.setString(0, loginName); 
		List<Admin> list=query.list();
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
