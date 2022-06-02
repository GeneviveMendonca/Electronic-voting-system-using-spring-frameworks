package com.electronicvotingsystem.service;

import java.util.List;
import java.util.Map;

import com.electronicvotingsystem.entity.Election;
import com.electronicvotingsystem.exception.CandidateNotFoundException;
import com.electronicvotingsystem.exception.ElectionAlreadyExistsException;
import com.electronicvotingsystem.exception.ElectionNotFoundException;
import com.electronicvotingsystem.model.ElectionDTO;

public interface ElectionService {

	
		public Election addElection(ElectionDTO electionDto)throws ElectionAlreadyExistsException;
		
		public List<Election>viewAllElection()throws ElectionNotFoundException;
		
		public ElectionDTO viewElection(int electionId)throws ElectionNotFoundException;
		
		public Election updateElection(ElectionDTO electionDTO)throws ElectionNotFoundException;
		
		public String castVote(int electionId, int candidateId)throws ElectionNotFoundException, CandidateNotFoundException;
		
		public Map<String,String> calculateResults(int electionId)throws ElectionNotFoundException;
		
}