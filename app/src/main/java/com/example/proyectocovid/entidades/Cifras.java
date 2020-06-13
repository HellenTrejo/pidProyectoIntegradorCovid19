package com.example.proyectocovid.entidades;

public class Cifras {

    private int idCifras;
    private int nuevos, recuperados, totales, fallecidos, codigoDepartamento;
    private String fecha;

    private Departamento departamento;

    @Override
    public String toString(){
        return fecha;
    }




    public int getIdCifras() {
        return idCifras;
    }

    public void setIdCifras(int idCifras) {
        this.idCifras = idCifras;
    }

    public int getNuevos() {
        return nuevos;
    }

    public void setNuevos(int nuevos) {
        this.nuevos = nuevos;
    }

    public int getRecuperados() {
        return recuperados;
    }

    public void setRecuperados(int recuperados) {
        this.recuperados = recuperados;
    }

    public int getTotales() {
        return totales;
    }

    public void setTotales(int totales) {
        this.totales = totales;
    }

    public int getFallecidos() {
        return fallecidos;
    }

    public void setFallecidos(int fallecidos) {
        this.fallecidos = fallecidos;
    }

    public int getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(int codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
