package com.abhi.rest.security;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

public class CustomSecurityContext implements SecurityContext {

	private final CustomUser user;
	public CustomSecurityContext(CustomUser currentUser) {
		this.user=currentUser;
	}
	@Override
	public Principal getUserPrincipal() {
		return user;
	}

	@Override
	public boolean isUserInRole(String paramString) {
		return user.getRoles().contains(paramString);
	}

	@Override
	public boolean isSecure() {
		return true;
	}

	@Override
	public String getAuthenticationScheme() {
		return SecurityContext.BASIC_AUTH;
	}

}
