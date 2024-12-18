package com.tercero.controller.dao;

import com.tercero.controller.dao.implement.AdapterDao;
import com.tercero.controller.tda.list.LinkedList;
import com.tercero.models.Componente;

@SuppressWarnings({"unchecked", "ConvertToTryWithResources" })
public class ComponenteDao extends AdapterDao<Componente> {
    private Componente componente;
    private LinkedList<Componente> listAll;

    public ComponenteDao() {
        super(Componente.class);
    }

    public Componente getComponente() {
        if(this.componente == null) {
            this.componente = new Componente();
        }
        return this.componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public LinkedList<Componente> getListAll() {
        if(this.listAll == null) {
            this.listAll = listAll();
        }
        return this.listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize()+1;
        getComponente().setId(id);
        persist(getComponente());
        return true;
    }
}
