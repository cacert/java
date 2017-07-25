package com.example.restservice.core;

import com.example.restservice.rest.component.RestComponent;
import com.example.restservice.soap.component.SoapComponent;

public class ComponentFactory {

	public static Component of(Components components) {
		if(components == Components.REST) {
			return new RestComponent();
		}
		if(components == Components.SOAP) {
			return new SoapComponent();
		}
		return null;
	}
}


