package com.tercero.rest;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tercero.controller.dao.services.PersonaServices;
import com.tercero.controller.tda.list.LinkedList;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        HashMap map = new HashMap<>();
        PersonaServices ps = new PersonaServices();
        String aux = "";
        try {
            aux = "la lista esta vacia " + ps.listAll().isEmpty();
            LinkedList<Double> listaA = new LinkedList<>();
            for (int i = 0; i < 15; i++) {
                double roundNumber = Math.round((Math.random() * 100) * 100.0) / 100.0;
                listaA.add(roundNumber);
            }
            System.out.println(listaA.toString());
            listaA.order();
            System.out.println(listaA.toString());

            System.out.println(ps.listAll().toString());
            System.out.println(ps.order_apellido(1).toString());
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return "Got it!";
    }
}
