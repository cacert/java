package com.kasim.spring.security;

import org.apache.cxf.BusFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SprinSecurityDemo implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(SprinSecurityDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JAXRSServerFactoryBean bean  = new JAXRSServerFactoryBean();
		bean.setAddress("/");
		bean.setBus(BusFactory.getDefaultBus());
		bean.setResourceClasses(HelloWorld.class);
		bean.create();
	}
	
	
}
