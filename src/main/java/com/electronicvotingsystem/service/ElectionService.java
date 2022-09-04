package com.electronicvotingsystem.service;

import java.util.List;
import java.util.Map;

import com.electronicvotingsystem.entity.Election;
import com.electronicvotingsystem.exception.ApplicationStatusPendingException;
import com.electronicvotingsystem.exception.CandidateNotFoundException;
import com.electronicvotingsystem.exception.ElectionAlreadyExistsException;
import com.electronicvotingsystem.exception.ElectionNotFoundException;
import com.electronicvotingsystem.model.ElectionDTO;

public interface ElectionService {

		//addElection
		public Election addElection(ElectionDTO electionDto)throws ElectionAlreadyExistsException;
		
		//refreshAll
		public Election refreshAll(int electionId)throws ElectionNotFoundException;
		
		//viewAllElection
		public List<Election>viewAllElection()throws ElectionNotFoundException;
		
		//viewElection
		public ElectionDTO viewElection(int electionId)throws ElectionNotFoundException;
		
		//updateElection
		public Election updateElection(ElectionDTO electionDTO)throws ElectionNotFoundException;
		
		//castVote
		public String castVote(int electionId, int candidateId, int voterId, int requestId)throws ElectionNotFoundException, CandidateNotFoundException, ApplicationStatusPendingException;
		
		//calculateResults
		public Map<String,String> calculateResults(int electionId)throws ElectionNotFoundException;
		
}