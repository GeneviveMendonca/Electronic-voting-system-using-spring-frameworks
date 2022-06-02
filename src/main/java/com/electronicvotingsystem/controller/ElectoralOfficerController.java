package com.electronicvotingsystem.controller;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.electronicvotingsystem.entity.VoterRequest;
import com.electronicvotingsystem.exception.ElectoralOfficerAlreadyExistsException;
import com.electronicvotingsystem.exception.VoterRequestNotFoundException;
import com.electronicvotingsystem.model.ElectoralOfficerDTO;
import com.electronicvotingsystem.model.VoterRequestDTO;
import com.electronicvotingsystem.service.ElectionService;
import com.electronicvotingsystem.service.ElectoralOfficerService;
import com.electronicvotingsystem.service.VoterRequestService;

@RestController
@CrossOrigin(origins = "http://localhost",maxAge = 3600)
public class ElectoralOfficerController {

	@Autowired
	private  ElectoralOfficerService electoralOfficerService;
	
	@Autowired
	private VoterRequestService voterRequestService;
	
	@Autowired
	private ElectionService electionService;
	
	
	@PostMapping(value = "/registerelectofficer")
	public String RegisterElectoralOfficer(@RequestBody @Valid ElectoralOfficerDTO electoralOfficerDTO) throws ElectoralOfficerAlreadyExistsException
	{
		return electoralOfficerService.registerElectoralOfficer(electoralOfficerDTO);
	}
	
	@GetMapping(value = "/viewvoterreqt/{id}")
	public VoterRequestDTO viewVoterRequest(@PathVariable("id") int requestId) throws VoterRequestNotFoundException{
		return voterRequestService.viewVoterRequest(requestId);
	}
	
	@PostMapping(value = "/permissionelect")
	public VoterRequest approveVoterRequest(@RequestBody VoterRequestDTO voterRequestDTO) {
	return voterRequestService.approveVoterRequest(voterRequestDTO);
	}
	
	@PutMapping(value = "/vote/{electionId}/{candidateId}")
	public String vote (@PathVariable("electionId")int electionId,@PathVariable("candidateId")int candidateId) {
		return electionService.castVote(electionId, candidateId);
		
	}
	@GetMapping(value = "/declareresults/{electionId}")
	public Map<String,String> declareResults(int electionId){
		return electionService.calculateResults(electionId);
	}
	
}
