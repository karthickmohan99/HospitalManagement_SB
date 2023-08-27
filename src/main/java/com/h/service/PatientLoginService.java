package com.h.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.h.model.PatientLogin;
import com.h.repo.PatientLoginRepo;
import com.h.exception.AlreadyExistException;
import com.h.exception.NotFound;


@Service
public class PatientLoginService {
	
	@Autowired
	PatientLoginRepo patientrepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public PatientLogin register(PatientLogin pr){
		
	PatientLogin checkEmail = patientrepo.findByEmail(pr.getEmail());
    PatientLogin checkNumber = patientrepo.findByPhoneNumber(pr.getPhoneNumber());
		
		if(checkEmail!=null) 
			throw new NotFound("Email already exist");
		else {
			if(checkNumber!=null) {
				throw new NotFound("Phone number already exist");
			}else {
				String encodedPassword = this.passwordEncoder.encode(pr.getPassword());
				pr.setPassword(encodedPassword);
				pr.setFirstName(pr.getFirstName().substring(0, 1).toUpperCase() + pr.getFirstName().substring(1).toLowerCase());
				pr.setLastName(pr.getLastName().substring(0, 1).toUpperCase() + pr.getLastName().substring(1).toLowerCase());
				pr.setGender(pr.getGender().substring(0, 1).toUpperCase() + pr.getGender().substring(1).toLowerCase());
				return patientrepo.save(pr);
			}
			
		}
		

		
	}
	
	public PatientLogin login(PatientLogin pr){
	
	PatientLogin pl = patientrepo.findByEmail(pr.getEmail());
	
	if (pl != null) {
		
		String password = pr.getPassword();
		String encodedPassword = pl.getPassword();
		Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
		
		if(isPwdRight) {
			Optional <PatientLogin> checkCredentials = patientrepo.findByEmailAndPassword(pr.getEmail(), encodedPassword);
			if(checkCredentials.isPresent()) {
				
				throw new AlreadyExistException("Login Sucessfully ");
			}
			else {
				throw new NotFound("Invalid credantial");
			}
			
		}else {
			throw new NotFound("Password is not match");
		}
	
	}else {
		 throw new NotFound("Email is not match");
    }
	
}
	
	
	public List<PatientLogin> listPatients(){
		return patientrepo.findAll();
	}
	
	public PatientLogin listById(int id) {
		Optional <PatientLogin> op = patientrepo.findById(id);
		
		if(op.isPresent()) 
			return op.get();
		else {
			throw new NotFound("Patient not found : "+id);
		}
		
	}
	
public PatientLogin listByName(String email){
	
		
		PatientLogin b1 = patientrepo.findByEmail(email);
		
		if(b1!=null) 
			
			return b1;
			
		
		else {
			throw new NotFound("Patient not found");
			
		}
	}
	
	
	public PatientLogin updatePatient(PatientLogin pl) {
		boolean status = patientrepo.existsById(pl.getPId());
		
		if(status!=false) 
			
			return patientrepo.save(pl);
		else {
			throw new NotFound("Patient not found");
		}
	}


	public ResponseEntity<String> deletePatient(int id) {
	    Optional<PatientLogin> op = patientrepo.findById(id);

	    if (op.isEmpty()) {
	        throw new NotFound("Doctor not found");
	    } else {
	    	patientrepo.deleteById(id);
	        return ResponseEntity.ok().body("Deleted successfully");
	    }
	}
}
