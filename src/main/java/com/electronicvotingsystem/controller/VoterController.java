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

import com.electronicvotingsystem.entity.Candidate;
import com.electronicvotingsystem.entity.Schedule;
import com.electronicvotingsystem.entity.VoterRequest;
import com.electronicvotingsystem.exception.VoterAlreadyExistsException;
import com.electronicvotingsystem.exception.VoterRequestAlreadyExistsException;
import com.electronicvotingsystem.exception.VoterRequestNotFoundException;
import com.electronicvotingsystem.model.VoterDTO;
import com.electronicvotingsystem.model.VoterRequestDTO;
import com.electronicvotingsystem.service.CandidateService;
import com.electronicvotingsystem.service.ScheduleService;
import com.electronicvotingsystem.service.VoterRequestService;
import com.electronicvotingsystem.service.VoterService;

@RestController
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

	@PostMapping(value = "/registervoter")
	public String RegisterVoter(@RequestBody @Valid VoterDTO voterDTO) throws VoterAlreadyExistsException
	{
		return voterService.registerVoter(voterDTO);
	}
	
	@PostMapping(value = "/addvoterreq")
	public VoterRequest addVoterRequest(@RequestBody @Valid VoterRequestDTO voterRequestDTO)throws VoterRequestAlreadyExistsException
	{
		return voterRequestService.addVoterRequest(voterRequestDTO);
	}

	@GetMapping(value = "/view/{id}")
	public VoterRequestDTO viewVoterRequest(@PathVariable("id") int requestId) throws VoterRequestNotFoundException{
		return voterRequestService.viewVoterRequest(requestId);
	}
	
	@GetMapping(value="/viewallschedule")
	public List<Schedule> viewAllSchedules(){
		return scheduleService.viewAllSchedule();
	}

	@GetMapping(value="/viewallcandidate")
	public List<Candidate> viewAllCandidates(){
		return candidateService.viewAllCandidates();
	}


}
