package com.h.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.h.model.Doctor;


@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Integer> {
	
	public Doctor findByEmail(String email);
	
    public Doctor findByPhoneNumber(Long phoneNumber);
	
	public Optional<Doctor> findByPassword(String password);
	
	public Optional<Doctor> findByEmailAndPassword(String email, String password);

}
