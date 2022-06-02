package com.electronicvotingsystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
@Component
public class ElectionDTO {
	
	private int electionId;

	@NotNull
	private String electionName;

	@NotNull
	private String state;

	@NotNull
	private List<CandidateDTO> candidateDTOs = new ArrayList<>();
	
	
	private List <ScheduleDTO> scheduleDTOs = new ArrayList<>() ;


	public ElectionDTO() {
		super();

	}

	public ElectionDTO(int electionId, @NotNull String electionName, @NotNull String state,
			@NotNull List<CandidateDTO> candidateDTOs, List<ScheduleDTO> scheduleDTOs) {
		super();
		this.electionId = electionId;
		this.electionName = electionName;
		this.state = state;
		this.candidateDTOs = candidateDTOs;
		this.scheduleDTOs = scheduleDTOs;
	}




	public List<ScheduleDTO> getSchedules() {
		return scheduleDTOs;
	}




	public void setSchedules(List<ScheduleDTO> scheduleDTOs) {
		this.scheduleDTOs = scheduleDTOs;
	}




	public int getElectionId() {
		return electionId;
	}


	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}


	public String getElectionName() {
		return electionName;
	}


	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public List<CandidateDTO> getCandidates() {
		return candidateDTOs;
	}


	public void setCandidates(List<CandidateDTO> candidateDTOs) {
		this.candidateDTOs = candidateDTOs;
	}


	@Override
	public String toString() {
		return "Election [electionId=" + electionId + ", electionName=" + electionName + ", state=" + state
				+ ", candidates=" + candidateDTOs + ", schedules=" + scheduleDTOs + "]";
	}	

}