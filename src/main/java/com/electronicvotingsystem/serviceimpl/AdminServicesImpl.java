package com.electronicvotingsystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicvotingsystem.dao.AdminRepository;
import com.electronicvotingsystem.dao.CandidateRepository;
import com.electronicvotingsystem.dao.ElectionRepository;
import com.electronicvotingsystem.dao.PartyRepository;
import com.electronicvotingsystem.dao.UserRepository;
import com.electronicvotingsystem.dao.VoterRequestRepository;
import com.electronicvotingsystem.entity.Admin;
import com.electronicvotingsystem.entity.Candidate;
import com.electronicvotingsystem.entity.Election;
import com.electronicvotingsystem.entity.Party;
import com.electronicvotingsystem.entity.VoterRequest;
import com.electronicvotingsystem.exception.CandidateNotFoundException;
import com.electronicvotingsystem.exception.ElectionNotFoundException;
import com.electronicvotingsystem.exception.PartyNotFoundException;
import com.electronicvotingsystem.exception.UserAlreadyExistsException;
import com.electronicvotingsystem.exception.VoterRequestNotFoundException;
import com.electronicvotingsystem.model.AdminDTO;
import com.electronicvotingsystem.model.CandidateDTO;
import com.electronicvotingsystem.model.ElectionDTO;
import com.electronicvotingsystem.model.PartyDTO;
import com.electronicvotingsystem.model.VoterRequestDTO;
import com.electronicvotingsystem.service.AdminServices;
import com.electronicvotingsystem.utils.ConversionClass;

@Service
public class AdminServicesImpl implements AdminServices {

	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private ConversionClass convertAdminRepo;

	@Autowired
	private ElectionRepository electionRepo;

	@Autowired
	private ConversionClass convertElection;

	@Autowired
	private PartyRepository partyRepo;
	
	@Autowired
	private ConversionClass convertParty;

	@Autowired
	private CandidateRepository candRepo;
	
	@Autowired
	private ConversionClass convertCandidate;

	@Autowired
	private VoterRequestRepository voterRequestRepo;
	
	@Autowired
	private ConversionClass convertvoterRequestRepo;
	
	@Autowired
	private UserRepository userRepo;


	@Override
	public String registerAdmin(AdminDTO adminDTO) {
		String message=null;
		Admin admin=null;
		 if(this.userRepo.existsByUserName(adminDTO.getUserName())) {
		        throw new UserAlreadyExistsException("User with given userName already exist");
		 }
		 admin=adminRepo.save(convertAdminRepo.convertToAdminEntity(adminDTO));
		 if(admin!=null) {
		 message="register Successfull";
		 }
		 return message;
	}

	@Override
	public Election addElection(ElectionDTO electionDto)
	{
		return electionRepo.save(convertElection.convertToElectionEntity(electionDto));
		
	}

	@Override
	public List<Election> viewAllElection() {

		return electionRepo.findAll();
	}

	@Override
	public Party addParty(PartyDTO partyDTO)
	{
		return partyRepo.save(convertParty.convertToPartyEntity(partyDTO));
	}

	@Override
	public List<Party> viewAllParty() {

		return partyRepo.findAll();

	}

	@Override
	public ElectionDTO viewElection(int electionId) throws ElectionNotFoundException {

		Optional<Election> election = electionRepo.findById(electionId);
		ElectionDTO elecDto = null;
		Election elec = null;
		if(election.isPresent()) {
			elec = election.get();
			elecDto=convertElection.convertToElectionDTO(elec);
		}
		else
		{
			throw new ElectionNotFoundException("Election not Found");
		}
		return elecDto;	
	}

	@Override
	public PartyDTO viewParty(String partyName) throws PartyNotFoundException {

		Optional<Party> party = partyRepo.findById(Integer.parseInt(partyName));
		PartyDTO partyDto = null;
		Party part = null;
		if(party.isPresent()) {
			part = party.get();
			partyDto=convertParty.convertToPartyDTO(part);
		}
		else
		{
			throw new PartyNotFoundException("Party not Found");
		}
		return partyDto;	
	}

	@Override
	public Candidate addCandidate(CandidateDTO candidateDTO) {
		return candRepo.save(convertCandidate.convertToCandidateEntity(candidateDTO));
	}

	@Override
	public CandidateDTO viewCandidate(String userName)  throws CandidateNotFoundException{
		Optional<Candidate> candidate = candRepo.findById(Integer.parseInt(userName));
		CandidateDTO dto = null;
		Candidate cand = null;
		if(candidate.isPresent()) {
			cand = candidate.get();
			dto = convertCandidate.convertToCandidateDTO(cand);
		}else {
			throw new CandidateNotFoundException("No such candidate");
		}
		return dto;
	}


	@Override 
	public List<Candidate> viewAllCandidates()
	{ 
		return candRepo.findAll(); 
	}

	@Override
	public List<VoterRequest> viewAllVoterRequest() {

		return voterRequestRepo.findAll();

	}

	@Override
	public VoterRequestDTO viewVoterRequest(int requestId) throws VoterRequestNotFoundException {
		Optional<VoterRequest> voterRequest = voterRequestRepo.findById(requestId);
		VoterRequestDTO dto = null;
		VoterRequest vr = null;

		if (voterRequest.isPresent()) {
			vr = voterRequest.get();
			dto = convertvoterRequestRepo.convertToVoterRequestDTO(vr);
		} else {

			throw new VoterRequestNotFoundException("no such requests");
		}
		return dto;
	}	

}
