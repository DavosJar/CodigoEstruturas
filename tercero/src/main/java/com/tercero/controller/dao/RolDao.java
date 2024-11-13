package com.tercero.controller.dao;

import com.tercero.controller.dao.implement.AdapterDao;
import com.tercero.controller.tda.list.LinkedList;
import com.tercero.models.Rol;
@SuppressWarnings({"unchecked", "ConvertToTryWithResources" })

public class RolDao extends AdapterDao<Rol> {
    private Rol rol;

    public RolDao() {
        super(Rol.class);
    }

    public Rol getRol() {
        if(this.rol == null) {
            this.rol = new Rol();
        }
        return this.rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public LinkedList<Rol> getListAll() {
        return this.listAll();
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize()+1;
        getRol().setId(id);
        persist(getRol());
        return true;
    }


}
