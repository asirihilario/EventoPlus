
package com.jemrcode.service;

import com.jemrcode.model.Evento;
import com.jemrcode.model.Participante;

public class PagoService {

    // Registrar pago de un participante en un evento
    public void registrarPago(Participante participante, Evento evento, double monto) {
        if (participante == null || evento == null) {
            System.out.println("Datos invalidos.");
            return;
        }
        if (!evento.getListaParticipantes().contains(participante)) {
            System.out.println("El participante no esta inscrito en el evento. Primero debe inscribirse.");
            return;
        }
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a cero.");
            return;
        }
        System.out.println("Pago registrado: " + participante.getNombre()
                + " ha pagado S/." + String.format("%.2f", monto)
                + " por el evento " + evento.getNombre());
    }
}
