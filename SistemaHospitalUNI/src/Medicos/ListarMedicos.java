/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicos;

import Conexion.DAO;
import Pojo.Medico;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.TreeSelectionModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;

/**
 *
 * @author crdzbird
 */
public class ListarMedicos extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    Session session;
    SessionFactory sf;
    public int IdMedico;

    public void InicializarTabla() {
        dtm.addColumn("Id");
        dtm.addColumn("Nombre Completo");
        dtm.addColumn("Cedula");
        dtm.addColumn("Usuario");
        dtm.addColumn("Estado");
        jTable1.setModel(dtm);
        llenartabla();
    }

    public void limpiar() {
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Id", "Nombre Completo", "Cedula", "Usuario", "Estado"}
        ) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

        });
    }

    public void MostrarActivosInactivos(boolean estado) {
        String est;
        limpiar();
        DAO d = new DAO(sf);
        List<Medico> listaMedicos = DAO.Listar_Medicos();
        if (listaMedicos.isEmpty()) {
            System.out.println("Lista Vacia");
            return;
        } else {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            for (Medico medico : listaMedicos) {
                if (medico.isEstado() == true) {
                    est = "Activo";
                } else {
                    est = "Inactivo";
                }
                if (medico.isEstado() == estado) {
                    modelo.addRow(new Object[]{medico.getIdMedico(), medico.getPrimernombre() + " " + medico.getSegundonombre() + medico.getPrimerapellido() + " " + medico.getSegundoapellido(), medico.getCedula(), medico.getUsuario(), est});
                }
            }
            jTable1.setModel(modelo);
        }
    }

    public void BuscarId(String Nombre) {
        String est;
        limpiar();
        DAO d = new DAO(sf);
        List<Medico> listaMedicos = DAO.Listar_Medicos();
        if (listaMedicos.isEmpty()) {
            System.out.println("Lista Vacia");
            return;
        } else {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            for (Medico medico : listaMedicos) {
                if (medico.isEstado() == true) {
                    est = "Activo";
                } else {
                    est = "Inactivo";
                }
                if (String.valueOf(medico.getIdMedico()).equalsIgnoreCase(Nombre)) {
                    modelo.addRow(new Object[]{medico.getIdMedico(), medico.getPrimernombre() + " " + medico.getSegundonombre() + medico.getPrimerapellido() + " " + medico.getSegundoapellido(), medico.getCedula(), medico.getUsuario(), est});
                }
            }
            jTable1.setModel(modelo);
        }
    }

    public void BuscarCedula(String criteriaCedula) {
        String est;
        limpiar();
        DAO d = new DAO(sf);
        List<Medico> listaMedicos = DAO.Listar_Medicos();
        if (listaMedicos.isEmpty()) {
            System.out.println("Lista Vacia");
            return;
        } else {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            for (Medico medico : listaMedicos) {
                if (medico.isEstado() == true) {
                    est = "Activo";
                } else {
                    est = "Inactivo";
                }
                if (String.valueOf(medico.getCedula()).equalsIgnoreCase(criteriaCedula)) {
                    modelo.addRow(new Object[]{medico.getIdMedico(), medico.getPrimernombre() + " " + medico.getSegundonombre() + medico.getPrimerapellido() + " " + medico.getSegundoapellido(), medico.getCedula(), medico.getUsuario(), est});
                }
            }
            jTable1.setModel(modelo);
        }
    }

    public void BuscarUsuario(String criteriaCedula) {
        String est;
        limpiar();
        DAO d = new DAO(sf);
        List<Medico> listaMedicos = DAO.Listar_Medicos();
        if (listaMedicos.isEmpty()) {
            System.out.println("Lista Vacia");
            return;
        } else {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            for (Medico medico : listaMedicos) {
                if (medico.isEstado() == true) {
                    est = "Activo";
                } else {
                    est = "Inactivo";
                }
                if (String.valueOf(medico.getUsuario()).equalsIgnoreCase(criteriaCedula)) {
                    modelo.addRow(new Object[]{medico.getIdMedico(), medico.getPrimernombre() + " " + medico.getSegundonombre() + medico.getPrimerapellido() + " " + medico.getSegundoapellido(), medico.getCedula(), medico.getUsuario(), est});
                }
            }
            jTable1.setModel(modelo);
        }
    }
    
    public void BuscarNombre(String idCriteria) {
        String est;
        limpiar();
        DAO d = new DAO(sf);
        List<Medico> listaMedicos = DAO.Listar_Medicos();
        if (listaMedicos.isEmpty()) {
            System.out.println("Lista Vacia");
            return;
        } else {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            for (Medico medico : listaMedicos) {
                if (medico.isEstado() == true) {
                    est = "Activo";
                } else {
                    est = "Inactivo";
                }
                if (String.valueOf(medico.getPrimernombre()).equalsIgnoreCase(idCriteria)) {
                    modelo.addRow(new Object[]{medico.getIdMedico(), medico.getPrimernombre() + " " + medico.getSegundonombre() + medico.getPrimerapellido() + " " + medico.getSegundoapellido(), medico.getCedula(), medico.getUsuario(), est});
                }
            }
            jTable1.setModel(modelo);
        }
    }

    public void llenartabla() {
        String est;
        limpiar();
        DAO d = new DAO(sf);
        List<Medico> listaMedicos = DAO.Listar_Medicos();
        if (listaMedicos.isEmpty()) {
            System.out.println("Lista Vacia");
            return;
        } else {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            for (Medico medico : listaMedicos) {
                if (medico.isEstado() == true) {
                    est = "Activo";
                } else {
                    est = "Inactivo";
                }
                modelo.addRow(new Object[]{medico.getIdMedico(), medico.getPrimernombre() + " " + medico.getSegundonombre() + medico.getPrimerapellido() + " " + medico.getSegundoapellido(), medico.getCedula(), medico.getUsuario(), est});
            }
            jTable1.setModel(modelo);
        }
    }

    public ListarMedicos(SessionFactory sf) {
        initComponents();
        this.sf = sf;
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        CbxMostrar = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        CbxBuscar = new javax.swing.JComboBox();
        Buscar = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnReporteMedico = new javax.swing.JButton();
        btnReporteGeneral = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Buscador Medicos");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jLabel9.setForeground(new java.awt.Color(1, 1, 1));
        jLabel9.setText("Tipo de Muestreo:");

        CbxMostrar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mostrar Todo", "Mostrar Activos", "Mostrar Inactivos" }));

        jLabel11.setForeground(new java.awt.Color(1, 1, 1));
        jLabel11.setText("Buscar por:");

        CbxBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id", "Primer Nombre", "Cédula", "Usuario" }));

        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarKeyReleased(evt);
            }
        });

        btnMostrar.setText("Aceptar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CbxBuscar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CbxMostrar, 0, 187, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(392, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addGap(284, 284, 284))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrar)
                    .addComponent(CbxMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        btnReporteMedico.setText("Reporte de Medico");
        btnReporteMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteMedicoActionPerformed(evt);
            }
        });

        btnReporteGeneral.setText("Reporte Total");
        btnReporteGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteGeneralActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReporteMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addGap(126, 126, 126)
                .addComponent(btnReporteGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addGap(133, 133, 133)
                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReporteMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReporteGeneral, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        //llenartabla();
        try {
            setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ListarMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        btnReporteMedico.setEnabled(true);
        int fila = this.jTable1.getSelectedRow();
        IdMedico = Integer.parseInt(jTable1.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnReporteMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteMedicoActionPerformed
        // TODO add your handling code here:
        JasperReport jr = null;
        Connection con = null;
        SessionFactoryImplementor SFI = null;

        this.session = sf.openSession();
        SFI = (SessionFactoryImplementor) session.getSessionFactory();

        String ruta = "/home/crdzbird/NetBeansProjects/GitHub/ProgramaFinal/ProgramaHospitalUNI/SistemaHospitalUNI/src/Reportes/reportMedicoUnico.jasper";

        try {
            con = (Connection) SFI.getConnectionProvider().getConnection();
        } catch (SQLException ex) {
            return;
        }

        try {
            Map parametro = new HashMap();
            parametro.put("ParametroID", IdMedico);
            jr = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Reporte de Medico General");
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (Exception ex) {
            System.out.println("ERROR EN CREACION DE REPORTE: " + ex.getMessage() + " CAUSA DEL ERROR: " + ex.getCause());
        }
    }//GEN-LAST:event_btnReporteMedicoActionPerformed

    private void btnReporteGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteGeneralActionPerformed
        // TODO add your handling code here:
        String ruta = "/home/crdzbird/NetBeansProjects/GitHub/ProgramaFinal/ProgramaHospitalUNI/SistemaHospitalUNI/src/Reportes/reporteGlobalMedicos.jasper";
        JasperReport jr = null;
        Connection con = null;
        SessionFactoryImplementor SFI = null;

        this.session = sf.openSession();
        SFI = (SessionFactoryImplementor) session.getSessionFactory();

        try {
            con = (Connection) SFI.getConnectionProvider().getConnection();
        } catch (SQLException ex) {
            return;
        }
        try {
            Map parametro = new HashMap();
            jr = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Reporte de Medico General");
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }//GEN-LAST:event_btnReporteGeneralActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarActionPerformed

    private void BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarKeyReleased
        this.btnReporteGeneral.setEnabled(true);
        String texto = Buscar.getText();
        if (texto.trim().equals("")) {
            this.llenartabla();
            return;
        }
        switch (CbxBuscar.getSelectedIndex() + 1) {
            case 1: {
                this.BuscarId(texto);
                break;
            }
            case 2: {
                this.BuscarNombre(texto);
                break;
            }
            case 3: {
                this.BuscarCedula(texto);
                break;
            }
            case 4: {
                this.BuscarUsuario(texto);
                break;
            }
        }
    }//GEN-LAST:event_BuscarKeyReleased

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        this.btnReporteGeneral.setEnabled(true);
        switch (CbxMostrar.getSelectedIndex() + 1) {
            case 1: {
                this.llenartabla();
                break;
            }
            case 2: {
                MostrarActivosInactivos(true);
                break;
            }
            case 3: {
                MostrarActivosInactivos(false);
                break;
            }
        }
    }//GEN-LAST:event_btnMostrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscar;
    private javax.swing.JComboBox CbxBuscar;
    public javax.swing.JComboBox CbxMostrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnReporteGeneral;
    private javax.swing.JButton btnReporteMedico;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
