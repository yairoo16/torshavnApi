package com.orellanab.springboot.torshavn.repo.interfaces;

import java.util.List;

import com.orellanab.springboot.torshavn.entity.AppUser;

public interface UserRepo {
	
	public List<AppUser> findAllUsers();
 

}
