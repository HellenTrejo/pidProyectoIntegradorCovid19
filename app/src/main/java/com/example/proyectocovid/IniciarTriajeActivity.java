package com.example.proyectocovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class IniciarTriajeActivity extends AppCompatActivity {


    Button btnIniTri;
     int idPersona=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_triaje);
        //
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //
        getSupportActionBar().setIcon(R.drawable.icon);
        //
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
    }
}
