package com.electronicvotingsystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity

public class ElectoralOfficer extends User{


	
	@NotNull
	private String designation;

	public ElectoralOfficer() {
		super();
	}
	@OneToMany
	//@JoinColumn(name = "requestId")
	private List<VoterRequest> voterRequests = new ArrayList<>();

	
	public ElectoralOfficer(@NotNull String designation, List<VoterRequest> voterrequests) {
		super();
		this.designation = designation;
		this.voterRequests = voterrequests;
	}


	public List<VoterRequest> getVoterrequests() {
		return voterRequests;
	}


	public void setVoterrequests(List<VoterRequest> voterrequests) {
		this.voterRequests = voterrequests;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "ElectoralOfficer [designation=" + designation + ", voterRequests=" + voterRequests + "]";
	}



}
