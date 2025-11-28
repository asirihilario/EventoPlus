package com.jemrcode.service;

import com.jemrcode.model.Evento;
import com.jemrcode.model.Participante;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EventoService {

    private List<Evento> listaEventos = new ArrayList<>();

    public void crearEvento(int id, String nombre, LocalDate fecha, LocalTime hora, String descripcion, int capacidad) {
        Evento e = new Evento(id, nombre, fecha, hora, descripcion, capacidad);
        listaEventos.add(e);
    }

    public Evento buscarEventoPorId(int id) {
        return listaEventos.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public boolean inscribirParticipante(int idEvento, Participante p) {
        Evento e = buscarEventoPorId(idEvento);
        if (e != null) {
            return e.agregarParticipante(p);
        }
        return false;
    }

    public List<Evento> listarEventos() {
        return listaEventos;
    }
}