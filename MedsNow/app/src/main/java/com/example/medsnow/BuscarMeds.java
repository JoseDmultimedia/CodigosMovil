package com.example.medsnow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BuscarMeds extends AppCompatActivity {

    private EditText itemB;
    private Button buscar;
    private ListView listView;
    List<Farmacia> drogas;
    List<Farmacia> resultados;
    ArrayAdapter<Farmacia> arrayAdapterFarmacia;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_meds);

        itemB = (EditText) findViewById(R.id.itemBuscar);
        buscar = (Button) findViewById(R.id.buscar);
        listView = (ListView) findViewById(R.id.lv_datosMed);

        drogas = new ArrayList<Farmacia>();
        resultados = new ArrayList<Farmacia>();


        myRef = FirebaseDatabase.getInstance().getReference();

    }

    public void buscarDrugs (View view){
        drogas.clear();
        resultados.clear();
        final String valAbuscar = itemB.getText().toString();
        myRef.child("Medicamento").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()) {
                    Farmacia farma = objSnapshot.getValue(Farmacia.class);
                    drogas.add(farma);
                }
                for (int i = 0; i < drogas.size();i ++){
                    if (valAbuscar.equals(drogas.get(i).getMedName())){
                        resultados.add(drogas.get(i));
                        arrayAdapterFarmacia = new ArrayAdapter<Farmacia>(BuscarMeds.this, android.R.layout.simple_list_item_1, resultados);
                        listView.setAdapter(arrayAdapterFarmacia);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}