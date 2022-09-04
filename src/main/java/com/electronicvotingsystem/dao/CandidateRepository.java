package com.electronicvotingsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronicvotingsystem.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>{
	
	//findAllByConstituency
	List<Candidate> findAllByConstituency(String constituency);

}
