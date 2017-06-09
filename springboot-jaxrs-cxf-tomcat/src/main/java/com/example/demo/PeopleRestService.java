package com.example.demo;

import java.util.Collection;
import java.util.Collections;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;


@Path("/people")
@Component
public class PeopleRestService {
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Collection<Person> getPeople() {
        return Collections.singletonList(new Person("a@b.com", "John", "Smith"));
    }
}
