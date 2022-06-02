package com.electronicvotingsystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicvotingsystem.dao.VoterRequestRepository;
import com.electronicvotingsystem.entity.VoterRequest;
import com.electronicvotingsystem.exception.VoterRequestNotFoundException;
import com.electronicvotingsystem.model.VoterRequestDTO;
import com.electronicvotingsystem.service.VoterRequestService;
import com.electronicvotingsystem.utils.ConversionClass;

@Service
public class VoterRequestServiceImpl implements VoterRequestService {

	@Autowired
	private VoterRequestRepository voterRequestRepo;

	@Autowired
	private ConversionClass convertVoterRequest;

	@Override
	public VoterRequest addVoterRequest(VoterRequestDTO voterRequestDTO) {

		return voterRequestRepo.save(convertVoterRequest.convertToVoterRequestEntity(voterRequestDTO));
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
	
//	@Override
//	public String approveVoterRequest(String result,VoterRequestDTO voterRequestDTO)  {
//	if(result.equalsIgnoreCase("APPROVE")==true) 
//	voterRequestRepo.save(convertVoterRequest.convertToVoterRequestEntity(voterRequestDTO));
//	return result;
//}
	
	public VoterRequest approveVoterRequest(VoterRequestDTO voterRequestDTO)throws VoterRequestNotFoundException {
		Optional<VoterRequest> voterRequest = voterRequestRepo.findById(voterRequestDTO.getRequestId());
		VoterRequest voter = null;
		if (voterRequest.isPresent()) {
			voter = voterRequest.get();
			voterRequestRepo.save(convertVoterRequest.convertToVoterRequestEntity(voterRequestDTO));

		} else {
			throw new VoterRequestNotFoundException("voterRequest Not Found");
		}

		return voter;
	}
	
}
	
