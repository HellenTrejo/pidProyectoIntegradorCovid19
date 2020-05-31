package com.example.proyectocovid.taskPersona;

import android.content.Context;
import android.os.AsyncTask;

import com.example.proyectocovid.entidades.Persona;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServicioTaskSavePersona extends AsyncTask<Void,Void,Void> {
    private Context httpContext;//contexto
    private String linkURL;
    private Persona persona;
    //constructor del hilo (Asynctask)
    public ServicioTaskSavePersona(Context ctx, String linkURL,Persona persona){
        this.httpContext=ctx;
        this.linkURL=linkURL;
        this.persona=persona;
    }

    @Override
    protected Void doInBackground(Void... params) {
        URL url = null;
        try {
            url = new URL(linkURL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //crear el objeto json para enviar por POST
            JSONObject parametrosPost= new JSONObject();
            parametrosPost.put("idPersona",persona.getIdpersona());
            parametrosPost.put("numDoc",persona.getNumDoc());
            parametrosPost.put("numcel",persona.getNumCel());
            parametrosPost.put("idTipoDocumento",persona.getCodigoDoc());
            parametrosPost.put("idNacionalidad",persona.getCodigoNac());
            parametrosPost.put("idRol",persona.getCodigoRol());
            parametrosPost.put("idEstado",persona.getCodigoEst());
            //DEFINIR PARAMETROS DE CONEXION
            urlConnection.setReadTimeout(15000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("POST");// se puede cambiar por delete ,put ,etc
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream ());
            wr.writeBytes(parametrosPost.toString());
            wr.flush();
            wr.close();
            urlConnection.connect();
            int responseCode = urlConnection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                // server_response = readStream(urlConnection.getInputStream());
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
