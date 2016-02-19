package com.abhi.rest.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.junit.Test;

public class TestRest {

	@Test
	public void test() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet req = new HttpGet("http://localhost:8080/secure-rest/rest/testintercept");
		req.setHeader("Authorization","Basic "+ Base64.getEncoder().encodeToString("Abhishek:12345".getBytes()));
		HttpResponse response = client.execute(req);
		BufferedReader rd = new BufferedReader(
				new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
		System.out.println(result.toString());
	}
			
	}
	


	@Test
	public void testWriter() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet req = new HttpGet("http://localhost:8090/secure-rest/rest/getEmployees");
		req.setHeader("accept", "application/json");
//		req.setHeader("Authorization","Basic "+ Base64.getEncoder().encodeToString("Abhishek:12345".getBytes()));
		HttpResponse response = client.execute(req);
		BufferedReader rd = new BufferedReader(
				new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
		System.out.println(result.toString());
	}
			
	}



}
