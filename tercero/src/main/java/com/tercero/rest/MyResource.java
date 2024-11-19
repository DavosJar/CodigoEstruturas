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
        String aux = "";
        Long startTime;
        Long endTime;
        Long duration;
        Boolean existe;
        try {
            // aux = "la lista esta vacia " + ps.listAll().isEmpty();
            LinkedList<String> listita = new LinkedList<>();
            LinkedList<Double> listaA = new LinkedList<>();
            /*
             * for (int i = 0; i < 40000; i++) {
             * listita.add(generarCedula());
             * }
             * startTime = System.nanoTime();
             * listita.mergeOrder();
             * endTime = System.nanoTime();
             * duration = endTime - startTime;
             * System.out.println("Tempo de ordenacion: " + duration + "ns");
             * 
             * startTime = System.nanoTime();
             * existe = buscarBinaria("1104343593", listita);
             * endTime = System.nanoTime();
             * duration = endTime - startTime;
             * System.out.println("Tempo de Busqueda con ordenacion y binaria: " + duration
             * + "ns");
             * startTime = System.nanoTime();
             * existe = busquedaLineal("1104343593", listita);
             * endTime = System.nanoTime();
             * duration = endTime - startTime;
             * System.out.println("Tempo de lineal: " + duration + "ns");
             * /
             **/
            for (int i = 0; i < 150; i++) {
                double roundNumber = Math.round((Math.random() * 100) * 100.0) / 100.0;
                listaA.add(roundNumber);
            }
            System.out.println(listaA.toString());
            listaA.mergeOrder();
            System.out.println(listaA.toString());

            System.out.println(ps.listAll().toString());
            System.out.println(ps.order().toString());

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
        LinkedList<String> listaOrdenada = listita.mergeOrder();
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
