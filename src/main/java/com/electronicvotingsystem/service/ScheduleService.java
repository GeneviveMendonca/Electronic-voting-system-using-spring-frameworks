package com.electronicvotingsystem.service;

import java.util.List;

import com.electronicvotingsystem.entity.Schedule;
import com.electronicvotingsystem.exception.ScheduleAlreadyExistsException;
import com.electronicvotingsystem.exception.ScheduleNotFoundException;
import com.electronicvotingsystem.model.ScheduleDTO;

public interface ScheduleService {

	//addSchedule
	public Schedule addSchedule(ScheduleDTO scheduleDTO) throws ScheduleAlreadyExistsException;

	//viewSchedule
	public ScheduleDTO viewSchedule(int scheduleId) throws ScheduleNotFoundException;

	//viewAllSchedule
	public List<Schedule> viewAllSchedule();

	//deleteSchedule
	public String deleteSchedule(int scheduleId) throws ScheduleNotFoundException;

	//updateSchedule
	Schedule updateSchedule(ScheduleDTO scheduleDTO) throws ScheduleNotFoundException;
}
