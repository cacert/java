package com.example.restservice.soap.component;

import com.example.restservice.core.Component;
import com.example.restservice.core.Components;

public class SoapComponent implements Component {

	@Override
	public String id() {
		return Components.SOAP.name();
	}

}
