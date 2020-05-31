package com.example.proyectocovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.proyectocovid.controlador.MySqlNacionalidadDAO;
import com.example.proyectocovid.controlador.MySqlTipoDocumentoDAO;
import com.example.proyectocovid.entidades.Nacionalidad;
import com.example.proyectocovid.entidades.TipoDocumento;
import com.example.proyectocovid.taskNacionalidad.ServicioTaskListNacionalidad;
import com.example.proyectocovid.taskTipoDoc.ServicioTaskListTipoDoc;

import java.util.ArrayList;

public class RegistroPersona extends AppCompatActivity {
    EditText edtNumCel, edtNumDoc;
    Spinner spNacion, spTipoDoc;
    Button btnRegistrop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_persona);


        edtNumCel =(EditText) findViewById(R.id.txtCelular);
        edtNumDoc=(EditText) findViewById(R.id.txtNumeroDoc);
        spNacion =(Spinner) findViewById(R.id.spNacionalidad);
        spTipoDoc=(Spinner) findViewById(R.id.spTipoDocumento);
        btnRegistrop=(Button) findViewById(R.id.btnRegPersona);
      //  btnRegistrop.setOnClickListener(this);

        cargarNacionalidad();
        cargarTipoDoc();

    }
    public void cargarNacionalidad(){
        try{
            ServicioTaskListNacionalidad servicio=new ServicioTaskListNacionalidad(this,"http://env-4252036.j.layershift.co.uk/rest/servicios/nacionalidad/");
            servicio.execute();
            String c=servicio.get();
            ArrayList<Nacionalidad> data= MySqlNacionalidadDAO.listaAllNacionalidad(c);
            ArrayAdapter<Nacionalidad> adapter=new ArrayAdapter<Nacionalidad>(this,android.R.layout.simple_list_item_1,data);
            spNacion.setAdapter(adapter);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void cargarTipoDoc(){
        try{
            ServicioTaskListTipoDoc servicio=new ServicioTaskListTipoDoc(this,"http://env-4252036.j.layershift.co.uk/rest/servicios/tipodoc/");
            servicio.execute();
            String c=servicio.get();
            ArrayList<TipoDocumento> data= MySqlTipoDocumentoDAO.listaAllTipoDoc(c);
            ArrayAdapter<TipoDocumento> adapter=new ArrayAdapter<TipoDocumento>(this,android.R.layout.simple_list_item_1,data);
            spNacion.setAdapter(adapter);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



}



