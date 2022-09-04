package com.electronicvotingsystem.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.electronicvotingsystem.entity.Admin;
import com.electronicvotingsystem.entity.Candidate;
import com.electronicvotingsystem.entity.Election;
import com.electronicvotingsystem.entity.ElectoralOfficer;
import com.electronicvotingsystem.entity.Party;
import com.electronicvotingsystem.entity.Schedule;
import com.electronicvotingsystem.entity.Voter;
import com.electronicvotingsystem.entity.VoterRequest;
import com.electronicvotingsystem.model.AdminDTO;
import com.electronicvotingsystem.model.CandidateDTO;
import com.electronicvotingsystem.model.ElectionDTO;
import com.electronicvotingsystem.model.ElectoralOfficerDTO;
import com.electronicvotingsystem.model.PartyDTO;
import com.electronicvotingsystem.model.ScheduleDTO;
import com.electronicvotingsystem.model.VoterDTO;
import com.electronicvotingsystem.model.VoterRequestDTO;

@Component
public class ConversionClass {

	//converting PartyDTO to entity

	public Party convertToPartyEntity(PartyDTO partyDTO) {
		Party party = new Party();
		if(partyDTO!=null){
		BeanUtils.copyProperties(partyDTO, party);
		}
		return party;
	}

	//converting entity to PartyDTO

	public PartyDTO convertToPartyDTO(Party party) {
		PartyDTO partyDto = new PartyDTO();
		if(party!=null){
		BeanUtils.copyProperties(party,partyDto);
		}
		return partyDto;
	}
	//converting VoterRequestDTO to entity

	public VoterRequest convertToVoterRequestEntity(VoterRequestDTO voterRequestDTO) {
		VoterRequest voterRequest= new VoterRequest();
		if(voterRequestDTO!=null) {
		BeanUtils.copyProperties(voterRequestDTO, voterRequest);
		}
		return voterRequest;
	}

	//converting entity to VoterRequestDTO

	public VoterRequestDTO convertToVoterRequestDTO(VoterRequest voterRequest) {
		VoterRequestDTO voterRequestDto = new VoterRequestDTO();
		if(voterRequest!=null){
		BeanUtils.copyProperties(voterRequest, voterRequestDto);
		}
		return voterRequestDto;
	}

	//Converting  ElectionDTO to entity

	public Election convertToElectionEntity(ElectionDTO electionDTO) {
		Election election = new Election();
		if(electionDTO!=null) {
		BeanUtils.copyProperties(electionDTO, election);
		List<CandidateDTO> candidateDTOs = electionDTO.getCandidates();
		List<Candidate> candidates = new ArrayList<>();

		for(CandidateDTO candidateDTO : candidateDTOs) {
			candidates.add(convertToCandidateEntity(candidateDTO));
		}
		election.setCandidates(candidates);
		
		
		election.setSchedule(convertToScheduleEntity(electionDTO.getScheduleDTO()));
//
//		List<ScheduleDTO> scheduleDTOs = electionDTO.getSchedules();
//		List<Schedule> schedules = new ArrayList<>();
//
//		for(ScheduleDTO scheduleDTO : scheduleDTOs) {
//			schedules.add(convertToScheduleEntity(scheduleDTO));
//		}
//		election.setSchedules(schedules);
//		
//		
//		List<VoterDTO> voterDTOs = electionDTO.getVotersDTOs();
//		List<Voter> voters = new ArrayList<>();
//		
//		for(VoterDTO voterDTO : voterDTOs) {
//			voters.add(convertToVoterEntity(voterDTO));
//		}
//		election.setVoters(voters);
		}

		return election;
	}

	//Converting entity to ElectionDTO

	public ElectionDTO convertToElectionDTO(Election election) {
		ElectionDTO electionDto = new ElectionDTO();
		if(election!=null){
		BeanUtils.copyProperties(election,electionDto);

		List<Candidate> candidates = election.getCandidates();
		List<CandidateDTO> candidatesDTOs = new ArrayList<>();
		for(Candidate candidate : candidates){
			candidatesDTOs.add(convertToCandidateDTO(candidate));
		}
		electionDto.setCandidates(candidatesDTOs);
		
		electionDto.setScheduleDTO(convertToScheduleDTO(election.getSchedule()));

//		List<Schedule> schedules = election.getSchedules();
//		List<ScheduleDTO> schedulesDTOs = new ArrayList<>();
//		for(Schedule schedule : schedules) {
//			schedulesDTOs.add(convertToScheduleDTO(schedule));
//		}
//		electionDto.setSchedules(schedulesDTOs);
//		
//		List<Voter> voters = election.getVoters();
//		List<VoterDTO> voterDTOs = new ArrayList<>();
//		for(Voter voter : voters) {
//			voterDTOs.add(convertToVoterDTO(voter));
//		}
//		electionDto.setVotersDTOs(voterDTOs);
		}
		
		return electionDto;

	}

	//Converting  CandidateDTO to entity

	public Candidate convertToCandidateEntity(CandidateDTO candidateDTO) {
		Candidate candidate = new Candidate();
		if(candidateDTO!=null) {
		BeanUtils.copyProperties(candidateDTO, candidate);
		
		candidate.setParty(convertToPartyEntity(candidateDTO.getPartyDTO()));
		}
		return candidate;
		
		
	}

	//Converting entity to CandidateDTO

	public CandidateDTO convertToCandidateDTO(Candidate candidate) {
		CandidateDTO candidateDto = new CandidateDTO();
		if(candidate!=null) {
		BeanUtils.copyProperties(candidate, candidateDto);
		
		candidateDto.setPartyDTO(convertToPartyDTO(candidate.getParty()));
		}
		return candidateDto;
		
	
	}

	//Converting  ScheduleDTO to entity

	public Schedule convertToScheduleEntity(ScheduleDTO scheduleDTO) {
		Schedule schedule = new Schedule();
		if(scheduleDTO!=null){
		BeanUtils.copyProperties(scheduleDTO, schedule);
		}
		return schedule;
	}

	//Converting entity to ScheduleDTO

	public ScheduleDTO convertToScheduleDTO(Schedule schedule) {
		ScheduleDTO scheduleDto= new ScheduleDTO();
		if(schedule!=null) {
		BeanUtils.copyProperties(schedule, scheduleDto);
		}
		return scheduleDto;
	}

	//Converting  VoterDTO to entity

	public Voter convertToVoterEntity(VoterDTO voterDTO) {
		Voter voter = new Voter();
		if(voterDTO!=null) {
		BeanUtils.copyProperties(voterDTO, voter);
		
		voter.setVoterRequest(convertToVoterRequestEntity(voterDTO.getVoterRequestDTO()));
		
		
		
//		List<VoterRequestDTO> voterRequestDTOs = voterDTO.getVoterRequest();
//		List<VoterRequest> voterRequests = new ArrayList<>();
//		for(VoterRequestDTO voterRequestDTO : voterRequestDTOs) {
//			
//			voterRequests.add(convertToVoterRequestEntity(voterRequestDTO));
//		}
//		
//		voter.setVoterRequest(voterRequests);
		}
		return voter;
	}

	//Converting entity to VoterDTO

	public VoterDTO convertToVoterDTO(Voter voter) {
		VoterDTO voterDto= new VoterDTO();
		if(voter!=null) {
		BeanUtils.copyProperties(voter, voterDto);
		
		
		voterDto.setVoterRequestDTO(convertToVoterRequestDTO(voter.getVoterRequest()));
		
//		List<VoterRequest> voterRequests = voter.getVoterRequest();
//		List<VoterRequestDTO> voterRequestDTOs = new ArrayList<>();
//	    for(VoterRequest voterRequest : voterRequests ) {
//			
//			voterRequestDTOs.add(convertToVoterRequestDTO(voterRequest));
//		}
//	    
//	    voterDto.setVoterRequest(voterRequestDTOs);
		}
		return voterDto;
	}

	//Converting  ElectoralDTO to entity

	public ElectoralOfficer convertToElectoralOfficerEntity(ElectoralOfficerDTO electoralOfficerDTO) {
		ElectoralOfficer electoralOfficer = new ElectoralOfficer();
		if(electoralOfficerDTO!=null) {
		BeanUtils.copyProperties(electoralOfficerDTO,electoralOfficer );
		List<VoterRequestDTO> voterRequestDTOs = electoralOfficerDTO.getVoterrequests();
		List<VoterRequest> voterRequests = new ArrayList<>();
		for(VoterRequestDTO voterRequestDTO : voterRequestDTOs) {
			
			voterRequests.add(convertToVoterRequestEntity(voterRequestDTO));
		}
		electoralOfficer.setVoterrequests(voterRequests);
		
		
		}
		return electoralOfficer;
	}

	//Converting entity to ElectoralDTO

	public ElectoralOfficerDTO convertToElectoralOfficerDTO(ElectoralOfficer electoralOfficer) {
		ElectoralOfficerDTO electoralOfficerDto= new ElectoralOfficerDTO();
		if(electoralOfficer!=null) {
		BeanUtils.copyProperties(electoralOfficer, electoralOfficerDto);
		
		List<VoterRequest> voterRequests = electoralOfficer.getVoterrequests();
		List<VoterRequestDTO> voterRequestDTOs = new ArrayList<>();
		for(VoterRequest voterRequest : voterRequests ) {
			
			voterRequestDTOs.add(convertToVoterRequestDTO(voterRequest));
		}
		 electoralOfficerDto.setVoterrequests(voterRequestDTOs);
		}
		return electoralOfficerDto;
	}

	//Converting  AdminDTO to entity

	public Admin convertToAdminEntity(AdminDTO adminDTO) {
		Admin admin = new Admin();
		if(adminDTO!=null) {
		BeanUtils.copyProperties(adminDTO, admin);
	}
		return admin;
	}

	//Converting entity to AdminDTO

	public AdminDTO convertToAdminDTO(Admin admin) {
		AdminDTO adminDto= new AdminDTO();
		if(admin !=null) {
		BeanUtils.copyProperties(admin, adminDto);
		}
		return adminDto;
	}

}
