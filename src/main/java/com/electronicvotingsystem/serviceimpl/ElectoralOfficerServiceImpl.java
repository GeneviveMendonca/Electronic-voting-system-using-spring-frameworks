package com.electronicvotingsystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicvotingsystem.dao.ElectoralOfficerRepository;
import com.electronicvotingsystem.dao.UserRepository;
import com.electronicvotingsystem.dao.VoterRequestRepository;
import com.electronicvotingsystem.entity.ElectoralOfficer;
import com.electronicvotingsystem.entity.VoterRequest;
import com.electronicvotingsystem.exception.UserAlreadyExistsException;
import com.electronicvotingsystem.exception.VoterRequestNotFoundException;
import com.electronicvotingsystem.model.ElectoralOfficerDTO;
import com.electronicvotingsystem.model.VoterRequestDTO;
import com.electronicvotingsystem.service.ElectoralOfficerService;
import com.electronicvotingsystem.utils.ConversionClass;

@Service
public class ElectoralOfficerServiceImpl implements ElectoralOfficerService{
	
	
	@Autowired
	private ElectoralOfficerRepository electoralOfficerRepo;
	
	@Autowired
	private ConversionClass convertelectoralOfficerRepo ;

	@Autowired
	private VoterRequestRepository voterRequestRepo;
	
	@Autowired
	private ConversionClass convertVoterRequest;
	
	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public String registerElectoralOfficer(ElectoralOfficerDTO electoralOfficerDTO) {
		String message=null;
		ElectoralOfficer electoralOfficer = null;
		 if(this.userRepo.existsByUserName(electoralOfficerDTO.getUserName())) {
		        throw new UserAlreadyExistsException("User with given userName already exist");
		 }
		 electoralOfficer = electoralOfficerRepo.save(convertelectoralOfficerRepo.convertToElectoralOfficerEntity(electoralOfficerDTO));
		 if(electoralOfficer!=null) {
		 message="register Successfull";
		 }
		 return message;
	}
	
	
	@Override
	public VoterRequestDTO viewVoterRequest(int requestId) throws VoterRequestNotFoundException {
		Optional<VoterRequest> voterRequest = voterRequestRepo.findById(requestId);
		VoterRequestDTO dto = null;
		VoterRequest vr = null;

		if (voterRequest.isPresent()) {
			vr = voterRequest.get();
			dto = convertVoterRequest.convertToVoterRequestDTO(vr);
		} else {

			throw new VoterRequestNotFoundException("no such requests");
		}
		return dto;
	}

	@Override
	public List<VoterRequest> viewAllVoterRequest() {

		return voterRequestRepo.findAll();

	}

	@Override
	public String approveVoterRequest(String result,VoterRequestDTO voterRequestDTO)  {
	if(result.equalsIgnoreCase("APPROVE")==true) 
	voterRequestRepo.save(convertVoterRequest.convertToVoterRequestEntity(voterRequestDTO));
	return result;
}

	
	
	

}
