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

import com.h.model.Doctor;
import com.h.service.DoctorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

	@Autowired
	DoctorService dservice;
	
	@PostMapping("/add")
	public Doctor reg(@RequestBody Doctor d) {
		return dservice.register(d);
		
	}
	
	@PostMapping("/login")
	public Doctor log(@RequestBody Doctor d) {
		return dservice.login(d);
		
	}
	
	
	@GetMapping("/listall")
	public List<Doctor> listAll() {
		return dservice.listDoctors();
	}
	
	@GetMapping("/listbyid/{id}")
	public Doctor listId(@PathVariable int id) {
		return dservice.listById(id);
	}
	
	@GetMapping("/listByName/{email}")
	public Doctor listByname(@PathVariable String email){
		return dservice.listByName(email);
		
	}
	
	@PutMapping("/update/{id}")
	public Doctor update(@RequestBody Doctor pl, @PathVariable int id) {
		pl.setDId(id);
		return dservice.updateDoctor(pl); 
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseEntity<String>> delete(@PathVariable int id) {
	    ResponseEntity<String> result = dservice.deleteDoctor(id);
	    return ResponseEntity.ok(result);
	}
}
