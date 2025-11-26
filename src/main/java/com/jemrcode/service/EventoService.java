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

//Funcionalidades Asiri
    private final List<Evento> eventos;
    
public EventoService(){
    eventos = new ArrayList<>();
}
   
public boolean registrarEvento(Evento evento) {
        if (existeEvento(evento)) {
            System.out.println("Evento duplicado. No se registró.");
            return false;
        }
        eventos.add(evento);
        System.out.println("Evento registrado.");
        return true;
    }

private boolean existeEvento(Evento evento) {
        for (Evento eventoExistente : eventos) {
            if (eventoExistente.getNombre().equalsIgnoreCase(evento.getNombre())) {
                return true;
            }
        }
        return false;
    }
    
public Evento buscar(int id) {
        for (Evento evento : eventos) {
            if(id.equals(evento.getId()){
                return evento;
            } else {
            }
        }
        return null;
    }

public void actualizar(Evento evento) {
        Evento existente = buscar(evento.getId());
        if (existente != null) {
            existente.setNombre(evento.getNombre());
            existente.setFecha(evento.getFecha());
            existente.setHora(evento.getHora());
            existente.setDescripcion(evento.getDescripcion());
            existente.setCapacidadMaxima(evento.getCapacidadMaxima());
            System.out.println("Evento actualizado");
        } else {
            System.out.println("Evento no encontrado");
        }
}
public void eliminar(int id) {
        Evento evento = buscar(id);
        if (evento != null) {
            eventos.remove(evento);
            System.out.println("Propietario eliminado");
        } else {
            System.out.println("Propietario no encontrado");
        }
    }
}

