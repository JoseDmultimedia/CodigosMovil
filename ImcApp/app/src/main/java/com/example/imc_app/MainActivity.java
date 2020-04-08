package com.example.imc_app;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /*
    ----------------------------------------------------------------------------
    Codigo realizado por Joe
    Materia desarrollo soft movil
    ----------------------------------------------------------------------------
     */

    // crear variables para llamarla del front
    private TextView imc;
    private EditText peso, estatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlace con el view
        imc = (TextView)findViewById(R.id.tImc);
        peso = (EditText)findViewById(R.id.ePeso);
        estatura = (EditText)findViewById(R.id.eEstatu);
    }

    public void calcular (View view){

        //Obteniendo los valores en cadena
        String valor1 = peso.getText().toString();
        String valor2 = estatura.getText().toString();

        //Parseadod de cadena - a numeric
        double pesoNum = Double.parseDouble(valor1);
        double estaturaNum = Double.parseDouble(valor2);

        //imc calculo
        double operacion = pesoNum/(estaturaNum*estaturaNum);
        String calculo = String.valueOf(operacion);
        imc.setText(calculo);

        //Codiciones para mostrar un mensaje
        if(operacion <= 18.5){
            Toast.makeText(this, "desnutricion",Toast.LENGTH_SHORT).show();
        }
        if((operacion >= 18.5) && (operacion < 25)){
            Toast.makeText(this, "bajo peso",Toast.LENGTH_SHORT).show();
        }
        if((operacion >= 25) && (operacion < 30)){
            Toast.makeText(this, "normal",Toast.LENGTH_SHORT).show();
        }
        if((operacion >= 30) && (operacion < 40)){
            Toast.makeText(this, "obesidad",Toast.LENGTH_SHORT).show();
        }
        if(operacion >= 40){
            Toast.makeText(this, "obesidad severa",Toast.LENGTH_SHORT).show();
        }
    }
}
