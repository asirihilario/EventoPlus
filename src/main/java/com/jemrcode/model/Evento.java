package com.jemrcode.model;

import com.jemrcode.util.ArchivoSerializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Evento implements ArchivoSerializable {

    private String id;
    private String nombre;
    private LocalDate fecha;
    private LocalTime hora;
    private String descripcion;
    private int capacidadMaxima;

    public Evento(String id, String nombre, LocalDate fecha, LocalTime hora, String descripcion, int capacidadMaxima) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    @Override
    public String toFileLine() {
        return id + ";" + nombre + ";" + fecha + ";" + hora + ";" + descripcion + ";" + capacidadMaxima;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
