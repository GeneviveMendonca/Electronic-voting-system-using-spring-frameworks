package com.electronicvotingsystem.service;

import java.util.List;

import com.electronicvotingsystem.entity.Candidate;
import com.electronicvotingsystem.entity.Schedule;
import com.electronicvotingsystem.entity.VoterRequest;
import com.electronicvotingsystem.exception.VoterAlreadyExistsException;
import com.electronicvotingsystem.exception.VoterRequestAlreadyExistsException;
import com.electronicvotingsystem.exception.VoterRequestNotFoundException;
import com.electronicvotingsystem.model.VoterDTO;
import com.electronicvotingsystem.model.VoterRequestDTO;

public interface VoterService {

	//voter Registration
		public String registerVoter(VoterDTO voterDTO)throws VoterAlreadyExistsException;
				
		//addVoterRequest
		public VoterRequest addVoterRequest(VoterRequestDTO voterRequestDTO) throws VoterRequestAlreadyExistsException;
		
		//viewVoterRequest
		public VoterRequestDTO viewVoterRequest(int requestId) throws VoterRequestNotFoundException;
		
		//view Schedule
		public List<Schedule> viewAllSchedule();
		
		//View Candidates
		public List<Candidate> viewAllCandidates();
		
}
