package com.electronicvotingsystem.service;

import java.util.List;

import com.electronicvotingsystem.entity.Schedule;
import com.electronicvotingsystem.exception.ScheduleAlreadyExistsException;
import com.electronicvotingsystem.exception.ScheduleNotFoundException;
import com.electronicvotingsystem.model.ScheduleDTO;

public interface ScheduleService {

	public Schedule addSchedule(ScheduleDTO scheduleDTO) throws ScheduleAlreadyExistsException;

	public ScheduleDTO viewSchedule(int scheduleId) throws ScheduleNotFoundException;

	public List<Schedule> viewAllSchedule();

	public String deleteSchedule(int scheduleId) throws ScheduleNotFoundException;

	Schedule updateSchedule(ScheduleDTO scheduleDTO) throws ScheduleNotFoundException;
}
