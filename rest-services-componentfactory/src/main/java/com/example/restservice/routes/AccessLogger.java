package com.example.restservice.routes;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.restservice.core.Component;
import com.example.restservice.core.Constants;

public class AccessLogger {
	Logger logger = LoggerFactory.getLogger(AccessLogger.class);

	public void log(Exchange  e) {
		Component cmp = (Component)e.getProperty(Constants.COMPONENT);
		logger.info(String.format("Component %s message reveived", cmp.id()));
	}
}
