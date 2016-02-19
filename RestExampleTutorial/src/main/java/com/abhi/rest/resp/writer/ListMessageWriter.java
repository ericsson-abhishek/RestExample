package com.abhi.rest.resp.writer;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;

import om.abhi.rest.resource.Employee;
@Provider
public class ListMessageWriter implements MessageBodyWriter<List<Employee>> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		System.out.println(type);
		System.out.println(genericType);
		return true;
	}

	@Override
	public long getSize(List<Employee> t, Class<?> type, Type genericType, Annotation[] annotations,
			MediaType mediaType) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public void writeTo(List<Employee> t, Class<?> type, Type genericType, Annotation[] annotations,
			MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
					throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		StringBuffer sb = new StringBuffer("{\"employees\":");
		sb.append(mapper.writeValueAsString(t));
		sb.append("}");
		entityStream.write(sb.toString().getBytes());
		
//		for(Employee e: t)
//		{
//			
//		}
		
	}

}
