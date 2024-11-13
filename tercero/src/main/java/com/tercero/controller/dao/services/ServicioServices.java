package com.tercero.controller.dao.services;

import com.tercero.controller.dao.ServicioDao;
import com.tercero.controller.tda.list.LinkedList;
import com.tercero.models.Servicio;

public class ServicioServices {
    private ServicioDao obj;
    public ServicioServices() {
        obj = new ServicioDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public LinkedList<Servicio> listAll() {
        return obj.getListAll();
    }

    public Servicio getServicio() {
        return obj.getServicio();
    }

    public void setServicio(Servicio Servicio) {
        obj.setServicio(Servicio);
    }

 /*    public String toJson() throws Exception{
        return obj.toJson();
    }

    public Servicio getServicioById(Integer id) throws Exception  {
        return obj.getServicioById(id);
    }

    public String getServicioJsonById(Integer id) throws Exception {
        return obj.getServicioJsonById(id);
    } */
    
}