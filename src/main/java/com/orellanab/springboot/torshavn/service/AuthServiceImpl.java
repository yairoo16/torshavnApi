package com.orellanab.springboot.torshavn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orellanab.springboot.torshavn.entity.AppUser;
import com.orellanab.springboot.torshavn.repo.interfaces.AuthRepo;
import com.orellanab.springboot.torshavn.service.interfaces.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	
	private AuthRepo authRepo;
	
	@Autowired
	public AuthServiceImpl(AuthRepo authRepo) {
		this.authRepo = authRepo;
	}
	@Override
	public AppUser findByUsername(String email) {
		
		return this.authRepo.findByUsername(email);
	}

}
