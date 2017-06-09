package com.kasim.jersey;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 *  JAX-RS application class
 * @author maykoone
 */
@Component
@ApplicationPath("/rest")
public class JaxRsApplication extends ResourceConfig {

    public JaxRsApplication() {
        register(new HelloWorldResource());
        register(new Hello());
    }

}
