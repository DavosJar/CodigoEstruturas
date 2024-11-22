package com.tercero.rest;

import java.util.HashMap;
import java.util.Random;

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
        Long startTime;
        Long endTime;
        Long duration;
        Boolean existe;
        try {

            System.out.println(ps.listAll().toString());
            System.out.println(ps.orderBy("id", 0));
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return "Got it!";
    }

    public static String generarCedula() {
        Random random = new Random();
        StringBuilder cedula = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);
            cedula.append(digit);
        }

        return cedula.toString();
    }

    public Boolean buscarBinaria(String dni, LinkedList<String> listita) throws Exception {
        LinkedList<String> listaOrdenada = listita.order(dni, 1);
        String[] lista = (String[]) listaOrdenada.toArray();

        int left = 0;
        int right = lista.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = lista[mid].compareTo(dni);

            if (comparison == 0) {
                return true;
            }
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public Boolean busquedaLineal(String dni, LinkedList<String> listita) {
        String[] lista = listita.toArray();

        for (String elemento : lista) {
            if (elemento.equals(dni)) {
                return true;
            }
        }
        return false;
    }

}
