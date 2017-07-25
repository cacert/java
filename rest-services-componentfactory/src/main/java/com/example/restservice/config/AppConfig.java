package com.example.restservice.config;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.service.invoker.Invoker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.restservice.demo.MyResponse;
import com.example.restservice.rest.component.RestMessageInvoker;
import com.example.restservice.routes.RestRouteBuilder;
import com.example.restservice.routes.SoapRouteBuilder;
import com.example.restservice.soap.component.SoapMessageInvoker;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

@Configuration
public class AppConfig {
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
		return new RestRouteBuilder(restInvoker());
	}
	@Bean
	public SoapRouteBuilder soapBuilder() {
		return new SoapRouteBuilder(soapInvoker());
	}
	@Bean
	public Invoker restInvoker() {
		return new RestMessageInvoker();
	}

	@Bean
	public Invoker soapInvoker() {
		return new SoapMessageInvoker();
	}
	@Bean
	public MyResponse response() {
		return new MyResponse();
	}
	@Bean 
	public JacksonJaxbJsonProvider jsonProvider() {
		return new JacksonJaxbJsonProvider();
	}

}
