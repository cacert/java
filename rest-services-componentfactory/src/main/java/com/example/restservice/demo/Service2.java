package com.example.restservice.demo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@WebService
@Path(value = "/hi2")
public class Service2 {
	@WebMethod
	@GET
	public Response hello() {return null;};
}
