package com.h.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.h.model.AdminLogin;
import com.h.repo.AdminRegisterRepo;
import com.h.exception.AlreadyExistException;
import com.h.exception.NotFound;
import com.h.exception.NotFoundException;

@Service
public class AdminRegisterService {
	
	@Autowired
	AdminRegisterRepo adminrepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public AdminLogin register(AdminLogin ar){
	
	AdminLogin checkNumber = adminrepo.findByPhoneNumber(ar.getPhoneNumber());
	AdminLogin checkEmail = adminrepo.findByEmail(ar.getEmail());
	
		if(checkEmail!=null) 
			throw new NotFoundException("Email already exist");
		else {
			if(checkNumber!=null) {
				throw new NotFoundException("Phone number already exist");
			}else {
				String encodedPassword = this.passwordEncoder.encode(ar.getPassword());
				ar.setPassword(encodedPassword);
				return adminrepo.save(ar);
			}
			
		}
		

		
	}
	
	public AdminLogin login(AdminLogin ar){
		
		AdminLogin ad = adminrepo.findByEmail(ar.getEmail());
		
		if (ad != null) {
			
			String password = ar.getPassword();
			String encodedPassword = ad.getPassword();
			Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
			
			if(isPwdRight) {
				Optional <AdminLogin> checkCredentials = adminrepo.findByEmailAndPassword(ar.getEmail(), encodedPassword);
				if(checkCredentials.isPresent()) 
					throw new AlreadyExistException("Login Sucessfully ");
				else {
					throw new NotFound("Invalid credantial");
				}
				
			}else {
				throw new NotFound("password is not match");
			}
		
		}else {
			 throw new NotFound("Email is not match");
	    }
	}

	public AdminLogin listByName(String email){
		
		
		AdminLogin b1 = adminrepo.findByEmail(email);
		
		if(b1!=null) 
			
			return b1;
			
		
		else {
			throw new NotFound("Admin not found");
			
		}
	}
}






