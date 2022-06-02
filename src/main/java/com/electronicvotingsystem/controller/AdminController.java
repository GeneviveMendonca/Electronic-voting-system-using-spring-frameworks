package com.electronicvotingsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.electronicvotingsystem.entity.Election;
import com.electronicvotingsystem.entity.Party;
import com.electronicvotingsystem.entity.User;
import com.electronicvotingsystem.entity.VoterRequest;
import com.electronicvotingsystem.exception.AdminAlreadyExistsException;
import com.electronicvotingsystem.exception.CandidateAlreadyExistsException;
import com.electronicvotingsystem.exception.CandidateNotFoundException;
import com.electronicvotingsystem.exception.ElectionNotFoundException;
import com.electronicvotingsystem.exception.PartyNotFoundException;
import com.electronicvotingsystem.exception.VoterRequestNotFoundException;
import com.electronicvotingsystem.model.AdminDTO;
import com.electronicvotingsystem.model.CandidateDTO;
import com.electronicvotingsystem.model.ElectionDTO;
import com.electronicvotingsystem.model.PartyDTO;
import com.electronicvotingsystem.model.VoterRequestDTO;
import com.electronicvotingsystem.service.AdminServices;
import com.electronicvotingsystem.service.CandidateService;
import com.electronicvotingsystem.service.ElectionService;
import com.electronicvotingsystem.service.PartyService;
import com.electronicvotingsystem.service.UserService;
import com.electronicvotingsystem.service.VoterRequestService;

@RestController
@CrossOrigin(origins = "http://localhost",maxAge = 3600)
public class AdminController{


	@Autowired
	private ElectionService electionService;

	@Autowired
	private PartyService partyService;

	@Autowired
	private CandidateService candidateService;

	@Autowired
	private AdminServices adminServices;

	@Autowired
	private VoterRequestService voterRequestService;

	@Autowired
	private UserService userService;

	@PostMapping(value = "/registeradmin")
	public String registerAdmin(@RequestBody @Valid AdminDTO adminDTO)throws AdminAlreadyExistsException {
		return adminServices.registerAdmin(adminDTO);
	}

	@PostMapping(value = "/login")
	public User login(@RequestBody User user) {
		String userName = user.getUserName();
		String password = user.getPassword();
		return userService.loginUser(userName, password);
	}

	@PostMapping(value = "/addelection")
	public Election addElection(@RequestBody @Valid ElectionDTO electionDTO) {
		return electionService.addElection(electionDTO);
	}

	@GetMapping(value = "/viewelection{id}")
	public ElectionDTO viewElection(@PathVariable("id") int electionId) throws ElectionNotFoundException{
		return electionService.viewElection(electionId);
	}

	@PostMapping(value = "/addparty")
	public Party addParty(@RequestBody @Valid PartyDTO partyDTO) {
		return partyService.addParty(partyDTO);
	}

	@GetMapping(value = "/viewparty/{id}")
	public PartyDTO viewParty(@PathVariable("id") int partyId) throws PartyNotFoundException{
		return partyService.viewParty(partyId);
	}

	@PostMapping(value = "/registercandidate")
	public String addCandidate(@RequestBody @Valid CandidateDTO candidateDTO) throws CandidateAlreadyExistsException
	{
		return candidateService.addCandidate(candidateDTO);
	}

	@GetMapping(value = "/viewcandidate/{name}")
	public CandidateDTO viewCandidate(@PathVariable("name") String userName) throws CandidateNotFoundException{
		return adminServices.viewCandidate(userName);
	}

	@GetMapping(value = "/viewvoterreq/{id}")
	public VoterRequestDTO viewVoterRequest(@PathVariable("id") int requestId) throws VoterRequestNotFoundException{
		return voterRequestService.viewVoterRequest(requestId);
	}

	@GetMapping(value = "/viewallrequests")
	public List<VoterRequest> viewAllVoterRequest() {
		return voterRequestService.viewAllVoterRequest();
	}

	@PostMapping(value = "/permissionadmin")
	public VoterRequest approveVoterRequest(@RequestBody VoterRequestDTO voterRequestDTO) {
		return voterRequestService.approveVoterRequest(voterRequestDTO);
	}
}
