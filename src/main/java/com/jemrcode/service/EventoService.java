package com.jemrcode.service;

import com.jemrcode.model.Evento;
import com.jemrcode.util.GestorArchivos;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EventoService {

    private static EventoService instancia;
    private List<Evento> eventos;
    private GestorArchivos gestor;
    private static final String ARCHIVO = "eventos.txt";

    private EventoService() {
        this.eventos = new ArrayList<>();
        this.gestor = new GestorArchivos();
        cargar();
    }

    public static EventoService getInstance() {
        if (instancia == null) {
            instancia = new EventoService();
        }
        return instancia;
    }

    public boolean registrarEvento(Evento evento) {
        if (buscarEvento(evento.getId()) == null) {
            eventos.add(evento);
            guardar();
            return true;
        }
        return false;
    }

    public boolean actualizarEvento(String idOriginal, Evento eventoNuevo) {
        Evento e = buscarEvento(idOriginal);
        if (e != null) {
            e.setNombre(eventoNuevo.getNombre());
            e.setFecha(eventoNuevo.getFecha());
            e.setHora(eventoNuevo.getHora());
            e.setDescripcion(eventoNuevo.getDescripcion());
            e.setCapacidadMaxima(eventoNuevo.getCapacidadMaxima());
            guardar();
            return true;
        }
        return false;
    }

    public boolean eliminarEvento(String id) {
        boolean eliminado = eventos.removeIf(e -> e.getId().equals(id));
        if (eliminado) {
            guardar();
        }
        return eliminado;
    }

    public Evento buscarEvento(String id) {
        return eventos.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Evento> obtenerEventos() {
        return new ArrayList<>(eventos);
    }

    private void guardar() {
        gestor.guardar(ARCHIVO, eventos, Evento::toFileLine);
    }

    private void cargar() {
        gestor.cargar(ARCHIVO, line -> {
            String[] datos = line.split(";");
            if (datos.length >= 6) {
                eventos.add(new Evento(datos[0], datos[1], LocalDate.parse(datos[2]), LocalTime.parse(datos[3]), datos[4], Integer.parseInt(datos[5])));
            }
            return null;
        });
    }
}
