package com.jemrcode.service;

import com.jemrcode.model.Reunion;
import java.util.ArrayList;
import java.util.List;

public class BuscadorDeReuniones {
    private final List<Reunion> listaReuniones = new ArrayList<>();

    // Registrar nueva reunion con validacion de duplicados
    public void registrarReunion(String nombre, String fecha) {
        for (Reunion r : listaReuniones) {
            if (r.getNombre().equalsIgnoreCase(nombre) && r.getFecha().equals(fecha)) {
                System.out.println("Ya existe una reunion con ese nombre y fecha.");
                return;
            }
        }
        Reunion reunion = new Reunion(nombre, fecha);
        listaReuniones.add(reunion);
        System.out.println("Reunion registrada correctamente.");
    }

    // Listar todas las reuniones
    public void listarReuniones() {
        if (listaReuniones.isEmpty()) {
            System.out.println("No hay reuniones registradas.");
        } else {
            System.out.println("\n=== LISTA DE REUNIONES ===");
            listaReuniones.forEach(Reunion::mostrarDetalles);
        }
    }

    // Buscar por nombre
    public void buscarPorNombre(String nombreBuscado) {
        boolean encontrado = false;
        for (Reunion r : listaReuniones) {
            if (r.getNombre().toLowerCase().contains(nombreBuscado.toLowerCase())) {
                r.mostrarDetalles();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro ninguna reunion con ese nombre.");
        }
    }

    // Buscar por fecha exacta
    public void buscarPorFecha(String fechaBuscada) {
        boolean encontrado = false;
        for (Reunion r : listaReuniones) {
            if (r.getFecha().equals(fechaBuscada)) {
                r.mostrarDetalles();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro ninguna reunion en esa fecha.");
        }
    }

    // Buscar reuniones en un rango de fechas
    public void buscarPorRangoFechas(String fechaInicio, String fechaFin) {
        boolean encontrado = false;
        for (Reunion r : listaReuniones) {
            if (r.getFecha().compareTo(fechaInicio) >= 0 && r.getFecha().compareTo(fechaFin) <= 0) {
                r.mostrarDetalles();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron reuniones en ese rango de fechas.");
        }
    }

    // Eliminar reunion por nombre
    public void eliminarReunion(String nombre) {
        boolean eliminado = listaReuniones.removeIf(r -> r.getNombre().equalsIgnoreCase(nombre));
        if (eliminado) {
            System.out.println("Reunion eliminada correctamente.");
        } else {
            System.out.println("No se encontro la reunion a eliminar.");
        }
    }

    // Mostrar cantidad de reuniones registradas
    public void mostrarCantidadReuniones() {
        System.out.println("Total de reuniones registradas: " + listaReuniones.size());
    }

    // Obtener lista de reuniones
    public List<Reunion> getListaReuniones() {
        return listaReuniones;
    }
}