package com.example.restservice;

import org.apache.cxf.bus.spring.SpringBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JaxrsConfig {
	@Bean(destroyMethod = "shutdown")
	public SpringBus cxf() {
		return new SpringBus();
	}

//	@Bean(destroyMethod = "destroy")
//	@DependsOn("cxf")
//	public Server jaxRsServer() {
//		final JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
//		factory.setResourceClasses(new Class[] { Service1.class });
//		factory.setBus(cxf());
//		factory.setAddress("/rest1");
//		return factory.create();
//	}
	@Bean
	public RestRouteBuilder restBuilder() {
		return new RestRouteBuilder();
	}
	
	@Bean
	public MyResponse response() {
		return new MyResponse();
	}

}
