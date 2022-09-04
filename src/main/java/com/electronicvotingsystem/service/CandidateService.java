package com.electronicvotingsystem.service;

import java.util.List;

import com.electronicvotingsystem.entity.Candidate;
import com.electronicvotingsystem.exception.CandidateAlreadyExistsException;
import com.electronicvotingsystem.exception.CandidateNotFoundException;
import com.electronicvotingsystem.model.CandidateDTO;


public interface CandidateService{

	//addCandidate
	public String addCandidate(CandidateDTO candidateDTO) throws CandidateAlreadyExistsException;

	//viewCandidate
	public CandidateDTO viewCandidate(int userId) throws CandidateNotFoundException;

	//viewAllCandidates
	public List<Candidate> viewAllCandidates();
	
	//viewCandidatesByConstituency
	public List<Candidate> viewCandidatesByConstituency(String constituency)throws CandidateNotFoundException;

	//updateCandidate
	public Candidate updateCandidate(CandidateDTO candidateDTO) throws CandidateNotFoundException;

	//deleteCandidate
	public String deleteCandidate(int userId) throws CandidateNotFoundException;

}
