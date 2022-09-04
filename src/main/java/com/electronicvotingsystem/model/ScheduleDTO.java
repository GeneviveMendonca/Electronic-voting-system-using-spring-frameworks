package com.electronicvotingsystem.model;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class ScheduleDTO {

	private int scheduleId;
	
	@NotNull
	private String electionName;

	
	private Date electionDate;

	public ScheduleDTO() {
		super();
	}

	public ScheduleDTO(int scheduleId, @NotNull String electionName, Date electionDate) {
		super();
		this.scheduleId = scheduleId;
		this.electionName = electionName;
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

	public Date getElectionDate() {
		return electionDate;
	}

	public void setElectionDate(Date electionDate) {
		this.electionDate = electionDate;
	}

	@Override
	public String toString() {
		return "ScheduleDTO [scheduleId=" + scheduleId + ", electionName=" + electionName + ", electionDate="
				+ electionDate + "]";
	}

	

	

	


}



