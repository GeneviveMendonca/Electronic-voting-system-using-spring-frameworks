package com.electronicvotingsystem.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Candidate extends User {

	@NotNull
	@OneToOne
	@JoinColumn(name="partyId")
	private Party party;

	private int age;
	
	@ManyToOne
	@JsonIgnore
	private Election election;

	@NotNull
	private String constituency;

	private long votecount;

	public Candidate() {
		super();
	}

	

	public Candidate(@NotNull Party party, int age, Election election, @NotNull String constituency, long votecount) {
		super();
		this.party = party;
		this.age = age;
		this.election = election;
		this.constituency = constituency;
		this.votecount = votecount;
	}



	public long getVotecount() {
		return votecount;
	}

	public void setVotecount(long votecount) {
		this.votecount = votecount;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	

	public Election getElection() {
		return election;
	}



	public void setElection(Election election) {
		this.election = election;
	}



	@Override
	public String toString() {
		return "Candidate [party=" + party + ", age=" + age + ", election=" + election + ", constituency="
				+ constituency + ", votecount=" + votecount + "]";
	}



				
}
