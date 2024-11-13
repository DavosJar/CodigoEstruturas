package com.tercero.controller.dao;

import com.tercero.controller.dao.implement.AdapterDao;
import com.tercero.controller.tda.list.LinkedList;
import com.tercero.models.Tecnico;
@SuppressWarnings({"unchecked", "ConvertToTryWithResources" })

public class TecnicoDao extends AdapterDao<Tecnico> {
    private Tecnico tecnico;

    public TecnicoDao() {
        super(Tecnico.class);
    }

    public Tecnico getTecnico() {
        if(this.tecnico == null) {
            this.tecnico = new Tecnico();
        }
        return this.tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public LinkedList<Tecnico> getListAll() {
        return this.listAll();
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize()+1;
        getTecnico().setId(id);
        persist(getTecnico());
        return true;
    }

}