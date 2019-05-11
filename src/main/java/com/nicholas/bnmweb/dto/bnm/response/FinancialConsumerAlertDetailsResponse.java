package com.nicholas.bnmweb.dto.bnm.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class FinancialConsumerAlertDetailsResponse {

	private String name;

	@JsonProperty("regisration_number")
	private String registrationNo;

	@JsonProperty("added_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date addedDate;

	private List<String> websites;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public List<String> getWebsites() {
		return websites;
	}

	public void setWebsites(List<String> websites) {
		this.websites = websites;
	}
}
