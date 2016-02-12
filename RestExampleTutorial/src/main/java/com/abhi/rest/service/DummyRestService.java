package com.abhi.rest.service;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.abhi.rest.intercept.annotation.CustomValidator;
import com.abhi.rest.intercept.validator.AuthorizationValidator;
@Path("/rest")
//@RolesAllowed("ADMIN")
public class DummyRestService {
	
	@GET
	@Path("/messageInt")
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("ADMIN")
	public Integer greet()
	{
		return 1;
	}
	
	
	@POST
	@Path("/messageInt")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public Integer greetPost( String name)
	{
		System.out.println("Post Method got invoked "+name);
		return 123;
	}
	
	
	@POST
	@Path("/FormMessageInt")
//	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public Integer greetPostForm(@FormParam("name") String name)
	{
		System.out.println("Post Method got invoked "+name);
		return 123;
	}
	
	@GET
	@Path("/message")
	@Produces(MediaType.APPLICATION_JSON)
	public String greetStr()
	{
		return "\"Abhishek\"";
	}
	
	@GET
	@Path("/testintercept")
	@Produces(MediaType.APPLICATION_JSON)
	@CustomValidator(value={AuthorizationValidator.class})
	@RolesAllowed("ADMIN")
	public String testIntercept()
	{
		return "\"Test is succesfull\"";
	}

}
