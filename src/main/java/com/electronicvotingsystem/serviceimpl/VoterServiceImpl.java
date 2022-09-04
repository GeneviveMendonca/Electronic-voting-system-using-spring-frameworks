package com.electronicvotingsystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicvotingsystem.dao.CandidateRepository;
import com.electronicvotingsystem.dao.ElectionRepository;
import com.electronicvotingsystem.dao.ScheduleRepository;
import com.electronicvotingsystem.dao.UserRepository;
import com.electronicvotingsystem.dao.VoterRepository;
import com.electronicvotingsystem.dao.VoterRequestRepository;
import com.electronicvotingsystem.entity.Candidate;
import com.electronicvotingsystem.entity.Election;
import com.electronicvotingsystem.entity.Schedule;
import com.electronicvotingsystem.entity.Voter;
import com.electronicvotingsystem.entity.VoterRequest;
import com.electronicvotingsystem.exception.ApplicationStatusPendingException;
import com.electronicvotingsystem.exception.CandidateNotFoundException;
import com.electronicvotingsystem.exception.ElectionNotFoundException;
import com.electronicvotingsystem.exception.UserAlreadyExistsException;
import com.electronicvotingsystem.exception.VoterNotFoundException;
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
	private ElectionRepository electionRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private VoterRequestRepository voterRequestRepo;

	// register Voter
	@Override
	public String registerVoter(VoterDTO voterDTO) {
		String message = null;
		Voter voter = null;
		if (this.userRepo.existsByUserName(voterDTO.getUserName())) {
			throw new UserAlreadyExistsException("User with given userName already exist");

		}
		VoterRequest voterRequest = convertt.convertToVoterRequestEntity(voterDTO.getVoterRequestDTO());
		voterRequest.setDistrict(voterDTO.getDistrict());
		voter = convertt.convertToVoterEntity(voterDTO);
		voter.setVoterRequest(voterRequest);

		voter = voterRepo.save(voter);
		if (voter != null) {
			message = "register Successfull";
		}
		return message;
	}

	// update voter
	@Override
	public Voter updateVoter(VoterDTO voterDTO) throws VoterNotFoundException {
		Optional<Voter> voter = voterRepo.findById(voterDTO.getUserId());
		Voter voterRecord = null;
		if (voter.isPresent()) {
			voterRecord = voter.get();
			voterRepo.save(convertt.convertToVoterEntity(voterDTO));

		} else {
			throw new VoterNotFoundException("User Not Found");
		}

		return voterRecord;
	}

	// view voter
	@Override
	public VoterDTO viewVoter(int userId) throws VoterNotFoundException {
		Optional<Voter> voter = voterRepo.findById(userId);
		VoterDTO dto = null;
		Voter vote = null;
		if (voter.isPresent()) {
			vote = voter.get();
			dto = convertt.convertToVoterDTO(vote);
		} else {
			throw new VoterNotFoundException("No such User");
		}
		return dto;
	}

	// add voter request
	@Override
	public VoterRequest addVoterRequest(VoterRequestDTO voterRequestDTO) {

		return vtrRepo.save(converttVoterReqRepo.convertToVoterRequestEntity(voterRequestDTO));
	}

	// view voterRequest
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
	public List<Schedule> viewAllSchedule() {
		return scheduleRepo.findAll();
	}

	// View all Candidate

	@Override
	public List<Candidate> viewAllCandidates() {
		return candRepo.findAll();
	}

	// castVote

	@Override
	public String castVote(int electionId, int candidateId, int voterId, int requestId)// voterUserId
			throws ElectionNotFoundException, CandidateNotFoundException, ApplicationStatusPendingException {
		Voter voter = null;
		Election elect = null;
		String message = null;
		VoterRequest voterRequest = null;

		Optional<Election> election = electionRepo.findById(electionId);

		if (election.isPresent()) {
			elect = election.get();

			voter = voterRepo.findById(voterId).get();

			voterRequest = voterRequestRepo.findById(requestId).get();
			if (voterRequest.getApplicationStatus().equalsIgnoreCase("approved")) {

				if (voter.isHasVoted() == false) {

					List<Candidate> candidates = elect.getCandidates();

					boolean found = false;
					int size = candidates.size();

					for (int i = 0; i < size; i++) {

						Candidate candidate = candidates.get(i);

						if (candidate.getUserId() == candidateId) {

							long currentCount = candidate.getVotecount();
							candidate.setVotecount(currentCount + 1);

							voter.setHasVoted(true);
							candidates.set(i, candidate);
							found = true;
							electionRepo.save(elect);
							voterRepo.save(voter);
							message = "vote casted sucessfully";
							break;

						}
					}

					if (!found) {
						message = "no such candidate";
						throw new CandidateNotFoundException("no such candidate");
					}
				} else {
					message = "no such election";
					throw new ElectionNotFoundException("no such election");
				}
			} else {
				message = "Application status not approved";

			}
		}

		else {
			message = "you have already voted!";
		}
		return message;
	}

	// viewAllVoter
	@Override
	public List<Voter> viewAllVoter() {

		return voterRepo.findAll();
	}
}
