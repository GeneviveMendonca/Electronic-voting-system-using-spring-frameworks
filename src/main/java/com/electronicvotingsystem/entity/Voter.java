package com.electronicvotingsystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Voter extends User {

	@Min(18)
	private int age;

	@NotNull
	private String constituency;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "requestId")
	private VoterRequest voterRequest = new VoterRequest();

	private boolean hasVoted;

	public Voter() {
		super();
		
	}

	public Voter(@Min(18) int age, @NotNull String constituency, VoterRequest voterRequest, boolean hasVoted) {
		super();
		this.age = age;
		this.constituency = constituency;
		this.voterRequest = voterRequest;
		this.hasVoted = hasVoted;
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

	public VoterRequest getVoterRequest() {
		return voterRequest;
	}

	public void setVoterRequest(VoterRequest voterRequest) {
		this.voterRequest = voterRequest;
	}

	public boolean isHasVoted() {
		return hasVoted;
	}

	public void setHasVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}

	@Override
	public String toString() {
		return "Voter [age=" + age + ", constituency=" + constituency + ", voterRequest=" + voterRequest + ", hasVoted="
				+ hasVoted + "]";
	}

}
