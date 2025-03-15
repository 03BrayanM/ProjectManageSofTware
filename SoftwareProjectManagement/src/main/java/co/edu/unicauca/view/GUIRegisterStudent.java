/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.unicauca.view;

import co.edu.unicauca.domain.entities.Student;
import co.edu.unicauca.domain.services.StudentService;
import co.edu.unicauca.infra.Messages;
import co.edu.unicauca.main.Main;

public class GUIRegisterStudent extends javax.swing.JFrame {

    /**
     * Creates new form GUIRegisterCompany
     */
    StudentService servicestudent;

    public GUIRegisterStudent(StudentService student) {
        this.servicestudent = student;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label2 = new java.awt.Label();
        lblname1 = new java.awt.Label();
        lblname = new java.awt.Label();
        lblcodigo = new java.awt.Label();
        txtnombre = new javax.swing.JTextField();
        txtcedula = new javax.swing.JTextField();
        txtcodigo = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        lblemail = new java.awt.Label();
        lbltelefono = new java.awt.Label();
        btnvolver = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(450, 380));
        setPreferredSize(new java.awt.Dimension(450, 380));
        setSize(new java.awt.Dimension(450, 380));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        label2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        label2.setForeground(new java.awt.Color(35, 38, 107));
        label2.setText("Registrar Estudiante");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 48, 0, 35);
        getContentPane().add(label2, gridBagConstraints);

        lblname1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblname1.setForeground(new java.awt.Color(35, 38, 107));
        lblname1.setName("lblName"); // NOI18N
        lblname1.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(47, 50, 0, 0);
        getContentPane().add(lblname1, gridBagConstraints);

        lblname.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblname.setForeground(new java.awt.Color(35, 38, 107));
        lblname.setName("lblName"); // NOI18N
        lblname.setText("Numero de cedula");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 50, 0, 0);
        getContentPane().add(lblname, gridBagConstraints);

        lblcodigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblcodigo.setForeground(new java.awt.Color(35, 38, 107));
        lblcodigo.setName("lblName"); // NOI18N
        lblcodigo.setText("Codigo estudiante");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = -1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 50, 0, 0);
        getContentPane().add(lblcodigo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 66;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(47, 14, 0, 0);
        getContentPane().add(txtnombre, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 68;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 0);
        getContentPane().add(txtcedula, gridBagConstraints);

        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 68;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 0);
        getContentPane().add(txtcodigo, gridBagConstraints);

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 68;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 0);
        getContentPane().add(txtemail, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 68;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 14, 0, 0);
        getContentPane().add(txttelefono, gridBagConstraints);

        lblemail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblemail.setForeground(new java.awt.Color(35, 38, 107));
        lblemail.setName("lblName"); // NOI18N
        lblemail.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 50, 0, 0);
        getContentPane().add(lblemail, gridBagConstraints);

        lbltelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbltelefono.setForeground(new java.awt.Color(35, 38, 107));
        lbltelefono.setName("lblName"); // NOI18N
        lbltelefono.setText("Telefono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 50, 0, 0);
        getContentPane().add(lbltelefono, gridBagConstraints);

        btnvolver.setBackground(new java.awt.Color(191, 212, 228));
        btnvolver.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnvolver.setForeground(new java.awt.Color(35, 38, 107));
        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(39, 14, 46, 0);
        getContentPane().add(btnvolver, gridBagConstraints);

        jButton2.setBackground(new java.awt.Color(13, 65, 133));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Registrarme");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(39, 44, 46, 0);
        getContentPane().add(jButton2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nombre = txtnombre.getText().trim();
        String cedula = txtcedula.getText().trim();
        String codigo = txtcodigo.getText().trim();
        String email = txtemail.getText().trim();
        String telefono = txttelefono.getText().trim();
        boolean validar = validarFormulario(nombre, cedula, codigo, email, telefono);
        if (validar) {
            Student estudiante = new Student(nombre, cedula, codigo, email, telefono);
            boolean res = servicestudent.registreStudent(estudiante);
            if (res) {
                Messages.showMessageDialog("Estudiante Registrado correctamente", "Atención");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        this.dispose();
        Main.mostrarLogin();        
    }//GEN-LAST:event_btnvolverActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoActionPerformed
    private boolean validarFormulario(String nombre, String cedula, String codigo, String email, String telefono) {
        // Validar que el nombre no esté vacío y no contenga números
        if (nombre.isEmpty()) {
            Messages.showMessageDialog("El campo Nombre no puede estar vacío.", "Atención");
            return false;
        }

        // Validar que la cédula no esté vacía y solo contenga números
        if (cedula.isEmpty()) {
            Messages.showMessageDialog("El campo Cédula no puede estar vacío.", "Atención");
            return false;
        }
        if (!cedula.matches("\\d+")) {
            Messages.showMessageDialog("El campo cedula debe ser un número positivo.", "Atención");
            return false;
        }
        // Validar que el código sea un número positivo
        if (!codigo.matches("\\d+")) {
            Messages.showMessageDialog("El campo Código debe ser un número positivo.", "Atención");
            return false;
        }

        // Validar que el email no esté vacío y tenga un formato válido
        if (email.isEmpty()) {
            Messages.showMessageDialog("El campo Email no puede estar vacío.", "Atención");
            return false;
        }
        // Validar que el teléfono no esté vacío y solo contenga números
        if (telefono.isEmpty()) {
            Messages.showMessageDialog("El campo Teléfono no puede estar vacío.", "Atención");
            return false;
        }
        if (!telefono.matches("\\d+")) {
            Messages.showMessageDialog("El campo Teléfono solo puede contener números.", "Atención");
            return false;
        }

        // Si todas las validaciones pasan, retornar true
        return true;
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnvolver;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private java.awt.Label label2;
    private java.awt.Label lblcodigo;
    private java.awt.Label lblemail;
    private java.awt.Label lblname;
    private java.awt.Label lblname1;
    private java.awt.Label lbltelefono;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
