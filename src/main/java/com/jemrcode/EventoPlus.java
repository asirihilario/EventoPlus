package com.jemrcode;

import com.jemrcode.service.EventoService;
import com.jemrcode.service.ParticipanteService;
import com.jemrcode.ui.FrmPrincipal;
import javax.swing.*;

public class EventoPlus {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Error al configurar LookAndFeel: " + e.getMessage());
        }

        System.out.println("Cargando datos del sistema...");
        EventoService.getInstance();
        ParticipanteService.getInstance();

        SwingUtilities.invokeLater(() -> {
            FrmPrincipal frame = new FrmPrincipal();
            frame.setVisible(true);
        });
    }
}
