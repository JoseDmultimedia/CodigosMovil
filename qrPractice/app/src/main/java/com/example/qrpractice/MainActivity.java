package com.example.qrpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.*;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*
    Desarrollado por;
    Jose David Garcia Diosa
    V 1.0
     */

    //Inicializar variables globales
    private EditText codigoTxt, nombreTxt, telefonoTxt, emailTxt;
    private Button scanBtn, guardar, eliminar, ver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //llamado de variables globales con la identificacion de cada Edittext
        codigoTxt = (EditText)findViewById(R.id.eCodigo);
        nombreTxt = (EditText)findViewById(R.id.eNombre);
        telefonoTxt = (EditText)findViewById(R.id.eTelefono);
        emailTxt = (EditText)findViewById(R.id.eEmail);

        //llamado de variables globales con la identificacion de cada Button
        scanBtn = (Button) findViewById(R.id.scan);
        guardar = (Button) findViewById(R.id.guardar);
        eliminar = (Button) findViewById(R.id.eliminar);
        ver = (Button) findViewById(R.id.ver);

        //Evento Click del button
        scanBtn.setOnClickListener(this);
        guardar.setOnClickListener(this);
        eliminar.setOnClickListener(this);
        ver.setOnClickListener(this);

    }
    public void onActivityResult (int requestCode, int resultCode, Intent intent ){

        //Se obtinene el resultado del proceso de escaneo y se parsea
        IntentResult sccaningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if(sccaningResult != null) {
            //desplegar el contenido obtenido de la imagen
            String scanContent = sccaningResult.getContents();
            StringTokenizer t = new StringTokenizer(scanContent, "*");
            final String nombre = t.nextToken();
            final String telefono = t.nextToken();
            final String email = t.nextToken();

            // se depliegan los datos obtenidos a traves del escaneo de la imagen
            nombreTxt.setText(""+ nombre );
            telefonoTxt.setText(""+ telefono);
            emailTxt.setText(""+ email);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No se ha recibido datos del scaneo!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onClick(View view) {
    if(view.getId() == R.id.scan){
        IntentIntegrator scanIntegrator = new IntentIntegrator(this);
        scanIntegrator.initiateScan();
    }
    if(view.getId() == R.id.guardar){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivity.this, "museo2", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        ContentValues registro = new ContentValues();

        registro.put("nombre", nombreTxt.getText().toString());
        registro.put("telefono", telefonoTxt.getText().toString());
        registro.put("email", emailTxt.getText().toString());
        bd.insert("obras", null, registro);
        bd.close();

        Toast.makeText(MainActivity.this, "Se guardo los datos satisfactoriamente", Toast.LENGTH_SHORT).show();
    }
    if(view.getId() == R.id.ver){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivity.this, "museo2", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cdg = codigoTxt.getText().toString();
        Cursor registro = bd.rawQuery("select nombre, telefono, email from obras where codigo ="+cdg,null);
        if (registro.moveToFirst()){
            nombreTxt.setText(registro.getString(0));
            telefonoTxt.setText(registro.getString(1));
            emailTxt.setText(registro.getString(2));
        } else{
            Toast.makeText(MainActivity.this, "No existe una obra con ese codigo", Toast.LENGTH_SHORT).show();
        }
    }
    if(view.getId() == R.id.eliminar){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivity.this, "museo2", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cdg = codigoTxt.getText().toString();
        int cant = bd.delete("obras", "codigo =" +cdg, null);
        bd.close();
        codigoTxt.setText("");
        nombreTxt.setText("");
        telefonoTxt.setText("");
        emailTxt.setText("");
        if(cant ==1){
            Toast.makeText(MainActivity.this,"Los datos se borraron satisfactoriamente", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(MainActivity.this, "No existe una obre con ese codigo", Toast.LENGTH_SHORT).show();
    }
    }
}
