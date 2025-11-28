package com.jemrcode.model;

public class Reunion {
    private String nombre;
    private String fecha;

    public Reunion(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getNombre() { return nombre; }
    public String getFecha() { return fecha; }

    public void mostrarDetalles() {
        System.out.println("Reunión: " + nombre + " | Fecha: " + fecha);
    }

    @Override
    public String toString() {
        return "Reunión{" + "nombre='" + nombre + '\'' + ", fecha='" + fecha + '\'' + '}';
    }
}