package com.jemrcode.service;

import com.jemrcode.model.Evento;
import com.jemrcode.model.Participante;

public class InscripcionService {

    // Inscribir participante en un evento con validacion
    public boolean inscribirParticipante(Evento evento, Participante participante) {
        if (evento == null || participante == null) {
            System.out.println("Datos invalidos.");
            return false;
        }
        if (evento.getListaParticipantes().contains(participante)) {
            System.out.println("El participante ya esta inscrito en este evento.");
            return false;
        }
        if (evento.getListaParticipantes().size() >= evento.getCapacidadMaxima()) {
            System.out.println("No se puede inscribir. El evento esta lleno.");
            return false;
        }
        evento.getListaParticipantes().add(participante);
        System.out.println("Participante inscrito correctamente en el evento " + evento.getNombre());
        return true;
    }
}