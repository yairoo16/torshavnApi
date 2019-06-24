package com.orellanab.springboot.torshavn.service.interfaces;

import java.util.List;

import com.orellanab.springboot.torshavn.entity.AppUser;

public interface UserService {

	public List<AppUser> findAllUsers();
}
