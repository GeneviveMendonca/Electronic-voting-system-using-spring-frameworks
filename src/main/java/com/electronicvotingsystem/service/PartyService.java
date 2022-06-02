package com.electronicvotingsystem.service;

import java.util.List;

import com.electronicvotingsystem.entity.Party;
import com.electronicvotingsystem.exception.PartyAlreadyExistsException;
import com.electronicvotingsystem.exception.PartyNotFoundException;
import com.electronicvotingsystem.model.PartyDTO;

public interface PartyService {

	//addParty
	public Party addParty(PartyDTO partyDTO) throws PartyAlreadyExistsException;

	//viewParty
	public PartyDTO viewParty(int partyId)throws PartyNotFoundException;

	//UpdateParty
	public Party updateParty( PartyDTO partyDTO)throws PartyNotFoundException;

	//deleteParty
	public String deleteParty(int partyId)throws PartyNotFoundException;
	
	//viewAllParty
	public List<Party> viewAllParty();

}
