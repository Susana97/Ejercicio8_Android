package com.example.susanasantosmoreno.ejericicio8_android;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdaptadorInformacion extends ArrayAdapter<InformacionAnimales> {

    Activity contexto;
    // Contructor del adaptador usando el contexto de la aplicacion actual

    AdaptadorInformacion(Activity contexto, ArrayList<InformacionAnimales> datos) {

        // Llamamos al constructor de la clase superior
        //se le pasa el xml que genera la fila y el array de objetos
        super(contexto, R.layout.list_item_option, datos);
        this.contexto = contexto;
    }

    // Metodo que dibuja la Vista de cada Opcion
    // Se invoca cada vez que haya que mostrar un elemento de la lista.
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View item = convertView;
        ViewHolder holder;
        if(item==null) {
            LayoutInflater inflater = contexto.getLayoutInflater();
            item = inflater.inflate(R.layout.list_item_option, null);

            holder = new ViewHolder();

            holder.imagen = (ImageView)item.findViewById(R.id.ImagenAnimales);
            holder.nombreComun = (TextView)item.findViewById(R.id.textViewTitulo);
            holder.nombreLatin = (TextView)item.findViewById(R.id.TituloLatin);
            holder.longitud = (TextView)item.findViewById(R.id.Longitud);
            holder.habitat = (TextView)item.findViewById(R.id.Habitat);
            item.setTag(holder);
        }else{
            holder = (ViewHolder)item.getTag();
        }

        //Mediante getItem cargamos cada uno de los objetos del array
        InformacionAnimales mielemento=getItem(position);

        holder.imagen.setImageResource(mielemento.getImagen());
        holder.nombreComun.setText(mielemento.getNombreComun());
        holder.nombreLatin.setText(mielemento.getNombreLatin());
        holder.longitud.setText(mielemento.getLongitud());
        holder.habitat.setText(mielemento.getHabitat());

        // Devolvemos la Vista (nueva o reutilizada) que dibuja la opcion
        return(item);
    }

    class ViewHolder {
        ImageView imagen;
        TextView nombreComun;
        TextView nombreLatin;
        TextView longitud;
        TextView habitat;
    }

}
