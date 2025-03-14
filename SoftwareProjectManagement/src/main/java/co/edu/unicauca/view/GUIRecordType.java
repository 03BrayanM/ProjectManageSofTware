/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.unicauca.view;

import co.edu.unicauca.access.Factory;
import co.edu.unicauca.domain.services.CompanyService;
import co.edu.unicauca.domain.services.StudentService;
import co.edu.unicauca.domain.services.UserService;
import co.edu.unicauca.interfaces.IFrameFactory;
import co.edu.unicauca.interfaces.IRepository;
import javax.swing.JFrame;

/**
 *
 * @author Yisus
 */
public class GUIRecordType extends javax.swing.JFrame {

    /**
     * Creates new form GUIRecordType
     */
    public GUIRecordType() {
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

        jPanel1 = new javax.swing.JPanel();
        lbltipoderegistro = new javax.swing.JLabel();
        lblenunciado = new javax.swing.JLabel();
        lbltiporegistro1 = new javax.swing.JLabel();
        cbxtipo = new javax.swing.JComboBox<>();
        btnvolver = new javax.swing.JButton();
        btnsiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 380));
        setPreferredSize(new java.awt.Dimension(450, 380));
        setSize(new java.awt.Dimension(450, 380));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(242, 247, 249));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 380));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lbltipoderegistro.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbltipoderegistro.setForeground(new java.awt.Color(35, 38, 107));
        lbltipoderegistro.setText("Tipo de Registro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jPanel1.add(lbltipoderegistro, gridBagConstraints);

        lblenunciado.setBackground(new java.awt.Color(255, 255, 255));
        lblenunciado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblenunciado.setText("Por favor seleccione el tipo de resgitro deseado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 60, 0, 23);
        jPanel1.add(lblenunciado, gridBagConstraints);

        lbltiporegistro1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbltiporegistro1.setForeground(new java.awt.Color(35, 38, 107));
        lbltiporegistro1.setText("Tipo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 110, 0, 0);
        jPanel1.add(lbltiporegistro1, gridBagConstraints);

        cbxtipo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbxtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiante", "Empresa" }));
        cbxtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxtipoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 87;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 0, 0, 0);
        jPanel1.add(cbxtipo, gridBagConstraints);

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
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(127, 120, 86, 0);
        jPanel1.add(btnvolver, gridBagConstraints);

        btnsiguiente.setBackground(new java.awt.Color(13, 65, 133));
        btnsiguiente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnsiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnsiguiente.setText("Siguiente");
        btnsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsiguienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(127, 94, 86, 0);
        jPanel1.add(btnsiguiente, gridBagConstraints);

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsiguienteActionPerformed
        String seleccionado = cbxtipo.getSelectedItem().toString();
        if (seleccionado.equals("Estudiante")) {
            //  IRepository serviceRepository = Factory.getInstance().getRepository("company");
            IRepository studentRepository = Factory.getInstance().getRepository("student");

            //   CompanyService servicecompany = new CompanyService(serviceRepository);
            StudentService servicestudent = new StudentService(studentRepository);

            GUIRegisterStudent instance = new GUIRegisterStudent(servicestudent);
            instance.setExtendedState(JFrame.NORMAL);
            instance.setSize(450, 380); // Ajusta el tamaño a 600x400 píxeles
            instance.setLocationRelativeTo(null); // Centrar en pantalla
            this.dispose();
            instance.setVisible(true);
        } else {
            IRepository CompanyRepository = Factory.getInstance().getRepository("company");

            //   CompanyService servicecompany = new CompanyService(serviceRepository);
            CompanyService servicecompany = new CompanyService(CompanyRepository);

            GUIRegistreCompany instance = new GUIRegistreCompany(servicecompany);
            instance.setExtendedState(JFrame.NORMAL);
            instance.setSize(450, 380); // Ajusta el tamaño a 600x400 píxeles
            instance.setLocationRelativeTo(null); // Centrar en pantalla
            this.dispose();
            instance.setVisible(true);
        }
    }//GEN-LAST:event_btnsiguienteActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        this.dispose();
        IRepository userRepository = Factory.getInstance().getRepository("usuario");
        UserService service = new UserService(userRepository);
        IFrameFactory frameFactory = new FrameFactory();

        GUILogin instance = new GUILogin(service, frameFactory);
        instance.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnvolverActionPerformed

    private void cbxtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxtipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxtipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsiguiente;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox<String> cbxtipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblenunciado;
    private javax.swing.JLabel lbltipoderegistro;
    private javax.swing.JLabel lbltiporegistro1;
    // End of variables declaration//GEN-END:variables
}
