package com.example.restservice.rest.component;

import javax.ws.rs.core.Response;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.ExchangeBuilder;
import org.apache.cxf.jaxrs.JAXRSInvoker;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.MessageContentsList;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.restservice.core.Component;
import com.example.restservice.core.ComponentFactory;
import com.example.restservice.core.Components;
import com.example.restservice.core.Constants;
import com.example.restservice.core.RequestContextFactory;
import com.example.restservice.core.ServiceName;

public class RestMessageInvoker extends JAXRSInvoker {
	@Autowired
	private CamelContext context;
	@Override
	public Object invoke(Exchange exchange, Object o) {
		
		org.apache.camel.Exchange camelExchange = ExchangeBuilder.anExchange(context).withBody(o).build();
		final ClassResourceInfo cri = (ClassResourceInfo) exchange.get("root.resource.class");
		if(cri == null)
			throw new RuntimeException("class info(main part) can not be extracted");
		String mainPart = cri.getServiceClass().getSimpleName();
		String subpart = (String)exchange.get("org.apache.cxf.resource.operation.name");
		if(subpart == null)
			throw new RuntimeException("method info(main part) can not be extracted");
		
		ServiceName serviceName = new ServiceName(mainPart, ".", subpart);
		Component restComponent = ComponentFactory.of(Components.REST);
		camelExchange.setProperty(Constants.COMPONENT, restComponent);
		camelExchange.setProperty(Constants.REQUEST_CONTEXT, RequestContextFactory.requestContext(serviceName));
		
		org.apache.camel.Exchange e =  context.createProducerTemplate().send("direct://common",camelExchange);
		return new MessageContentsList(Response.ok(e.getIn().getBody()).build());
	}

}
