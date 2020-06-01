package com.example.proyectocovid.entidades;

public class Triaje {
    private int idTriaje;
    private String respuesta;

    private int codPregunta;
    private int codPersona;

    public int getIdTriaje() {
        return idTriaje;
    }

    public void setIdTriaje(int idTriaje) {
        this.idTriaje = idTriaje;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getCodPregunta() {
        return codPregunta;
    }

    public void setCodPregunta(int codPregunta) {
        this.codPregunta = codPregunta;
    }

    public int getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }
}
