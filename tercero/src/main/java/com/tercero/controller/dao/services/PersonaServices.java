package com.tercero.controller.dao.services;

import com.tercero.controller.dao.PersonaDao;
import com.tercero.controller.tda.list.LinkedList;
import com.tercero.models.Persona;

public class PersonaServices {
    private final PersonaDao obj;

    public PersonaServices() {
        obj = new PersonaDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public LinkedList<Persona> listAll() {
        return obj.getListAll();
    }

    public Persona getPersona() {
        return obj.getPersona();
    }

    public void setPersona(Persona persona) {
        obj.setPersona(persona);
    }

    public String toJson() throws Exception {
        return obj.toJson();
    }

    public Persona getPersonaByIndex(Integer Index) throws Exception {
        return obj.getPersonaByIndex(Index);
    }

    public String getPersonaJsonByIndex(Integer Index) throws Exception {
        return obj.getPersonaJsonByIndex(Index);
    }

    public Boolean delPersona() throws Exception {
        return obj.delete();
    }

    public Boolean updatePersona() throws Exception {
        return obj.update();
    }

    public LinkedList<Persona> orderBy(String attibute, Integer type) throws Exception {
        return obj.orderBy(attibute, type);
    }

    public LinkedList<Persona> buscarNombre(String texto) throws Exception {
        return obj.buscar(texto);
    }
}
