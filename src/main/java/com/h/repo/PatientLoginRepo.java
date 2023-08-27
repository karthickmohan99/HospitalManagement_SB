package com.h.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.h.model.PatientLogin;

@Repository
public interface PatientLoginRepo extends JpaRepository<PatientLogin,Integer> {
	
	public PatientLogin findByEmail(String email);
	
    public PatientLogin findByPhoneNumber(Long phoneNumber);
	
	public Optional<PatientLogin> findByPassword(String password);
	
	public Optional<PatientLogin> findByEmailAndPassword(String email, String password);

}
