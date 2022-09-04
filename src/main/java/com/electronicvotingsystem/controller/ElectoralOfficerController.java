package com.electronicvotingsystem.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electronicvotingsystem.entity.Election;
import com.electronicvotingsystem.entity.ElectoralOfficer;
import com.electronicvotingsystem.entity.Voter;
import com.electronicvotingsystem.entity.VoterRequest;
import com.electronicvotingsystem.exception.ElectoralOfficerAlreadyExistsException;
import com.electronicvotingsystem.exception.ElectoralOfficerNotFoundException;
import com.electronicvotingsystem.exception.VoterRequestNotFoundException;
import com.electronicvotingsystem.model.ElectoralOfficerDTO;
import com.electronicvotingsystem.model.VoterRequestDTO;
import com.electronicvotingsystem.service.ElectionService;
import com.electronicvotingsystem.service.ElectoralOfficerService;
import com.electronicvotingsystem.service.VoterRequestService;
import com.electronicvotingsystem.service.VoterService;

@RestController
@RequestMapping("/secure")
@CrossOrigin(origins = "http://localhost", maxAge = 3600)
public class ElectoralOfficerController {

	@Autowired
	private ElectoralOfficerService electoralOfficerService;

	@Autowired
	private VoterRequestService voterRequestService;

	@Autowired
	private ElectionService electionService;
	
	@Autowired
	private VoterService voterService;

	//RegisterElectoralOfficer
	@PostMapping(value = "/registerelectofficer")
	public String RegisterElectoralOfficer(@RequestBody @Valid ElectoralOfficerDTO electoralOfficerDTO)
			throws ElectoralOfficerAlreadyExistsException {
		return electoralOfficerService.registerElectoralOfficer(electoralOfficerDTO);
	}

	//viewVoterRequest
	@GetMapping(value = "/viewvoterreqt/{id}")
	public VoterRequestDTO viewVoterRequest(@PathVariable("id") int requestId) throws VoterRequestNotFoundException {
		return voterRequestService.viewVoterRequest(requestId);
	}

	//approveVoterRequest
	@PutMapping(value = "/permissionelect")
	public VoterRequest approveVoterRequest(@RequestBody VoterRequestDTO voterRequestDTO) {
		return voterRequestService.approveVoterRequest(voterRequestDTO);
	}

	//viewAllVoterRequest
	@GetMapping(value = "/viewallvoterrequest")
	public List<VoterRequest> viewAllVoterRequest() {
		return voterRequestService.viewAllVoterRequest();
	}

//	@PutMapping(value = "/castvote/{electionId}/{candidateId}/{voterId}/{requestId}")
//	public String vote(@PathVariable("electionId") int electionId, @PathVariable("candidateId") int candidateId,
//			@PathVariable("voterId") int voterId,@PathVariable("requestId") int requestId) {
//		return electionService.castVote(electionId, candidateId, voterId, requestId);
//
//	}
	
	//updateElectoralOfficer
	@PutMapping(value = "/updateelectoralofficer")
	public ElectoralOfficer updateElectoralOfficer(@RequestBody @Valid ElectoralOfficerDTO electoralOfficerDTO) {
		return electoralOfficerService.updateElectoralOfficer(electoralOfficerDTO);
	}
	
	//viewElectoralOfficer
	@GetMapping(value = "/viewelectoralofficer/{id}")
	public ElectoralOfficerDTO viewElectoralOfficer(@PathVariable("id") int userId) throws ElectoralOfficerNotFoundException{
		return electoralOfficerService.viewElectoralOfficer(userId);
	}
	
	//declareResults
	@GetMapping(value = "/declareresults/{electionId}")
	public Map<String, String> declareResults(int electionId) {
		return electionService.calculateResults(electionId);
	}

	//refresh
	@GetMapping(value = "/refresh/{electionId}")
	public Election refresh(@PathVariable("electionId") int electionId) {
		return electionService.refreshAll(electionId);
	}
	
	//viewAllVoter
	@GetMapping(value = "/viewallvoter")
	public List<Voter> viewAllVoter() {
		return voterService.viewAllVoter();
	}
	

}
