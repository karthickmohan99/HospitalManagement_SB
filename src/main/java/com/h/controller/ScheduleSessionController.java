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

import com.h.model.ScheduleSession;
import com.h.service.ScheduleSessionService;

@CrossOrigin(origins = {
	    "https://hospital-management-ng-h9kx.vercel.app",
	     "http://localhost:4200" 
	})
@RestController
@RequestMapping("/api/session")
public class ScheduleSessionController {
	
	@Autowired
	ScheduleSessionService sessionservice;
	
	
	@PostMapping("/add")
	public ScheduleSession reg(@RequestBody ScheduleSession ss) {
		return sessionservice.addSession(ss);
		
	}
		
	@GetMapping("/listall")
	public List<ScheduleSession> listAll() {
		return sessionservice.listSession();
	}
	
	@GetMapping("/listbyid/{id}")
	public ScheduleSession listId(@PathVariable int id) {
		return sessionservice.listById(id);
	}
	
	
	
	@PutMapping("/update/{id}")
	public ScheduleSession update(@RequestBody ScheduleSession pl, @PathVariable int id) {
		pl.setSId(id);
		return sessionservice.updateSession(pl);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseEntity<String>> delete(@PathVariable int id) {
	    ResponseEntity<String> result = sessionservice.deleteSession(id);
	    return ResponseEntity.ok(result);
	}

}
