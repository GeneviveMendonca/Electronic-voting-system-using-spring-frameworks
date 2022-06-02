package com.electronicvotingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronicvotingsystem.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}
