package com.orellanab.springboot.torshavn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orellanab.springboot.torshavn.dto.LoginDTO;
import com.orellanab.springboot.torshavn.entity.AppUser;
import com.orellanab.springboot.torshavn.service.interfaces.AuthService;

@RestController
@RequestMapping("/api")
public class AuthController {
	
	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	@CrossOrigin
	@PostMapping("/login")
	public AppUser login(@RequestBody LoginDTO user) {
		return this.authService.findByUsername(user.getEmail());
	}
	
	@CrossOrigin
	@PostMapping("/users")
	public AppUser findUser(@RequestBody LoginDTO user) {
		return this.authService.findByUsername(user.getEmail());
	}

}
