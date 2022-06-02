package com.electronicvotingsystem.model;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class ScheduleDTO {

	private int scheduleId;
	
	@NotNull
	private String electionName;
	
	@NotNull
	private String state;
	
	@NotNull
	private String constituency;
	
	private Date electionDate;

	public ScheduleDTO() {
		super();
	}

	public ScheduleDTO(int scheduleId, @NotNull String electionName, @NotNull String state, @NotNull String constituency,
			Date electionDate) {
		super();
		this.scheduleId = scheduleId;
		this.electionName = electionName;
		this.state = state;
		this.constituency = constituency;
		this.electionDate = electionDate;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
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

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	public Date getElectionDate() {
		return electionDate;
	}

	public void setElectionDate(Date electionDate) {
		this.electionDate = electionDate;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", electionName=" + electionName + ", state=" + state
				+ ", constituency=" + constituency + ", electionDate=" + electionDate + "]";
	}


}



