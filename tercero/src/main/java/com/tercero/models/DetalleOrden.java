package com.tercero.models;

public class DetalleOrden {
    private Integer id;

    private Integer ordenId;

    private String fechaOrden;
    private String horaOrden;

    private Integer servicioId;
    private Integer componenteId;

    public DetalleOrden() {}

    public DetalleOrden(Integer ordenId, String fechaOrden, String horaOrden, Integer 
    servicioId, Integer componenteId) 
    {
        this.ordenId = ordenId;
        this.fechaOrden = fechaOrden;
        this.horaOrden = horaOrden;
        this.servicioId = servicioId;
        this.componenteId = componenteId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdenId() {
        return this.ordenId;
    }

    public void setOrdenId(Integer ordenId) {
        this.ordenId = ordenId;
    }

    public String getFechaOrden() {
        return this.fechaOrden;
    }

    public void setFechaOrden(String fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public String getHoraOrden() {
        return this.horaOrden;
    }

    public void setHoraOrden(String horaOrden) {
        this.horaOrden = horaOrden;
    }

    public Integer getServicioId() {
        return this.servicioId;
    }

    public void setServicioId(Integer servicioId) {
        this.servicioId = servicioId;
    }

    public Integer getComponenteId() {
        return this.componenteId;
    }

    public void setComponenteId(Integer componenteId) {
        this.componenteId = componenteId;
    }

}
