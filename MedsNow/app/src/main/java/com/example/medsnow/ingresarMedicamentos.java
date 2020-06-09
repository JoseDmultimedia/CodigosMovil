package com.example.medsnow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ingresarMedicamentos extends AppCompatActivity {


    private EditText nombreMed, codigo, farmaName, valor, cantidad;
    private Button ingresarMedica;
    //Para la base de datos
    private DatabaseReference myRef;
    //List<Farmacia> drogas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_medicamentos);

        nombreMed = (EditText) findViewById(R.id.medName);
        codigo = (EditText) findViewById(R.id.codigo);
        farmaName = (EditText) findViewById(R.id.farmaName);
        valor = (EditText) findViewById(R.id.valor);
        cantidad = (EditText) findViewById(R.id.cantidad);

        ingresarMedica = (Button) findViewById(R.id.entrar);

        myRef = FirebaseDatabase.getInstance().getReference();

    }

    public void ingresarMed (View view){
        String id = myRef.push().getKey();
        String val1 = nombreMed.getText().toString();
        String val2 = codigo.getText().toString();
        String val3 = farmaName.getText().toString();
        double val4 = Double.parseDouble(valor.getText().toString());
        int val5 = Integer.parseInt(cantidad.getText().toString());

        Farmacia droga = new Farmacia();

        droga.setMedName(val1);
        droga.setCantidad(val5);
        droga.setCodigo(val2);
        droga.setFarmaciaName(val3);
        droga.setValor(val4);

        myRef.child("Medicamento").child(id).setValue(droga);

        Toast.makeText(this,"Se ha ingresado el Medicamento \n"+ val1,Toast.LENGTH_LONG).show();

        limpiar();
    }

    public void limpiar(){
        nombreMed.setText("");
        codigo.setText("");
        farmaName.setText("");
        valor.setText("");
        cantidad.setText("");
    }

}