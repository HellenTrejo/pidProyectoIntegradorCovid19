package com.example.proyectocovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectocovid.entidades.Nacionalidad;
import com.example.proyectocovid.entidades.Persona;
import com.example.proyectocovid.entidades.TipoDocumento;
import com.example.proyectocovid.entidades.Triaje;
import com.example.proyectocovid.taskPersona.ServicioTaskSavePersona;
import com.example.proyectocovid.taskTriaje.ServicioTaskSaveTriaje;

public class RegistroTriajeActivity extends AppCompatActivity {


    RadioGroup rgPre01,rgPre02,rgPre03,rgPre04,rgPre05;
    RadioButton rb1Si, rb1No, rb1Otro, rb2Si,rb2No,rb3Si,rb3No,rb4Si,rb4No, rb5Si,rb5No;
    Button btnRegTriaje;
    int conT=0;

     int idPersona=0;



    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_triaje);
        //

        idPersona=getIntent().getExtras().getInt("idPersona");

        rgPre01=(RadioGroup) findViewById(R.id.rgPregunta01);
        rgPre02=(RadioGroup) findViewById(R.id.rgPregunta02);
        rgPre03=(RadioGroup) findViewById(R.id.rgPregunta03);
        rgPre04=(RadioGroup) findViewById(R.id.rgPregunta04);
        rgPre05=(RadioGroup) findViewById(R.id.rgPregunta05);



        rb1Si=(RadioButton) findViewById(R.id.rbPre1Si);
        rb1No=(RadioButton) findViewById(R.id.rbPre1No);
        rb1Otro=(RadioButton) findViewById(R.id.rbPre1Otro);
        rb2Si=(RadioButton) findViewById(R.id.rbPre2Si);
        rb2No=(RadioButton) findViewById(R.id.rbPre2No);
        rb3Si=(RadioButton) findViewById(R.id.rbPre3Si);
        rb3No=(RadioButton) findViewById(R.id.rbPre3No);
        rb4Si=(RadioButton) findViewById(R.id.rbPre4Si);
        rb4No=(RadioButton) findViewById(R.id.rbPre4No);
        rb5Si=(RadioButton) findViewById(R.id.rbPre5Si);
        rb5No=(RadioButton) findViewById(R.id.rbPre5No);

        btnRegTriaje =(Button) findViewById(R.id.btnTerminarTriaje);
        btnRegTriaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarTriajePregunta01();
                registrarTriajePregunta02();
                registrarTriajePregunta03();
                registrarTriajePregunta04();
                registrarTriajePregunta05();

                if(conT>=3){
                    Intent i = new Intent(RegistroTriajeActivity.this,MalaRespuestaActivity.class);

                    startActivityForResult(i, 0);
                }else{
                    Intent i2 = new Intent(RegistroTriajeActivity.this,BuenaRespuestaActivity.class);

                    startActivityForResult(i2, 0);
                }


            }
        });
    }



    public void registrarTriajePregunta01(){

        String resp="";
        if(rb1Si.isChecked()) {
            resp="SI";
            conT++;
            }

        else if(rb1No.isChecked()) {
            resp="NO";
        }
        else if(rb1Otro.isChecked()) {
            resp="OTRO";
        }

        Triaje t=new Triaje();
        t.setRespuesta(resp);
        t.setCodPregunta(1);
        t.setCodPersona(idPersona);//Cambiarlo el id por persona que se registre
        ServicioTaskSaveTriaje servicio= new ServicioTaskSaveTriaje(this, "http://env-4252036.j.layershift.co.uk/rest/servicios/triaje/add/",t);
        servicio.execute();

    }
    public void registrarTriajePregunta02(){

        String resp="";
        if(rb2Si.isChecked()) {
            resp="SI";
            conT++;
        }

        else if(rb2No.isChecked()) {
            resp="NO";
        }


        Triaje tr=new Triaje();
        tr.setRespuesta(resp);
        tr.setCodPregunta(2);
        tr.setCodPersona(idPersona);//Cambiarlo el id por persona que se registre
        ServicioTaskSaveTriaje servicio= new ServicioTaskSaveTriaje(this, "http://env-4252036.j.layershift.co.uk/rest/servicios/triaje/add/",tr);
        servicio.execute();

    }

    public void registrarTriajePregunta03(){

        String resp="";
        if(rb3Si.isChecked()) {
            resp="SI";
            conT++;
        }

        else if(rb3No.isChecked()) {
            resp="NO";
        }


        Triaje tri=new Triaje();
        tri.setRespuesta(resp);
        tri.setCodPregunta(3);
        tri.setCodPersona(idPersona);//Cambiarlo el id por persona que se registre
        ServicioTaskSaveTriaje servicio= new ServicioTaskSaveTriaje(this, "http://env-4252036.j.layershift.co.uk/rest/servicios/triaje/add/",tri);
        servicio.execute();

    }

    public void registrarTriajePregunta04(){

        String resp="";
        if(rb4Si.isChecked()) {
            resp="SI";
            conT++;
        }

        else if(rb4No.isChecked()) {
            resp="NO";
        }


        Triaje tria=new Triaje();
        tria.setRespuesta(resp);
        tria.setCodPregunta(4);
        tria.setCodPersona(idPersona);//Cambiarlo el id por persona que se registre
        ServicioTaskSaveTriaje servicio= new ServicioTaskSaveTriaje(this, "http://env-4252036.j.layershift.co.uk/rest/servicios/triaje/add/",tria);
        servicio.execute();

    }

    public void registrarTriajePregunta05(){

        String resp="";
        if(rb5Si.isChecked()) {
            resp="SI";
            conT++;
        }

        else if(rb5No.isChecked()) {
            resp="NO";
        }


        Triaje triaj=new Triaje();
        triaj.setRespuesta(resp);
        triaj.setCodPregunta(5);
        triaj.setCodPersona(idPersona);//Cambiarlo el id por persona que se registre
        ServicioTaskSaveTriaje servicio= new ServicioTaskSaveTriaje(this, "http://env-4252036.j.layershift.co.uk/rest/servicios/triaje/add/",triaj);
        servicio.execute();

    }




}
