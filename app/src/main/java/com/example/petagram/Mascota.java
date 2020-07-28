package com.example.petagram;

public class Mascota {

    private String nombre;
    private int rating;
    private int foto;

    public Mascota(int foto, String nombre, int rating) {
        this.foto = foto;
        this.nombre = nombre;
        this.rating = rating;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
