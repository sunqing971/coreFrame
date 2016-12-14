package com.core.shiro.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.StringUtils;

import com.core.shiro.dao.AdminDao;
import com.core.shiro.entity.Admin;

public class SystemRealm extends AuthorizingRealm {

	@Resource  
	private AdminDao adminDao;  
	 
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**  
	  * 登录验证  
	  */ 
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		 System.out.println(">>>shiro token:"+authcToken+"<");
		//令牌——基于用户名和密码的令牌    
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;    
        //令牌中可以取出用户名  
        String accountName = token.getUsername();  
        //让shiro框架去验证账号密码  
        if(!StringUtils.isEmpty(accountName)){  
            Admin admin = adminDao.findByLoginname(accountName);  
            if(admin != null){  
            	return new SimpleAuthenticationInfo(admin.getLoginname(), admin.getPwd(), getName());  
            }  
        }  
		return null;
	}

}
