package com.example.restservice;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.CxfComponent;
import org.apache.camel.component.cxf.jaxrs.CxfRsEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestRouteBuilder extends RouteBuilder{

	@Autowired
	CamelContext camelContext;
	
	@Override
	public void configure() throws Exception {
		
		System.err.println(camelContext == null);
		CxfRsEndpoint ep = new CxfRsEndpoint("/rest2",new CxfComponent(camelContext));
		ep.setResourceClasses(Service1.class);
		ep.setAddress("/rest2");
		from(ep)
			.log("deneme")
			.setBody(constant("deneme"));
		
	}

}
