package com.tercero.controller.dao.services;

import com.tercero.controller.dao.ComponenteDao;
import com.tercero.controller.tda.list.LinkedList;
import com.tercero.models.Componente;

public class ComponenteServices {
    private ComponenteDao obj;
    public ComponenteServices() {
        obj = new ComponenteDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public LinkedList<Componente> listAll() {
        return obj.getListAll();
    }

    public Componente getComponente() {
        return obj.getComponente();
    }

    public void setComponente(Componente componente) {
        obj.setComponente(componente);
    }


    
}

