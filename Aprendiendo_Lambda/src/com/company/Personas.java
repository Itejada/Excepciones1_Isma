package com.company;

public class Personas {

    String nombre;
    String apellido;

    Personas(String _nombre, String _apellido){
        nombre= _nombre;
        apellido=_apellido;

    }


    @Override
    public String toString() {
        return "Personas{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}














