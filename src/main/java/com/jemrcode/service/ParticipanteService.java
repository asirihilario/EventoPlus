package com.jemrcode.service;

import com.jemrcode.model.Participante;
import java.util.ArrayList;
import java.util.List;

public class ParticipanteService {

    private List<Participante> listaParticipantes = new ArrayList<>();

    public void registrarParticipante(int id, String nombre, String dni, String correo) {
        Participante p = new Participante(id, nombre, dni, correo);
        listaParticipantes.add(p);
    }

    public Participante buscarPorDni(String dni) {
        return listaParticipantes.stream()
                .filter(p -> p.getDni().equals(dni))
                .findFirst()
                .orElse(null);
    }

    public List<Participante> listarParticipantes() {
        return listaParticipantes;
    }
}