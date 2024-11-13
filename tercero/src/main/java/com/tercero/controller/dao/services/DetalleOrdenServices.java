package com.tercero.controller.dao.services;

import com.tercero.controller.dao.DetalleOrdenDao;
import com.tercero.controller.tda.list.LinkedList;
import com.tercero.models.DetalleOrden;

public class DetalleOrdenServices {
    private DetalleOrdenDao obj;
    public DetalleOrdenServices() {
        obj = new DetalleOrdenDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public LinkedList<DetalleOrden> listAll() {
        return obj.getListAll();
    }

    public DetalleOrden getDetalleOrden() {
        return obj.getDetalleOrden();
    }

    public void setDetalleOrden(DetalleOrden DetalleOrden) {
        obj.setDetalleOrden(DetalleOrden);
    }

/*     public String toJson() throws Exception{
        return obj.toJson();
    }

    public DetalleOrden getDetalleOrdenById(Integer id) throws Exception  {
        return obj.getDetalleOrdenById(id);
    }

    public String getDetalleOrdenJsonById(Integer id) throws Exception {
        return obj.getDetalleOrdenJsonById(id);
    } */
    
}