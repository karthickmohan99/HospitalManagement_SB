package com.h.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.h.exception.NotFound;
import com.h.model.Appointment;
import com.h.repo.AppointmentRepo;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepo aprepo;
	
	public Appointment addAppoitment(Appointment ap) {
		return aprepo.save(ap);
		
	}
	
	public List<Appointment> listAppotment(){
		return aprepo.findAll();
	}
	
	public Appointment listById(int id) {
		Optional <Appointment> op = aprepo.findById(id);
		
		if(op.isPresent()) 
			return op.get();
		else {
			throw new NotFound("Appointment not found : "+id);
		}
		
	}
	
	public Appointment updateAppointment(Appointment ss) {
		boolean status = aprepo.existsById(ss.getApId());
		
		if(status!=false) 
			
			return aprepo.save(ss);
		else {
			throw new NotFound("Appointment not found");
		}
	}


	public ResponseEntity<String> deleteAppointment(int id) {
	    Optional<Appointment> op = aprepo.findById(id);

	    if (op.isEmpty()) {
	        throw new NotFound("Doctor not found");
	    } else {
	    	aprepo.deleteById(id);
	        return ResponseEntity.ok().body("Deleted successfully");
	    }
	}
	

}
