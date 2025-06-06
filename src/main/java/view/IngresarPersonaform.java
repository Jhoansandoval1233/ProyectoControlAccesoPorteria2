/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JOptionPane;
import model.Persona;

/**
 *
 * @author sando
 */
public class IngresarPersonaform extends javax.swing.JFrame {

    /**
     * Creates new form IngresarPersonaform
     */
    public IngresarPersonaform() {
        initComponents();  
        jTextFieldTipoELemento.setVisible(false);
        jTextFieldSerialElemento.setVisible(false);
        jTextFieldTipoVehiculo.setVisible(false);
        jTextFieldPlaca.setVisible(false);
        
        agregarBorradoAlHacerClick(jTextFileIngresarNombre);
        agregarBorradoAlHacerClick(jTextFileIngresarApellido);
        agregarBorradoAlHacerClick(jTexttIngresarID);
        agregarBorradoAlHacerClick(jTexttIngresarNumeroTelefonico);
        agregarBorradoAlHacerClick(jTexttIngresarCorreo);
        agregarBorradoAlHacerClick(jTextFieldTipoELemento);
        agregarBorradoAlHacerClick(jTextFieldSerialElemento);
        agregarBorradoAlHacerClick(jTextFieldTipoVehiculo);
        agregarBorradoAlHacerClick(jTextFieldPlaca);
        
      jCheckBoxRegistrarElemento.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
      jCheckBoxRegistrarElementoActionPerformed(evt);
      
      
    }
      private boolean validarCampos() {
    String nombre = jTextFileIngresarNombre.getText().trim();
    String apellido = jTextFileIngresarApellido.getText().trim();
    String tipoDocumento = (String) jComboTiposDocumentos1.getSelectedItem();
    String id = jTexttIngresarID.getText().trim();
    String telefono = jTexttIngresarNumeroTelefonico.getText().trim();
    String correo = jTexttIngresarCorreo.getText().trim();
    String tipoVisita = (String) jComboTipoDeVisita.getSelectedItem();

    if (nombre.isEmpty() || nombre.equals("Ingrese nombres")) {
        mostrarMensaje("Ingrese un nombre válido");
        return false;
    }
    if (apellido.isEmpty() || apellido.equals("Ingrese apellidos")) {
        mostrarMensaje("Ingrese un apellido válido");
        return false;
    }
    if (tipoDocumento.equals("Tipo de documento")) {
        mostrarMensaje("Seleccione un tipo de documento");
        return false;
    }
    if (!id.matches("\\d+")) {
        mostrarMensaje("El número de ID debe ser numérico");
        return false;
    }
    if (!telefono.matches("\\d{7,10}")) {
        mostrarMensaje("Ingrese un número telefónico válido (7 a 10 dígitos)");
        return false;
    }
    if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
        mostrarMensaje("Ingrese un correo electrónico válido");
        return false;
    }
    if (tipoVisita.equals("Tipo de visitante")) {
        mostrarMensaje("Seleccione un tipo/rol válido");
        return false;
    }

    if (jCheckBoxRegistrarElemento.isSelected()) {
        String tipoElemento = jTextFieldTipoELemento.getText().trim();
        String serialElemento = jTextFieldSerialElemento.getText().trim();
        if (tipoElemento.isEmpty() || serialElemento.isEmpty()) {
            mostrarMensaje("Complete los campos del elemento");
            return false;
        }
    }

    if (jCheckBoxReigistrarVehiculo.isSelected()) {
        String tipoVehiculo = jTextFieldTipoVehiculo.getText().trim();
        String placa = jTextFieldPlaca.getText().trim();
        if (tipoVehiculo.isEmpty() || placa.isEmpty()) {
            mostrarMensaje("Complete los campos del vehículo");
            return false;
        }
    }

    return true;
}

        });
    }
    
        private void mostrarMensaje(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(this, mensaje, "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
    }
        
       private void registrarPersona() {
    String nombre = jTextFileIngresarNombre.getText().trim();
    String apellido = jTextFileIngresarApellido.getText().trim();
    String tipoDocumento = (String) jComboTiposDocumentos1.getSelectedItem();
    String idTexto = jTexttIngresarID.getText().trim();
    String telefono = jTexttIngresarNumeroTelefonico.getText().trim();
    String correo = jTexttIngresarCorreo.getText().trim();
    String tipoVisita = (String) jComboTipoDeVisita.getSelectedItem();

    // Validar y convertir ID a entero
    int id;
    try {
        id = Integer.parseInt(idTexto);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Construir el nombre completo
    String nombreCompleto = nombre + " " + apellido;

    // Crear la persona con el constructor correcto
    Persona persona = new Persona(nombreCompleto, tipoDocumento, id, tipoVisita, telefono, correo);

    // Aquí deberías guardar la persona en la base de datos, por ejemplo:
    // personaDAO.guardar(persona);

    // Mensaje de éxito
    JOptionPane.showMessageDialog(this, "Persona registrada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabelIngresarPersona = new javax.swing.JLabel();
        jLabelNombreCompleto = new javax.swing.JLabel();
        jTextFileIngresarNombre = new javax.swing.JTextField();
        jTextFileIngresarApellido = new javax.swing.JTextField();
        jLabelTipoDeDocumento = new javax.swing.JLabel();
        jComboTipoDeVisita = new javax.swing.JComboBox<>();
        jTexttIngresarID = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        jTexttIngresarNumeroTelefonico = new javax.swing.JTextField();
        jLabelCorreo = new javax.swing.JLabel();
        jTexttIngresarCorreo = new javax.swing.JTextField();
        jLabelTipoRol = new javax.swing.JLabel();
        jComboTiposDocumentos1 = new javax.swing.JComboBox<>();
        jCheckBoxRegistrarElemento = new javax.swing.JCheckBox();
        jTextFieldTipoELemento = new javax.swing.JTextField();
        jTextFieldSerialElemento = new javax.swing.JTextField();
        jCheckBoxReigistrarVehiculo = new javax.swing.JCheckBox();
        jTextFieldTipoVehiculo = new javax.swing.JTextField();
        jTextFieldPlaca = new javax.swing.JTextField();
        jButtonRegistrar = new javax.swing.JButton();
        jLabelFondoTaladro = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(820, 520));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIngresarPersona.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelIngresarPersona.setText("Ingresar Persona");
        jPanel1.add(jLabelIngresarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, -1));

        jLabelNombreCompleto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelNombreCompleto.setText("Nombre Completo");
        jPanel1.add(jLabelNombreCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jTextFileIngresarNombre.setText("Ingrese nombres");
        jTextFileIngresarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFileIngresarNombreActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFileIngresarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 170, 30));

        jTextFileIngresarApellido.setText("Ingrese apellidos");
        jTextFileIngresarApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFileIngresarApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFileIngresarApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 170, 30));

        jLabelTipoDeDocumento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTipoDeDocumento.setText("Tipo de documento ");
        jPanel1.add(jLabelTipoDeDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        jComboTipoDeVisita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de visitante", "visitante", "Empleado", "Proveedor", "Aprendiz" }));
        jComboTipoDeVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTipoDeVisitaActionPerformed(evt);
            }
        });
        jPanel1.add(jComboTipoDeVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 170, 30));

        jTexttIngresarID.setText("Ingrese numero ID");
        jTexttIngresarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTexttIngresarIDActionPerformed(evt);
            }
        });
        jPanel1.add(jTexttIngresarID, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 170, 30));

        jLabelTelefono.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTelefono.setText("Telefono/celular");
        jPanel1.add(jLabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 150, -1));

        jTexttIngresarNumeroTelefonico.setText("Ingrese numero telefonico");
        jTexttIngresarNumeroTelefonico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTexttIngresarNumeroTelefonicoActionPerformed(evt);
            }
        });
        jPanel1.add(jTexttIngresarNumeroTelefonico, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 170, 30));

        jLabelCorreo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCorreo.setText("Correo o gmail");
        jPanel1.add(jLabelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 130, -1));

        jTexttIngresarCorreo.setText("Ingrese correo");
        jTexttIngresarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTexttIngresarCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(jTexttIngresarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 220, 30));

        jLabelTipoRol.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTipoRol.setText("Tipo/rol");
        jPanel1.add(jLabelTipoRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 80, -1));

        jComboTiposDocumentos1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de documento", "Cedula de ciudadania", "Pasaporte", "Tarjeta de Identidad" }));
        jComboTiposDocumentos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTiposDocumentos1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboTiposDocumentos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 170, 30));

        jCheckBoxRegistrarElemento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBoxRegistrarElemento.setText("Registrar elemento");
        jCheckBoxRegistrarElemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRegistrarElementoActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxRegistrarElemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, -1));

        jTextFieldTipoELemento.setText("Tipo de elemento");
        jPanel1.add(jTextFieldTipoELemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 130, 30));

        jTextFieldSerialElemento.setText("Serial o ID");
        jTextFieldSerialElemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSerialElementoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldSerialElemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 130, 30));

        jCheckBoxReigistrarVehiculo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBoxReigistrarVehiculo.setText("Registrar vehiculo");
        jCheckBoxReigistrarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxReigistrarVehiculoActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxReigistrarVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, -1, -1));

        jTextFieldTipoVehiculo.setText("Tipo de vehiculo");
        jPanel1.add(jTextFieldTipoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 130, 30));

        jTextFieldPlaca.setText("Placa");
        jPanel1.add(jTextFieldPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 130, 30));

        jButtonRegistrar.setBackground(new java.awt.Color(0, 204, 0));
        jButtonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonRegistrar.setText("Registrar datos");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 140, 40));

        jLabelFondoTaladro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/taladro.jpg"))); // NOI18N
        jLabelFondoTaladro.setText("jLabel1");
        jPanel1.add(jLabelFondoTaladro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboTipoDeVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTipoDeVisitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboTipoDeVisitaActionPerformed

    private void jCheckBoxReigistrarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxReigistrarVehiculoActionPerformed
          boolean seleccionado = jCheckBoxReigistrarVehiculo.isSelected();
          jTextFieldTipoVehiculo.setVisible(seleccionado);
          jTextFieldPlaca.setVisible(seleccionado);
    }//GEN-LAST:event_jCheckBoxReigistrarVehiculoActionPerformed

    private void jTexttIngresarNumeroTelefonicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTexttIngresarNumeroTelefonicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTexttIngresarNumeroTelefonicoActionPerformed

    private void jTextFieldSerialElementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSerialElementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSerialElementoActionPerformed

    private void jTextFileIngresarApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFileIngresarApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFileIngresarApellidoActionPerformed

    private void jTextFileIngresarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFileIngresarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFileIngresarNombreActionPerformed

    private void jTexttIngresarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTexttIngresarCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTexttIngresarCorreoActionPerformed

    private void jTexttIngresarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTexttIngresarIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTexttIngresarIDActionPerformed

    private void jComboTiposDocumentos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTiposDocumentos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboTiposDocumentos1ActionPerformed

    private void jCheckBoxRegistrarElementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRegistrarElementoActionPerformed
           boolean seleccionado = jCheckBoxRegistrarElemento.isSelected();
           jTextFieldTipoELemento.setVisible(seleccionado);
           jTextFieldSerialElemento.setVisible(seleccionado);
    }//GEN-LAST:event_jCheckBoxRegistrarElementoActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
          if (validarCampos()) {
        registrarPersona(); // o el método que estés usando para guardar
    }
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IngresarPersonaform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarPersonaform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarPersonaform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarPersonaform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new IngresarPersonaform().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JCheckBox jCheckBoxRegistrarElemento;
    private javax.swing.JCheckBox jCheckBoxReigistrarVehiculo;
    private javax.swing.JComboBox<String> jComboTipoDeVisita;
    private javax.swing.JComboBox<String> jComboTiposDocumentos1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelFondoTaladro;
    private javax.swing.JLabel jLabelIngresarPersona;
    private javax.swing.JLabel jLabelNombreCompleto;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTipoDeDocumento;
    private javax.swing.JLabel jLabelTipoRol;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTextField jTextFieldPlaca;
    private javax.swing.JTextField jTextFieldSerialElemento;
    private javax.swing.JTextField jTextFieldTipoELemento;
    private javax.swing.JTextField jTextFieldTipoVehiculo;
    private javax.swing.JTextField jTextFileIngresarApellido;
    private javax.swing.JTextField jTextFileIngresarNombre;
    private javax.swing.JTextField jTexttIngresarCorreo;
    private javax.swing.JTextField jTexttIngresarID;
    private javax.swing.JTextField jTexttIngresarNumeroTelefonico;
    // End of variables declaration//GEN-END:variables
private void agregarBorradoAlHacerClick(javax.swing.JTextField campo) {
    campo.addMouseListener(new java.awt.event.MouseAdapter() {
        private boolean borrado = false;

        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (!borrado) {
                campo.setText("");
                borrado = true;
            }
        }
    });
}

    private boolean validarCampos() {
           if (jTextFileIngresarNombre.getText().trim().isEmpty()
        || jTextFileIngresarApellido.getText().trim().isEmpty()
        || jTexttIngresarID.getText().trim().isEmpty()
        || jTexttIngresarNumeroTelefonico.getText().trim().isEmpty()
        || jTexttIngresarCorreo.getText().trim().isEmpty()
        || jComboTiposDocumentos1.getSelectedItem() == null
        || jComboTipoDeVisita.getSelectedItem() == null) {

        JOptionPane.showMessageDialog(this, "Todos los campos deben estar completos", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    try {
        Integer.parseInt(jTexttIngresarID.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El campo ID debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    return true;
}
   
}
