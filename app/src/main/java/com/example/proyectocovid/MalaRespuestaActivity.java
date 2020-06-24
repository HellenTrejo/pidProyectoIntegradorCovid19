package com.example.proyectocovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MalaRespuestaActivity extends AppCompatActivity {

    Button btnFinalizarMala;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mala_respuesta);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ////poner icono
        getSupportActionBar().setIcon(R.drawable.icon);

        btnFinalizarMala =(Button)findViewById(R.id.btnFinMalaResp);
        btnFinalizarMala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(MalaRespuestaActivity.this,ActivityPerfil.class);
                finish();
                //startActivityForResult(i, 0);
            }
        });


    }
}
