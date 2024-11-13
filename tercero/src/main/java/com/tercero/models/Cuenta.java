package com.tercero.models;

public class Cuenta {


    private Integer id;
    private Integer personaId;
    private Integer rolId;

    private String email;
    private String password;

    private Boolean estado;

    public Cuenta() {}

    public Cuenta(Integer personaId,String email, String password) {
        this.personaId = personaId;
        this.email = email;
        this.password = password;
    }

    public Cuenta(Integer personaId,String email, String password, Integer rolId) {
        this(personaId, email, password);
        this.rolId = rolId;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonaId() {
        return this.personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

}
