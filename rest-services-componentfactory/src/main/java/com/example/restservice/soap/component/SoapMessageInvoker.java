package com.example.restservice.soap.component;

import javax.ws.rs.core.Response;
import javax.xml.namespace.QName;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.ExchangeBuilder;
import org.apache.cxf.jaxrs.JAXRSInvoker;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageContentsList;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.restservice.core.Component;
import com.example.restservice.core.ComponentFactory;
import com.example.restservice.core.Components;
import com.example.restservice.core.Constants;
import com.example.restservice.core.RequestContextFactory;
import com.example.restservice.core.ServiceName;

public class SoapMessageInvoker extends JAXRSInvoker {
	@Autowired
	private CamelContext context;
	@Override
	public Object invoke(Exchange exchange, Object o) {
		
		org.apache.camel.Exchange camelExchange = ExchangeBuilder.anExchange(context).withBody(o).build();
		final QName qname = (QName) exchange.get(Message.WSDL_INTERFACE);
		if(qname == null)
			throw new RuntimeException("class info(main part) can not be extracted");
		String mainPart = qname.getLocalPart();
		final QName sub = (QName) exchange.getInMessage().get(Message.WSDL_OPERATION);
		if(sub == null)
			throw new RuntimeException("method info(main part) can not be extracted");
		
		ServiceName serviceName = new ServiceName(mainPart, ".", sub.getLocalPart());
		Component soapComponent = ComponentFactory.of(Components.SOAP);
		camelExchange.setProperty(Constants.COMPONENT, soapComponent);
		camelExchange.setProperty(Constants.REQUEST_CONTEXT, RequestContextFactory.requestContext(serviceName));
		
		org.apache.camel.Exchange e =  context.createProducerTemplate().send("direct://common",camelExchange);
		return new MessageContentsList(Response.ok(e.getIn().getBody()).build());
	}

}
