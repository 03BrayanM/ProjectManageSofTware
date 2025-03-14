/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.unicauca.view;

import co.edu.unicauca.access.Factory;
import co.edu.unicauca.domain.entities.Project;
import co.edu.unicauca.domain.entities.User;
import co.edu.unicauca.domain.services.ProjectService;
import co.edu.unicauca.domain.services.UserService;
import co.edu.unicauca.infra.Subject;
import co.edu.unicauca.interfaces.IFrameFactory;
import co.edu.unicauca.interfaces.IProjectObserver;
import co.edu.unicauca.interfaces.IRepository;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brayan
 */
public class GUIGestionSofwareCoordination extends javax.swing.JFrame implements IProjectObserver {

    ProjectService projectService;
    User usuario;
    public GUIGestionSofwareCoordination(ProjectService projectService, User usuario) {

        initComponents();
        agregarEventos();
        this.projectService = projectService;
        Subject.getInstance().agregarObservador(this);
        this.usuario = usuario;
        actualizarTablaP(projectService.obtenerProyectos());
        configurarEventosTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnRegistrarEmpresa = new javax.swing.JButton();
        btnGestionarProyecto = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblProyectos = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblProyectosregistrados = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtnombrecordinador = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel11.setText("Empresas registradas en el periodo 2025.1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.CardLayout());

        jPanel5.setBackground(new java.awt.Color(247, 247, 247));

        jButton1.setBackground(new java.awt.Color(223, 224, 226));
        jButton1.setText("Registrar Estudiante");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnRegistrarEmpresa.setBackground(new java.awt.Color(223, 224, 226));
        btnRegistrarEmpresa.setText("Registrar Empresa");

        btnGestionarProyecto.setBackground(new java.awt.Color(223, 224, 226));
        btnGestionarProyecto.setText("Gestionar proyecto");

        btnSalir.setBackground(new java.awt.Color(223, 224, 226));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("            Gestion de Proyectos Sofware Academicos de ingenieria de sistemas");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel7.setText("Empresas");

        jLabel8.setText("Estudiantes");

        lblProyectos.setText("Proyectos");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addGap(49, 49, 49)
                .addComponent(jLabel8)
                .addGap(61, 61, 61)
                .addComponent(lblProyectos)
                .addContainerGap(337, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(lblProyectos))
                .addContainerGap())
        );

        jLabel10.setText("Opciones");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Empresa", "Fecha de Entrega", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        lblProyectosregistrados.setText("Proyectos registrados");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProyectosregistrados, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lblProyectosregistrados)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 204));
        jLabel13.setText("Coordinador de sistema");

        txtnombrecordinador.setBackground(new java.awt.Color(247, 247, 247));
        txtnombrecordinador.setBorder(null);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(59, 59, 59))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegistrarEmpresa))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGestionarProyecto)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(54, 54, 54)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtnombrecordinador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(58, 58, 58))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombrecordinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jButton1)
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnRegistrarEmpresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGestionarProyecto)
                        .addGap(9, 9, 9)
                        .addComponent(btnSalir))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, "card5");
        jPanel4.add(jLabel4, "card3");

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtnombrecordinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombrecordinadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombrecordinadorActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
        IRepository userRepository = Factory.getInstance().getRepository("usuario");
        UserService service = new UserService(userRepository);
        IFrameFactory frameFactory = new FrameFactory();
        GUILogin instance = new GUILogin(service, frameFactory);
        instance.setExtendedState(JFrame.NORMAL);
        instance.setSize(450, 380); // Ajusta el tamaño a 600x400 píxeles
        instance.setLocationRelativeTo(null); // Centrar en pantalla
        instance.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGestionarProyecto;
    private javax.swing.JButton btnRegistrarEmpresa;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblProyectos;
    private javax.swing.JLabel lblProyectosregistrados;
    private javax.swing.JTextField txtnombrecordinador;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizarProyectos(List<Project> proyectos) {
        actualizarTablaP(proyectos);
    }

    private void agregarEventos() {
        lblProyectos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                actualizarTablaP(projectService.obtenerProyectos());
            }

        });
    }

    private void actualizarTablaP(List<Project> proyectos) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpiar la tabla
        model.setColumnIdentifiers(new String[]{"Título", "Empresa", "Fecha Entrega", "Estado"}); // Definir columnas

        if (proyectos == null || proyectos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No existen proyectos registrados.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return; // Salir del método para no procesar datos vacíos
        }
        for (Project p : proyectos) {

            int meses = 0;
            try {
                meses = Integer.parseInt(p.getTiempoMaximo());
            } catch (NumberFormatException e) {
                // Puedes asignar un valor predeterminado o registrar el error
                meses = 0;
            }
            LocalDate fechaEntrega = LocalDate.now().plusMonths(meses);
            model.addRow(new Object[]{
                p.getNombre(),
                p.getNombreEmpresa(),
                fechaEntrega.toString(),
                p.getEstado()
            });
        }
    }

    private void configurarEventosTabla() {
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                manejarSeleccionProyecto();
            }
        });
    }

    private void manejarSeleccionProyecto() {

        int filaSeleccionada = jTable1.getSelectedRow();
        Project proyectoSeleccionado = null;
        if (filaSeleccionada != -1) {
            Object valorCelda = jTable1.getValueAt(filaSeleccionada, 0);
            System.out.println("Tipo de valor en la celda: " + valorCelda.getClass().getName());
            String titulo = "";

            if (valorCelda instanceof Project) {
                titulo = ((Project) valorCelda).getNombre(); // Extrae el nombre correctamente
            } else if (valorCelda instanceof String) {
                titulo = (String) valorCelda; // Si ya es un String, lo usa directamente
            } else {
                JOptionPane.showMessageDialog(null, "Error: El valor seleccionado no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Evita continuar si hay un error
            }

            Project proyectoBusqueda = new Project();
            proyectoBusqueda.setNombre(titulo);
            System.out.println("Buscando proyecto con nombre: " + titulo);
            proyectoSeleccionado = (Project) projectService.buscarProyectoPorNombre(proyectoBusqueda);

            if (proyectoSeleccionado != null) {
                System.out.println("Proyecto encontrado: " + proyectoSeleccionado.getNombre());
                abrirGUICoordinadorProject(proyectoSeleccionado);

            } else {
                JOptionPane.showMessageDialog(null, "Error: No se encontro ningun proyecto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void abrirGUICoordinador() {
        // Obtener el repositorio de proyectos desde la fábrica
        IRepository projectRepository = Factory.getInstance().getRepository("project");

        // Crear el servicio de proyectos con su repositorio
        ProjectService projectService = new ProjectService(projectRepository);

        // Instanciar la GUI del coordinador y mostrarla
        GUIGestionSofwareCoordination instance = new GUIGestionSofwareCoordination(projectService, usuario);
        instance.setExtendedState(JFrame.NORMAL);
        instance.setVisible(true);
    }

    private void abrirGUICoordinadorProject(Project p) {
        // Obtener el repositorio de proyectos desde la fábrica
        IRepository projectRepository = Factory.getInstance().getRepository("project");

        // Crear el servicio de proyectos con su repositorio
        ProjectService projectService = new ProjectService(projectRepository);

        // Instanciar la GUI del coordinador y mostrarla
        GUIGestionSofwareCoordinationProject instance = new GUIGestionSofwareCoordinationProject(projectService, p);
        instance.setExtendedState(JFrame.NORMAL);
        instance.setVisible(true);
    }

}
