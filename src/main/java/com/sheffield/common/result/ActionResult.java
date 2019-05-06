package com.sheffield.common.result;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;


/**
 * Interface return value encapsulation
 *
 */
public class ActionResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/** status code */
	private int code;
	/** message */
	private String message;
	/** data */
	private T data;

	private ActionResult(Builder<T> builder) {
		this.code = builder.code;
		this.message = builder.message;
		this.data = builder.data;
	}

	public ActionResult() {
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean successful() {
		return ResultType.OK.code().equals(code);
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

	public static class Builder<T> {
		/** status code */
		private int code;
		/** message */
		private String message;
		/** data */
		private T data;
		
		public Builder() {}

		public Builder<T> code(int code) {
			this.code = code;
			return this;
		}

		public Builder<T> message(String message) {
			this.message = message;
			return this;
		}

		public Builder<T> data(T data) {
			this.data = data;
			return this;
		}

		public Builder<T> resultType(ResultType resultType) {
			this.code = resultType.code();
			this.message = resultType.msg();
			return this;
		}

		public ActionResult<T> build() {
			initDefaultValue(this);
			return new ActionResult<>(this);
		}

		private void initDefaultValue(Builder<T> builder) {
			if (builder.code == 0) {
				builder.code = ResultType.OK.code();
			}
			if (builder.message == null) {
				builder.message = ResultType.OK.msg();
			}
		}
	}

}
