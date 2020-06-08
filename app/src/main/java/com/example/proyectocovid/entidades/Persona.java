package com.example.proyectocovid.entidades;

public class Persona {
    private int idpersona;
    private String numDoc;
    private String numCel;
    private int codigoDoc;
    private int codigoNac;
    private int codigoRol;
    private int codigoEst;

    private Rol rol;
    private Estado estado;
    private Nacionalidad nacionalidad;
    private TipoDocumento tipoDocumento;

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getNumCel() {
        return numCel;
    }

    public void setNumCel(String numCel) {
        this.numCel = numCel;
    }

    public int getCodigoDoc() {
        return codigoDoc;
    }

    public void setCodigoDoc(int codigoDoc) {
        this.codigoDoc = codigoDoc;
    }

    public int getCodigoNac() {
        return codigoNac;
    }

    public void setCodigoNac(int codigoNac) {
        this.codigoNac = codigoNac;
    }

    public int getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(int codigoRol) {
        this.codigoRol = codigoRol;
    }

    public int getCodigoEst() {
        return codigoEst;
    }

    public void setCodigoEst(int codigoEst) {
        this.codigoEst = codigoEst;
    }
}
