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

import com.electronicvotingsystem.entity.Candidate;
import com.electronicvotingsystem.entity.Election;
import com.electronicvotingsystem.entity.Schedule;
import com.electronicvotingsystem.entity.Voter;
import com.electronicvotingsystem.exception.VoterAlreadyExistsException;
import com.electronicvotingsystem.exception.VoterNotFoundException;
import com.electronicvotingsystem.exception.VoterRequestNotFoundException;
import com.electronicvotingsystem.model.VoterDTO;
import com.electronicvotingsystem.model.VoterRequestDTO;
import com.electronicvotingsystem.service.CandidateService;
import com.electronicvotingsystem.service.ElectionService;
import com.electronicvotingsystem.service.ScheduleService;
import com.electronicvotingsystem.service.VoterRequestService;
import com.electronicvotingsystem.service.VoterService;

@RestController
@RequestMapping("/secure")
@CrossOrigin(origins = "http://localhost",maxAge = 3600)
public class VoterController {


	@Autowired
	private VoterService voterService;

	@Autowired
	private VoterRequestService voterRequestService;

	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private ElectionService electionService;

	//RegisterVoter
	@PostMapping(value = "/registervoter")
	public String RegisterVoter(@RequestBody @Valid VoterDTO voterDTO) throws VoterAlreadyExistsException
	{
		return voterService.registerVoter(voterDTO);
	}
	
//	@PutMapping(value = "/addvoterreq")
//	public VoterRequest addVoterRequest(@RequestBody @Valid VoterRequestDTO voterRequestDTO)throws VoterRequestAlreadyExistsException
//	{
//		return voterService.addVoterRequest(voterRequestDTO);
//	}
	
	//updateVoter
	@PutMapping(value = "/updatevoter")
	public Voter updateVoter(@RequestBody @Valid VoterDTO voterDTO) {
		return voterService.updateVoter(voterDTO);
	}
	
	//viewVoter
	@GetMapping(value = "/viewvoter/{id}")
	public VoterDTO viewVoter(@PathVariable("id") int userId) throws VoterNotFoundException{
		return voterService.viewVoter(userId);
	}
	
	//viewVoterRequest
	@GetMapping(value = "/view/{id}")
	public VoterRequestDTO viewVoterRequest(@PathVariable("id") int requestId) throws VoterRequestNotFoundException{
		return voterRequestService.viewVoterRequest(requestId);
	}
	
	//viewAllSchedules
	@GetMapping(value="/viewallschedule")
	public List<Schedule> viewAllSchedules(){
		return scheduleService.viewAllSchedule();
	}

	//viewAllCandidates
	@GetMapping(value="/viewallcandidate")
	public List<Candidate> viewAllCandidates(){
		return candidateService.viewAllCandidates();
	}
	
	//vote
	@PutMapping(value = "/castvote/{electionId}/{candidateId}/{voterId}/{requestId}")
	public String vote(@PathVariable("electionId") int electionId, @PathVariable("candidateId") int candidateId,
			@PathVariable("voterId") int voterId,@PathVariable("requestId") int requestId) {
		return electionService.castVote(electionId, candidateId, voterId, requestId);

	}
	
	//viewResult
	@GetMapping(value = "/viewresults/{electionId}")
	public Map<String, String> viewResult(int electionId) {
		return electionService.calculateResults(electionId);
	}
	
	//viewAllElection
	@GetMapping(value="/viewallelection")
	public List<Election> viewAllElection(){
		return electionService.viewAllElection();
	}

}
