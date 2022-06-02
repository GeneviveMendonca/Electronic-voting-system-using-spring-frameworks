package com.electronicvotingsystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class VoterDTO  extends UserDTO{

	@Min(18)
	private int age;

	@NotNull
	@Email
	private String emailId;

	
	private List <VoterRequestDTO> voterRequestDTO = new ArrayList<>() ;

	private List<ElectionDTO> electionDTOs = new ArrayList<>();

	public VoterDTO() {
		super();
	}

	public VoterDTO(@Min(18) int age, @NotNull @Email String emailId, List<VoterRequestDTO> voterRequestDTO,
			List<ElectionDTO> electionDTOs) {
		super();
		this.age = age;
		this.emailId = emailId;
		this.voterRequestDTO = voterRequestDTO;
		this.electionDTOs = electionDTOs;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<VoterRequestDTO> getVoterRequest() {
		return voterRequestDTO;
	}

	public void setVoterRequest(List<VoterRequestDTO> voterRequestDTO) {
		this.voterRequestDTO = voterRequestDTO;
	}

	public List<ElectionDTO> getElections() {
		return electionDTOs;
	}

	public void setElections(List<ElectionDTO> electionDTOs) {
		this.electionDTOs = electionDTOs;
	}

	@Override
	public String toString() {
		return "Voter [age=" + age + ", emailId=" + emailId + ", voterRequest=" + voterRequestDTO + ", elections="
				+ electionDTOs + "]";
	}


	


}
