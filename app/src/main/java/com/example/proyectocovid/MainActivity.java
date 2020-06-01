package com.example.proyectocovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener, AdapterView.OnItemClickListener {

    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIngresar = (Button) findViewById(R.id.btnlogin);
        btnIngresar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v==btnIngresar){
            Intent intent=new Intent(this,RegistroPersona.class);
            startActivity(intent);

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
