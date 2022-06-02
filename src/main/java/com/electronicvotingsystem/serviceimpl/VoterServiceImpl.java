package com.electronicvotingsystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicvotingsystem.dao.CandidateRepository;
import com.electronicvotingsystem.dao.ScheduleRepository;
import com.electronicvotingsystem.dao.UserRepository;
import com.electronicvotingsystem.dao.VoterRepository;
import com.electronicvotingsystem.dao.VoterRequestRepository;
import com.electronicvotingsystem.entity.Candidate;
import com.electronicvotingsystem.entity.Schedule;
import com.electronicvotingsystem.entity.Voter;
import com.electronicvotingsystem.entity.VoterRequest;
import com.electronicvotingsystem.exception.UserAlreadyExistsException;
import com.electronicvotingsystem.exception.VoterRequestNotFoundException;
import com.electronicvotingsystem.model.VoterDTO;
import com.electronicvotingsystem.model.VoterRequestDTO;
import com.electronicvotingsystem.service.VoterService;
import com.electronicvotingsystem.utils.ConversionClass;

@Service
public class VoterServiceImpl implements VoterService {

	@Autowired
	private VoterRepository voterRepo;

	@Autowired
	private ConversionClass convertt;

	@Autowired
	private VoterRequestRepository vtrRepo;

	@Autowired
	private ConversionClass converttVoterReqRepo;

	@Autowired
	private ScheduleRepository scheduleRepo;

	@Autowired
	private CandidateRepository candRepo;
	
	@Autowired
	private UserRepository userRepo;


	//register Voter
	@Override
	public String registerVoter(VoterDTO voterDTO) {
		String message = null;
		Voter voter = null;
		 if(this.userRepo.existsByUserName(voterDTO.getUserName())) {
		        throw new UserAlreadyExistsException("User with given userName already exist");
		 }
		 voter = voterRepo.save(convertt.convertToVoterEntity(voterDTO));
		 if(voter!=null) {
		 message="register Successfull";
		 }
		 return message;
	}

	// add voter request
	@Override
	public VoterRequest addVoterRequest(VoterRequestDTO voterRequestDTO) {

		return vtrRepo.save(converttVoterReqRepo.convertToVoterRequestEntity(voterRequestDTO));
	}

	//view voterId
	@Override
	public VoterRequestDTO viewVoterRequest(int requestId) throws VoterRequestNotFoundException {
		Optional<VoterRequest> voterRequest = vtrRepo.findById(requestId);
		VoterRequestDTO dto = null;
		VoterRequest vr = null;

		if (voterRequest.isPresent()) {
			vr = voterRequest.get();
			dto = convertt.convertToVoterRequestDTO(vr);
		} else {

			throw new VoterRequestNotFoundException("no such requests");
		}
		return dto;

	}

	// View All Schedule
	@Override 
	public List<Schedule> viewAllSchedule()
	{ 
		return scheduleRepo.findAll(); 
	}

	//View all Candidate

	@Override 
	public List<Candidate> viewAllCandidates()
	{ 
		return candRepo.findAll(); 
	}


}
