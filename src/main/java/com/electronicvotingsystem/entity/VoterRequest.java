package com.electronicvotingsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="voterrequest")
public class VoterRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestId;

	@NotNull
	private String district;

    @NotNull
	private String applicationStatus;

	public VoterRequest() {
		super();
	}

	public VoterRequest(int requestId, @NotNull String district, @NotNull  String applicationStatus) {
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

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(@NotNull String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	@Override
	public String toString() {
		return "VoterRequest [requestId=" + requestId + ", district=" + district + 
				", applicationStatus=" + applicationStatus + "]";
	}
}
