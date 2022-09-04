package com.electronicvotingsystem.service;

import java.util.List;

import com.electronicvotingsystem.entity.Candidate;
import com.electronicvotingsystem.entity.Schedule;
import com.electronicvotingsystem.entity.Voter;
import com.electronicvotingsystem.entity.VoterRequest;
import com.electronicvotingsystem.exception.ApplicationStatusPendingException;
import com.electronicvotingsystem.exception.CandidateNotFoundException;
import com.electronicvotingsystem.exception.ElectionNotFoundException;
import com.electronicvotingsystem.exception.VoterAlreadyExistsException;
import com.electronicvotingsystem.exception.VoterNotFoundException;
import com.electronicvotingsystem.exception.VoterRequestAlreadyExistsException;
import com.electronicvotingsystem.exception.VoterRequestNotFoundException;
import com.electronicvotingsystem.model.VoterDTO;
import com.electronicvotingsystem.model.VoterRequestDTO;

public interface VoterService {

	    //voter Registration
		public String registerVoter(VoterDTO voterDTO)throws VoterAlreadyExistsException;
		
		//View Voter
		public VoterDTO viewVoter(int userId) throws VoterNotFoundException;
				
		//addVoterRequest
		public VoterRequest addVoterRequest(VoterRequestDTO voterRequestDTO) throws VoterRequestAlreadyExistsException;
		
		//viewVoterRequest
		public VoterRequestDTO viewVoterRequest(int requestId) throws VoterRequestNotFoundException;
		
		//updateVoter
		public Voter updateVoter(VoterDTO voterDTO) throws VoterNotFoundException;	
		
		public List<Voter> viewAllVoter();
		
		//view Schedule
		public List<Schedule> viewAllSchedule();
		
		//View Candidates
		public List<Candidate> viewAllCandidates();
		
		//cast vote
		public String castVote(int electionId, int candidateId, int voterId, int requestId)throws ElectionNotFoundException, CandidateNotFoundException, ApplicationStatusPendingException;
		
}
