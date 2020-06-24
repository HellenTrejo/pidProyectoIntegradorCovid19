package com.example.proyectocovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class BuenaRespuestaActivity extends AppCompatActivity {
//probando

    Button btnFinalizaBuena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buena_respuesta);
        btnFinalizaBuena=(Button) findViewById(R.id.btnFinBuenaResp);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ////poner icono
        getSupportActionBar().setIcon(R.drawable.icon);


        btnFinalizaBuena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(BuenaRespuestaActivity.this,ActivityPerfil.class);

                finish();
                //finishAffinity();
                //startActivityForResult(i, 0);

            }
        });
    }


}
