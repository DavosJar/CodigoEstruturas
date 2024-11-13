package com.tercero.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.tercero.controller.dao.services.ServicioServices;
import com.tercero.controller.excepcion.ListEmptyException;
import com.tercero.models.Servicio;

@Path("/servicio")
public class ServicioApi {

   /*  @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAllServicios() throws ListEmptyException {
        String responseJson = "";
        ServicioServices ps = new ServicioServices();
        Gson gson = new Gson();
        
        try {
            responseJson = "{\"data\":\"succes!\",\"info\":" + 
            gson.toJson(ps.listAll().toArray()) + "}";            
        } catch (Exception e) {
            e.printStackTrace();
            responseJson = "{\"data\":\"ErrorMsg\",\"info\":\"" + 
            e.getMessage() + "\"}"; 
        }

        return Response.ok(responseJson).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/{id}")
    public Response getServicioById(@PathParam("id") Integer id) {
        String jsonResponse = "";
        ServicioServices ps = new ServicioServices();
        
        try {
            jsonResponse = "{\"data\":\"succes!\",\"info\":" + 
            ps.getServicioJsonById(id) + "}";            
        } catch (Exception e) {
            e.printStackTrace();
            jsonResponse = "{\"data\":\"ErrorMsg\",\"info\":\"" + 
            e.getMessage() + "\"}"; 
        }

        return Response.ok(jsonResponse).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createServicio")
    public Response createServicio(String json) {
        String jsonResponse = "";
        ServicioServices ps = new ServicioServices();
        Gson gson = new Gson();
        try {
            Servicio p = gson.fromJson(json,Servicio.class);
            ps.setServicio(p);
            ps.save();
            jsonResponse = "{\"data\":\"Servicio created!\",\"with info\":" 
            + ps.toJson() + "}";
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            jsonResponse = "{\"data\":\"ErrorMsg\",\"info\":\"" + 
            e.getMessage() + "\"}"; 
        }
        

        return Response.ok(jsonResponse).build();
    } */
}
