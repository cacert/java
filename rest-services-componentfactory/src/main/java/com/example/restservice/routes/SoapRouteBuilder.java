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
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.service.invoker.Invoker;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.restservice.demo.MyResponse;
import com.example.restservice.demo.Service1;
import com.example.restservice.demo.Service2;

public class SoapRouteBuilder{

	@Autowired
	CamelContext camelContext;
	
	private Map<String,Server> servers = new ConcurrentHashMap<>();
	
	@Autowired 
	Bus bus;
	@Autowired
	MyResponse response;
	
	private Invoker invoker;
	
	public SoapRouteBuilder(Invoker invoker) {
		this.invoker = invoker;
	}
	
	
	@PostConstruct
	public void configure() throws Exception {
		
		AtomicInteger count = new AtomicInteger();
		List<String> classes = Arrays.asList(Service1.class.getCanonicalName(),Service2.class.getCanonicalName());
		for(String s : classes) {
			JaxWsServerFactoryBean server = new JaxWsServerFactoryBean();
			Class<?> clas = Class.forName(s);
			server.setInvoker(invoker);
			server.setAddress("/soap"+count.incrementAndGet());
			server.setServiceClass(clas);
			servers.put(server.getAddress(), server.create());
		}
	}

}
