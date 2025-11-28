package com.jemrcode.service;

import com.jemrcode.model.Evento;
import java.util.List;

public class BuscadorDeEventos {

    // Listar todos los eventos
    public void listarEventos(List<Evento> eventos) {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
        } else {
            System.out.println("\n=== LISTA DE EVENTOS ===");
            for (Evento e : eventos) {
                System.out.println(e);
                if (e.getListaParticipantes().isEmpty()) {
                    System.out.println("  (Sin participantes inscritos)");
                } else {
                    System.out.println("  Participantes:");
                    e.getListaParticipantes().forEach(p ->
                            System.out.println("   - " + p.getNombre() + " (" + p.getDni() + ")"));
                }
            }
        }
    }

    // Buscar evento por nombre
    public void buscarPorNombre(List<Evento> eventos, String nombreBuscado) {
        boolean encontrado = false;
        for (Evento e : eventos) {
            if (e.getNombre().toLowerCase().contains(nombreBuscado.toLowerCase())) {
                System.out.println("\nEvento encontrado:");
                System.out.println(e);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro ningun evento con ese nombre.");
        }
    }

    // Buscar evento por fecha
    public void buscarPorFecha(List<Evento> eventos, String fechaBuscada) {
        boolean encontrado = false;
        for (Evento e : eventos) {
            if (e.getFecha().toString().equals(fechaBuscada)) {
                System.out.println("\nEvento encontrado:");
                System.out.println(e);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro ningun evento en esa fecha.");
        }
    }

  
    public void eliminarEvento(List<Evento> eventos, int idEvento) {
        boolean eliminado = eventos.removeIf(e -> e.getId() == idEvento);
        if (eliminado) {
            System.out.println("Evento eliminado correctamente.");
        } else {
            System.out.println("No se encontro el evento a eliminar.");
        }
    }
}