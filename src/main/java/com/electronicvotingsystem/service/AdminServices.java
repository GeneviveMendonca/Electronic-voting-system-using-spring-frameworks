package com.electronicvotingsystem.service;

import java.util.List;

import com.electronicvotingsystem.entity.Candidate;
import com.electronicvotingsystem.entity.Election;
import com.electronicvotingsystem.entity.Party;
import com.electronicvotingsystem.entity.VoterRequest;
import com.electronicvotingsystem.exception.CandidateAlreadyExistsException;
import com.electronicvotingsystem.exception.CandidateNotFoundException;
import com.electronicvotingsystem.exception.ElectionAlreadyExistsException;
import com.electronicvotingsystem.exception.ElectionNotFoundException;
import com.electronicvotingsystem.exception.PartyAlreadyExistsException;
import com.electronicvotingsystem.exception.PartyNotFoundException;
import com.electronicvotingsystem.exception.UserAlreadyExistsException;
import com.electronicvotingsystem.exception.VoterRequestNotFoundException;
import com.electronicvotingsystem.model.AdminDTO;
import com.electronicvotingsystem.model.CandidateDTO;
import com.electronicvotingsystem.model.ElectionDTO;
import com.electronicvotingsystem.model.PartyDTO;
import com.electronicvotingsystem.model.VoterRequestDTO;

public interface AdminServices {
	
	public String registerAdmin(AdminDTO adminDTO)throws UserAlreadyExistsException;
	
	public Election addElection(ElectionDTO electionDto)throws ElectionAlreadyExistsException;

	public List<Election>viewAllElection()throws ElectionNotFoundException;

	public ElectionDTO viewElection(int electionId)throws ElectionNotFoundException;
	

	//addParty
	public Party addParty(PartyDTO partyDTO) throws PartyAlreadyExistsException;

	//viewAllParty
	public List<Party> viewAllParty();
	
	public PartyDTO viewParty(String partyName) throws PartyNotFoundException;

	public Candidate addCandidate(CandidateDTO candidateDTO) throws CandidateAlreadyExistsException;

	public CandidateDTO viewCandidate(String userName) throws CandidateNotFoundException;

	public List<Candidate> viewAllCandidates();

	public List<VoterRequest> viewAllVoterRequest();

	//viewVoterRequest
	public VoterRequestDTO viewVoterRequest(int requestId) throws VoterRequestNotFoundException;


}
