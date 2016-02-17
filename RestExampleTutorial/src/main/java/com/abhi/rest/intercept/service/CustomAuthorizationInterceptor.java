package com.abhi.rest.intercept.service;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.PostProcessInterceptor;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;

import com.abhi.rest.intercept.annotation.CustomValidator;
import com.abhi.rest.intercept.annotation.HighestPrecedence;
import com.abhi.rest.intercept.validator.BaseValidator;

/**
 * @author Abhishek
 *
 */
@Provider
@HighestPrecedence
@ServerInterceptor
public class CustomAuthorizationInterceptor implements PreProcessInterceptor, PostProcessInterceptor{
	

	@Override
	public void postProcess(ServerResponse arg0) {
		
	}

	@Override
	public ServerResponse preProcess(HttpRequest req, ResourceMethod resourceMethod)
			throws Failure, WebApplicationException {

		 Class<? extends BaseValidator>[] validators = resourceMethod.getMethod().getAnnotation(CustomValidator.class).value();
		 for (Class<? extends BaseValidator> validator : validators)
		 {
			
			 try {
				validator.newInstance().validate(req);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			 
		 }
		return null;
	}

}
