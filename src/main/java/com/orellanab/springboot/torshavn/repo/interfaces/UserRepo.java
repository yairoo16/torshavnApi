package com.orellanab.springboot.torshavn.repo.interfaces;

import java.util.List;

import com.orellanab.springboot.torshavn.entity.User;

public interface UserRepo {
	
	public List<User> findAllUsers();

	public User loadUserByUsername(String username);

	public User saveUser(User user);
	
	public boolean usernameExists(String username);
}
