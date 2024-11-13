package com.tercero.controller.dao;

import com.tercero.controller.dao.implement.AdapterDao;
import com.tercero.controller.tda.list.LinkedList;
import com.tercero.models.Cuenta;
@SuppressWarnings({"unchecked", "ConvertToTryWithResources" })

public class CuentaDao extends AdapterDao<Cuenta> {
    private Cuenta cuenta;

    public CuentaDao() {
        super(Cuenta.class);
    }

    public Cuenta getCuenta() {
        if(this.cuenta == null) {
            this.cuenta = new Cuenta();
        }
        return this.cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public LinkedList<Cuenta> getListAll() {
        return this.listAll();
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize()+1;
        getCuenta().setId(id);
        persist(getCuenta());
        return true;
    }


}
