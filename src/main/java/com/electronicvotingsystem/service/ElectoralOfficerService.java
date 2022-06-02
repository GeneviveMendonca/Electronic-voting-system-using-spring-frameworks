package com.electronicvotingsystem.service;

import java.util.List;

import com.electronicvotingsystem.entity.VoterRequest;
import com.electronicvotingsystem.exception.ElectoralOfficerAlreadyExistsException;
import com.electronicvotingsystem.exception.VoterRequestNotFoundException;
import com.electronicvotingsystem.model.ElectoralOfficerDTO;
import com.electronicvotingsystem.model.VoterRequestDTO;

public interface ElectoralOfficerService {

	//add electoral officer
	public String registerElectoralOfficer(ElectoralOfficerDTO electoralOfficerDTO)throws ElectoralOfficerAlreadyExistsException;
	
		 //viewVoterRequest
		public VoterRequestDTO viewVoterRequest(int requestId) throws VoterRequestNotFoundException;
		
		//ViewAllVoterRequest
		public List<VoterRequest> viewAllVoterRequest();
		
		public String approveVoterRequest(String result,VoterRequestDTO voterRequestDTO);
}
