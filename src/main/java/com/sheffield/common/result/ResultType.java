package com.sheffield.common.result;

/**
 * http 请求返回状态码
 * 
 * @author caowuchao
 * @since 2018年5月16日
 * @version 1.0
 */
public enum ResultType {

	OK(200, "success"),

	FAILURE(210, "fail");


	private Integer code;
	private String msg;

	ResultType(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer code() {
		return code;
	}

	public String msg() {
		return msg;
	}

}
