package com.tercero.controller.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tercero.controller.dao.implement.AdapterDao;
import com.tercero.controller.tda.list.LinkedList;
import com.tercero.models.Persona;

@SuppressWarnings({ "unchecked", "ConvertToTryWithResources" })

public class PersonaDao extends AdapterDao<Persona> {
    private Persona persona;
    private LinkedList<Persona> listAll;
    Gson g = new GsonBuilder().disableHtmlEscaping().create();

    public PersonaDao() {
        super(Persona.class);
    }

    public Persona getPersona() {
        if (this.persona == null) {
            this.persona = new Persona();
        }
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LinkedList<Persona> getListAll() {
        if (listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = listAll().getSize() + 1;
        getPersona().setId(id);
        this.persist(this.persona);
        this.listAll = listAll();
        return true;
    }

    public Boolean update() throws Exception {
        listAll = listAll();
        this.merge(this.persona, this.persona.getId());
        return true;
    }

    public Boolean delete() throws Exception {
        if (listAll == null) {
            listAll = getListAll();
        }
        this.delete(persona.getId());
        return true;
    }

    public LinkedList<Persona> orderBy(String attribute, Integer type) throws Exception {
        LinkedList<Persona> list = listAll().order(attribute, type);
        return list;
    }

    public String toJson() throws Exception {
        return g.toJson(this.persona);
    }

    public Persona getPersonaByIndex(Integer index) throws Exception {
        return get(index);
    }

    public String getPersonaJsonByIndex(Integer index) throws Exception {
        return g.toJson(get(index));
    }

    public LinkedList<Persona> buscar(String texto) throws Exception {
        LinkedList<Persona> listita = listAll();
        LinkedList<Persona> list = new LinkedList<>();
        if (!listita.isEmpty()) {
            Persona[] personas = listita.toArray();
            for (int i = 0; i < personas.length; i++) {
                if (personas[i].getNombre().toLowerCase().startsWith(texto.toLowerCase())) {
                    list.add(personas[i]);
                }
            }
        }
        return list;
    }
}
