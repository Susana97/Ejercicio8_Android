package com.example.susanasantosmoreno.ejericicio8_android;

public class InformacionAnimales {

    private int imagen;
    private String nombreComun;
    private String nombreLatin;
    private String longitud;
    private String habitat;

    public InformacionAnimales(int imagen, String nombreComun, String nombreLatin, String longitud, String habitat) {
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

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return "InformacionAnimales{" +
                "imagen=" + imagen +
                ", nombreComun='" + nombreComun + '\'' +
                ", nombreLatin='" + nombreLatin + '\'' +
                ", longitud=" + longitud +
                ", habitat='" + habitat + '\'' +
                '}';
    }
}
