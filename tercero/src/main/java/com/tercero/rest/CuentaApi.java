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
import com.tercero.controller.dao.services.CuentaServices;
import com.tercero.controller.excepcion.ListEmptyException;
import com.tercero.models.Cuenta;

@Path("/cuenta")
public class CuentaApi {

    /* @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAllCuentas() throws ListEmptyException {
        String responseJson = "";
        CuentaServices ps = new CuentaServices();
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
    public Response getCuentaById(@PathParam("id") Integer id) {
        String jsonResponse = "";
        CuentaServices ps = new CuentaServices();
        
        try {
            jsonResponse = "{\"data\":\"succes!\",\"info\":" + 
            ps.getCuentaJsonById(id) + "}";            
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
    @Path("/createCuenta")
    public Response createCuenta(String json) {
        String jsonResponse = "";
        CuentaServices ps = new CuentaServices();
        Gson gson = new Gson();
        try {
            Cuenta p = gson.fromJson(json,Cuenta.class);
            ps.setCuenta(p);
            ps.save();
            jsonResponse = "{\"data\":\"Cuenta created!\",\"with info\":" 
            + ps.toJson() + "}";
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            jsonResponse = "{\"data\":\"ErrorMsg\",\"info\":\"" + 
            e.getMessage() + "\"}"; 
        }
        

        return Response.ok(jsonResponse).build();
    } */
}
