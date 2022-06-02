package com.electronicvotingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronicvotingsystem.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>{

}
