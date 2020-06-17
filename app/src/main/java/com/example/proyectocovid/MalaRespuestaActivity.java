package com.example.proyectocovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MalaRespuestaActivity extends AppCompatActivity {

    Button btnFinalizarMala;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mala_respuesta);
        btnFinalizarMala =(Button)findViewById(R.id.btnFinMalaResp);
        btnFinalizarMala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(MalaRespuestaActivity.this,ActivityPerfil.class);

                //startActivityForResult(i, 0);
            }
        });


    }
}
