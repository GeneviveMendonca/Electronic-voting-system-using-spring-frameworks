package com.electronicvotingsystem.model;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class VoterRequestDTO {


	private int requestId;

	@NotNull
	private String district;


	private String applicationStatus;

	public VoterRequestDTO() {
		super();
	}



	public VoterRequestDTO(int requestId, @NotNull String district, String applicationStatus) {
		super();
		this.requestId = requestId;
		this.district = district;
		this.applicationStatus = applicationStatus;
	}



	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}



	public String isApplicationStatus() {
		return applicationStatus;
	}



	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}



	@Override
	public String toString() {
		return "VoterRequest [requestId=" + requestId + ", district=" + district + 
				", applicationStatus=" + applicationStatus + "]";
	}
}
