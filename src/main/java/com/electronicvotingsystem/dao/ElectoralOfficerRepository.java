package com.electronicvotingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronicvotingsystem.entity.ElectoralOfficer;

public interface ElectoralOfficerRepository extends JpaRepository<ElectoralOfficer, Integer> {

}
