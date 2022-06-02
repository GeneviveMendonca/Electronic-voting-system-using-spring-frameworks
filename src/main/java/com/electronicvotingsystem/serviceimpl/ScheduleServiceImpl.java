package com.electronicvotingsystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.electronicvotingsystem.dao.ScheduleRepository;
import com.electronicvotingsystem.entity.Schedule;
import com.electronicvotingsystem.exception.CandidateNotFoundException;
import com.electronicvotingsystem.exception.ScheduleNotFoundException;
import com.electronicvotingsystem.model.ScheduleDTO;
import com.electronicvotingsystem.service.ScheduleService;
import com.electronicvotingsystem.utils.ConversionClass;

@Service
public class ScheduleServiceImpl implements ScheduleService {


	@Autowired
	private ScheduleRepository scheduleRepo;

	@Autowired
	private ConversionClass convertSchedule;

	@Override
	public Schedule addSchedule(ScheduleDTO scheduleDTO) {
		return scheduleRepo.save(convertSchedule.convertToScheduleEntity(scheduleDTO));
	}

	@Override
	public ScheduleDTO viewSchedule(int scheduleId)  throws CandidateNotFoundException{
		Optional<Schedule> schedule = scheduleRepo.findById(scheduleId);
		ScheduleDTO message = null;
		Schedule sched = null;
		if(schedule.isPresent()) {
			sched = schedule.get();
			message = convertSchedule.convertToScheduleDTO(sched);
		}else {
			throw new CandidateNotFoundException("No such schedule");
		}
		return message;
	}

	@Override 
	public List<Schedule> viewAllSchedule()
	{ 
		return scheduleRepo.findAll(); 
	}

	@Override
	public Schedule updateSchedule(ScheduleDTO scheduleDTO) throws ScheduleNotFoundException {
		Optional<Schedule> schedule = scheduleRepo.findById(scheduleDTO.getScheduleId());
		Schedule scheduleRecord=null;
		if(schedule.isPresent()) {
			scheduleRecord= schedule.get();
			scheduleRepo.save(convertSchedule.convertToScheduleEntity(scheduleDTO));

		}
		else {
			throw new ScheduleNotFoundException("Schedule Not Found");
		}

		return scheduleRecord;
	}

	@Override
	public String deleteSchedule(int scheduleId) throws ScheduleNotFoundException 
	{
		Optional<Schedule> Schedule = scheduleRepo.findById(scheduleId);
		String message=null;
		if(Schedule.isPresent()) {
			scheduleRepo.deleteById(scheduleId);
			message="Schedule Deleted Successfully";

		}else {
			message="No Schedule Found";
			throw new ScheduleNotFoundException(message);
		}
		return message;

	}

}
