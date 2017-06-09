package com.kasim.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author maykoone
 */
@Path("helloworld")
public class HelloWorldResource {

    public static final String MESSAGE = "Hello World!";
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return MESSAGE;
    }

}
