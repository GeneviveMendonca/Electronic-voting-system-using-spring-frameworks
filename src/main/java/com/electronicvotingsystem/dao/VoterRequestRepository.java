package com.electronicvotingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronicvotingsystem.entity.VoterRequest;

public interface VoterRequestRepository extends JpaRepository<VoterRequest, Integer>{

}
