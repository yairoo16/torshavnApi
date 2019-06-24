package com.orellanab.springboot.torshavn.repo.interfaces;

import com.orellanab.springboot.torshavn.entity.AppUser;

public interface AuthRepo {
	
	public AppUser findByUsername(String email);

}
