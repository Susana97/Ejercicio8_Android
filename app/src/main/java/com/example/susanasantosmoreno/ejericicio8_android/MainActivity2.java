package com.example.susanasantosmoreno.ejericicio8_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Activar la flecha para volver al activity principal
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int imagen = getIntent().getIntExtra("imagen", 0);
        String texto = getIntent().getStringExtra("titulo");
        this.setTitle(texto);
        ImageView imagenPrincipal = (ImageView)findViewById(R.id.ImagenPrincipal);
        imagenPrincipal.setImageResource(imagen);


    }

    public void onReturn(View v){

        Intent datos = new Intent();
        // Le decimos a Android que estamos preparados para acabar
        // con éxito...
        setResult(RESULT_OK, datos);

        // ... y le pedimos que nos cierre.
        finish();
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
