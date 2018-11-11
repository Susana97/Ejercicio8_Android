package com.example.susanasantosmoreno.ejericicio8_android;

public class InformacionAnimales {

    private int imagen;
    private String nombreComun;
    private String nombreLatin;
    private int longitud;
    private String habitat;

    public InformacionAnimales(int imagen, String nombreComun, String nombreLatin, int longitud, String habitat) {
        this.imagen = imagen;
        this.nombreComun = nombreComun;
        this.nombreLatin = nombreLatin;
        this.longitud = longitud;
        this.habitat = habitat;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNombreLatin() {
        return nombreLatin;
    }

    public void setNombreLatin(String nombreLatin) {
        this.nombreLatin = nombreLatin;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
}
