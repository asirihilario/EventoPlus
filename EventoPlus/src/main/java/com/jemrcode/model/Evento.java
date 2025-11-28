package com.jemrcode.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private int id;
    private String nombre;
    private LocalDate fecha;
    private LocalTime hora;
    private String descripcion;
    private int capacidadMaxima;
    private List<Participante> listaParticipantes;

    public Evento(int id, String nombre, LocalDate fecha, LocalTime hora, String descripcion, int capacidadMaxima) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.capacidadMaxima = capacidadMaxima;
        this.listaParticipantes = new ArrayList<>();
    }

    public boolean agregarParticipante(Participante p) {
        if (listaParticipantes.size() < capacidadMaxima && !listaParticipantes.contains(p)) {
            listaParticipantes.add(p);
            return true;
        }
        return false;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getCapacidadMaxima() { return capacidadMaxima; }
    public void setCapacidadMaxima(int capacidadMaxima) { this.capacidadMaxima = capacidadMaxima; }

    public List<Participante> getListaParticipantes() { return listaParticipantes; }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", capacidadMaxima=" + capacidadMaxima +
                ", inscritos=" + listaParticipantes.size() +
                '}';
    }
}