/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.DAO.ElementoDAO;
import model.DAO.RegistroDAO;
import model.DAO.VehiculoDAO;
import model.Elemento;
import model.Persona;
import model.Registro;
import model.Usuario;
import model.Vehiculo;
import utilities.Conexion;

/**
 *
 * @author sando
 */
public class RegistrosForm extends javax.swing.JFrame {

    private int intID;
    private Usuario usuarioActual;
    private  JTextField jTextFileIngresarNombre;
    private  JTextField jTextFileIngresarApellido;
    private  JTextField jTexttIngresarNumeroTelefonico;
    private  JTextField jTexttIngresarCorreo;

  
     //Creates new form Registros
   
    public RegistrosForm() {
        initComponents();   
          
          agregarBorradoAlHacerClick(jTexttIngresarID);
          agregarBorradoAlHacerClick(jTextFieldTipoELemento);
          agregarBorradoAlHacerClick(jTextFieldSerialElemento);
          agregarBorradoAlHacerClick(jTextFieldTipoVehiculo);
          agregarBorradoAlHacerClick(jTextFieldPlaca);
          agregarBorradoAlHacerClick(jLabelIngreseObservaciones); 

        
        jPanelElemento.setVisible(true);    
        jPanelVehiculo.setVisible(true);
        
// Agregar acción al checkbox para mostrar/ocultar el panel
         jCheckBoxRegistrarElemento.addActionListener((java.awt.event.ActionEvent evt) -> {
             jPanelElemento.setVisible(jCheckBoxRegistrarElemento.isSelected());
        });
          jCheckBoxRegistrarVehiculo.addActionListener((java.awt.event.ActionEvent evt) -> {
              jPanelVehiculo.setVisible(jCheckBoxRegistrarVehiculo.isSelected());
        });
          
    }
    @Override
    public void setVisible(boolean isVisible) {
        super.setVisible(isVisible); // Llama a la implementación de JFrame para hacer la ventana visible
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelElemento = new javax.swing.JPanel();
        jPanelVehiculo = new javax.swing.JPanel();
        jPanelRegistros = new javax.swing.JPanel();
        jLabelRegistros = new javax.swing.JLabel();
        jLabelTipoDocumento = new javax.swing.JLabel();
        jComboTiposDocumentos = new javax.swing.JComboBox<>();
        jLabelNumeroID = new javax.swing.JLabel();
        jTexttIngresarID = new javax.swing.JTextField();
        jLabelTipoRegistro = new javax.swing.JLabel();
        jComboBoxEntradaSalida = new javax.swing.JComboBox<>();
        jLabelObservaciones = new javax.swing.JLabel();
        jLabelIngreseObservaciones = new javax.swing.JTextField();
        jCheckBoxRegistrarElemento = new javax.swing.JCheckBox();
        jCheckBoxRegistrarVehiculo = new javax.swing.JCheckBox();
        jButtonRegistrar = new javax.swing.JButton();
        jTextFieldTipoELemento = new javax.swing.JTextField();
        jTextFieldSerialElemento = new javax.swing.JTextField();
        jTextFieldTipoVehiculo = new javax.swing.JTextField();
        jTextFieldPlaca = new javax.swing.JTextField();
        jLabelFondoTaladro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelRegistros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelRegistros.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelRegistros.setText("Registros de Acceso");
        jPanelRegistros.add(jLabelRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, 60));

        jLabelTipoDocumento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTipoDocumento.setText("Tipo de documento ");
        jPanelRegistros.add(jLabelTipoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        jComboTiposDocumentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de documento", "Cedula de ciudadania", "Pasaporte", "Tarjeta de Identidad" }));
        jComboTiposDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTiposDocumentosActionPerformed(evt);
            }
        });
        jPanelRegistros.add(jComboTiposDocumentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 170, 30));

        jLabelNumeroID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelNumeroID.setText("NumeroID");
        jPanelRegistros.add(jLabelNumeroID, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        jTexttIngresarID.setText("Ingrese ID");
        jTexttIngresarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTexttIngresarIDActionPerformed(evt);
            }
        });
        jPanelRegistros.add(jTexttIngresarID, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 170, 30));

        jLabelTipoRegistro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTipoRegistro.setText("Tipo de registro ");
        jPanelRegistros.add(jLabelTipoRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        jComboBoxEntradaSalida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione registro", "Entrada", "Salida" }));
        jComboBoxEntradaSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEntradaSalidaActionPerformed(evt);
            }
        });
        jPanelRegistros.add(jComboBoxEntradaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 170, 30));

        jLabelObservaciones.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelObservaciones.setText("Observaciones");
        jPanelRegistros.add(jLabelObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));

        jLabelIngreseObservaciones.setText("Obvservaciones...");
        jLabelIngreseObservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLabelIngreseObservacionesActionPerformed(evt);
            }
        });
        jPanelRegistros.add(jLabelIngreseObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 170, 30));

        jCheckBoxRegistrarElemento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBoxRegistrarElemento.setText("Registrar elemento");
        jCheckBoxRegistrarElemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRegistrarElementoActionPerformed(evt);
            }
        });
        jPanelRegistros.add(jCheckBoxRegistrarElemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, -1, -1));

        jCheckBoxRegistrarVehiculo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCheckBoxRegistrarVehiculo.setText("Registrar vehiculo");
        jCheckBoxRegistrarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRegistrarVehiculoActionPerformed(evt);
            }
        });
        jPanelRegistros.add(jCheckBoxRegistrarVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, -1, -1));

        jButtonRegistrar.setBackground(new java.awt.Color(0, 204, 0));
        jButtonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        jPanelRegistros.add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 130, 40));

        jTextFieldTipoELemento.setText("Tipo de elemento");
        jTextFieldTipoELemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTipoELementoActionPerformed(evt);
            }
        });
        jPanelRegistros.add(jTextFieldTipoELemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 130, 30));

        jTextFieldSerialElemento.setText("Serial o ID");
        jTextFieldSerialElemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSerialElementoActionPerformed(evt);
            }
        });
        jPanelRegistros.add(jTextFieldSerialElemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 130, 30));

        jTextFieldTipoVehiculo.setText("Tipo de vehiculo");
        jPanelRegistros.add(jTextFieldTipoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 130, 30));

        jTextFieldPlaca.setText("Placa");
        jTextFieldPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlacaActionPerformed(evt);
            }
        });
        jPanelRegistros.add(jTextFieldPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 130, 30));

        jLabelFondoTaladro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/taladro.jpg"))); // NOI18N
        jLabelFondoTaladro.setText("jLabel1");
        jPanelRegistros.add(jLabelFondoTaladro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -60, 880, 720));

        jLabel1.setText("jLabel1");
        jPanelRegistros.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 550, -1, -1));

        javax.swing.GroupLayout jPanelVehiculoLayout = new javax.swing.GroupLayout(jPanelVehiculo);
        jPanelVehiculo.setLayout(jPanelVehiculoLayout);
        jPanelVehiculoLayout.setHorizontalGroup(
            jPanelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelVehiculoLayout.setVerticalGroup(
            jPanelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelElementoLayout = new javax.swing.GroupLayout(jPanelElemento);
        jPanelElemento.setLayout(jPanelElementoLayout);
        jPanelElementoLayout.setHorizontalGroup(
            jPanelElementoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelVehiculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelElementoLayout.setVerticalGroup(
            jPanelElementoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelElementoLayout.createSequentialGroup()
                .addComponent(jPanelVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelElemento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelElemento, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxEntradaSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEntradaSalidaActionPerformed
              String accion = jComboBoxEntradaSalida.getSelectedItem().toString();
        // Verificar la opción seleccionada
        switch (accion) {
            case "Entrada" -> // Aquí se maneja el registro de entrada
                JOptionPane.showMessageDialog(this, "Registro de Entrada realizado.");
            // Puedes agregar aquí la lógica para guardar en la base de datos o realizar alguna otra acción
            case "Salida" -> // Aquí se maneja el registro de salida
                JOptionPane.showMessageDialog(this, "Registro de Salida realizado.");
            // Puedes agregar aquí la lógica para guardar en la base de datos o realizar alguna otra acción
            default -> // En caso de que no se haya seleccionado ninguna opción válida
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una acción válida (Entrada o Salida).");
        }
    }//GEN-LAST:event_jComboBoxEntradaSalidaActionPerformed

    private void jComboTiposDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTiposDocumentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboTiposDocumentosActionPerformed

    private void jLabelIngreseObservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLabelIngreseObservacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelIngreseObservacionesActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
    String tipoDocumento = jComboTiposDocumentos.getSelectedItem().toString();
    String numeroID = jTexttIngresarID.getText();
    String tipoRegistro = jComboBoxEntradaSalida.getSelectedItem().toString();

    if (tipoDocumento.equals("Tipo de documento") || numeroID.isEmpty() || tipoRegistro.equals("Seleccione registro")) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        return;
    }
    // Aquí deberías buscar la persona y usuario en la base de datos
    Persona persona = obtenerPersonaPorID(intID); // Método a implementar
    Usuario usuario = obtenerUsuarioActual(); // Método a implementar
    
    if (persona == null) {
        JOptionPane.showMessageDialog(this, "Persona no encontrada en la base de datos.");
        return;
    }

    Registro.TipoAccion accion = tipoRegistro.equals("Entrada") ? Registro.TipoAccion.ENTRADA : Registro.TipoAccion.SALIDA;
    Registro nuevoRegistro = new Registro(0, persona, usuario, LocalDateTime.now(), "", accion, null, null);

    // Llamar al DAO para guardar el registro en la base de datos
    RegistroDAO registroDAO = new RegistroDAO(conexion.getConnection());
    boolean guardado = registroDAO.guardarRegistro(nuevoRegistro);

    if (guardado) {
        JOptionPane.showMessageDialog(this, "Registro guardado correctamente.");
    } else {
        JOptionPane.showMessageDialog(this, "Error al guardar el registro.");
    }
    
    // Si está marcado el checkbox de elemento
Elemento elemento = null;
if (jCheckBoxRegistrarElemento.isSelected()) {
    String tipoElemento = jTextFieldTipoELemento.getText().trim();
    String serialElemento = jTextFieldSerialElemento.getText().trim();
    if (tipoElemento.isEmpty() || serialElemento.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete los campos de Elemento.");
        return;
    }
}


// Si está marcado el checkbox de vehículo
    Vehiculo vehiculo = null;
      if (jCheckBoxRegistrarVehiculo.isSelected()) {
         String tipoVehiculo = jTextFieldTipoVehiculo.getText().trim();
         String placa = jTextFieldPlaca.getText().trim();
      if (!tipoVehiculo.isEmpty() && !placa.isEmpty()) {
          vehiculo = new Vehiculo(0, tipoVehiculo, placa, persona);
          VehiculoDAO vehiculoDAO = new VehiculoDAO();
          vehiculoDAO.guardarVehiculo(vehiculo);
          nuevoRegistro.setVehiculo(vehiculo);
    }
}

    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jCheckBoxRegistrarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRegistrarVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxRegistrarVehiculoActionPerformed

    private void jTexttIngresarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTexttIngresarIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTexttIngresarIDActionPerformed

    private void jTextFieldSerialElementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSerialElementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSerialElementoActionPerformed

    private void jTextFieldPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPlacaActionPerformed

    private void jCheckBoxRegistrarElementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRegistrarElementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxRegistrarElementoActionPerformed

    private void jTextFieldTipoELementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTipoELementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTipoELementoActionPerformed

   public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(() -> {
        try {
            new RegistrosForm().setVisible(true);
        } catch (Exception e) {
            e.printStackTrace(); // Verás el error en la consola
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JCheckBox jCheckBoxRegistrarElemento;
    private javax.swing.JCheckBox jCheckBoxRegistrarVehiculo;
    private javax.swing.JComboBox<String> jComboBoxEntradaSalida;
    private javax.swing.JComboBox<String> jComboTiposDocumentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFondoTaladro;
    private javax.swing.JTextField jLabelIngreseObservaciones;
    private javax.swing.JLabel jLabelNumeroID;
    private javax.swing.JLabel jLabelObservaciones;
    private javax.swing.JLabel jLabelRegistros;
    private javax.swing.JLabel jLabelTipoDocumento;
    private javax.swing.JLabel jLabelTipoRegistro;
    private javax.swing.JPanel jPanelElemento;
    private javax.swing.JPanel jPanelRegistros;
    private javax.swing.JPanel jPanelVehiculo;
    private javax.swing.JTextField jTextFieldPlaca;
    private javax.swing.JTextField jTextFieldSerialElemento;
    private javax.swing.JTextField jTextFieldTipoELemento;
    private javax.swing.JTextField jTextFieldTipoVehiculo;
    private javax.swing.JTextField jTexttIngresarID;
    // End of variables declaration//GEN-END:variables

    private Persona obtenerPersonaPorID(int Id_persona) { // Cambié String por int
    Persona persona = null;
    try {
        Connection con; 
        con = Conexion.getConnection();
        String sql = "SELECT * FROM persona WHERE id_persona = ?"; // Consulta SQL
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, Id_persona); // Usamos setInt porque numeroID es un int
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            persona = new Persona(
                rs.getInt("id_persona"), // ID numérico
                rs.getString("nombre_completo"),
                rs.getString("tipo_id")
            );
        }
        con.close();
    } catch (SQLException e) {
        e.printStackTrace(); // Imprimir errores si hay problemas
    }
    return persona; // Devuelve la persona encontrada (o null si no existe)
}
    private Usuario obtenerUsuarioActual() {
           return usuarioActual; 
    }

    private void agregarBorradoAlHacerClick(JTextField jTextFileIngresarNombre) {
           jTextFieldPlaca.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTextFieldPlaca.setText("");
        }
    });

    jTextFieldSerialElemento.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTextFieldSerialElemento.setText("");
        }
    });

    jTextFieldTipoELemento.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTextFieldTipoELemento.setText("");
        }
    });

    jTextFieldTipoVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTextFieldTipoVehiculo.setText("");
        }
    });

    jTexttIngresarID.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTexttIngresarID.setText("");
        }
    });

    jLabelIngreseObservaciones.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelIngreseObservaciones.setText("");
        }
    });
}

    private static class conexion {

        private static Connection getConnection() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public conexion() {
        }
    }
}
