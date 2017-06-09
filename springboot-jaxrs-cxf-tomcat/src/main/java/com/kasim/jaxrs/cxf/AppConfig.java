package com.example.demo;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Configuration
public class AppConfig {
	
	@Bean(destroyMethod = "shutdown")
	public SpringBus cxf() {
		return new SpringBus();
	}

	@Bean(destroyMethod = "destroy") @DependsOn("cxf")
	public Server jaxRsServer() {
		final JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();

		factory.setProvider(new JacksonJsonProvider());
		factory.setResourceClasses(new Class[]{PeopleRestService.class});
		factory.setBus(cxf());
		factory.setAddress("/");

		return factory.create();
	}

	@Bean
	public org.springframework.boot.web.servlet.ServletRegistrationBean cxfServlet() {
		final org.springframework.boot.web.servlet.ServletRegistrationBean servletRegistrationBean = 
			new org.springframework.boot.web.servlet.ServletRegistrationBean(new CXFServlet(), "/api/*");
		servletRegistrationBean.setLoadOnStartup(1);
		return servletRegistrationBean;
	}
}
