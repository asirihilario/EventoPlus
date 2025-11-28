package com.jemrcode.model;

import com.jemrcode.util.ArchivoSerializable;

public class Participante implements ArchivoSerializable {

    private String id;
    private String nombre;
    private String dni;
    private String correo;
    private Evento evento; // Relación con Evento

    public Participante(String id, String nombre, String dni, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toFileLine() {
        String idEvento = (evento != null) ? evento.getId() : "SIN_EVENTO";
        return id + ";" + nombre + ";" + dni + ";" + correo + ";" + idEvento;
    }
}
