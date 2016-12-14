package com.core.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.bean.Json;

@Controller 
public class ShiroAction {

	@ResponseBody
	@RequestMapping("loginin")  
    public Json login(HttpServletRequest request){  
         //当前Subject    
         Subject currentUser = SecurityUtils.getSubject();    
         //加密（md5+盐），返回一个32位的字符串小写  
         String salt="("+request.getParameter("loginname")+")";    
         String md5Pwd=new Md5Hash(request.getParameter("pwd"),salt).toString();  
         //传递token给shiro的realm  
         UsernamePasswordToken token = new UsernamePasswordToken(request.getParameter("loginname"),md5Pwd);    
         Json json=new Json(Json.ERROR,"失败");
         try {   
        	 json=new Json(Json.SUCCESS,"成功");
        	 //用户认证
             currentUser.login(token);   
             return json;  
         } catch (AuthenticationException e) {//登录失败    
        	 json=new Json(Json.ERROR,"失败");
        	 System.out.println("登录失败:");
        	 e.printStackTrace();
         }   
         return json;  
    }  
	
    @RequestMapping("toLogin")  
    public String toLogin(){  
    	System.out.println(">>>>>>>>>>>>tologin");
    	return "login";  
    }
    
}
