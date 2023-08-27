package com.h.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 
import com.h.model.AdminLogin;



@Repository
public interface AdminRegisterRepo extends JpaRepository<AdminLogin,Integer> {
	

	
//	public Optional<AdminLogin> findByEmail(String email);
	
	public AdminLogin findByEmail(String email);
	
	public AdminLogin findByPhoneNumber(Long phoneNumber);
	
	public Optional<AdminLogin> findByPassword(String password);
	
	public Optional<AdminLogin> findByEmailAndPassword(String email, String password);
	

}
