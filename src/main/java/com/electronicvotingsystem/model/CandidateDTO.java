package com.electronicvotingsystem.model;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class CandidateDTO extends UserDTO {

	@NotNull
	private PartyDTO partyDTO;

	private int age;

	@NotNull
	private String constituency;

	private long votecount;

	public CandidateDTO() {
		super();
	}

	public CandidateDTO(@NotNull PartyDTO partyDTO, int age, @NotNull String constituency, long votecount) {
		super();
		this.partyDTO = partyDTO;
		this.age = age;
		this.constituency = constituency;
		this.votecount = votecount;
	}



	public long getVotecount() {
		return votecount;
	}

	public void setVotecount(long votecount) {
		this.votecount = votecount;
	}

	public PartyDTO getParty() {
		return partyDTO;
	}

	public void setParty(PartyDTO partyDTO) {
		this.partyDTO = partyDTO;
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

	@Override
	public String toString() {
		return "Candidate [party=" + partyDTO + ", age=" + age + ", constituency=" + constituency + ", votecount="
				+ votecount + "]";
	}			
}
