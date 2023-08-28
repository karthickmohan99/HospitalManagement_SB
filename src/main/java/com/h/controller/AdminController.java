package com.h.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.h.model.AdminLogin;
import com.h.service.AdminRegisterService;


@CrossOrigin(origins = {
	    "https://hospital-management-ng-h9kx.vercel.app",
	     "http://localhost:4200" 
	})
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	AdminRegisterService aservice;
	
	@PostMapping("/register")
	public AdminLogin reg(@RequestBody AdminLogin ar) {
		return aservice.register(ar);
		
	}
	
	@PostMapping("/login")
	public AdminLogin log(@RequestBody AdminLogin ar) {
		return aservice.login(ar);
		
	}
	
	@GetMapping("/listByName/{email}")
	public AdminLogin listByname(@PathVariable String email){
		return aservice.listByName(email);
		
	}

}
