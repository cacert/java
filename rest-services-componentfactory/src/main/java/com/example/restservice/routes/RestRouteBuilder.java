package com.example.restservice.routes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.apache.camel.CamelContext;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.service.invoker.Invoker;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.restservice.demo.MyResponse;
import com.example.restservice.demo.Service1;
import com.example.restservice.demo.Service2;

public class RestRouteBuilder{

	@Autowired
	CamelContext camelContext;
	
	@Autowired 
	Bus bus;
	@Autowired
	MyResponse response;
	
	private Map<String,Server> servers = new ConcurrentHashMap<>();
	
	private Invoker invoker;
	
	public RestRouteBuilder(Invoker invoker) {
		this.invoker = invoker;
	}
	
	
	@PostConstruct
	public void configure() throws Exception {
		
		AtomicInteger count = new AtomicInteger();
		List<String> classes = Arrays.asList(Service1.class.getCanonicalName(),Service2.class.getCanonicalName());
		for(String s : classes) {
			JAXRSServerFactoryBean server = new JAXRSServerFactoryBean();
			Class<?> clas = Class.forName(s);
			server.setInvoker(invoker);
			server.setAddress("/rest"+count.incrementAndGet());
			server.setResourceClasses(clas);
			servers.put(server.getAddress(), server.create());		
		}
		
//		RouteBuilder builder = new RouteBuilder() {
//			@Override
//			public void configure() throws Exception {
//				from("direct://common")
//				.id("deneme")
//				.log("deneme")
//				.setBody(constant("deneme"));
//			}
//		};
//		camelContext.addRoutes(builder);
//		camelContext.startRoute("deneme");

	}

}
