package com.tercero.controller.dao.services;

import com.tercero.controller.dao.PersonaDao;
import com.tercero.controller.tda.list.LinkedList;
import com.tercero.models.Persona;

@SuppressWarnings("unchecked")
public class PersonaServices {
    private PersonaDao obj;

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

    public LinkedList<Persona> order_apellido(Integer type_order) {
        return obj.order_apellido(type_order);
    }

    public Boolean delPersona() throws Exception {
        return obj.delete();
    }

}
