package com.example.susanasantosmoreno.ejericicio8_android;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    private int imagen;
    private String nombre;
    private String nombreLatin;
    private String tamanio;
    private String habitat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Activar la flecha para volver al activity principal
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int imagen = getIntent().getIntExtra("imagen", 0);
        String nombre = getIntent().getStringExtra("titulo");
        String nombreLatin = getIntent().getStringExtra("tituloLatin");
        String tamanio = getIntent().getStringExtra("longitud");
        String habitat = getIntent().getStringExtra("habitat");
        String titulo = nombre + "(" + nombreLatin + ")";
        this.setTitle(titulo);
        ImageView imagenPrincipal = (ImageView)findViewById(R.id.ImagenPrincipal);
        imagenPrincipal.setImageResource(imagen);
        System.out.println(nombre + nombreLatin + tamanio + habitat );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Metodo para volver a la actividad principal si se pulsa la flecha.
        switch (item.getItemId()) {
            case android.R.id.home:
                //do whatever
                Intent datos = new Intent();
                setResult(RESULT_CANCELED, datos);
                finish();
                return true;
            case R.id.action_settings:
                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogoInfo dialogo = new DialogoInfo();
                dialogo.show(fragmentManager, "tagAlerta");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
