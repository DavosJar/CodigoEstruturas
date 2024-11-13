package com.tercero.models;

public class Servicio {

    private Integer id;
    private String nombre;
    private String detalle;
    private float costo;

    public Servicio() {}

    public Servicio(String nombre, String detalle, float costo) {
        this();
        this.nombre = nombre;
        this.detalle = detalle;
        this.costo = costo;
    }


    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return this.detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public float getCosto() {
        return this.costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    
}
