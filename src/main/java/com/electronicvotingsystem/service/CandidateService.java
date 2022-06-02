package com.electronicvotingsystem.service;

import java.util.List;

import com.electronicvotingsystem.entity.Candidate;
import com.electronicvotingsystem.exception.CandidateAlreadyExistsException;
import com.electronicvotingsystem.exception.CandidateNotFoundException;
import com.electronicvotingsystem.model.CandidateDTO;


public interface CandidateService{

	public String addCandidate(CandidateDTO candidateDTO) throws CandidateAlreadyExistsException;

	public CandidateDTO viewCandidate(int userId) throws CandidateNotFoundException;

	public List<Candidate> viewAllCandidates();

	public Candidate updateCandidate(CandidateDTO candidateDTO) throws CandidateNotFoundException;

	public String deleteCandidate(int userId) throws CandidateNotFoundException;

}
