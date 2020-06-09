package com.example.medsnow;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText usuarioText;
    private EditText contraseña;
    private Button ingresarL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioText = (EditText) findViewById(R.id.userT);
        contraseña = (EditText) findViewById(R.id.contraT);


        ingresarL = (Button) findViewById(R.id.ingresarLogin);


        //myRef = FirebaseDatabase.getInstance().getReference();

        ingresarL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ingresar();
            }
        });
    }

    public void ingresar (){
       String userName1 = "Medico1";
       String pass1 = "1234";

       String userName2 = "Farmacia1";
       String pass2 = "4321";

       String val1 = usuarioText.getText().toString();
       String val2 = contraseña.getText().toString();
       if(val1.equals(userName1) && val2.equals(pass1)) {
          Intent i = new Intent(MainActivity.this, BuscarMeds.class);
          startActivity(i);
       }else
           if(val1.equals(userName2) && val2.equals(pass2)){
               Intent i = new Intent(MainActivity.this, crudFarmacia.class);
               startActivity(i);
           }

    }

}