package com.example.proyectocovid.entidades;

public class Pregunta {
    private int idPregunta;
    private String descripcion;


    @Override
    public String toString(){
        return descripcion;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
