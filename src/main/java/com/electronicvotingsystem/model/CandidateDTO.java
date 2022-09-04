package com.electronicvotingsystem.model;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class CandidateDTO extends UserDTO {

	@NotNull
	private PartyDTO partyDTO;

	@NotNull
	private int age;
	

	@NotNull
	private String constituency;

	private long votecount;

	public CandidateDTO() {
		super();
	}

	public CandidateDTO(@NotNull PartyDTO partyDTO, @NotNull int age, @NotNull String constituency, long votecount) {
		super();
		this.partyDTO = partyDTO;
		this.age = age;
		this.constituency = constituency;
		this.votecount = votecount;
	}

	public PartyDTO getPartyDTO() {
		return partyDTO;
	}

	public void setPartyDTO(PartyDTO partyDTO) {
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

	public long getVotecount() {
		return votecount;
	}

	public void setVotecount(long votecount) {
		this.votecount = votecount;
	}

	@Override
	public String toString() {
		return "CandidateDTO [partyDTO=" + partyDTO + ", age=" + age + ", constituency=" + constituency + ", votecount="
				+ votecount + "]";
	}

	


				
}
