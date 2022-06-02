package com.electronicvotingsystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicvotingsystem.dao.CandidateRepository;
import com.electronicvotingsystem.dao.UserRepository;
import com.electronicvotingsystem.entity.Candidate;
import com.electronicvotingsystem.exception.CandidateNotFoundException;
import com.electronicvotingsystem.exception.UserAlreadyExistsException;
import com.electronicvotingsystem.model.CandidateDTO;
import com.electronicvotingsystem.service.CandidateService;
import com.electronicvotingsystem.utils.ConversionClass;

@Service
public class CandidateServiceImpl implements CandidateService{

	@Autowired
	private CandidateRepository candRepo;
	
	@Autowired
	private ConversionClass convertCandidate;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public String addCandidate(CandidateDTO candidateDTO) {
		String message = null;
		Candidate candidate = null;
		 if(this.userRepo.existsByUserName(candidateDTO.getUserName())) {
		        throw new UserAlreadyExistsException("User with given userName already exist");
		 }
		 candidate = candRepo.save(convertCandidate.convertToCandidateEntity(candidateDTO));
		 if(candidate!=null) {
		 message="registered Successfull";
		 }
		 return message;
	}
	
	@Override
	public CandidateDTO viewCandidate(int userId)  throws CandidateNotFoundException{
		Optional<Candidate> candidate = candRepo.findById(userId);
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
		public Candidate updateCandidate(CandidateDTO candidateDTO) throws CandidateNotFoundException {
			Optional<Candidate> candidate = candRepo.findById(candidateDTO.getUserId());
			Candidate candidateRecord = null;
			if (candidate.isPresent()) {
				candidateRecord = candidate.get();
				candRepo.save(convertCandidate.convertToCandidateEntity(candidateDTO));

			} else {
				throw new CandidateNotFoundException("Candidate Not Found");
			}

			return candidateRecord;
		}

		@Override
		public String deleteCandidate(int userId) throws CandidateNotFoundException {
			Optional<Candidate> Candidate = candRepo.findById(userId);
			String message = null;
			if (Candidate.isPresent()) {
				candRepo.deleteById(userId);
				message = "Candidate Deleted Successfully";

			} else {
				message = "No Candidate Found";
				throw new CandidateNotFoundException(message);
			}
			return message;

		}
	
}
