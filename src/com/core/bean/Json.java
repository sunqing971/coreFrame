package com.core.bean;

/**
 * 基础json对象
 * @author Administrator
 */
public class Json {
	
	public static final String SUCCESS="200";
	public static final String ERROR="300";

	private String code="";
	
	private String msg="";
	
	private Object others=null;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getOthers() {
		return others;
	}

	public void setOthers(Object others) {
		this.others = others;
	}
	
	public Json(String code,String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public Json(String code,String msg,Object others){
		this.code = code;
		this.msg = msg;
		this.others = others;
	}
	
}
