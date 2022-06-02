package com.electronicvotingsystem.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="election")
public class Election {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int electionId;

	@NotNull
	private String electionName;

	@NotNull
	private String state;

	@NotNull
	@OneToMany(mappedBy = "election",cascade=CascadeType.ALL,fetch = FetchType.EAGER )
	//@JoinColumn(name="Candidate.userId")
	private List<Candidate> candidates = new ArrayList<>();
	
	@OneToMany
	//@JoinColumn(name="scheduleId")
	private List <Schedule> schedules = new ArrayList<>() ;

	

	public Election() {
		super();

	}

	public Election(int electionId, @NotNull String electionName, @NotNull String state,
			@NotNull List<Candidate> candidates, List<Schedule> schedules) {
		super();
		this.electionId = electionId;
		this.electionName = electionName;
		this.state = state;
		this.candidates = candidates;
		this.schedules = schedules;
	}


	public List<Schedule> getSchedules() {
		return schedules;
	}


	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
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


	public List<Candidate> getCandidates() {
		return candidates;
	}


	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}


	@Override
	public String toString() {
		return "Election [electionId=" + electionId + ", electionName=" + electionName + ", state=" + state
				+ ", candidates=" + candidates + ", schedules=" + schedules + "]";
	}

}