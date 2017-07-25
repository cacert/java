package com.example.restservice.demo;

import javax.ws.rs.core.Response;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;

public class MyResponse {
	@Autowired
	CamelContext camelContext;
	
	public Response response() {
		System.err.println("camelcontext == null" + camelContext == null);
		return Response.ok("response").build();
	}
}
