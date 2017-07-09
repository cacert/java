package com.kasim.tomcat;

import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;

public class HelloJaxRs
{
    public static void main( String[] args ) throws Exception
    {
        Tomcat tomcat = new Tomcat();
        Context context = tomcat.addContext( "/", "" );

        Wrapper servlet = context.createWrapper();
        servlet.setName( "jaxrs" );
        servlet.setServletClass(
            "org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet" );

        servlet.addInitParameter(
            "jaxrs.serviceClasses",
            Hello.class.getName()
        );

        servlet.setLoadOnStartup( 1 );
        context.addChild( servlet );
        context.addServletMapping( "/rest/*", "jaxrs" );

        tomcat.start();
        tomcat.getServer().await();
    }
}
