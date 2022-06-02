package com.electronicvotingsystem.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="schedule")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int scheduleId;

	@NotNull
	private String electionName;

	@NotNull
	private String state;

	@NotNull
	private String constituency;

	@ManyToOne
	@JsonIgnore
	private Election election;

	private Date electionDate;

	public Schedule() {
		super();
	}



	public Schedule(int scheduleId, @NotNull String electionName, @NotNull String state, @NotNull String constituency,
			Election election, Date electionDate) {
		super();
		this.scheduleId = scheduleId;
		this.electionName = electionName;
		this.state = state;
		this.constituency = constituency;
		this.election = election;
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


	public Election getElection() {
		return election;
	}



	public void setElection(Election election) {
		this.election = election;
	}



	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", electionName=" + electionName + ", state=" + state
				+ ", constituency=" + constituency + ", election=" + election + ", electionDate=" + electionDate + "]";
	}



}



