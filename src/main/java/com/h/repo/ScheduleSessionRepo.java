package com.h.repo;

import java.sql.Time;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h.model.PatientLogin;
import com.h.model.ScheduleSession;

public interface ScheduleSessionRepo extends JpaRepository<ScheduleSession,Integer>{
	
	public ScheduleSession findBySessionDateAndScheduleTime(String sessionDate, Time scheduleTime);
	public ScheduleSession findBySessionDate(String sessionDate);
	public ScheduleSession findByScheduleTime(Time scheduleTime);

}
