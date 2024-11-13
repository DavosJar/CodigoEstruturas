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
import com.tercero.controller.dao.services.DetalleOrdenServices;
import com.tercero.controller.excepcion.ListEmptyException;
import com.tercero.models.DetalleOrden;

@Path("/detalleOrden")
public class DetalleOrdenApi {

    /* @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAllDetalleOrdens() throws ListEmptyException {
        String responseJson = "";
        DetalleOrdenServices ps = new DetalleOrdenServices();
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
    public Response getDetalleOrdenById(@PathParam("id") Integer id) {
        String jsonResponse = "";
        DetalleOrdenServices ps = new DetalleOrdenServices();
        
        try {
            jsonResponse = "{\"data\":\"succes!\",\"info\":" + 
            ps.getDetalleOrdenJsonById(id) + "}";            
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
    @Path("/createDetalleOrden")
    public Response createDetalleOrden(String json) {
        String jsonResponse = "";
        DetalleOrdenServices ps = new DetalleOrdenServices();
        Gson gson = new Gson();
        try {
            DetalleOrden p = gson.fromJson(json,DetalleOrden.class);
            ps.setDetalleOrden(p);
            ps.save();
            jsonResponse = "{\"data\":\"DetalleOrden created!\",\"with info\":" 
            + ps.toJson() + "}";
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            jsonResponse = "{\"data\":\"ErrorMsg\",\"info\":\"" + 
            e.getMessage() + "\"}"; 
        }
        

        return Response.ok(jsonResponse).build();
    } */
}
