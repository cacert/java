package com.example.restservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path(value = "/hi")
public class Service1 {
	@GET
	public String hello(){
		return "hi";
	}
}
