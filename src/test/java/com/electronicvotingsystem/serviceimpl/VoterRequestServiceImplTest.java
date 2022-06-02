package com.electronicvotingsystem.serviceimpl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.electronicvotingsystem.dao.VoterRequestRepository;
import com.electronicvotingsystem.entity.VoterRequest;
import com.electronicvotingsystem.model.VoterRequestDTO;
import com.electronicvotingsystem.utils.ConversionClass;

@ExtendWith(MockitoExtension.class)
public class VoterRequestServiceImplTest {

	@InjectMocks
	VoterRequestServiceImpl voterRequestServiceImpl;
	@Mock
	VoterRequestRepository voterRequestRepo;
	@Mock
	ConversionClass converter;

	static VoterRequest voterRequest;
	static VoterRequestDTO voterRequestDto;

	@BeforeEach
	public void setUp() {
		voterRequestDto = new VoterRequestDTO();
		voterRequestDto.setRequestId(1);

	}

	@Test
	public void testaddVoterRequest() {
		Mockito.when(converter.convertToVoterRequestEntity(voterRequestDto)).thenReturn(voterRequest);
		Mockito.when(voterRequestRepo.save(voterRequest)).thenReturn(voterRequest);
		assertThat(voterRequestServiceImpl.addVoterRequest(voterRequestDto)).isEqualTo(voterRequest);
	}

}
