package com.example.proyectocovid.taskPersona;

import android.content.Context;
import android.os.AsyncTask;

import com.example.proyectocovid.Libreria;

public class ServicioTaskListPersona extends AsyncTask<Void,Void,String> {
//atributos
private Context context;
private String urlLink;
//constructor
public ServicioTaskListPersona(Context context, String urlLink) {
        this.context = context;
        this.urlLink = urlLink;
        }
@Override
protected String doInBackground(Void... voids) {
        String contenido="";
        try {
        contenido= Libreria.leerPagina(urlLink);
        }
        catch (Exception e){
        e.printStackTrace();
        }
        return contenido;
        }
        }
