package com.electronicvotingsystem.serviceimpl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.electronicvotingsystem.dao.PartyRepository;
import com.electronicvotingsystem.entity.Party;
import com.electronicvotingsystem.model.PartyDTO;
import com.electronicvotingsystem.utils.ConversionClass;

@ExtendWith(MockitoExtension.class)
public class PartyServiceImplTest 
{
	@InjectMocks
	PartyServiceImpl partyServiceImpl;
	
	@Mock
    PartyRepository partyRepo;
	@Mock
	ConversionClass converter;
	
	static Party party;
	static PartyDTO partyDto;
	
	@BeforeEach
	public void setUp() 
	{
		partyDto =new PartyDTO();
		partyDto.setPartyId(1);
		partyDto.setPartyName("JDS");
		partyDto.setLeader("Daksh");
		partyDto.setSymbol("EVS");
	}
	
	@Test
	public void testaddParty()
	{
		Mockito.when(converter.convertToPartyEntity(partyDto)).thenReturn(party);
		Mockito.when(partyRepo.save(party)).thenReturn(party);
		assertThat(partyServiceImpl.addParty(partyDto)).isEqualTo(party);
	}
	

}
