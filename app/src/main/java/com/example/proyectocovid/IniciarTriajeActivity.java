package com.example.proyectocovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class IniciarTriajeActivity extends AppCompatActivity {


    Button btnIniTri;
     int idPersona=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_triaje);

        btnIniTri= (Button) findViewById(R.id.btnIniciarTriaje);

        idPersona= getIntent().getExtras().getInt("idPersona");
        btnIniTri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IniciarTriajeActivity.this,RegistroTriajeActivity.class);
                i.putExtra("idPersona", idPersona);
                startActivityForResult(i, 0);
            }
        });

    }
}
