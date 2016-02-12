package com.abhi.example;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces("application/json")
public class DummyWriter implements MessageBodyWriter<Integer> {

	@Override
	public long getSize(Integer arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4) {
		// TODO Auto-generated method stub
//		return String.valueOf(arg0).getBytes().length;
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {
		// TODO Auto-generated method stub
		System.out.println("Checking this");
		return arg1==Integer.class;
	}

	@Override
	public void writeTo(Integer arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4,
			MultivaluedMap<String, Object> arg5, OutputStream arg6) throws IOException, WebApplicationException {
		System.out.println("calling this");
		System.out.println(arg0);
		arg6.write(String.valueOf(arg0).getBytes());

	}
	private byte[] intToByteArray(int value) {
	    return new byte[] {
	            (byte)(value >>> 24),
	            (byte)(value >>> 16),
	            (byte)(value >>> 8),
	            (byte)value};
	}
}
