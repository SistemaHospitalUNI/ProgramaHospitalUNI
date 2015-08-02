/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Horario;

import Conexion.DAO;
import Pojo.DiasMedico;
import Pojo.Especialidad;
import Pojo.HorarioMedico;
import Pojo.Medico;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author crdzbird
 */
public class FrameHorario extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form FrameHorario
     */
    SessionFactory sf;
    Session s;

    public FrameHorario(SessionFactory sf) {
        initComponents();
        this.sf = sf;
        InicializarTabla();
        ListarTodoMedicoDia();
    }

    public void LlenarTabla() {
        DAO d = new DAO(sf);
    }

    public void InicializarTabla() {
        dtm.addColumn("Id");
        dtm.addColumn("Medico");
        dtm.addColumn("Hora Inicio");
        dtm.addColumn("Hora Final");
        jTable1.setModel(dtm);
    }

//    public void llenartabla() {
//        limpiar();
//        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
//        for (int i = 0; i < horas.length; i++) {
//            modelo.addRow(new Object[]{horas[i]});
//        }
//        jTable1.setModel(modelo);
//    }
    public void ListarTodoMedicoDia() {
        s = sf.openSession();
        List<Medico> lstMedico = (List<Medico>) s.createQuery("from Medico").list();
        for (Medico medico : lstMedico) {
            System.out.println("ID: " + medico.getDiasMedicos().size());
            ListarTodoDiaHorario(medico.getDiasMedicos().size());
        }
        s.close();
    }

    public void ListarTodoDiaHorario(int idDias) {
        s = sf.openSession();
        int idMedic;
        List<DiasMedico> lstDiasMedic = (List<DiasMedico>) s.createQuery("from DiasMedico").list();
        for (DiasMedico diaMedic : lstDiasMedic) {
            idMedic = diaMedic.getMedico().getIdMedico();
            System.out.println("MEDICO: " + diaMedic.getMedico().getPrimernombre());
            System.out.println("ID HORARIO: " + diaMedic.getHorarioMedicos().size());
            ListarTodoHorarioXMedicos(diaMedic.getHorarioMedicos().size());
        }
    }

    public void ListarTodoHorarioXMedicos(int idDiaMedico) {
        limpiar();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        s = sf.openSession();
        List<HorarioMedico> lstHorario = new ArrayList<>();
        List<HorarioMedico> lstHorarioMedico = (List<HorarioMedico>) s.createQuery("from HorarioMedico").list();
        for (HorarioMedico hMedico : lstHorarioMedico) {
            System.out.println("MEDICO: " + hMedico.getDiasMedico().getMedico().getPrimernombre() + " " + hMedico.getDiasMedico().getMedico().getPrimerapellido());
            System.out.println("HORA: " + hMedico.getHoraEntrada() + "   " + "HORA SALIDA: " + hMedico.getHoraSalida());
            modelo.addRow(new Object[]{hMedico.getDiasMedico().getMedico().getIdMedico(), hMedico.getDiasMedico().getMedico().getPrimernombre() + " " + hMedico.getDiasMedico().getMedico().getPrimerapellido(), hMedico.getHoraEntrada(), hMedico.getHoraSalida()});
        }
        jTable1.setModel(modelo);
    }

    public void limpiar() {
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Id", "Medico", "Hora Inicio", "Hora Final"}
        ) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

        });
    }

    public void ListarMedicoDia(String cedula) {
        s = sf.openSession();
        List<Medico> lstMedico = (List<Medico>) s.createQuery("from Medico").list();
        for (Medico medico : lstMedico) {
            if (medico.getCedula().equals(cedula)) {
                System.out.println("ID: " + medico.getDiasMedicos().size());
                ListarDiaHorario(medico.getDiasMedicos().size());

            }
        }
        s.close();
    }

    public void ListarDiaHorario(int idDias) {
        s = sf.openSession();
        int idMedic;
        List<DiasMedico> lstDiasMedic = (List<DiasMedico>) s.createQuery("from DiasMedico").list();
        for (DiasMedico diaMedic : lstDiasMedic) {
            idMedic = diaMedic.getMedico().getIdMedico();
            if (diaMedic.getIdDiaMedico().equals(idDias)) {
                System.out.println("MEDICO: " + diaMedic.getMedico().getPrimernombre());
                System.out.println("ID HORARIO: " + diaMedic.getHorarioMedicos().size());
                ListarHorarioXMedico(diaMedic.getHorarioMedicos().size());
            }
        }
    }

    public void ListarHorarioXMedico(int idDiaMedico) {
        limpiar();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        s = sf.openSession();
        List<HorarioMedico> lstHorario = new ArrayList<>();
        List<HorarioMedico> lstHorarioMedico = (List<HorarioMedico>) s.createQuery("from HorarioMedico").list();
        for (HorarioMedico hMedico : lstHorarioMedico) {
            if (hMedico.getIdHorariomedico().equals(idDiaMedico)) {
                System.out.println("MEDICO: " + hMedico.getDiasMedico().getMedico().getPrimernombre() + " " + hMedico.getDiasMedico().getMedico().getPrimerapellido());
                System.out.println("HORA: " + hMedico.getHoraEntrada() + "   " + "HORA SALIDA: " + hMedico.getHoraSalida());
                modelo.addRow(new Object[]{hMedico.getDiasMedico().getMedico().getIdMedico(), hMedico.getDiasMedico().getMedico().getPrimernombre() + " " + hMedico.getDiasMedico().getMedico().getPrimerapellido(), hMedico.getHoraEntrada(), hMedico.getHoraSalida()});

            }
        }
        jTable1.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Chequeo Horarios");
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

        jLabel1.setText("Eliga el Medico:");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setText("Investigar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 72, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        s = sf.openSession();

    }//GEN-LAST:event_jTextField1KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        s = sf.openSession();
        ListarMedicoDia(jTextField1.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        try {
            setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FrameHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
