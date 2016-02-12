package com.abhi.rest.security;

import java.security.Principal;
import java.util.List;

public class CustomUser implements Principal {

	private List<String> roles ;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "annonymous";
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
