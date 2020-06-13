package com.example.proyectocovid.entidades;

public class Departamento {
    private int idDepartamento;
    private  String descripcion;

    @Override
    public String toString(){
        return descripcion;
    }


    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
