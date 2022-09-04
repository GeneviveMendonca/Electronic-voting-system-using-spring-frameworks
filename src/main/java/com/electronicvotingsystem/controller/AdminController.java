package com.electronicvotingsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electronicvotingsystem.entity.Admin;
import com.electronicvotingsystem.entity.Candidate;
import com.electronicvotingsystem.entity.Election;
import com.electronicvotingsystem.entity.ElectoralOfficer;
import com.electronicvotingsystem.entity.Party;
import com.electronicvotingsystem.entity.Schedule;
import com.electronicvotingsystem.entity.User;
import com.electronicvotingsystem.entity.VoterRequest;
import com.electronicvotingsystem.exception.AdminAlreadyExistsException;
import com.electronicvotingsystem.exception.AdminNotFoundException;
import com.electronicvotingsystem.exception.CandidateAlreadyExistsException;
import com.electronicvotingsystem.exception.CandidateNotFoundException;
import com.electronicvotingsystem.exception.ElectionNotFoundException;
import com.electronicvotingsystem.exception.PartyNotFoundException;
import com.electronicvotingsystem.exception.ScheduleNotFoundException;
import com.electronicvotingsystem.exception.VoterRequestNotFoundException;
import com.electronicvotingsystem.model.AdminDTO;
import com.electronicvotingsystem.model.CandidateDTO;
import com.electronicvotingsystem.model.ElectionDTO;
import com.electronicvotingsystem.model.PartyDTO;
import com.electronicvotingsystem.model.ScheduleDTO;
import com.electronicvotingsystem.model.VoterRequestDTO;
import com.electronicvotingsystem.service.AdminServices;
import com.electronicvotingsystem.service.CandidateService;
import com.electronicvotingsystem.service.ElectionService;
import com.electronicvotingsystem.service.ElectoralOfficerService;
import com.electronicvotingsystem.service.PartyService;
import com.electronicvotingsystem.service.ScheduleService;
import com.electronicvotingsystem.service.UserService;
import com.electronicvotingsystem.service.VoterRequestService;

@RestController
@RequestMapping("/secure")
@CrossOrigin(origins = "http://localhost", maxAge = 3600)
public class AdminController {

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
	private ElectoralOfficerService electoralOfficerService;

     @Autowired private UserService userService;


	@Autowired
	private ScheduleService scheduleService;

	//registerAdmin
	@PostMapping(value = "/registeradmin")
	public String registerAdmin(@RequestBody @Valid AdminDTO adminDTO) throws AdminAlreadyExistsException {
		return adminServices.registerAdmin(adminDTO);
	}

//	@PostMapping(value = "/login")
//	public User login(@RequestBody User user) {
//		String userName = user.getUserName();
//		String password = user.getPassword();
//		return userService.loginUser(userName, password);
//	}

	//addElection
	@PostMapping(value = "/addelection")
	public Election addElection(@RequestBody @Valid ElectionDTO electionDTO) {
		return electionService.addElection(electionDTO);
	}

	//viewElection
	@GetMapping(value = "/viewelection{id}")
	public ElectionDTO viewElection(@PathVariable("id") int electionId) throws ElectionNotFoundException {
		return electionService.viewElection(electionId);
	}

	//addParty
	@PostMapping(value = "/addparty")
	public Party addParty(@RequestBody @Valid PartyDTO partyDTO) {
		return partyService.addParty(partyDTO);
	}

	//viewParty
	@GetMapping(value = "/viewparty/{id}")
	public PartyDTO viewParty(@PathVariable("id") int partyId) throws PartyNotFoundException {
		return partyService.viewParty(partyId);
	}

	//addCandidate
	@PostMapping(value = "/registercandidate")
	public String addCandidate(@RequestBody @Valid CandidateDTO candidateDTO) throws CandidateAlreadyExistsException {
		return candidateService.addCandidate(candidateDTO);
	}

	//viewCandidate
	@GetMapping(value = "/viewcandidate/{id}")
	public CandidateDTO viewCandidate(@PathVariable("id") int userId) throws CandidateNotFoundException {
		return adminServices.viewCandidate(userId);
	}

	//viewAllCandidate
	@GetMapping(value = "/viewallcandidates")
	public List<Candidate> viewAllCandidate() {
		return candidateService.viewAllCandidates();
	}

	//viewVoterRequest
	@GetMapping(value = "/viewvoterreq/{id}")
	public VoterRequestDTO viewVoterRequest(@PathVariable("id") int requestId) throws VoterRequestNotFoundException {
		return voterRequestService.viewVoterRequest(requestId);
	}

	//addSchedule
	@PostMapping(value = "/addschedule")
	public Schedule addSchedule(@RequestBody @Valid ScheduleDTO scheduleDTO) {
		return scheduleService.addSchedule(scheduleDTO);
	}

	// update schedule
	@PutMapping(value = "/updateschedule")
	public Schedule updateSchedule(@RequestBody @Valid ScheduleDTO scheduleDTO) {
		return scheduleService.updateSchedule(scheduleDTO);
	}

	//deleteSchedule
	@DeleteMapping(value = "/deleteschedule/{id}")
	public String deleteSchedule(@PathVariable("id") int scheduleId) throws ScheduleNotFoundException {
		return scheduleService.deleteSchedule(scheduleId);
	}

	//updateElection
	@PutMapping(value = "/updateelection")
	public Election updateElection(@RequestBody @Valid ElectionDTO electionDTO) {
		return electionService.updateElection(electionDTO);
	}

	//viewAllVoterRequest
	@GetMapping(value = "/viewallrequests")
	public List<VoterRequest> viewAllVoterRequest() {
		return voterRequestService.viewAllVoterRequest();
	}
	
	//viewAllUsers
	@GetMapping(value="/viewalluser")
	public List<User> viewAllUsers(){
		return userService.viewAllUser();
	}

	// deleteParty
	@DeleteMapping(value = "/deleteparty/{id}")
	public String deleteParty(@PathVariable("id") int partyId) throws PartyNotFoundException {
		return partyService.deleteParty(partyId);
	}

	// updateParty
	@PutMapping(value = "/updateparty")
	public Party modifyParty(@RequestBody @Valid PartyDTO partyDto) throws PartyNotFoundException {
		return partyService.updateParty(partyDto);
	}

	//viewAllParty
	@GetMapping(value = "/viewallparty")
	public List<Party> viewAllParty() {
		return partyService.viewAllParty();
	}

	//updateAdmin
	@PutMapping(value = "/updateadmin")
	public Admin updateAdmin(@RequestBody @Valid AdminDTO adminDTO) {
		return adminServices.updateAdmin(adminDTO);
	}

	//viewAdmin
	@GetMapping(value = "/viewadmin/{id}")
	public AdminDTO viewAdmin(@PathVariable("id") int userId) throws AdminNotFoundException {
		return adminServices.viewAdmin(userId);
	}

	//approveVoterRequest
	@PostMapping(value = "/permissionadmin")
	public VoterRequest approveVoterRequest(@RequestBody VoterRequestDTO voterRequestDTO) {
		return voterRequestService.approveVoterRequest(voterRequestDTO);
	}

	// updateCandidate
	@PutMapping(value = "/updatecandidate")
	public Candidate updateCandidate(@RequestBody @Valid CandidateDTO candidateDto) throws CandidateNotFoundException {
		return candidateService.updateCandidate(candidateDto);
	}

	//viewAllElectoralOfficer
	@GetMapping(value = "/viewallelectoralOfficer")
	public List<ElectoralOfficer> viewAllElectoralOfficer() {
		return  electoralOfficerService.viewAllElectoralOfficer();
	}

}
