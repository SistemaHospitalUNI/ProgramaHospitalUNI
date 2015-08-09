/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalFrames;

import Conexion.DAO;
import Pojo.*;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author HOME
 */
public class VerFacturas extends javax.swing.JInternalFrame {

    /**
     * Creates new form VerFacturas
     */
    SessionFactory sf;
    public VerFacturas(SessionFactory s) {
        initComponents();
        sf = s;
        DefaultTableModel dft = new DefaultTableModel();
        dft.addColumn("Numero de Factura");
        dft.addColumn("Fecha");
        dft.addColumn("Total");
        dft.addColumn("Pago");
        dft.addColumn("Cambio");
        dft.addColumn("Paciente nombre");
        dft.addColumn("Paciente apellido");
        dft.addColumn("Cajero nombre");
        dft.addColumn("Cajero apellido");
        
        DAO d = new DAO(sf);
        List<FacturaExamen> listafe = d.ListarFacturaExamen();
        List<FacturaConsulta> listafc = d.ListarFacturaConsulta();
        List<Paciente> listap = d.Listar_Pacientes();
        List<Pojo.Cajero> listac = d.Listar_Cajero();
        
        for(FacturaExamen fe : listafe){
        for(Pojo.Cajero c : listac){
        if(c.getIdCajero() == fe.getCajero().getIdCajero()){
        for(Pojo.Paciente p : listap){
        if(p.getIdPaciente() == fe.getPaciente().getIdPaciente()){
        String fila []= {String.valueOf(fe.getNumfactura()),String.valueOf( fe.getFecha()),String.valueOf(fe.getTotal()), String.valueOf(fe.getPago()),String.valueOf(fe.getCambio()), p.getNombre(), p.getApellido(),c.getNombre(),c.getApellido()};
        dft.addRow(fila);
        }
        }
        }
        }
        }
        
        this.jTable1.setModel(dft);
        
//        Session se =sf.openSession();
//        String query = "Select * from VerFacturas";
//        Query q = se.createSQLQuery(query);
//        List lista =q.list();
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
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setTitle("Facturas");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1436254886_Search.png"))); // NOI18N
        jButton2.setText("Buscar Por:");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jRadioButton1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jRadioButton1.setText("Paciente");

        jRadioButton2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jRadioButton2.setText("Cajero");

        jRadioButton3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jRadioButton3.setText("Fecha");
        jRadioButton3.setToolTipText("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jButton2)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2))
                    .addComponent(jRadioButton3))
                .addGap(24, 24, 24)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3))
                    .addComponent(jButton2)))
        );

        getContentPane().add(jPanel1);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jTable1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}