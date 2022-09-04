package com.electronicvotingsystem.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="schedule")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int scheduleId;

	@NotNull
	private String electionName;

	@NotNull
	private Date electionDate;

	public Schedule() {
		super();
	}

	public Schedule(int scheduleId, @NotNull String electionName, Date electionDate) {
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
		return "Schedule [scheduleId=" + scheduleId + ", electionName=" + electionName + ", electionDate="
				+ electionDate + "]";
	}


	



}



