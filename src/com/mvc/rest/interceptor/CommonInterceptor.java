package com.mvc.rest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CommonInterceptor implements HandlerInterceptor {

	/**
	 * Controller方法调用之前调用
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object obj) throws Exception {
		System.out.println(">进入拦截");
		return true;
	}

	/**
	 * 在Controller的方法调用之后执行,但是它会在DispatcherServlet进行视图的渲染之前执行，
	 * 也就是说在这个方法中你可以对ModelAndView进行操作
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,Object obj, ModelAndView mav) throws Exception {
		System.out.println(">即将加载视图");
	}

	/**
	 * 该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行， 
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,Object obj, Exception exception) throws Exception {
		System.out.println(">请求完毕");
	}
	
}
