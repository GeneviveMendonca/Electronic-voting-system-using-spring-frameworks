package com.electronicvotingsystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicvotingsystem.dao.PartyRepository;
import com.electronicvotingsystem.entity.Party;
import com.electronicvotingsystem.exception.PartyNotFoundException;
import com.electronicvotingsystem.model.PartyDTO;
import com.electronicvotingsystem.service.PartyService;
import com.electronicvotingsystem.utils.ConversionClass;

@Service
public class PartyServiceImpl implements PartyService {

	@Autowired
	private PartyRepository partyRepo;

	@Autowired
	private ConversionClass convertParty;

	@Override
	public Party addParty(PartyDTO partyDTO)
	{
		return partyRepo.save(convertParty.convertToPartyEntity(partyDTO));
	}

	@Override
	public PartyDTO viewParty(int partyId) throws PartyNotFoundException {

		Optional<Party> party = partyRepo.findById(partyId);
		PartyDTO dto = null;
		Party pou = null;
		if(party.isPresent()) {
			pou = party.get();
			dto=convertParty.convertToPartyDTO(pou);
		}
		else
		{
			throw new PartyNotFoundException("Party not Found");
		}
		return dto;	
	}

	//updateParty
	@Override
	public Party updateParty(PartyDTO partyDTO) throws PartyNotFoundException {
		Optional<Party> party = partyRepo.findById(partyDTO.getPartyId());
		Party partyRecord=null;
		if(party.isPresent()) {
			partyRecord= party.get();
			partyRepo.save(convertParty.convertToPartyEntity(partyDTO));

		}
		else {
			throw new PartyNotFoundException("Party Not Found");
		}

		return partyRecord;
	}

	//deleteParty
	@Override
	public String deleteParty(int partyId) throws PartyNotFoundException 
	{
		Optional<Party> Party = partyRepo.findById(partyId);
		String message=null;
		if(Party.isPresent()) {
			partyRepo.deleteById(partyId);
			message="Party Deleted Successfully";

		}else {
			message="No Party Found";
			throw new PartyNotFoundException(message);
		}
		return message;

	}

	//viewAllparty
	@Override
	public List<Party> viewAllParty() {

		return partyRepo.findAll();

	}
}




