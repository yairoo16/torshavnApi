package com.orellanab.springboot.torshavn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orellanab.springboot.torshavn.entity.AppUser;
import com.orellanab.springboot.torshavn.repo.interfaces.UserRepo;
import com.orellanab.springboot.torshavn.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	private UserRepo userRepo;
	
	@Autowired
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	@Override
	public List<AppUser> findAllUsers() {
		return this.userRepo.findAllUsers();
	}

}
