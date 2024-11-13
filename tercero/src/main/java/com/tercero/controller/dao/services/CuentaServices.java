package com.tercero.controller.dao.services;

import com.tercero.controller.dao.CuentaDao;
import com.tercero.controller.tda.list.LinkedList;
import com.tercero.models.Cuenta;

public class CuentaServices {
    private CuentaDao obj;
    public CuentaServices() {
        obj = new CuentaDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public LinkedList<Cuenta> listAll() {
        return obj.getListAll();
    }

    public Cuenta getCuenta() {
        return obj.getCuenta();
    }

    public void setCuenta(Cuenta Cuenta) {
        obj.setCuenta(Cuenta);
    }

/*     public String toJson() throws Exception{
        return obj.toJson();
    }

    public Cuenta getCuentaById(Integer id) throws Exception  {
        return obj.getCuentaById(id);
    }

    public String getCuentaJsonById(Integer id) throws Exception {
        return obj.getCuentaJsonById(id);
    } */
    
}