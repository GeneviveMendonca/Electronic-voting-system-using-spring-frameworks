package com.electronicvotingsystem.service;

import java.util.List;

import com.electronicvotingsystem.entity.VoterRequest;
import com.electronicvotingsystem.exception.VoterRequestAlreadyExistsException;
import com.electronicvotingsystem.exception.VoterRequestNotFoundException;
import com.electronicvotingsystem.model.VoterRequestDTO;

public interface VoterRequestService {

	//addVoterRequest
	public VoterRequest addVoterRequest(VoterRequestDTO voterRequestDTO) throws VoterRequestAlreadyExistsException;

    //viewVoterRequest
	public VoterRequestDTO viewVoterRequest(int requestId) throws VoterRequestNotFoundException;
	
	//ViewAllVoterRequest
	public List<VoterRequest> viewAllVoterRequest();
	
	//ApproveVoterRequest
	public VoterRequest approveVoterRequest(VoterRequestDTO voterRequestDTO)throws VoterRequestNotFoundException;
	
}
