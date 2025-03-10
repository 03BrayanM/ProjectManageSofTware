
package co.edu.unicauca.view;

import co.edu.unicauca.domain.entities.Project;
import co.edu.unicauca.domain.services.ProjectService;
import co.edu.unicauca.infra.IFrameEventListener;
import co.edu.unicauca.infra.Messages;
import co.edu.unicauca.infra.gotaAguaTexto;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author evers
 */
public class GUIPostularProject extends javax.swing.JDialog {

    /**
     * Creates new form GUIPostularProject
     */
    private IFrameEventListener listener; 
    private ProjectService projectService;
    private String nit;
    public GUIPostularProject(JFrame parent,ProjectService projectService,IFrameEventListener listener,String nit) {
        super(parent, "Nueva projecto", true);
        this.nit=nit;
        this.projectService = projectService;
        this.listener = listener;
        initComponents();
        setSize(800, 700);
        setLocationRelativeTo(parent);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbProjectName = new javax.swing.JLabel();
        lbOverView = new javax.swing.JLabel();
        lbDescription = new javax.swing.JLabel();
        lbObjetive = new javax.swing.JLabel();
        lbMaximumTime = new javax.swing.JLabel();
        lbEstimatedBudge = new javax.swing.JLabel();
        lbEstimatedDeliveryDate = new javax.swing.JLabel();
        txtTitle = new javax.swing.JLabel();
        txtNameProyect = new gotaAguaTexto("project name");
        txtOverView = new gotaAguaTexto("overView");
        txtDescription = new gotaAguaTexto("description");
        txtObjetivo = new gotaAguaTexto("objective");
        txtMaximumTime = new gotaAguaTexto("maximum time");
        txtEstimatedBudge = new gotaAguaTexto("estimated budget");
        txteEstimatedDeliveryDate = new gotaAguaTexto("estimated delivery date");
        btnRegistrarProyecto = new javax.swing.JButton();
        lbWarningProjectName = new javax.swing.JLabel();
        lbWarningDescription = new javax.swing.JLabel();
        lbWarningOverView = new javax.swing.JLabel();
        lbWarningObjetive = new javax.swing.JLabel();
        lbWarningMaximumTime = new javax.swing.JLabel();
        lbWarningEstimatedBudge = new javax.swing.JLabel();
        lbWarningEstimatedDeliveryDate = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(897, 509));
        setSize(new java.awt.Dimension(897, 509));
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        lbProjectName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbProjectName.setForeground(new java.awt.Color(112, 112, 112));
        lbProjectName.setText("Nombre del proyecto");

        lbOverView.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbOverView.setForeground(new java.awt.Color(112, 112, 112));
        lbOverView.setText("Resumen");

        lbDescription.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbDescription.setForeground(new java.awt.Color(112, 112, 112));
        lbDescription.setText("Descripción del proyecto");

        lbObjetive.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbObjetive.setForeground(new java.awt.Color(112, 112, 112));
        lbObjetive.setText("Objetivo principal");

        lbMaximumTime.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbMaximumTime.setForeground(new java.awt.Color(112, 112, 112));
        lbMaximumTime.setText("Tiempo maximo");

        lbEstimatedBudge.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbEstimatedBudge.setForeground(new java.awt.Color(112, 112, 112));
        lbEstimatedBudge.setText("Presupuesto estimado");

        lbEstimatedDeliveryDate.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbEstimatedDeliveryDate.setForeground(new java.awt.Color(112, 112, 112));
        lbEstimatedDeliveryDate.setText("Fecha de entrega esperada");

        txtTitle.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(112, 112, 112));
        txtTitle.setText("Registrar nuevo proyecto");

        txtNameProyect.setText("project name");
        txtNameProyect.setActionCommand("<Not Set>");
        txtNameProyect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameProyectActionPerformed(evt);
            }
        });

        txtOverView.setText("overView");

        txtDescription.setText("description");

        txtObjetivo.setText("objective");
        txtObjetivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObjetivoActionPerformed(evt);
            }
        });

        txtMaximumTime.setText("maximum time");

        txtEstimatedBudge.setText("estimated budget");

        txteEstimatedDeliveryDate.setText("estimated delivery date");

        btnRegistrarProyecto.setBackground(new java.awt.Color(9, 33, 103));
        btnRegistrarProyecto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistrarProyecto.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarProyecto.setText("Registrar");
        btnRegistrarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProyectoActionPerformed(evt);
            }
        });

        lbWarningProjectName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbWarningProjectName.setForeground(new java.awt.Color(255, 51, 51));
        lbWarningProjectName.setText("*");
        lbWarningProjectName.setFocusable(false);

        lbWarningDescription.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbWarningDescription.setForeground(new java.awt.Color(255, 51, 51));
        lbWarningDescription.setText("*");

        lbWarningOverView.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbWarningOverView.setForeground(new java.awt.Color(255, 51, 51));
        lbWarningOverView.setText("*");

        lbWarningObjetive.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbWarningObjetive.setForeground(new java.awt.Color(255, 51, 51));
        lbWarningObjetive.setText("*");

        lbWarningMaximumTime.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbWarningMaximumTime.setForeground(new java.awt.Color(255, 51, 51));
        lbWarningMaximumTime.setText("*");

        lbWarningEstimatedBudge.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbWarningEstimatedBudge.setForeground(new java.awt.Color(255, 51, 51));
        lbWarningEstimatedBudge.setText("*");

        lbWarningEstimatedDeliveryDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbWarningEstimatedDeliveryDate.setForeground(new java.awt.Color(255, 51, 51));
        lbWarningEstimatedDeliveryDate.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbEstimatedDeliveryDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(lbWarningEstimatedDeliveryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbEstimatedBudge)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbWarningEstimatedBudge, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbMaximumTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbWarningMaximumTime, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbObjetive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbWarningObjetive, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbProjectName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbWarningProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbOverView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbWarningOverView, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbWarningDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtEstimatedBudge, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaximumTime, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtObjetivo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescription, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOverView, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNameProyect, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txteEstimatedDeliveryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrarProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTitle)
                    .addComponent(btnRegistrarProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbProjectName)
                        .addGap(60, 60, 60)
                        .addComponent(lbOverView)
                        .addGap(55, 55, 55)
                        .addComponent(lbDescription)
                        .addGap(55, 55, 55)
                        .addComponent(lbObjetive)
                        .addGap(55, 55, 55)
                        .addComponent(lbMaximumTime)
                        .addGap(55, 55, 55)
                        .addComponent(lbEstimatedBudge)
                        .addGap(50, 50, 50)
                        .addComponent(lbEstimatedDeliveryDate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtOverView, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbWarningOverView))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNameProyect, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbWarningProjectName))
                                .addGap(75, 75, 75)))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbWarningDescription))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtObjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbWarningObjetive))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaximumTime, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbWarningMaximumTime))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEstimatedBudge, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbWarningEstimatedBudge))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txteEstimatedDeliveryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbWarningEstimatedDeliveryDate))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProyectoActionPerformed
        limpiarWarnings();
        String nombre = txtNameProyect.getText().trim();
        String resumen = txtOverView.getText().trim();
        String descripcion = txtDescription.getText().trim();
        String objetivo = txtObjetivo.getText().trim();
        String tiempoMaximo = txtMaximumTime.getText().trim();
        String presupuesto = txtEstimatedBudge.getText().trim();
        String fechaEntregaEsperada = txteEstimatedDeliveryDate.getText().trim();
        boolean validacion = validarCamposVacios(nombre, resumen, descripcion, objetivo, tiempoMaximo, presupuesto, fechaEntregaEsperada);
            
        if (validacion) {
            Project project = new Project(nombre,resumen,descripcion,objetivo,tiempoMaximo,presupuesto,fechaEntregaEsperada,nit);
            if (projectService.saveProject(project)) {
                if (listener != null) {
                    listener.onEventTriggered(); // Notificamos al primer frame
                }
                Messages.showMessageDialog("Agregado correctamente", "Atención");
                this.dispose();
            } else {
                Messages.showMessageDialog("No se agrego el proyecto", "Atención");
            }
        }
    }//GEN-LAST:event_btnRegistrarProyectoActionPerformed
    private boolean validarCamposVacios(String nombre, String resumen, String descripcion, String objetivo, String tiempoMaximo, String presupuesto, String fechaEntregaEsperada) {
        if (nombre.isEmpty() || nombre.equalsIgnoreCase("project name")) {
            Messages.showMessageDialog("Debe agregar el nombre del proyecto", "Atención");
            txtNameProyect.requestFocus();
            mostrarAdv(lbWarningProjectName);
            return false;
        }
        if (resumen.isEmpty() || resumen.equalsIgnoreCase("overView")) {
            Messages.showMessageDialog("Debe agregar un resumen", "Atención");
            txtOverView.requestFocus();
            mostrarAdv(lbWarningOverView);
            return false;
        }
        if (descripcion.isEmpty() || descripcion.equalsIgnoreCase("description")) {
            Messages.showMessageDialog("Debe agregar una descripción del proyecto", "Atención");
            txtDescription.requestFocus();
            mostrarAdv(lbWarningDescription);
            return false;
        }
        if (objetivo.isEmpty() || objetivo.equalsIgnoreCase("objective")) {
            Messages.showMessageDialog("Debe agregar un objetivo principal", "Atención");
            txtObjetivo.requestFocus();
            mostrarAdv(lbWarningObjetive);
            return false;
        }
        if (tiempoMaximo.isEmpty() || tiempoMaximo.equalsIgnoreCase("maximum time")) {
            Messages.showMessageDialog("Debe especificar el tiempo máximo", "Atención");
            txtMaximumTime.requestFocus();
            mostrarAdv(lbWarningMaximumTime);
            return false;
        }
        if (presupuesto.isEmpty() || presupuesto.equalsIgnoreCase("estimated budget")) {
            Messages.showMessageDialog("Debe agregar el presupuesto estimado", "Atención");
            txtEstimatedBudge.requestFocus();
            mostrarAdv(lbWarningEstimatedBudge);
            return false;
        }
        if (fechaEntregaEsperada.isEmpty() || fechaEntregaEsperada.equalsIgnoreCase("estimated delivery date")) {
            Messages.showMessageDialog("Debe agregar la fecha de entrega esperada", "Atención");
            txteEstimatedDeliveryDate.requestFocus();
            mostrarAdv(lbWarningEstimatedDeliveryDate);
            return false;
        }

        return true;

    }

    private void mostrarAdv(JLabel lb) {
        lb.setText("*"); // Color rojo para mayor visibilidad
        lb.setVisible(true);

    }

    private void limpiarWarnings() {
        lbWarningProjectName.setText("");
        lbWarningOverView.setText("");
        lbWarningDescription.setText("");
        lbWarningObjetive.setText("");
        lbWarningMaximumTime.setText("");
        lbWarningEstimatedBudge.setText("");
        lbWarningEstimatedDeliveryDate.setText("");
    }
    private void txtNameProyectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameProyectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameProyectActionPerformed

    private void txtObjetivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObjetivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObjetivoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarProyecto;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbDescription;
    private javax.swing.JLabel lbEstimatedBudge;
    private javax.swing.JLabel lbEstimatedDeliveryDate;
    private javax.swing.JLabel lbMaximumTime;
    private javax.swing.JLabel lbObjetive;
    private javax.swing.JLabel lbOverView;
    private javax.swing.JLabel lbProjectName;
    private javax.swing.JLabel lbWarningDescription;
    private javax.swing.JLabel lbWarningEstimatedBudge;
    private javax.swing.JLabel lbWarningEstimatedDeliveryDate;
    private javax.swing.JLabel lbWarningMaximumTime;
    private javax.swing.JLabel lbWarningObjetive;
    private javax.swing.JLabel lbWarningOverView;
    private javax.swing.JLabel lbWarningProjectName;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtEstimatedBudge;
    private javax.swing.JTextField txtMaximumTime;
    private javax.swing.JTextField txtNameProyect;
    private javax.swing.JTextField txtObjetivo;
    private javax.swing.JTextField txtOverView;
    private javax.swing.JLabel txtTitle;
    private javax.swing.JTextField txteEstimatedDeliveryDate;
    // End of variables declaration//GEN-END:variables
}
