package com.electronicvotingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronicvotingsystem.entity.Election;

public interface ElectionRepository extends JpaRepository<Election, Integer> {

	

}
