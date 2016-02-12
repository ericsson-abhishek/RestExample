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
import org.springframework.context.ApplicationContext;

import com.abhi.rest.intercept.annotation.CustomValidator;
import com.abhi.rest.intercept.annotation.HighestPrecedence;
import com.abhi.rest.intercept.validator.BaseValidator;

//@Precedence("HIGHEST_PRECEDENCE")
@Provider
@HighestPrecedence
@ServerInterceptor
public class CustomAuthorizationInterceptor implements PreProcessInterceptor, PostProcessInterceptor{
	ApplicationContext ctx = null;
	
//	@Override
//	public void setApplicationContext(ApplicationContext arg0)
//			throws BeansException {
//		this.ctx = arg0;
//	}

	@Override
	public void postProcess(ServerResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServerResponse preProcess(HttpRequest req, ResourceMethod resourceMethod)
			throws Failure, WebApplicationException {

		 Class<? extends BaseValidator>[] validators = resourceMethod.getMethod().getAnnotation(CustomValidator.class).value();
		 for (Class<? extends BaseValidator> validator : validators)
		 {
			
			 try {
				validator.newInstance().validate();
				
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
		return null;
	}

}
