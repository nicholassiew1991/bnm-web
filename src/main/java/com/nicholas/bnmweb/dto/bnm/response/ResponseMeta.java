package com.nicholas.bnmweb.dto.bnm.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ResponseMeta {

	@JsonProperty("total_result")
	private int totalResult;

	@JsonProperty("last_updated")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date lastUpdate;

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
