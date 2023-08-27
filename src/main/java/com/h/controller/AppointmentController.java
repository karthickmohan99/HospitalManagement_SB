package com.h.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h.model.Appointment;
import com.h.service.AppointmentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentService aservice;
	
	@PostMapping("/add")
	public Appointment reg(@RequestBody Appointment ap) {
		return aservice.addAppoitment(ap);
		
	}
		
	@GetMapping("/listall")
	public List<Appointment> listAll() {
		return aservice.listAppotment();
	}
	
	@GetMapping("/listbyid/{id}")
	public Appointment listId(@PathVariable int id) {
		return aservice.listById(id);
	}
	
	@PutMapping("/update/{id}")
	public Appointment update(@RequestBody Appointment pl, @PathVariable int id) {
		pl.setApId(id);
		return aservice.updateAppointment(pl);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseEntity<String>> delete(@PathVariable int id) {
	    ResponseEntity<String> result = aservice.deleteAppointment(id);
	    return ResponseEntity.ok(result);
	}
}
