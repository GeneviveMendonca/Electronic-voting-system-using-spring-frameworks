package com.electronicvotingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronicvotingsystem.entity.Party;

public interface PartyRepository extends JpaRepository<Party,Integer>{

}
