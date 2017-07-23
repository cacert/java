package com.example.restservice;

import javax.annotation.PostConstruct;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.CxfComponent;
import org.apache.camel.component.cxf.jaxrs.CxfRsEndpoint;
import org.apache.cxf.Bus;
import org.springframework.beans.factory.annotation.Autowired;

public class RestRouteBuilder{

	@Autowired
	CamelContext camelContext;
	
	@Autowired 
	Bus bus;
	@Autowired
	MyResponse response;
	
	@PostConstruct
	public void configure() throws Exception {
		
		System.err.println(response == null);
		CxfRsEndpoint ep = new CxfRsEndpoint("/rest2",new CxfComponent(camelContext));
		ep.setResourceClasses(Service1.class);
		ep.setBus(bus);
		RouteBuilder builder = new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from(ep)
				.id("deneme")
				.log("deneme")
				.bean(response);
				
			}
		};
		camelContext.addRoutes(builder);
		camelContext.startRoute("deneme");
	}

}
