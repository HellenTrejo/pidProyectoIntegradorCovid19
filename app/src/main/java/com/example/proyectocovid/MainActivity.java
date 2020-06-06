package com.example.proyectocovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtDniLogin;
    Button btnIngresar, btnARegistroP;
    private String numDoc;
    private String baseUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtDniLogin = (EditText) findViewById(R.id.et_dniLogin);
        btnIngresar = (Button) findViewById(R.id.btnlogin);
        btnARegistroP = (Button) findViewById((R.id.btnRegistrarNewP));
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



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



}
