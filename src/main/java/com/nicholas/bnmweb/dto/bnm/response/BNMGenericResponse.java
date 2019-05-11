package com.nicholas.bnmweb.dto.bnm.response;

public class BNMGenericResponse<T> {

	private Integer code;

	private String message;

	private ResponseMeta meta;

	private T data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseMeta getMeta() {
		return meta;
	}

	public void setMeta(ResponseMeta meta) {
		this.meta = meta;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
