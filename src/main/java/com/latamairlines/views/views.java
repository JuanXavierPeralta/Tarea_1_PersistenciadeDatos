package com.latamairlines.views;

import com.latamairlines.dao.ReservaDAO;
import com.latamairlines.entities.Reserva;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class views extends javax.swing.JFrame {

    // ACCESO A DATOS
    private final ReservaDAO dao = new ReservaDAO();

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(views.class.getName());

    public views() {

        initComponents();
        setLocationRelativeTo(null);

        // CONFIGURAR TABLA
        centrarTabla();
        mostrarReservas();

        // CERRAR RECURSOS DE HIBERNATE
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                dao.cerrar();
            }
        });
    }

// MOSTRAR RESERVAS
    private void mostrarReservas() {

        List<Reserva> reservas = dao.listarReservas();

        DefaultTableModel modelo
                = (DefaultTableModel) tblReservas.getModel();

        // LIMPIAR TABLA
        modelo.setRowCount(0);

        // CARGAR RESERVAS
        for (Reserva r : reservas) {
            modelo.addRow(new Object[]{
                r.getId(),
                r.getOrigen(),
                r.getDestino(),
                r.getNumeroPasajeros()
            });
        }
    }

    // CONFIGURAR TABLA
    private void centrarTabla() {

        // DATOS CENTRADOS SIN NEGRITA
        DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
        centro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        centro.setFont(new java.awt.Font("Bahnschrift", java.awt.Font.PLAIN, 18));

        for (int i = 0; i < tblReservas.getColumnCount(); i++) {
            tblReservas.getColumnModel()
                    .getColumn(i).setCellRenderer(centro);
        }

        // ENCABEZADOS CENTRADOS EN NEGRITA
        javax.swing.table.JTableHeader encabezado = tblReservas.getTableHeader();
        encabezado.setFont(new java.awt.Font("Bahnschrift", java.awt.Font.BOLD, 14));

        DefaultTableCellRenderer renderer
                = (DefaultTableCellRenderer) encabezado.getDefaultRenderer();

        renderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelLATAMAIRLINES = new javax.swing.JLabel();
        labelDESTINO = new javax.swing.JLabel();
        labelNUMPASAJEROS = new javax.swing.JLabel();
        labelORIGEN = new javax.swing.JLabel();
        labelID = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        tfOrigen = new javax.swing.JTextField();
        tfDestino = new javax.swing.JTextField();
        tfNumPasajeros = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();
        labelREGISTRORESERVAS = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelLATAMAIRLINES.setBackground(new java.awt.Color(51, 102, 255));
        labelLATAMAIRLINES.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        labelLATAMAIRLINES.setForeground(new java.awt.Color(0, 0, 0));
        labelLATAMAIRLINES.setText("LATAM Airlines | Gestión de reservas");

        labelDESTINO.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        labelDESTINO.setText("Destino");

        labelNUMPASAJEROS.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        labelNUMPASAJEROS.setText("Número de Pasajeros");

        labelORIGEN.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        labelORIGEN.setText("Origen");

        labelID.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        labelID.setText("ID de Reserva");

        tfID.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N

        tfOrigen.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tfOrigen.addActionListener(this::tfOrigenActionPerformed);

        tfDestino.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N

        tfNumPasajeros.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N

        btnActualizar.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnCrear.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(this::btnCrearActionPerformed);

        btnBuscar.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        btnMostrar.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(this::btnMostrarActionPerformed);

        btnEliminar.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        tblReservas.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        tblReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Origen", "Destino", "Pasajeros"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReservas);

        labelREGISTRORESERVAS.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        labelREGISTRORESERVAS.setForeground(new java.awt.Color(0, 0, 0));
        labelREGISTRORESERVAS.setText("Registro de Reservas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(labelREGISTRORESERVAS, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLATAMAIRLINES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNUMPASAJEROS, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelORIGEN, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNumPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfDestino)
                                        .addComponent(labelDESTINO, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(labelID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(btnCrear)
                        .addGap(39, 39, 39)
                        .addComponent(btnBuscar)
                        .addGap(31, 31, 31)
                        .addComponent(btnActualizar)
                        .addGap(43, 43, 43)
                        .addComponent(btnEliminar)
                        .addGap(56, 56, 56)
                        .addComponent(btnMostrar)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelLATAMAIRLINES, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelDESTINO)
                        .addComponent(labelORIGEN, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(labelNUMPASAJEROS, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNumPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnActualizar)
                    .addComponent(btnCrear)
                    .addComponent(btnMostrar)
                    .addComponent(btnEliminar))
                .addGap(36, 36, 36)
                .addComponent(labelREGISTRORESERVAS, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

        try {

            // OBTENER DATOS
            String origen = tfOrigen.getText().trim();
            String destino = tfDestino.getText().trim();
            String textoPasajeros = tfNumPasajeros.getText().trim();

            // VALIDAR CAMPOS
            if (origen.isEmpty() || destino.isEmpty()
                    || textoPasajeros.isEmpty()) {

                JOptionPane.showMessageDialog(this, "Complete todos los campos");
                return;
            }

            int pasajeros = Integer.parseInt(textoPasajeros);

            if (pasajeros <= 0) {
                JOptionPane.showMessageDialog(this,
                        "El número de pasajeros debe ser mayor a cero");
                return;
            }

            // CREAR RESERVA
            Reserva reserva = new Reserva(origen, destino, pasajeros);
            dao.crearReserva(reserva);
            mostrarReservas();

            JOptionPane.showMessageDialog(this, "Reserva creada correctamente");

            // LIMPIAR CAMPOS
            tfOrigen.setText("");
            tfDestino.setText("");
            tfNumPasajeros.setText("");
            tfID.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese un número válido de pasajeros");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al crear reserva: " + e.getMessage());
        }

    }//GEN-LAST:event_btnCrearActionPerformed

    private void tfOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOrigenActionPerformed
    }//GEN-LAST:event_tfOrigenActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        mostrarReservas();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        try {

            // OBTENER ID
            int id = Integer.parseInt(tfID.getText().trim());

            // BUSCAR RESERVA
            Reserva reserva = dao.buscarPorId(id);

            if (reserva != null) {

                // MOSTRAR DATOS
                tfOrigen.setText(reserva.getOrigen());
                tfDestino.setText(reserva.getDestino());
                tfNumPasajeros.setText(
                        String.valueOf(reserva.getNumeroPasajeros()));

            } else {
                JOptionPane.showMessageDialog(this,
                        "Reserva no encontrada");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese un ID válido");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al buscar reserva: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        try {

            // OBTENER DATOS
            int id = Integer.parseInt(tfID.getText().trim());
            String origen = tfOrigen.getText().trim();
            String destino = tfDestino.getText().trim();
            int pasajeros = Integer.parseInt(tfNumPasajeros.getText().trim());

            // VALIDAR DATOS
            if (id <= 0 || origen.isEmpty() || destino.isEmpty()
                    || pasajeros <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese datos válidos");
                return;
            }

            // ACTUALIZAR RESERVA
            dao.actualizarReserva(id, origen, destino, pasajeros);
            mostrarReservas();

            JOptionPane.showMessageDialog(this,
                    "Reserva actualizada correctamente");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese un ID y número de pasajeros válidos");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al actualizar: " + e.getMessage());
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        try {

            // OBTENER ID
            int id = Integer.parseInt(tfID.getText().trim());

            if (id <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese un ID válido");
                return;
            }

            // VERIFICAR RESERVA
            Reserva reserva = dao.buscarPorId(id);

            if (reserva == null) {
                JOptionPane.showMessageDialog(this, "Reserva no encontrada");
                return;
            }

            // CONFIRMAR ELIMINACIÓN
            int confirmar = JOptionPane.showConfirmDialog(
                    this,
                    "¿Desea eliminar la reserva " + id + "?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmar != JOptionPane.YES_OPTION) {
                return;
            }

            // ELIMINAR RESERVA
            dao.eliminarReserva(id);
            mostrarReservas();

            // LIMPIAR CAMPOS
            tfID.setText("");
            tfOrigen.setText("");
            tfDestino.setText("");
            tfNumPasajeros.setText("");

            JOptionPane.showMessageDialog(this,
                    "Reserva eliminada correctamente");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese un ID numérico válido");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al eliminar reserva: " + e.getMessage());
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new views().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDESTINO;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelLATAMAIRLINES;
    private javax.swing.JLabel labelNUMPASAJEROS;
    private javax.swing.JLabel labelORIGEN;
    private javax.swing.JLabel labelREGISTRORESERVAS;
    private javax.swing.JTable tblReservas;
    private javax.swing.JTextField tfDestino;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfNumPasajeros;
    private javax.swing.JTextField tfOrigen;
    // End of variables declaration//GEN-END:variables
}
