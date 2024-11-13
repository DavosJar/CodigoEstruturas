package com.tercero.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.HashMap;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.tercero.controller.dao.services.PersonaServices;
import com.tercero.controller.excepcion.ListEmptyException;
import com.tercero.models.Persona;

@Path("/persona")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class PersonaApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAllPersons() throws ListEmptyException {
        HashMap res = new HashMap<>();
        PersonaServices ps = new PersonaServices();

        try {
            res.put("status", "Ok");
            res.put("data", ps.listAll().toArray());
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("status", "ERROR");
            res.put("msg", "Errors." + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/{id}")
    public Response getPersonaById(@PathParam("id") Integer Index) {
        HashMap res = new HashMap<>();
        PersonaServices ps = new PersonaServices();

        try {
            res.put("status", "Ok");
            res.put("data", ps.getPersonaByIndex(Index));
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("status", "ERROR");
            res.put("msg", "Errors." + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }

    }

    @Path("/save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(HashMap map) {
        PersonaServices ps = new PersonaServices();
        ps.getPersona().setApellido(map.get(("apellido")).toString());
        ps.getPersona().setNombre(map.get(("nombre")).toString());
        ps.getPersona().setDni(map.get(("dni")).toString());
        ps.getPersona().setFechaNacimiento(map.get(("fechaNacimiento")).toString());
        ps.getPersona().setDireccion((map.get(("direccion")).toString()));

        HashMap res = new HashMap<>();
        try {
            ps.save();
            res.put("msg", "OK");
            res.put("data", "persona registrada correctamente");
            return Response.ok(map).build();
        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", e.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Integer id) throws Exception {
        HashMap res = new HashMap<>();
        PersonaServices ps = new PersonaServices();
        try {
            ps.getPersona().setId(id);
            ps.delPersona();
            res.put("estado", "Ok");
            res.put("data", "Registro eliminado con exito.");
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("estado", "error");
            res.put("data", "Error interno del servidor: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

}
