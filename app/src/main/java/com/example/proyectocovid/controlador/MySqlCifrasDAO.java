package com.example.proyectocovid.controlador;

import com.example.proyectocovid.entidades.Cifras;
import com.example.proyectocovid.entidades.Departamento;
import com.example.proyectocovid.entidades.Estado;
import com.example.proyectocovid.entidades.Nacionalidad;
import com.example.proyectocovid.entidades.Persona;
import com.example.proyectocovid.entidades.Rol;
import com.example.proyectocovid.entidades.TipoDocumento;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MySqlCifrasDAO {
    public static ArrayList<Cifras>
    listaCifras(String json){
        ArrayList<Cifras> data=new ArrayList<Cifras>();
        try {
            //convertir el valor de json en "json True"
            JSONArray jsonArray=new JSONArray(json);
            String json2=null;

            //objeto de la clase JSONObject
            JSONObject fila;

            //bucle sobre jsonArray
            for(int i=0;i<jsonArray.length();i++){
                //obtener cada fila del objeto jsonArray
                fila=(JSONObject)jsonArray.get(i);
                //crear objeto de la clase Docente
                Cifras p=new Cifras();
                Departamento d = new Departamento();
                //setear los atributos del objeto "doc"
                //con los valores del objeto fila


                p.setIdCifras(fila.getInt("idCifras"));
                p.setNuevos(fila.getInt("nuevos"));
                p.setTotales(fila.getInt("totales"));
                p.setFallecidos(fila.getInt("fallecidos"));
                p.setRecuperados(fila.getInt("recuperados"));
                p.setFecha(fila.getString("fecha"));

                json2=fila.getString("departamento");
                JSONArray jsonArray2=new JSONArray("["+json2+"]");
                JSONObject fila2;
                fila2=(JSONObject)jsonArray2.get(0);
                d.setIdDepartamento(fila2.getInt("idDepartamento"));
                d.setDescripcion(fila2.getString("descripcion"));

                p.setDepartamento(d);

                data.add(p);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
