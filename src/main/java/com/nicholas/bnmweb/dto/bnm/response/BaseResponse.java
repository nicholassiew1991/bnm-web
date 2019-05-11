package com.nicholas.bnmweb.dto.bnm.response;

public abstract class BaseResponse {

	private Integer code;

	private String message;

	private ResponseMeta meta;

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
}
