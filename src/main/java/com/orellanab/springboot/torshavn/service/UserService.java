package com.orellanab.springboot.torshavn.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.orellanab.springboot.torshavn.entity.User;
import com.orellanab.springboot.torshavn.repo.interfaces.UserRepo;

@Service
public class UserService implements UserDetailsService {
	
	private UserRepo userRepo;

	// private PasswordEncoder bcryptEncoder;
	
	@Autowired
	public UserService(UserRepo userRepo
			//, PasswordEncoder bcryptEncoder
					   ) {

		this.userRepo = userRepo;
		// this.bcryptEncoder = bcryptEncoder;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = this.userRepo.loadUserByUsername(username);

		if (user != null) {

//			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//			grantedAuthorities.add(new SimpleGrantedAuthority(user.getUsername()));
//
//			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);

			if ("test123".equals(username)) {
				return new
						org.springframework.security.core.userdetails.User("test123", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
						new ArrayList<>());
			} else {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}

		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

	}

	public User saveUser(User user) {

		return this.userRepo.saveUser(user);
	}
	
	public boolean usernameExists(String username) {
		
		return this.userRepo.usernameExists(username);
	}



}
