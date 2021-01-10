package com.example.demo;

public class MovieNotFoundException extends RuntimeException{
    MovieNotFoundException(){
        super("No se ha encontrado la pelicula");
    }
}
