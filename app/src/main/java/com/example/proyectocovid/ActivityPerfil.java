package com.example.proyectocovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityPerfil extends AppCompatActivity {
  ImageView btnTriajePerfil;
  TextView txtNumDocPerfil , txtNumCelPerfil, txtNacionPerfil;

    int idPersona= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        txtNumDocPerfil=(TextView)findViewById(R.id.tvNumDocPerfil);
        txtNacionPerfil=(TextView)findViewById(R.id.txNacionPerfil);
        txtNumCelPerfil=(TextView)findViewById(R.id.tvNumCelPerfil);

        String numDoc= getIntent().getStringExtra("numDoc");
        txtNumDocPerfil.setText(""+numDoc);
        String numcel= getIntent().getStringExtra("numcel");
        txtNumCelPerfil.setText(""+numcel);
        String nacion= getIntent().getStringExtra("nombreNac");
        txtNacionPerfil.setText(""+nacion);



        btnTriajePerfil= (ImageView) findViewById(R.id.btnPerTri);

        idPersona= getIntent().getExtras().getInt("idPersona");

        btnTriajePerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityPerfil.this,IniciarTriajeActivity.class);
                i.putExtra("idPersona", idPersona);
                startActivityForResult(i, 0);
            }
        });

    }
}
