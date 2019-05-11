package com.nicholas.bnmweb.dto.bnm.response;

import java.util.List;

public class FinancialConsumerAlertResponse extends BaseResponse {

	private List<FinancialConsumerAlertDetailsResponse> data;

	public List<FinancialConsumerAlertDetailsResponse> getData() {
		return data;
	}

	public void setData(List<FinancialConsumerAlertDetailsResponse> data) {
		this.data = data;
	}
}
