package com.example.proyectocovid.taskTriaje;

import android.content.Context;
import android.os.AsyncTask;

import com.example.proyectocovid.entidades.Triaje;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServicioTaskSaveTriaje extends AsyncTask<Void,Void,Void> {
    private Context httpContext;//contexto
    private String linkURL;
    private Triaje triaje;
    //constructor del hilo (Asynctask)
    public ServicioTaskSaveTriaje(Context ctx, String linkURL, Triaje triaje){
        this.httpContext=ctx;
        this.linkURL=linkURL;
        this.triaje=triaje;
    }

    @Override
    protected Void doInBackground(Void... params) {
        URL url = null;
        try {
            url = new URL(linkURL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //crear el objeto json para enviar por POST
            JSONObject parametrosPost= new JSONObject();
            parametrosPost.put("idTriaje",triaje.getIdTriaje());
            parametrosPost.put("respuesta",triaje.getRespuesta());
            parametrosPost.put("idpregunta",triaje.getCodPregunta());
            parametrosPost.put("idpersona",triaje.getCodPersona());

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
                //server_response = readStream(urlConnection.getInputStream());
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
