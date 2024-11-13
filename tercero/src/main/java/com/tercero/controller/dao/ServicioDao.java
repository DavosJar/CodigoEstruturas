package com.tercero.controller.dao;
import com.tercero.controller.dao.implement.AdapterDao;
import com.tercero.controller.tda.list.LinkedList;
import com.tercero.models.Servicio;
@SuppressWarnings({"unchecked", "ConvertToTryWithResources" })

public class ServicioDao extends AdapterDao<Servicio> {
    private Servicio servicio;

    public ServicioDao() {
        super(Servicio.class);
    }

    public Servicio getServicio() {
        if(this.servicio == null) {
            this.servicio = new Servicio();
        }
        return this.servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public LinkedList<Servicio> getListAll() {
        return this.listAll();
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize()+1;
        getServicio().setId(id);
        persist(getServicio());
        return true;
    }


}
