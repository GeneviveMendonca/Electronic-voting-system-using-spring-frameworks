package com.electronicvotingsystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
@Component
public class ElectionDTO {

	private int electionId;

	@NotNull
	private String constituency;

	@NotNull
	private List<CandidateDTO> candidates = new ArrayList<>();

	private ScheduleDTO scheduleDTO;


	public ElectionDTO() {
		super();

	}


	public ElectionDTO(int electionId, @NotNull String constituency, @NotNull List<CandidateDTO> candidates,
			ScheduleDTO scheduleDTO) {
		super();
		this.electionId = electionId;
		this.constituency = constituency;
		this.candidates = candidates;
		this.scheduleDTO = scheduleDTO;
	}


	public int getElectionId() {
		return electionId;
	}


	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}


	public String getConstituency() {
		return constituency;
	}


	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}


	public List<CandidateDTO> getCandidates() {
		return candidates;
	}


	public void setCandidates(List<CandidateDTO> candidates) {
		this.candidates = candidates;
	}


	public ScheduleDTO getScheduleDTO() {
		return scheduleDTO;
	}


	public void setScheduleDTO(ScheduleDTO scheduleDTO) {
		this.scheduleDTO = scheduleDTO;
	}


	@Override
	public String toString() {
		return "ElectionDTO [electionId=" + electionId + ", constituency=" + constituency + ", candidates=" + candidates
				+ ", scheduleDTO=" + scheduleDTO + "]";
	}



	









}