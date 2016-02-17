package com.abhi.rest.intercept.validator;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.ws.rs.core.SecurityContext;

import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import com.abhi.rest.security.CustomSecurityContext;
import com.abhi.rest.security.CustomUser;

public class HeaderAuthenticationValidator implements BaseValidator {

	@Override
	public void validate(HttpRequest req) {
		final List<String> authorizations = req.getHttpHeaders().getRequestHeader("authorization");
		String authorization = authorizations.get(0);
		if (authorization != null && authorization.startsWith("Basic")) {
			// Authorization: Basic base64credentials
			String base64Credentials = authorization.substring("Basic".length()).trim();
			String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));
			// credentials = username:password
			final String[] values = credentials.split(":", 2);
			if (values[0].equals("Abhishek")&& values[1].equals("12345"));
			{
				CustomUser user = new CustomUser();
				user.setRoles(Arrays.asList("ADMIN"));//intentionally hard-coded for testing purpose
				CustomSecurityContext con = new CustomSecurityContext(user);
				ResteasyProviderFactory.pushContext(SecurityContext.class, con);
			}
			System.out.println(values);
		}

	}

}
