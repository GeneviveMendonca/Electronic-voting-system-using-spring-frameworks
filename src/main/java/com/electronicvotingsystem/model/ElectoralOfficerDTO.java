package com.electronicvotingsystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;


@Component
public class ElectoralOfficerDTO extends UserDTO{

	@NotNull
	private String designation;

	public ElectoralOfficerDTO() {
		super();
	}

	private List<VoterRequestDTO> voterRequestDTOs = new ArrayList<>();

	
	public ElectoralOfficerDTO(@NotNull String designation, List<VoterRequestDTO> voterrequests) {
		super();
		this.designation = designation;
		this.voterRequestDTOs = voterrequests;
	}


	public List<VoterRequestDTO> getVoterrequests() {
		return voterRequestDTOs;
	}


	public void setVoterrequests(List<VoterRequestDTO> voterrequests) {
		this.voterRequestDTOs = voterrequests;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "ElectoralOfficer [designation=" + designation + ", voterRequests=" + voterRequestDTOs + "]";
	}

}
