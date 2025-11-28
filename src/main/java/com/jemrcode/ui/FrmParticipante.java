package com.jemrcode.ui;

import com.jemrcode.model.Evento;
import com.jemrcode.model.Participante;
import com.jemrcode.service.EventoService;
import com.jemrcode.service.ParticipanteService;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmParticipante extends javax.swing.JFrame {

    private ParticipanteService participanteService;
    private EventoService eventoService;
    private DefaultTableModel modeloTabla;

    public FrmParticipante() {
        participanteService = ParticipanteService.getInstance();
        eventoService = EventoService.getInstance();

        initComponents();

        cboEvento.setModel(new DefaultComboBoxModel<>());
        
        cboEvento.addItemListener(e -> {
            if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                actualizarInfoEvento();
            }
        });

        configurarTabla();
        cargarComboEventos();
        cargarDatos();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtIdI = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        cboEvento = new javax.swing.JComboBox<>();
        btnVerDetalle = new javax.swing.JButton();
        lblInformacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblParticipantes = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnInscribir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inscripción de Participantes");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Participante"));

        jLabel1.setText("ID Inscripción:");

        jLabel2.setText("DNI (8 dígitos):");

        jLabel3.setText("Nombre Completo:");

        jLabel4.setText("Correo:");

        jLabel5.setText("Asignar a Evento:");

        btnVerDetalle.setText("Ver Detalle");
        btnVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInformacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cboEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnVerDetalle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdI, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerDetalle))
                .addGap(18, 18, 18)
                .addComponent(lblInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tblParticipantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblParticipantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarFila(evt);
            }
        });
        jScrollPane1.setViewportView(tblParticipantes);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnInscribir.setText("Inscribir");
        btnInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnReporte.setText("Generar TXT");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(btnInscribir)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar)
                .addGap(18, 18, 18)
                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnInscribir)
                        .addComponent(btnEliminar)
                        .addComponent(btnLimpiar)
                        .addComponent(btnReporte)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed
        guardar();
    }//GEN-LAST:event_btnInscribirActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        generarReporte();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalleActionPerformed
        mostrarDialogoDetalle();
    }//GEN-LAST:event_btnVerDetalleActionPerformed

    private void seleccionarFila(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarFila
        seleccionarFila();
    }//GEN-LAST:event_seleccionarFila

    private void configurarTabla() {
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "DNI", "Correo", "Evento"}, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tblParticipantes.setModel(modeloTabla);
    }

    private void cargarComboEventos() {
        cboEvento.removeAllItems();
        List<Evento> eventos = eventoService.obtenerEventos();

        if (eventos.isEmpty()) {
            lblInformacion.setText("No hay eventos registrados.");
            lblInformacion.setForeground(Color.RED);
            cboEvento.setEnabled(false);
            btnInscribir.setEnabled(false);
            btnVerDetalle.setEnabled(false);
        } else {
            for (Evento e : eventos) {
                ((JComboBox) cboEvento).addItem(e);
            }
            cboEvento.setEnabled(true);
            btnInscribir.setEnabled(true);
            btnVerDetalle.setEnabled(true);
            cboEvento.setSelectedIndex(0);
            actualizarInfoEvento();
        }
    }

    private void actualizarInfoEvento() {
        if (cboEvento.getItemCount() == 0) {
            return;
        }

        Object item = ((JComboBox) cboEvento).getSelectedItem();

        if (item instanceof Evento) {
            Evento e = (Evento) item;
            long inscritos = participanteService.contarInscritosEnEvento(e.getId());
            long disponibles = e.getCapacidadMaxima() - inscritos;

            String texto = String.format("<html><b>%s</b> | Cap: %d | Inscritos: %d | <font color='%s'>Cupos: %d</font></html>",
                    e.getFecha(), e.getCapacidadMaxima(), inscritos,
                    (disponibles <= 0 ? "red" : "green"), disponibles);

            lblInformacion.setText(texto);
        }
    }

    private void mostrarDialogoDetalle() {
        Object item = cboEvento.getSelectedItem();
        if (item == null || !(item instanceof Evento)) {
            JOptionPane.showMessageDialog(this, "Seleccione un evento válido.");
            return;
        }
        Evento e = (Evento) item;

        JDialog dialogo = new JDialog(this, "Detalle de Asistentes: " + e.getNombre(), true);
        dialogo.setSize(500, 300);
        dialogo.setLocationRelativeTo(this);

        DefaultTableModel dt = new DefaultTableModel(new Object[]{"DNI", "Nombre"}, 0);
        JTable table = new JTable(dt);

        for (Participante p : participanteService.listarPorEvento(e.getId())) {
            dt.addRow(new Object[]{p.getDni(), p.getNombre()});
        }
        dialogo.add(new JScrollPane(table));
        dialogo.setVisible(true);
    }

    private void guardar() {
        if (!validarCampos()) {
            return;
        }

        Participante p = new Participante(
                txtIdI.getText(),
                txtNombres.getText(),
                txtDni.getText(),
                txtCorreo.getText()
        );

        Object item = cboEvento.getSelectedItem();
        if (item instanceof Evento) {
            p.setEvento((Evento) item);
        }

        if (participanteService.registrarParticipante(p)) {
            JOptionPane.showMessageDialog(this, "Inscripción Exitosa.");
            cargarDatos();
            limpiar();
            actualizarInfoEvento();
        } else {
            JOptionPane.showMessageDialog(this, "Error: ID duplicado o Evento Lleno.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizar() {
        if (!validarCampos()) {
            return;
        }

        Participante p = new Participante(
                txtIdI.getText(),
                txtNombres.getText(),
                txtDni.getText(),
                txtCorreo.getText()
        );
        Object item = cboEvento.getSelectedItem();
        if (item instanceof Evento) {
            p.setEvento((Evento) item);
        }

        if (participanteService.actualizarParticipante(txtIdI.getText(), p)) {
            JOptionPane.showMessageDialog(this, "Datos Actualizados.");
            cargarDatos();
            limpiar();
            actualizarInfoEvento();
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el ID para actualizar.");
        }
    }

    private void eliminar() {
        if (txtIdI.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese ID para eliminar.");
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "¿Eliminar?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (participanteService.eliminarParticipante(txtIdI.getText())) {
                JOptionPane.showMessageDialog(this, "Eliminado.");
                cargarDatos();
                limpiar();
                actualizarInfoEvento();
            }
        }
    }

    private void generarReporte() {
        Object item = cboEvento.getSelectedItem();
        if (item instanceof Evento) {
            Evento evt = (Evento) item;
            if (participanteService.generarReporteTxt(evt)) {
                JOptionPane.showMessageDialog(this, "Reporte generado en carpeta del proyecto.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al generar reporte.");
            }
        }
    }

    private void cargarDatos() {
        modeloTabla.setRowCount(0);
        for (Participante p : participanteService.obtenerParticipantes()) {
            String evt = (p.getEvento() != null) ? p.getEvento().getNombre() : "---";
            modeloTabla.addRow(new Object[]{p.getId(), p.getNombre(), p.getDni(), p.getCorreo(), evt});
        }
    }

    private void seleccionarFila() {
        int row = tblParticipantes.getSelectedRow();
        if (row >= 0) {
            String id = modeloTabla.getValueAt(row, 0).toString();
            Participante p = participanteService.buscarParticipante(id);
            if (p != null) {
                txtIdI.setText(p.getId());
                txtIdI.setEditable(false);
                txtNombres.setText(p.getNombre());
                txtDni.setText(p.getDni());
                txtCorreo.setText(p.getCorreo());

                if (p.getEvento() != null) {
                    // Recorremos el combo buscando el evento por ID
                    for (int i = 0; i < cboEvento.getItemCount(); i++) {
                        Object item = cboEvento.getItemAt(i);
                        if (item instanceof Evento) {
                            Evento e = (Evento) item;
                            if (e.getId().equals(p.getEvento().getId())) {
                                cboEvento.setSelectedIndex(i);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private void limpiar() {
        txtIdI.setText("");
        txtIdI.setEditable(true);
        txtNombres.setText("");
        txtDni.setText("");
        txtCorreo.setText("");
        tblParticipantes.clearSelection();
        if (cboEvento.getItemCount() > 0) {
            cboEvento.setSelectedIndex(0);
        }
        actualizarInfoEvento();
    }

    private boolean validarCampos() {
        if (txtIdI.getText().isEmpty() || txtNombres.getText().isEmpty() || txtDni.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete los campos obligatorios.");
            return false;
        }
        if (txtDni.getText().length() != 8) {
            JOptionPane.showMessageDialog(this, "DNI inválido (debe ser 8 dígitos).");
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnVerDetalle;
    private javax.swing.JComboBox<String> cboEvento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInformacion;
    private javax.swing.JTable tblParticipantes;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtIdI;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
