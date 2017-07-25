package com.example.restservice.core;

public class RequestContextFactory {
	private RequestContextFactory() {
	}
	public static RequestContext requestContext(ServiceName serviceName) {
		return new RequestContext(serviceName);
	}
}
