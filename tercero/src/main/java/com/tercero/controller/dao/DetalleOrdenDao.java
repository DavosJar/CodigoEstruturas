package com.tercero.controller.dao;

import com.tercero.controller.dao.implement.AdapterDao;
import com.tercero.controller.tda.list.LinkedList;
import com.tercero.models.DetalleOrden;
@SuppressWarnings({"unchecked", "ConvertToTryWithResources" })

public class DetalleOrdenDao extends AdapterDao<DetalleOrden> {
    private DetalleOrden detalleOrden;

    public DetalleOrdenDao() {
        super(DetalleOrden.class);
    }

    public DetalleOrden getDetalleOrden() {
        if(this.detalleOrden == null) {
            this.detalleOrden = new DetalleOrden();
        }
        return this.detalleOrden;
    }

    public void setDetalleOrden(DetalleOrden detalleOrden) {
        this.detalleOrden = detalleOrden;
    }

    public LinkedList<DetalleOrden> getListAll() {
        return this.listAll();
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize()+1;
        getDetalleOrden().setId(id);
        persist(getDetalleOrden());
        return true;
    }


}