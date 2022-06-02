package com.electronicvotingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronicvotingsystem.entity.Voter;

public interface VoterRepository extends JpaRepository<Voter,Integer>{
	
}
