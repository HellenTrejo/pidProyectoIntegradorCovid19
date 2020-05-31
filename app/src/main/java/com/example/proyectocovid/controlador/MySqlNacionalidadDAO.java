package com.example.proyectocovid.controlador;

import com.example.proyectocovid.entidades.Nacionalidad;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MySqlNacionalidadDAO {
    public static ArrayList<Nacionalidad>
    listaAllNacionalidad(String json){
        ArrayList<Nacionalidad> data=new ArrayList<Nacionalidad>();
        try {
            //convertir el valor de json en "json True"
            JSONArray jsonArray=new JSONArray(json);
            //objeto de la clase JSONObject
            JSONObject fila;
            //bucle sobre jsonArray
            for(int i=0;i<jsonArray.length();i++){
                //obtener cada fila del objeto jsonArray
                fila=(JSONObject)jsonArray.get(i);
                //crear objeto de la clase Docente
                Nacionalidad dis=new Nacionalidad();
                //setear los atributos del objeto "doc"
                //con los valores del objeto fila
                dis.setIdnacionalidad(fila.getInt("idNacionalidad"));
                dis.setNombreNacionalidad(fila.getString("nombreNacionalidad"));
                data.add(dis);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }


}
