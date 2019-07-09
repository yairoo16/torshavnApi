package com.orellanab.springboot.torshavn.security;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 4872782299961954126L;
	
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}

}
