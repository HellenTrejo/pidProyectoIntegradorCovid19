package com.example.proyectointegrador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SeguimientoSospechososActivity extends AppCompatActivity {

    Toolbar myToolbar;
    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguimiento_sospechosos);
        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        mySpinner =(Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter =  new ArrayAdapter<String>(SeguimientoSospechososActivity.this,android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.opciones_admin));
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
    }
}
