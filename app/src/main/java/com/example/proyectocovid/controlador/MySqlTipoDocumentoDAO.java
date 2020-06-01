package com.example.proyectocovid.controlador;

import com.example.proyectocovid.entidades.TipoDocumento;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MySqlTipoDocumentoDAO {
    public static ArrayList<TipoDocumento>
    listaAllTipoDoc(String json){
        ArrayList<TipoDocumento> data=new ArrayList<TipoDocumento>();
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
                TipoDocumento dis=new TipoDocumento();
                //setear los atributos del objeto "doc"
                //con los valores del objeto fila
                dis.setIdtipo_documento(fila.getInt("idTipoDocumento"));
                dis.setDescripcion(fila.getString("descripcion"));
                data.add(dis);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

}
