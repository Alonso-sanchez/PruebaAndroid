package com.example.rickmorty;

public class Personajes {
    private String nombre, especie, status,genero,origen, imagen;


    public Personajes(String nombre, String especie, String status, String genero, String origen, String imagen) {
        this.nombre = nombre;
        this.especie = especie;
        this.status = status;
        this.genero = genero;
        this.origen = origen;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getStatus() {
        return status;
    }

    public String getGenero() {
        return genero;
    }

    public String getOrigen() {
        return origen;
    }

    public String getImagen() {
        return imagen;
    }
}
