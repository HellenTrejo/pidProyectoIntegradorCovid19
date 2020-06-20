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

  ImageView btnTriajePerfil, btnMapaPerfil, btnCifrasPerfil;
  ImageView imgNoSintomas, imgConSintomas;
  TextView txtNumDocPerfil , txtNumCelPerfil, txtNacionPerfil;

    int idPersona= 0;
    int idEstado=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Toolbar toolbar = findViewById(R.id.toolbar_sup);
        setSupportActionBar(toolbar);



        imgNoSintomas=(ImageView)findViewById(R.id.imgNoSospechoso);
        imgConSintomas=(ImageView) findViewById(R.id.imgSospechoso);

        txtNumDocPerfil=(TextView)findViewById(R.id.tvNumDocPerfil);
        txtNacionPerfil=(TextView)findViewById(R.id.txNacionPerfil);
        txtNumCelPerfil=(TextView)findViewById(R.id.tvNumCelPerfil);

        String numDoc= getIntent().getStringExtra("numDoc");
        txtNumDocPerfil.setText(""+numDoc);
        String numcel= getIntent().getStringExtra("numcel");
        txtNumCelPerfil.setText(""+numcel);
        String nacion= getIntent().getStringExtra("nombreNac");
        txtNacionPerfil.setText(""+nacion);


        idEstado=getIntent().getExtras().getInt("idEstado");
        cambiaEstadoPerfil();
        btnTriajePerfil= (ImageView) findViewById(R.id.btnPerTri);
        btnMapaPerfil=(ImageView) findViewById(R.id.btnPerMap);

        btnCifrasPerfil =(ImageView)findViewById(R.id.btnPerCif) ;
        idPersona= getIntent().getExtras().getInt("idPersona");

        btnTriajePerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityPerfil.this,IniciarTriajeActivity.class);
                i.putExtra("idPersona", idPersona);
                startActivityForResult(i, 0);
            }
        });
        btnMapaPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(ActivityPerfil.this,MapsActivity.class);
                startActivityForResult(m, 0);
            }
        });
        btnCifrasPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(ActivityPerfil.this,CifrasCovid.class);
                startActivityForResult(c, 0);
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

            /*

            case R.id.menu_perfil:
                //Toast.makeText(this, "Cerró sesión",Toast.LENGTH_SHORT).show();
                //Intent myp = new Intent(ActivityPerfil.this,ActivityPerfil.class);
                //startActivityForResult(myp,0);
                return true;
            //break;
            case R.id.menu_cifras:
                //Toast.makeText(this, "Cerró sesión",Toast.LENGTH_SHORT).show();
                Intent myc = new Intent(ActivityPerfil.this,CifrasCovid.class);//Cambiar
                startActivityForResult(myc,0);
                return true;
            //break;

             */
        }
        return super.onOptionsItemSelected(item);
        //return true;
    }


    void cambiaEstadoPerfil(){
        if(idEstado==3){
            imgNoSintomas.setImageResource(R.drawable.circulogris);
            imgConSintomas.setImageResource(R.drawable.circulorojo);
        }else if(idEstado==4){
            imgNoSintomas.setImageResource(R.drawable.circuloverde);
            imgConSintomas.setImageResource(R.drawable.circulogris);
        }else if(idEstado==2){
            imgNoSintomas.setImageResource(R.drawable.circulogris);
            imgConSintomas.setImageResource(R.drawable.circulogris);
        }
    }


}
