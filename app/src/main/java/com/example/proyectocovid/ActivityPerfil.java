package com.example.proyectocovid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityPerfil extends AppCompatActivity {
    Spinner mySpinner;
  ImageView btnTriajePerfil;
  TextView txtNumDocPerfil , txtNumCelPerfil, txtNacionPerfil;

    int idPersona= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Toolbar toolbar = findViewById(R.id.toolbar_sup);
        setSupportActionBar(toolbar);
        mySpinner =(Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter =  new ArrayAdapter<String>(ActivityPerfil.this,android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.opciones_persona));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sup,menu);
        return super.onCreateOptionsMenu(menu);
        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_cerrar:
                Toast.makeText(this, "Cerró sesión",Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(ActivityPerfil.this,MainActivity.class);
                startActivityForResult(myIntent,0);
                return true;
            //break;
        }
        return super.onOptionsItemSelected(item);
        //return true;
    }


}
