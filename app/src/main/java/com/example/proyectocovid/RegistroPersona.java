package com.example.proyectocovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyectocovid.controlador.MySqlNacionalidadDAO;
import com.example.proyectocovid.controlador.MySqlTipoDocumentoDAO;
import com.example.proyectocovid.entidades.Estado;
import com.example.proyectocovid.entidades.Nacionalidad;
import com.example.proyectocovid.entidades.Persona;
import com.example.proyectocovid.entidades.Rol;
import com.example.proyectocovid.entidades.TipoDocumento;
import com.example.proyectocovid.taskNacionalidad.ServicioTaskListNacionalidad;
import com.example.proyectocovid.taskPersona.ServicioTaskSavePersona;
import com.example.proyectocovid.taskTipoDoc.ServicioTaskListTipoDoc;

import java.util.ArrayList;

public class RegistroPersona extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
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
        btnRegistrop.setOnClickListener(this);

        cargarNacionalidad();
        cargarTipoDoc();

    }
    public void cargarNacionalidad(){
        try{
            ServicioTaskListNacionalidad servicio=new ServicioTaskListNacionalidad(this,"http://env-6360882.j.layershift.co.uk/rest/servicios/nacionalidad/");
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
            ServicioTaskListTipoDoc servicio=new ServicioTaskListTipoDoc(this,"http://env-6360882.j.layershift.co.uk/rest/servicios/tipodoc/");
            servicio.execute();
            String c=servicio.get();
            ArrayList<TipoDocumento> data= MySqlTipoDocumentoDAO.listaAllTipoDoc(c);
            ArrayAdapter<TipoDocumento> adapter=new ArrayAdapter<TipoDocumento>(this,android.R.layout.simple_list_item_1,data);
            spTipoDoc.setAdapter(adapter);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void registrarPersona(){
        try{
            int codi;
            Persona per=new Persona();
            Nacionalidad nac= new Nacionalidad();
            TipoDocumento doc= new TipoDocumento();

            per.setNumDoc(edtNumDoc.getText().toString());
            per.setNumCel(edtNumCel.getText().toString());
            doc= (TipoDocumento) spTipoDoc.getItemAtPosition(spTipoDoc.getSelectedItemPosition());
            per.setCodigoDoc(doc.getIdtipo_documento());
            nac= (Nacionalidad) spNacion.getItemAtPosition(spNacion.getSelectedItemPosition());
            per.setCodigoNac(nac.getIdnacionalidad());
            per.setCodigoRol(2);
            per.setCodigoEst(4);
            ServicioTaskSavePersona servicio= new ServicioTaskSavePersona(this, "http://env-6360882.j.layershift.co.uk/rest/servicios/persona/add/",per);
            servicio.execute();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View v) {
        if(v==btnRegistrop){
            registrarPersona();
            Intent intent = new Intent(this, MainActivity.class);
            Toast.makeText(getApplicationContext(), "Registro exitoso!!!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}



