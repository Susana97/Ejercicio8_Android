package com.example.susanasantosmoreno.ejericicio8_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private InputStream inputInfo;
    private InputStream inputPeces;
    private BufferedReader br;
    private Spinner opcionesPeces;
    private ArrayAdapter<String> adaptador;
    private TextView textViewTitle;
    private AdaptadorInformacion adaptadorListPeces;
    private AdaptadorInformacion adaptadorListAlgas;
    private ListView listaOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        ArrayList<InformacionAnimales> informacionPeces = leerInformacionFichero("peces");
        ArrayList<InformacionAnimales> informacionAlgas = leerInformacionFichero("algaseinvertebrados");


        //USAMOS ADAPTADORES PARA DIBUJAR LAS OPCIONES DE LAS LISTAS.
        adaptadorListPeces = new AdaptadorInformacion(this, informacionPeces);
        adaptadorListAlgas = new AdaptadorInformacion(this, informacionAlgas);

        final String [] opciones = new String[]{"Peces", "Algas e Invertebrados"};
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        opcionesPeces = (Spinner)findViewById(R.id.spinnerPeces);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opcionesPeces.setAdapter(adaptador);

        textViewTitle = (TextView)findViewById(R.id.textViewTitulo);
        listaOpciones = (ListView)findViewById(R.id.ListViewPrincipal);

        //Acciones del Spiner.
        opcionesPeces.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String delparque = getResources().getString(R.string.delparque);
                textViewTitle.setText((opciones[position]).toUpperCase() + " " + delparque);
                if(position == 0){//ESTAMOS EN LA OPCION DE PECES
                    listaOpciones.setAdapter(adaptadorListPeces);
                    listaOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    });
                    adaptador.notifyDataSetChanged();

                }else{//ESTAMOS EN LA OPCIÓN DE ALGAS.
                    listaOpciones.setAdapter(adaptadorListAlgas);
                    listaOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    });
                    adaptador.notifyDataSetChanged();
                }
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

    public ArrayList<InformacionAnimales> leerInformacionFichero(String fichero){
        ArrayList<InformacionAnimales> informacion = new ArrayList<InformacionAnimales>();

        try{
            int resource = getResources().getIdentifier(fichero, "raw", this.getPackageName());
            inputInfo = getResources().openRawResource(resource);
            br = new BufferedReader(new InputStreamReader(inputInfo));
            String texto = null;
            while((texto = br.readLine())!= null) {
                String[] lista = texto.split(",");
                //para parar el ID de la imagen
                int imagen = getResources().getIdentifier(lista[0], "drawable", this.getPackageName());
                informacion.add(new InformacionAnimales(imagen, lista[1], lista[2], lista[3], lista[4]));
            }
        }catch (Exception e){
            e.printStackTrace();
            //Log.e("Ficheros", "Error al leer fichero desde recurso Raw");
        }finally {
            if(inputInfo != null){
                try{
                    inputInfo.close();
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
        return informacion;
    }
}
