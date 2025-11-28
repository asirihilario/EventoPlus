package com.jemrcode.service;

import com.jemrcode.model.Evento;
import com.jemrcode.model.Participante;
import com.jemrcode.util.GestorArchivos;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipanteService {

    private static ParticipanteService instancia;
    private List<Participante> participantes;
    private GestorArchivos gestor;
    private static final String ARCHIVO = "participantes.txt";

    private ParticipanteService() {
        this.participantes = new ArrayList<>();
        this.gestor = new GestorArchivos();
        cargar();
    }

    public static ParticipanteService getInstance() {
        if (instancia == null) {
            instancia = new ParticipanteService();
        }
        return instancia;
    }

    public boolean registrarParticipante(Participante p) {
        if (p.getEvento() != null) {
            long inscritos = contarInscritosEnEvento(p.getEvento().getId());
            if (inscritos >= p.getEvento().getCapacidadMaxima()) {
                return false;
            }
        }

        if (buscarParticipante(p.getId()) == null) {
            participantes.add(p);
            guardar();
            return true;
        }
        return false;
    }

    public boolean actualizarParticipante(String idOriginal, Participante pNuevo) {
        Participante p = buscarParticipante(idOriginal);
        if (p != null) {
            p.setNombre(pNuevo.getNombre());
            p.setDni(pNuevo.getDni());
            p.setCorreo(pNuevo.getCorreo());
            p.setEvento(pNuevo.getEvento());
            guardar();
            return true;
        }
        return false;
    }

    public boolean eliminarParticipante(String id) {
        boolean eliminado = participantes.removeIf(p -> p.getId().equals(id));
        if (eliminado) {
            guardar();
        }
        return eliminado;
    }

    public Participante buscarParticipante(String id) {
        return participantes.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Participante> listarPorEvento(String idEvento) {
        if (idEvento == null || idEvento.isEmpty()) {
            return obtenerParticipantes();
        }
        return participantes.stream()
                .filter(p -> p.getEvento() != null && p.getEvento().getId().equals(idEvento))
                .collect(Collectors.toList());
    }

    public List<Participante> obtenerParticipantes() {
        return new ArrayList<>(participantes);
    }

    public long contarInscritosEnEvento(String idEvento) {
        return participantes.stream()
                .filter(p -> p.getEvento() != null && p.getEvento().getId().equals(idEvento))
                .count();
    }

    public boolean generarReporteTxt(Evento evento) {
        List<Participante> lista = listarPorEvento(evento.getId());
        String nombreArchivo = "Reporte_" + evento.getNombre().replace(" ", "_") + ".txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            bw.write("=== LISTADO DE ASISTENCIA ===");
            bw.newLine();
            bw.write("EVENTO: " + evento.getNombre());
            bw.newLine();
            bw.write("FECHA: " + evento.getFecha() + " | HORA: " + evento.getHora());
            bw.newLine();
            bw.write("------------------------------------------------");
            bw.newLine();
            bw.write(String.format("%-15s %-30s %-25s", "DNI", "NOMBRE", "CORREO"));
            bw.newLine();
            bw.write("------------------------------------------------");
            bw.newLine();

            for (Participante p : lista) {
                bw.write(String.format("%-15s %-30s %-25s", p.getDni(), p.getNombre(), p.getCorreo()));
                bw.newLine();
            }
            bw.write("------------------------------------------------");
            bw.newLine();
            bw.write("TOTAL INSCRITOS: " + lista.size());
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error al generar reporte: " + e.getMessage());
            return false;
        }
    }

    private void guardar() {
        gestor.guardar(ARCHIVO, participantes, Participante::toFileLine);
    }

    private void cargar() {
        gestor.cargar(ARCHIVO, line -> {
            String[] datos = line.split(";");
            if (datos.length >= 4) {
                Participante p = new Participante(datos[0], datos[1], datos[2], datos[3]);
                if (datos.length >= 5 && !datos[4].equals("SIN_EVENTO")) {
                    Evento ev = EventoService.getInstance().buscarEvento(datos[4]);
                    p.setEvento(ev);
                }
                participantes.add(p);
            }
            return null;
        });
    }
}
