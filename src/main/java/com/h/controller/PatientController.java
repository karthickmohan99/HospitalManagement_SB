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

import com.h.model.PatientLogin;
import com.h.service.PatientLoginService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/patient")
public class PatientController {

	@Autowired
	PatientLoginService pservice;
	
	@PostMapping("/register")
	public PatientLogin reg(@RequestBody PatientLogin pr) {
		return pservice.register(pr);
		
	}
	
	@PostMapping("/login")
	public PatientLogin log(@RequestBody PatientLogin pr) {
		return pservice.login(pr);
		
	}
	
	
	@GetMapping("/listall")
	public List<PatientLogin> listAll() {
		return pservice.listPatients();
	}
	
	@GetMapping("/listbyid/{id}")
	public PatientLogin listId(@PathVariable int id) {
		return pservice.listById(id);
	}
	
	@GetMapping("/listByName/{email}")
	public PatientLogin listByname(@PathVariable String email){
		return pservice.listByName(email);
		
	}
	
	@PutMapping("/update/{id}")
	public PatientLogin update(@RequestBody PatientLogin pl, @PathVariable int id) {
		pl.setPId(id);
		return pservice.updatePatient(pl); 
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseEntity<String>> delete(@PathVariable int id) {
	    ResponseEntity<String> result = pservice.deletePatient(id);
	    return ResponseEntity.ok(result);
	}
}
