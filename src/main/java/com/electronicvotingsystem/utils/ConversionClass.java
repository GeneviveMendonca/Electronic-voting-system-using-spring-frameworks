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
		BeanUtils.copyProperties(partyDTO, party);
		return party;
	}

	//converting entity to PartyDTO

	public PartyDTO convertToPartyDTO(Party party) {
		PartyDTO partyDto = new PartyDTO();
		BeanUtils.copyProperties(party,partyDto);
		return partyDto;
	}
	//converting VoterRequestDTO to entity

	public VoterRequest convertToVoterRequestEntity(VoterRequestDTO voterRequestDTO) {
		VoterRequest voterRequest= new VoterRequest();
		BeanUtils.copyProperties(voterRequestDTO, voterRequest);
		return voterRequest;
	}

	//converting entity to VoterRequestDTO

	public VoterRequestDTO convertToVoterRequestDTO(VoterRequest voterRequest) {
		VoterRequestDTO voterRequestDto = new VoterRequestDTO();
		BeanUtils.copyProperties(voterRequest, voterRequestDto);
		return voterRequestDto;
	}

	//Converting  ElectionDTO to entity

	public Election convertToElectionEntity(ElectionDTO electionDTO) {
		Election election = new Election();
		BeanUtils.copyProperties(electionDTO, election);
		List<CandidateDTO> candidateDTOs = electionDTO.getCandidates();
		List<Candidate> candidates = new ArrayList<>();

		for(CandidateDTO candidateDTO : candidateDTOs) {
			candidates.add(convertToCandidateEntity(candidateDTO));
		}
		election.setCandidates(candidates);

		List<ScheduleDTO> scheduleDTOs = electionDTO.getSchedules();
		List<Schedule> schedules = new ArrayList<>();

		for(ScheduleDTO scheduleDTO : scheduleDTOs) {
			schedules.add(convertToScheduleEntity(scheduleDTO));
		}
		election.setSchedules(schedules);

		return election;
	}

	//Converting entity to ElectionDTO

	public ElectionDTO convertToElectionDTO(Election election) {
		ElectionDTO electionDto = new ElectionDTO();
		BeanUtils.copyProperties(election,electionDto);

		List<Candidate> candidates = election.getCandidates();
		List<CandidateDTO> candidatesDTOs = new ArrayList<>();
		for(Candidate candidate : candidates){
			candidatesDTOs.add(convertToCandidateDTO(candidate));
		}
		electionDto.setCandidates(candidatesDTOs);

		List<Schedule> schedules = election.getSchedules();
		List<ScheduleDTO> schedulesDTOs = new ArrayList<>();
		for(Schedule schedule : schedules) {
			schedulesDTOs.add(convertToScheduleDTO(schedule));
		}
		electionDto.setSchedules(schedulesDTOs);

		return electionDto;

	}

	//Converting  CandidateDTO to entity

	public Candidate convertToCandidateEntity(CandidateDTO candidateDTO) {
		Candidate candidate = new Candidate();
		BeanUtils.copyProperties(candidateDTO, candidate);
		return candidate;
	}

	//Converting entity to CandidateDTO

	public CandidateDTO convertToCandidateDTO(Candidate candidate) {
		CandidateDTO candidateDto = new CandidateDTO();
		BeanUtils.copyProperties(candidate, candidateDto);
		return candidateDto;
	}

	//Converting  ScheduleDTO to entity

	public Schedule convertToScheduleEntity(ScheduleDTO scheduleDTO) {
		Schedule schedule = new Schedule();
		BeanUtils.copyProperties(scheduleDTO, schedule);
		return schedule;
	}

	//Converting entity to ScheduleDTO

	public ScheduleDTO convertToScheduleDTO(Schedule schedule) {
		ScheduleDTO scheduleDto= new ScheduleDTO();
		BeanUtils.copyProperties(schedule, scheduleDto);
		return scheduleDto;
	}

	//Converting  VoterDTO to entity

	public Voter convertToVoterEntity(VoterDTO voterDTO) {
		Voter voter = new Voter();
		BeanUtils.copyProperties(voterDTO, voter);
		return voter;
	}

	//Converting entity to VoterDTO

	public VoterDTO convertToVoterDTO(Voter voter) {
		VoterDTO voterDto= new VoterDTO();
		BeanUtils.copyProperties(voter, voterDto);
		return voterDto;
	}

	//Converting  ElectoralDTO to entity

	public ElectoralOfficer convertToElectoralOfficerEntity(ElectoralOfficerDTO electoralOfficerDTO) {
		ElectoralOfficer electoralOfficer = new ElectoralOfficer();
		BeanUtils.copyProperties(electoralOfficerDTO,electoralOfficer );
		

		
		
		return electoralOfficer;
	}

	//Converting entity to ElectoralDTO

	public ElectoralOfficerDTO convertToElectoralOfficerDTO(ElectoralOfficer electoralOfficer) {
		ElectoralOfficerDTO electoralOfficerDto= new ElectoralOfficerDTO();
		BeanUtils.copyProperties(electoralOfficer, electoralOfficerDto);
		return electoralOfficerDto;
	}

	//Converting  AdminDTO to entity

	public Admin convertToAdminEntity(AdminDTO adminDTO) {
		Admin admin = new Admin();
		BeanUtils.copyProperties(adminDTO, admin);
		return admin;
	}

	//Converting entity to AdminDTO

	public AdminDTO convertToAdminDTO(Admin admin) {
		AdminDTO adminDto= new AdminDTO();
		BeanUtils.copyProperties(admin, adminDto);
		return adminDto;
	}

}
