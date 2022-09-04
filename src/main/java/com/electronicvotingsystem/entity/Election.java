package com.electronicvotingsystem.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="election")
public class Election {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int electionId;


	@NotNull
	private String constituency;
	

	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="Candidate.userId")
	private List<Candidate> candidates = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="scheduleId")
	private Schedule schedule;
	


	public Election() {
		super();

	}




	public Election(int electionId, @NotNull String constituency, @NotNull List<Candidate> candidates,
			Schedule schedule) {
		super();
		this.electionId = electionId;
		this.constituency = constituency;
		this.candidates = candidates;
		this.schedule = schedule;
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




	public List<Candidate> getCandidates() {
		return candidates;
	}




	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}




	public Schedule getSchedule() {
		return schedule;
	}




	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}




	@Override
	public String toString() {
		return "Election [electionId=" + electionId + ", constituency=" + constituency + ", candidates=" + candidates
				+ ", schedule=" + schedule + "]";
	}

	
	

}