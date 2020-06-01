package com.example.proyectocovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_triaje);
        rgPre01=(RadioGroup) findViewById(R.id.rgPregunta01);
        rgPre02=(RadioGroup) findViewById(R.id.rgPregunta02);
        rgPre03=(RadioGroup) findViewById(R.id.rgPregunta03);
        rgPre04=(RadioGroup) findViewById(R.id.rgPregunta04);
        rgPre05=(RadioGroup) findViewById(R.id.rgPregunta05);



        rb1Si=(RadioButton) findViewById(R.id.rbPre1Si);
        /*rb1No=(RadioButton) findViewById(R.id.rbPre1No);
        rb1Otro=(RadioButton) findViewById(R.id.rbPre1Otro);
        rb2Si=(RadioButton) findViewById(R.id.rbPre2Si);
        rb2No=(RadioButton) findViewById(R.id.rbPre2No);
        rb3Si=(RadioButton) findViewById(R.id.rbPre3Si);
        rb3No=(RadioButton) findViewById(R.id.rbPre3No);
        rb4Si=(RadioButton) findViewById(R.id.rbPre4Si);
        rb4No=(RadioButton) findViewById(R.id.rbPre4No);
        rb5Si=(RadioButton) findViewById(R.id.rbPre5Si);
        rb5No=(RadioButton) findViewById(R.id.rbPre5No);*/

        btnRegTriaje =(Button) findViewById(R.id.btnTerminarTriaje);
        btnRegTriaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarTriaje();
                Intent i = new Intent(RegistroTriajeActivity.this,MalaRespuestaActivity.class);
                startActivityForResult(i, 0);
            }
        });
    }
   // public String resp1;
    public void registrarTriaje(){
/*
        rgPre01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                int id=rgPre01.getCheckedRadioButtonId();
                switch (id)
                {
                    case R.id.rbPre1Si:
                        resp1="SI";
                        break;
                    case R.id.rbPre1No:
                        resp1="NO";
                        break;
                   // case R.id.rbPre1Otro:
                        //resp1="OTRO";
                     //   break;
                    default:
                        resp1="OTRO";
                        break;

                }
            }

        });*/
        String resp="";
        if(rb1Si.isChecked()) {
            resp="SI";
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
        t.setCodPersona(2);//Cambiarlo el id por persona que se registre
        ServicioTaskSaveTriaje servicio= new ServicioTaskSaveTriaje(this, "http://env-4252036.j.layershift.co.uk/rest/servicios/triajes/add/",t);
        servicio.execute();


       /* try{
            String resp;
            int codi;
            Triaje t= new Triaje();

            if(rb1Si.isChecked()) {
                resp="SI";
                t.setRespuesta(resp);}

            else if(rb1No.isChecked()) {
                resp="NO";
                t.setRespuesta(resp);
            }
           else if(rb1Otro.isChecked()) {
                resp="OTRO";
                t.setRespuesta(resp);
            }
            else if(rb2Si.isChecked()) {
                resp="SI";
                t.setRespuesta(resp);
            }
            else if(rb2No.isChecked()) {
                resp="NO";
                t.setRespuesta(resp);
            }
            else if(rb3Si.isChecked()) {
                resp="SI";
                t.setRespuesta(resp);
            }
            else if(rb3No.isChecked()) {
                resp="No";
                t.setRespuesta(resp);
            }
            else if(rb4Si.isChecked()) {
                resp="SI";
                t.setRespuesta(resp);
            }
            else if(rb4No.isChecked()) {
                resp="NO";
                t.setRespuesta(resp);
            }
            else if(rb5Si.isChecked()) {
                resp="SI";
                t.setRespuesta(resp);
            }
            else if(rb5No.isChecked()) {
                resp="NO";
                t.setRespuesta(resp);
            }*/


    }




}
