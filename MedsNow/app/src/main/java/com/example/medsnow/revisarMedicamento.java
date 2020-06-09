package com.example.medsnow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class revisarMedicamento extends AppCompatActivity {

    private Button revisar;
    private ListView mostrarMed;
    List<Farmacia> drogas;
    ArrayAdapter<Farmacia> arrayAdapterFarmacia;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revisar_medicamento);

        revisar = (Button) findViewById(R.id.show);
        mostrarMed = (ListView) findViewById(R.id.lv_mostrarMed);

        drogas = new ArrayList<Farmacia>();
        myRef = FirebaseDatabase.getInstance().getReference();
    }

    public void revisarDrogas (View view){
        drogas.clear();
        myRef.child("Medicamento").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()) {
                    Farmacia farma = objSnapshot.getValue(Farmacia.class);
                    drogas.add(farma);
                    arrayAdapterFarmacia = new ArrayAdapter<Farmacia>(revisarMedicamento.this, android.R.layout.simple_list_item_1, drogas);
                    mostrarMed.setAdapter(arrayAdapterFarmacia);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}