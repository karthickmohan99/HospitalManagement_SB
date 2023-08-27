package com.h.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.h.model.Appointment;


@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Integer> {

}
