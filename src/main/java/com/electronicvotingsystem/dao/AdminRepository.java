package com.electronicvotingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronicvotingsystem.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
