package com.neuedu.XiaoRyi.Servlet;

import com.alibaba.fastjson.JSON;

public class Result {
	
	/**
	 * 状态 
	 */
	private int code;
	
	/**
	 * 传送的数据
	 */
	private Object data;
	
	/**
	 * 传送的附加信息
	 */
	private String message;

	public Result() {
		super();
	}
	
	
	
	public Result(int code, Object data, String message) {
		super();
		this.code = code;
		this.data = data;
		this.message = message;
	}



	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
	
}
