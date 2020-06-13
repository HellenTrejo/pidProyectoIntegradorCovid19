package com.example.proyectocovid.taskDepartamento;

import android.content.Context;
import android.os.AsyncTask;

import com.example.proyectocovid.Libreria;

public class ServicioTaskListDepartamento extends AsyncTask<Void, Void, String> {
    //variables del hilo
    private Context httpContext;//contexto
    private String linkURL;
    //constructor del hilo (Asynctask)
    public ServicioTaskListDepartamento(Context ctx, String linkURL){
        this.httpContext=ctx;
        this.linkURL=linkURL;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    @Override
    protected String doInBackground(Void... params) {
        String contenido="";
        try {
            contenido= Libreria.leerPagina(linkURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  contenido;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //Log.e("CANTIDAD DESPUES", ""+data.size());

    }


}
