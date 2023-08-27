package com.h.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.h.model.Doctor;
import com.h.repo.DoctorRepo;
import com.h.exception.AlreadyExistException;
import com.h.exception.NotFound;

@Service
public class DoctorService {
	
	@Autowired
	DoctorRepo doctorrepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Doctor register(Doctor pr){
		
		Doctor checkEmail = doctorrepo.findByEmail(pr.getEmail());
	    Doctor checkNumber = doctorrepo.findByPhoneNumber(pr.getPhoneNumber());
		
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
				pr.setQualification(pr.getQualification().toUpperCase());
				pr.setSpecialties(pr.getSpecialties().substring(0, 1).toUpperCase() + pr.getSpecialties().substring(1).toLowerCase());
				return doctorrepo.save(pr);
			}
			
		}
		

		
	}
	
	public Doctor login(Doctor pr){
	
		Doctor pl = doctorrepo.findByEmail(pr.getEmail());
	
	if (pl != null) {
		
		String password = pr.getPassword();
		String encodedPassword = pl.getPassword();
		Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
		
		if(isPwdRight) {
			Optional <Doctor> checkCredentials = doctorrepo.findByEmailAndPassword(pr.getEmail(), encodedPassword);
			if(checkCredentials.isPresent()) 
				throw new AlreadyExistException("Login Sucessfully ");
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
	
	
	public List<Doctor> listDoctors(){
		return doctorrepo.findAll();
	}
	
	public Doctor listById(int id) {
		Optional <Doctor> op = doctorrepo.findById(id);
		
		if(op.isPresent()) 
			return op.get();
		else {
			throw new NotFound("Doctor not found : "+id);
		}
		
	}
	
public Doctor listByName(String email){
	
		
		Doctor b1 = doctorrepo.findByEmail(email);
		
		if(b1!=null) 
			
			return b1;
			
		
		else {
			throw new NotFound("Doctor not found");
			
		}
	}
	
	
	public Doctor updateDoctor(Doctor pl) {
		boolean status = doctorrepo.existsById(pl.getDId());
		
		if(status!=false) 
			
			return doctorrepo.save(pl);
		else {
			throw new NotFound("Doctor not found");
		}
	}


	public ResponseEntity<String> deleteDoctor(int id) {
	    Optional<Doctor> op = doctorrepo.findById(id);

	    if (op.isEmpty()) {
	        throw new NotFound("Doctor not found");
	    } else {
	        doctorrepo.deleteById(id);
	        return ResponseEntity.ok().body("Deleted successfully");
	    }
	}

}
