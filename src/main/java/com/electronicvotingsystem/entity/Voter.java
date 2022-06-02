package com.electronicvotingsystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Voter  extends User{

	@Min(18)
	private int age;

	@NotNull
	@Email
	private String emailId;

	@OneToMany
	@JoinColumn(name="requestId")
	private List <VoterRequest> voterRequest = new ArrayList<>() ;

	@OneToMany
	@JoinColumn(name="electionId",insertable= false , updatable=false, nullable = false)
	private List<Election> elections = new ArrayList<>();

	public Voter() {
		super();
	}

	public Voter(@Min(18) int age, @NotNull @Email String emailId, List<VoterRequest> voterRequest,
			List<Election> elections) {
		super();
		this.age = age;
		this.emailId = emailId;
		this.voterRequest = voterRequest;
		this.elections = elections;
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

	public List<VoterRequest> getVoterRequest() {
		return voterRequest;
	}

	public void setVoterRequest(List<VoterRequest> voterRequest) {
		this.voterRequest = voterRequest;
	}

	public List<Election> getElections() {
		return elections;
	}

	public void setElections(List<Election> elections) {
		this.elections = elections;
	}

	@Override
	public String toString() {
		return "Voter [age=" + age + ", emailId=" + emailId + ", voterRequest=" + voterRequest + ", elections="
				+ elections + "]";
	}


}
