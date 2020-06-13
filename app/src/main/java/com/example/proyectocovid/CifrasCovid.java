package com.example.proyectocovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyectocovid.controlador.MySqlCifrasDAO;
import com.example.proyectocovid.controlador.MySqlDepartamentoDAO;
import com.example.proyectocovid.controlador.MySqlNacionalidadDAO;
import com.example.proyectocovid.controlador.MySqlPersonaDAO;
import com.example.proyectocovid.controlador.MySqlTipoDocumentoDAO;
import com.example.proyectocovid.entidades.Cifras;
import com.example.proyectocovid.entidades.Departamento;
import com.example.proyectocovid.entidades.Nacionalidad;
import com.example.proyectocovid.entidades.Persona;
import com.example.proyectocovid.entidades.TipoDocumento;
import com.example.proyectocovid.taskCifras.ServicioTaskListCifras;
import com.example.proyectocovid.taskDepartamento.ServicioTaskListDepartamento;
import com.example.proyectocovid.taskNacionalidad.ServicioTaskListNacionalidad;
import com.example.proyectocovid.taskPersona.ServicioTaskListPersona;
import com.example.proyectocovid.taskTipoDoc.ServicioTaskListTipoDoc;

import java.util.ArrayList;

public class CifrasCovid extends AppCompatActivity {

    Button btnFiltroC;
    Spinner spDepartamento;
    Spinner spFecha;
    EditText edNuevo, edFallecido, edRecuperado,edTotal;

    private static String REST="http://env-6360882.j.layershift.co.uk/rest/servicios/cifras/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cifras_covid);

        btnFiltroC=(Button)findViewById(R.id.btnfiltroCifra);
        btnFiltroC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarCifras();
            }
        });
        spDepartamento=(Spinner) findViewById(R.id.spinnerDepart);
        spFecha=(Spinner) findViewById(R.id.spinnerFecha);
        edNuevo=(EditText)findViewById(R.id.contadornuevo);
        edNuevo.setEnabled(false);
        edFallecido=(EditText)findViewById(R.id.contadorFallecidos);
        edFallecido.setEnabled(false);
        edTotal=(EditText)findViewById(R.id.contadorTotales);
        edTotal.setEnabled(false);
        edRecuperado=(EditText)findViewById(R.id.contadorRecuperado);
        edRecuperado.setEnabled(false);


        cargarDepartamento();
        cargarFecha();

    }



    public void cargarDepartamento(){
        try{
            ServicioTaskListDepartamento servicio=new ServicioTaskListDepartamento(this,"http://env-6360882.j.layershift.co.uk/rest/servicios/departamento/");
            servicio.execute();
            String c=servicio.get();
            ArrayList<Departamento> data= MySqlDepartamentoDAO.listaAllDepartamento(c);
            ArrayAdapter<Departamento> adapter=new ArrayAdapter<Departamento>(this,android.R.layout.simple_list_item_1,data);
            spDepartamento.setAdapter(adapter);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void cargarFecha(){
        try{
            ServicioTaskListCifras servicio=new ServicioTaskListCifras(this,"http://env-6360882.j.layershift.co.uk/rest/servicios/cifras/");
            servicio.execute();
            String c=servicio.get();
            ArrayList<Cifras> data= MySqlCifrasDAO.listaCifras(c);


            ArrayAdapter<Cifras> adapter=new ArrayAdapter<Cifras>(this,android.R.layout.simple_list_item_1,data);
            spFecha.setAdapter(adapter);


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



    void cargarCifras(){
        try {
            int depar=spDepartamento.getSelectedItemPosition()+1;
            String fecha =spFecha.getSelectedItem().toString();
            ServicioTaskListCifras s=new ServicioTaskListCifras(this,REST+fecha+"/"+depar);
            s.execute();
            String a=s.get();
            ArrayList<Cifras> data= MySqlCifrasDAO.listaCifras(a);

            Cifras c= new Cifras();

            if(data.size()<=0){
                Toast.makeText(getApplicationContext(), "Usted no está registrado", Toast.LENGTH_SHORT).show();
            }else
            {
                for (Cifras x:data) {
                    int var= x.getNuevos();
                    int var2=x.getRecuperados();
                    int var3=x.getTotales();
                    int var4=x.getFallecidos();
                    int var5=x.getDepartamento().getIdDepartamento();


                    if (x.getFecha().equals(fecha)&&var5==depar){
                        edTotal.setText(""+var3);
                        edRecuperado.setText(""+var2);
                        edFallecido.setText(""+var4);
                        edNuevo.setText(""+var);

                        


                    }
                }
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


}
