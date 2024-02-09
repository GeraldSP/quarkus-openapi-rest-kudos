package com.redhat.kudos;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/kudos")
public class KudosResource {

    @Inject
    Repository repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object getKudos() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String  jacksonData= objectMapper.writeValueAsString(repo.getAllKudos());
        return jacksonData;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userEmail}")

    public void addKudoTo(String userEmail) {
        repo.addKudoTo(userEmail);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userEmail}")
    public Integer getKudosFrom(@PathParam("userEmail") String userEmail) {
        return repo.getKudosFrom(userEmail);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userEmail}")
    public void deleteKudoFrom(String userEmail) {
        repo.deleteKudoFrom(userEmail);
    }
}
