package com.electronicvotingsystem.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class VoterDTO  extends UserDTO{

	@Min(18)
	private int age;

	@NotNull
	private String constituency;

	private VoterRequestDTO voterRequestDTO;
	
	private boolean hasVoted;

	public VoterDTO() {
		super();
	}



	public VoterDTO(@Min(18) int age, @NotNull String constituency, VoterRequestDTO voterRequestDTO, boolean hasVoted) {
		super();
		this.age = age;
		this.constituency = constituency;
		this.voterRequestDTO = voterRequestDTO;
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

	public VoterRequestDTO getVoterRequestDTO() {
		return voterRequestDTO;
	}

	public void setVoterRequestDTO(VoterRequestDTO voterRequestDTO) {
		this.voterRequestDTO = voterRequestDTO;
	}



	public boolean isHasVoted() {
		return hasVoted;
	}



	public void setHasVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}



	@Override
	public String toString() {
		return "VoterDTO [age=" + age + ", constituency=" + constituency + ", voterRequestDTO=" + voterRequestDTO
				+ ", hasVoted=" + hasVoted + "]";
	}


	


}
