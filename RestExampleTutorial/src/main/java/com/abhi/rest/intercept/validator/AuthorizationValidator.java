package com.abhi.rest.intercept.validator;

import java.util.Arrays;

import javax.ws.rs.core.SecurityContext;

import org.jboss.resteasy.spi.ResteasyProviderFactory;

import com.abhi.rest.security.CustomSecurityContext;
import com.abhi.rest.security.CustomUser;

/**
 * @author Abhishek
 *
 */
public class AuthorizationValidator implements BaseValidator {

	public void validate()
	{
		// insert your custom code here for fetching the user and roles from Data-store
		// create the user correspondingly
		CustomUser user = new CustomUser();
		user.setRoles(Arrays.asList("ADMIN"));//intentionally hard-coded for testing purpose
		
		
		CustomSecurityContext con = new CustomSecurityContext(user);
		ResteasyProviderFactory.pushContext(SecurityContext.class, con);
	}
}
