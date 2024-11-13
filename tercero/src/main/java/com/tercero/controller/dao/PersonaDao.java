package com.tercero.controller.dao;

import com.tercero.models.Persona;
import com.google.gson.Gson;
import com.tercero.controller.dao.implement.AdapterDao;
import com.tercero.controller.tda.list.LinkedList;

@SuppressWarnings({ "unchecked", "ConvertToTryWithResources", "rawtypes" })

public class PersonaDao extends AdapterDao<Persona> {
    private Persona persona;
    private LinkedList<Persona> listAll;
    Gson g = new Gson();

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
        reindex();
        return true;
    }

    private void reindex() throws Exception {

        LinkedList<Persona> listAll = listAll();
        Persona[] matrix = listAll.toArray();
        int i = 0;
        for (Persona p : matrix) {
            p.setId(i + 1);
            this.merge(p, i + 1);
            i++;
        }
    }

    public LinkedList order_apellido(Integer type_order) {
        LinkedList listita = listAll();
        if (!listAll().isEmpty()) {
            Persona[] lista = (Persona[]) listita.toArray();
            listita.reset();
            switch (type_order) {
                case 1:
                    for (int i = 1; i < lista.length; i++) {
                        Persona aux = lista[i];
                        int j = i - 1;
                        while (j >= 0 && lista[j].getApellido().compareTo(aux.getApellido()) > 0) {
                            lista[j + 1] = lista[j--];
                        }
                        lista[j + 1] = aux;
                    }
                    break;

                default:
                    for (int i = 1; i < lista.length; i++) {
                        Persona aux = lista[i];
                        int j = i - 1;
                        while (j >= 0 && lista[j].getApellido().compareTo(aux.getApellido()) < 0) {
                            lista[j + 1] = lista[j--];
                        }
                        lista[j + 1] = aux;
                    }
                    break;
            }
            listita.toList(lista);
        }
        return listita;
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

}
