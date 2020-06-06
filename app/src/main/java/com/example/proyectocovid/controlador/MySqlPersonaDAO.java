package com.example.proyectocovid.controlador;

import com.example.proyectocovid.entidades.Estado;
import com.example.proyectocovid.entidades.Persona;
import com.example.proyectocovid.entidades.Rol;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MySqlPersonaDAO {
    public static ArrayList<Persona>
    listaPersonas(String json){
        ArrayList<Persona> data=new ArrayList<Persona>();
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
                Persona p=new Persona();
                Rol r = new Rol();
                Estado e = new Estado();
                //setear los atributos del objeto "doc"
                //con los valores del objeto fila


                p.setIdpersona(fila.getInt("idPersona"));
                p.setNumDoc(fila.getString("numDoc"));
                p.setNumCel(fila.getString("numcel"));
               /* r.setIdRol(fila.getInt("idRol"));
                r.setNombreRol(fila.getString("nombreRol"));
                p.setRol(r);
                e.setIdestado(fila.getInt("idEstado"));
                e.setDescripcion(fila.getString("descripcion"));
                p.setEstado(e);
                p.setCodigoRol(fila.getInt("idRol"));
                p.setCodigoEst(fila.getInt("idEstado"));*/
                data.add(p);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
