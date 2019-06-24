package com.orellanab.springboot.torshavn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orellanab.springboot.torshavn.entity.AppUser;
import com.orellanab.springboot.torshavn.service.interfaces.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@CrossOrigin
	@GetMapping("/users")
	public List<AppUser> findAllArtists() {
		return this.userService.findAllUsers();
	}

}
