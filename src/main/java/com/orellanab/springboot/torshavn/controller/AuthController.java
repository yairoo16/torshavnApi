package com.orellanab.springboot.torshavn.controller;

import com.orellanab.springboot.torshavn.entity.User;
import com.orellanab.springboot.torshavn.security.JwtResponse;
import com.orellanab.springboot.torshavn.security.JwtTokenUtil;
import com.orellanab.springboot.torshavn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orellanab.springboot.torshavn.dto.UserDTO;

@RestController
@RequestMapping("/api")
public class AuthController {

	private AuthenticationManager authenticationManager;

	private JwtTokenUtil jwtTokenUtil;

	private UserService userService;

	@Autowired
	public AuthController(AuthenticationManager authenticationManager,
						  JwtTokenUtil jwtTokenUtil,
						  UserService userService
						  ) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenUtil = jwtTokenUtil;
		this.userService = userService;
	}
	
	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDTO user) throws Exception {

		authenticate(user.getUsername(), user.getPassword());

		final UserDetails userDetails = userService.loadUserByUsername(user.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
//	@CrossOrigin
//	@PostMapping("/register")
//	public AppUser register(@RequestBody UserDTO user) {
//		return this.authService.findByUsername(user.getEmail());
//	}

	private void authenticate(String username, String password) throws Exception {
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					username, password);
			this.authenticationManager.authenticate(authenticationToken);
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
