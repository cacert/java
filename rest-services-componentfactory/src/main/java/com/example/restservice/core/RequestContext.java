package com.example.restservice.core;

import java.util.UUID;

public class RequestContext {
	
	private String id;
	private ServiceName serviceName;

	public RequestContext(ServiceName serviceName) {
		super();
		this.id = (UUID.randomUUID().toString());
		this.serviceName = serviceName;
	}

	public ServiceName getServiceName() {
		return serviceName;
	}

	public String getId() {
		return id;
	}

	
}
