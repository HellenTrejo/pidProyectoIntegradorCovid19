package com.example.proyectocovid.controlador;

import com.example.proyectocovid.entidades.Estado;
import com.example.proyectocovid.entidades.Nacionalidad;
import com.example.proyectocovid.entidades.Persona;
import com.example.proyectocovid.entidades.Rol;
import com.example.proyectocovid.entidades.TipoDocumento;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MySqlPersonaDAO {
    public static ArrayList<Persona>
    listaPersonas(String json){
        ArrayList<Persona> data=new ArrayList<Persona>();
        try {
            //convertir el valor de json en "json True"
            JSONArray jsonArray=new JSONArray(json);
            String json2=null;
            //
            String json3=null;

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
                Nacionalidad n = new Nacionalidad();
                TipoDocumento t =new TipoDocumento();
                //setear los atributos del objeto "doc"
                //con los valores del objeto fila


                p.setIdpersona(fila.getInt("idPersona"));
                p.setNumDoc(fila.getString("numDoc"));
                p.setNumCel(fila.getString("numcel"));
                /*
                t.setIdtipo_documento(fila.getInt("idTipoDocumento"));
                t.setDescripcion(fila.getString("descripcion"));
                p.setTipoDocumento(t);*/
                //n.setIdnacionalidad(fila.getInt("idNacionalidad"));
                //n.setNombreNacionalidad(fila.getString("nombreNacionalidad"));

                json2=fila.getString("nacionalidad");
                JSONArray jsonArray2=new JSONArray("["+json2+"]");
                JSONObject fila2;
               fila2=(JSONObject)jsonArray2.get(0);
                n.setIdnacionalidad(fila2.getInt("idNacionalidad"));
                n.setNombreNacionalidad(fila2.getString("nombreNacionalidad"));

                p.setNacionalidad(n);

                json3=fila.getString("estado");
                JSONArray jsonArray3=new JSONArray("["+json3+"]");
                JSONObject fila3;
                fila3=(JSONObject)jsonArray3.get(0);
                e.setIdestado(fila3.getInt("idEstado"));
                e.setDescripcion(fila3.getString("descripcion"));

                p.setEstado(e);
                /*
               r.setIdRol(fila.getInt("idRol"));
                r.setNombreRol(fila.getString("nombreRol"));
                p.setRol(r);
                e.setIdestado(fila.getInt("idEstado"));
                e.setDescripcion(fila.getString("descripcion"));
                p.setEstado(e);*/
                /*
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
