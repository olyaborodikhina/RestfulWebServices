package com.luxoft.rest.jersey.rest;

import com.luxoft.rest.domain.UserRepository;
import com.luxoft.rest.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.enterprise.inject.Produces;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by omsk17 on 12/22/2016.
 */

@Path("/users")
@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    @Autowired
    private UserRepository userRepository;


    @GET
    public Collection<User> getUsers() {
        return userRepository.findAll();
    }


    @POST
    @Consumes(APPLICATION_JSON)
    public void addUser(User user) {
        userRepository.save(user);
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") long id) {
        userRepository.delete(id);
    }



}

