package com.electronicvotingsystem.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Candidate extends User {

	
	@ManyToOne
	@JoinColumn(name="partyId")
	private Party party;

	@NotNull
	private int age;
	
	@NotNull
	private String constituency;

	private long votecount;

	public Candidate() {
		super();
	}

	public Candidate(Party party, int age, @NotNull String constituency, long votecount) {
		super();
		this.party = party;
		this.age = age;
		this.constituency = constituency;
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

	public long getVotecount() {
		return votecount;
	}

	public void setVotecount(long votecount) {
		this.votecount = votecount;
	}

	@Override
	public String toString() {
		return "Candidate [party=" + party + ", age=" + age + ", constituency=" + constituency + ", votecount="
				+ votecount + "]";
	}

	

	



	


				
}
