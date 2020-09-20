/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CarDTO;
import dto.GroupMemberDTO;
import dto.JokeDTO;
import entities.GroupMember;
import facades.CarFacade;
import facades.JokeFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;



        
        @Path("jokes")
public class JokeREST {

 private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3306/jokes",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);

            private static final JokeFacade FACADE = JokeFacade.getJokeFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
/**
 * REST Web Service
 *
 * @author Claus
 */
@Path("generic")
public class Joke {
    

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getJson() {
        //TODO return proper representation object
//        throw new UnsupportedOperationException();
        return "Vuf… (Message from a dog)";
    }
        
  @GET
   @Path("/animal_list")   
    @Produces(MediaType.APPLICATION_JSON)
    public String getList() {
        return "[\"Dog\", \"Cat\", \"Mouse\", \"Bird\"]";
        }
        
        
        
        
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJokeByID(@PathParam("id") int id)
    {
        entities.Joke joke = FACADE.findJoke(id);
        if (joke != null)
        {
            return GSON.toJson(joke);
        }
        else
        {
            return "{\"msg\":\"getCarById " + id + " not found\"}";
        }
    }}}
