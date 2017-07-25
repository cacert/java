package com.example.restservice.core;

public class ServiceName {
	private String mainPart;
	private String separator;
	private String subPart;
	
	public ServiceName(String mainPart, String separator, String subPart) {
		super();
		this.mainPart = mainPart;
		this.separator = separator;
		this.subPart= subPart;
	}

	public String toString() {
		return getMainPart()+separator+getSubPart();
	}

	public String getMainPart() {
		return mainPart;
	}

	public String getSubPart() {
		return subPart;
	}
	
}
