package com.example.proyectocovid.entidades;

public class Nacionalidad {
    private int idnacionalidad;
    private String nombreNacionalidad;

    @Override
    public String toString(){
        return nombreNacionalidad;
    }

    public int getIdnacionalidad() {
        return idnacionalidad;
    }

    public void setIdnacionalidad(int idnacionalidad) {
        this.idnacionalidad = idnacionalidad;
    }

    public String getNombreNacionalidad() {
        return nombreNacionalidad;
    }

    public void setNombreNacionalidad(String nombreNacionalidad) {
        this.nombreNacionalidad = nombreNacionalidad;
    }
}
