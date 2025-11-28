package com.jemrcode.service;

import com.jemrcode.model.Evento;

public class Validador {

    public boolean campoNoVacio(String campo) {
        return campo != null && !campo.trim().isEmpty();
    }

    public boolean correoValido(String correo) {
        return correo != null && correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public boolean dniValido(String dni) {
        return dni != null && dni.matches("\\d{8}");
    }

    public boolean capacidadDisponible(Evento e) {
        return e.getListaParticipantes().size() < e.getCapacidadMaxima();
    }
}