package com.example.restservice.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CommonRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:common")
			.id(CommonRoute.class.getName())
			.bean(AccessLogger.class)	
			.log("done")
			.setBody(constant("deneme"));
	}

}
