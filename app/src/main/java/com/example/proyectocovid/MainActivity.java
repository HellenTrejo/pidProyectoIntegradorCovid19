package com.example.proyectocovid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectocovid.controlador.MySqlPersonaDAO;
import com.example.proyectocovid.entidades.Persona;
import com.example.proyectocovid.taskPersona.ServicioTaskListPersona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String REST="http://env-6360882.j.layershift.co.uk/rest/servicios/persona/";

    EditText txtDniLogin;
    Button btnIngresar, btnARegistroP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ////poner icono
        getSupportActionBar().setIcon(R.drawable.icon);





        txtDniLogin = (EditText) findViewById(R.id.et_dniLogin);
        btnIngresar = (Button) findViewById(R.id.btnlogin);
        btnARegistroP = (Button) findViewById((R.id.btnRegistrarNewP));
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarPersona();
                //cargarPersonas();

                //Intent i2 = new Intent(MainActivity.this, ActivityPerfil.class);
                //startActivityForResult(i2, 0);
            }
        });
        btnARegistroP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegistroPersona.class);
                startActivityForResult(i, 0);
            }
        });



    }

    void cargarPersonas(){
        try {
            String numDoc=txtDniLogin.getText().toString();
            ServicioTaskListPersona s=new ServicioTaskListPersona(this,REST+numDoc);
            s.execute();
            String a=s.get();
            ArrayList<Persona> data= MySqlPersonaDAO.listaPersonas(a);

            Persona p= new Persona();

            if(data.size()<=0){
                Toast.makeText(getApplicationContext(), "Usted no está registrado", Toast.LENGTH_SHORT).show();
            }else
            {
            for (Persona x:data) {
                String var= x.getNumDoc();
                String var2=x.getNacionalidad().getNombreNacionalidad();
                String var3=x.getNumCel();
                int var4=x.getIdpersona();
                int var5=x.getEstado().getIdestado();


                if (x.getNumDoc().equals(numDoc)){
                    Intent i2 = new Intent(MainActivity.this, ActivityPerfil.class);
                    i2.putExtra("numDoc", var);
                    i2.putExtra("nombreNac", var2);
                    i2.putExtra("numcel", var3);
                    i2.putExtra("idPersona",var4);
                    i2.putExtra("idEstado",var5);
                    startActivityForResult(i2, 0);
                    //


                }
            }
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    void validarPersona(){
        if(txtDniLogin.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Ingrese documento de identidad", Toast.LENGTH_SHORT).show();
        }else if(txtDniLogin.getText().toString().length()<8||txtDniLogin.getText().toString().length()>8){
            Toast.makeText(getApplicationContext(), "Documento debe ser de 8 digitos", Toast.LENGTH_SHORT).show();
        }
        else
        {
            cargarPersonas();
        }
    }



}
