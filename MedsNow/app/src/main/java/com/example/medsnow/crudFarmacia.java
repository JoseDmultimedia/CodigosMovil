package com.example.medsnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class crudFarmacia extends AppCompatActivity {

    private Button ingresar, revisar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_farmacia);
        ingresar = (Button) findViewById(R.id.entrar);
        revisar = (Button) findViewById(R.id.revisar);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(crudFarmacia.this, ingresarMedicamentos.class);
                startActivity(i);
            }
        });



        revisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(crudFarmacia.this, revisarMedicamento.class );
                startActivity(i);
            }
        });
    }

}