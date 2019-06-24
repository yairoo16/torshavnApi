package com.orellanab.springboot.torshavn.service.interfaces;


import com.orellanab.springboot.torshavn.entity.AppUser;

public interface AuthService {

	public AppUser findByUsername(String email);
}
