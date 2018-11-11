package com.example.susanasantosmoreno.ejericicio8_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private InputStream inputAlgas;
    private InputStream inputPeces;
    private BufferedReader br;
    private Spinner opcionesPeces;
    private ArrayAdapter<String> adaptador;
    private TextView textViewTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //ACCEDEMOS A LOS FICHEROS.
        try{
            inputAlgas = getResources().openRawResource(R.raw.algaseinvertebrados);
            inputPeces = getResources().openRawResource(R.raw.peces);
            br = new BufferedReader(new InputStreamReader(inputAlgas));
            String texto = null;
            while((texto = br.readLine())!= null){
                System.out.println(texto + "\n");
            }


        }catch (Exception e){
            Log.e("Ficheros", "Error al leer fichero desde recurso Raw");
        }finally {
            if(inputAlgas != null){
                try{
                    inputAlgas.close();
                }catch (IOException e){
                    Log.e("Ficheros", "Error al cerrar");
                }
            }
            if(inputPeces != null){
                try{
                    inputPeces.close();
                }catch (IOException e){
                    Log.e("Ficheros", "Error al cerrar");
                }
            }
            if(br != null){
                try{
                    br.close();
                }catch (IOException e){
                    Log.e("Ficheros", "Error al cerrar");
                }
            }
        }
        final String [] opciones = new String[]{"Peces", "Algas e Invertebrados"};
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        opcionesPeces = (Spinner)findViewById(R.id.spinnerPeces);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opcionesPeces.setAdapter(adaptador);

        textViewTitle = (TextView)findViewById(R.id.textViewTitulo);
        //Acciones del Spiner.
        opcionesPeces.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String delparque = getResources().getString(R.string.delparque);
                textViewTitle.setText((opciones[position]).toUpperCase() + " " + delparque);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){}
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
