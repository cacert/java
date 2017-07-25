package com.example.restservice.rest.component;

import com.example.restservice.core.Component;
import com.example.restservice.core.Components;

public class RestComponent implements Component {

	@Override
	public String id() {
		return Components.REST.name();
	}

}
