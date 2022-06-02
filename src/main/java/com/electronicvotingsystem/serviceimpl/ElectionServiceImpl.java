package com.electronicvotingsystem.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map.Entry;
import org.springframework.stereotype.Service;

import com.electronicvotingsystem.dao.ElectionRepository;
import com.electronicvotingsystem.entity.Candidate;
import com.electronicvotingsystem.entity.Election;
import com.electronicvotingsystem.exception.CandidateNotFoundException;
import com.electronicvotingsystem.exception.ElectionNotFoundException;
import com.electronicvotingsystem.model.ElectionDTO;
import com.electronicvotingsystem.service.ElectionService;
import com.electronicvotingsystem.utils.ConversionClass;

@Service
public class ElectionServiceImpl implements ElectionService {

	@Autowired
	private ElectionRepository electionRepo;

	@Autowired
	private ConversionClass convertElection;

	@Override
	public Election addElection(ElectionDTO electionDto){

		return electionRepo.save(convertElection.convertToElectionEntity(electionDto));
	}

	@Override
	public List<Election> viewAllElection() {

		return electionRepo.findAll();
	}
	
	// viewElection

	@Override
	public ElectionDTO viewElection(int electionId) throws ElectionNotFoundException {

		Optional<Election> election = electionRepo.findById(electionId);
		ElectionDTO elecDto = null;
		Election elec = null;
		if(election.isPresent()) {
			elec = election.get();
			elecDto=convertElection.convertToElectionDTO(elec);
		}
		else
		{
			throw new ElectionNotFoundException("Election not Found");
		}
		return elecDto;	
	}
	
	//Update Election

	@Override
	public Election updateElection(ElectionDTO electionDTO) throws ElectionNotFoundException {
		Optional<Election> election = electionRepo.findById(electionDTO.getElectionId());
		Election electionRecord=null;
		if(election.isPresent()) {
			electionRecord= election.get();
			electionRepo.save(convertElection.convertToElectionEntity(electionDTO));

		}
		else {
			throw new ElectionNotFoundException("Election Not Found");
		}

		return electionRecord;
	}

	//castVote 

	@Override
	public String castVote(int electionId, int candidateId)
			throws ElectionNotFoundException, CandidateNotFoundException {
		Election elect = null;
		String message = null;
		Optional<Election> election = electionRepo.findById(electionId);

		if(election.isPresent()) {
			elect = election.get();

			List<Candidate> candidates = elect.getCandidates();

			boolean found = false;
			int size = candidates.size();

			for(int i = 0; i < size; i++) {

				Candidate candidate = candidates.get(i);

				if(candidate.getUserId()==candidateId) {

					long currentCount = candidate.getVotecount();
					candidate.setVotecount(currentCount+1);

					candidates.set(i, candidate);
					found = true;
					electionRepo.save(elect);
					message = "vote casted sucessfully";
					break;

				}
			}
			if(!found)
			{
				message="no such candidate";
				throw new CandidateNotFoundException("no such candidate");
			}
		}
		else {
			message="no such election";
			throw new ElectionNotFoundException("no such election");
		}
		return message;
	}

	//Calculating results
	
	@Override
	public Map<String, String> calculateResults(int electionId) throws ElectionNotFoundException {
		Optional<Election> opElection = electionRepo.findById(electionId);
		
		//ElectionDTO electionDTO = viewElection(electionId);
		
		Election election = opElection.get();//convertElection.convertToElectionEntity(electionDTO);
		
		List<Candidate> candidates = election.getCandidates();
		
		Map<String,String> electionResult = new HashMap<>();
		
		List<String>constituencies = candidates.stream().map((n)->n.getConstituency()).distinct().toList();
		
		Map<String,List<Candidate>> constiDetails = new HashMap<>();
		
		for(String constituency:constituencies ) {
			
			List<Candidate> constCandidates = candidates.stream().
					filter((n)->n.getConstituency().equalsIgnoreCase(constituency)).toList();
			
			constiDetails.put(constituency, constCandidates);
		}
		
		Set<Entry<String,List<Candidate>>> electionEntries = constiDetails.entrySet();
		
		for(Entry<String,List<Candidate>> electionEntry : electionEntries  ) {
			
			String constituency = electionEntry.getKey();
			List<Candidate> allCandidates = electionEntry.getValue();
			
			Optional<String> winnerCandidate = allCandidates.stream()
                  .max((a,b)->(int)a.getVotecount()>(int)b.getVotecount()?(int)a.getVotecount():(int)b.getVotecount())
                  .map((n)->n.getName());
			electionResult.put(constituency, winnerCandidate.get());
		}
		
		return electionResult;
	}


	
}
