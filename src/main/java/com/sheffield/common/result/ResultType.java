package com.sheffield.common.result;

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
