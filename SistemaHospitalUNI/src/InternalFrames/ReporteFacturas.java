/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalFrames;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HOME
 */
public class ReporteFacturas extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReporteFacturas
     */
    public ReporteFacturas() {
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

        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Reporte Factura");

        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Factura Externa", "Factura Consulta" }));

        jTextField1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Fecha inicial");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Fecha final");

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1439029450_file_extension_pdf.png"))); // NOI18N
        jButton1.setText("Ver Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Formato yyyy-MM-dd HH:mm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if(this.jTextField1.getText().equals("") || this.jTextField2.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Digite la fecha inicial y final");
     
        }
        else{
        if(this.jComboBox1.getSelectedItem().equals("Factura Externa")){GenerarFacturaExterna();}
        if(this.jComboBox1.getSelectedItem().equals("Factura Consulta")){GenerarFacturaConsulta();}
        }
    }//GEN-LAST:event_jButton1ActionPerformed
private Connection getConnection() {
    Connection con = null;
      String url = "jdbc:mysql://localhost/sistemahospital";
      //  String url = "jdbc:mysql://127.0.0.1:3306/televisora?zeroDateTimeBehavior=convertToNull";
        try { 
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error");
        }
        
        try {
            con =  DriverManager.getConnection(url, "root", "rosseluni2015");
        } catch (SQLException ex) {
            System.out.println("Error");
        }
        
        return con;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private void GenerarFacturaExterna() {
    try {
             SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            java.util.Date fechai = formatoDelTexto.parse(this.jTextField1.getText());
            java.util.Date fechaf= formatoDelTexto.parse(this.jTextField2.getText());
            
            String ruta = "src\\Reportes\\Facturas.jasper";
            Map parametro = new HashMap();
            parametro.put("fechai",fechai);
            parametro.put("fechaf", fechaf);
            JasperPrint informe = JasperFillManager.fillReport(ruta,parametro,getConnection());
            JOptionPane.showMessageDialog(this,
                    "Esta acción puede durar unos minutos espere por favor","Cargando...",JOptionPane.WARNING_MESSAGE);
           
            JasperViewer ventana = new JasperViewer(informe,false);
            ventana.setTitle("Expediente");
            ventana.setVisible(true);
        } catch (JRException ex) {
                JOptionPane.showMessageDialog(this,"Error al generar REporte","Error",JOptionPane.ERROR_MESSAGE);
     
        } catch (ParseException ex) {
               JOptionPane.showMessageDialog(this,"Formato yyyy-MM-dd HH:mm","Error",JOptionPane.ERROR_MESSAGE);
     
        }
    }

    private void GenerarFacturaConsulta() {
    try {
             SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            java.util.Date fechai = formatoDelTexto.parse(this.jTextField1.getText());
            java.util.Date fechaf= formatoDelTexto.parse(this.jTextField2.getText());
            
            String ruta = "src\\Reportes\\Facturas.jasper";
            Map parametro = new HashMap();
            parametro.put("fechai",fechai);
            parametro.put("fechaf", fechaf);
            JasperPrint informe = JasperFillManager.fillReport(ruta,parametro,getConnection());
            JOptionPane.showMessageDialog(this,
                    "Esta acción puede durar unos minutos espere por favor","Cargando...",JOptionPane.WARNING_MESSAGE);
           
            JasperViewer ventana = new JasperViewer(informe,false);
            ventana.setTitle("Expediente");
            ventana.setVisible(true);
        } catch (JRException ex) {
                JOptionPane.showMessageDialog(this,"Error al generar REporte","Error",JOptionPane.ERROR_MESSAGE);
     
        } catch (ParseException ex) {
               JOptionPane.showMessageDialog(this,"Formato yyyy-MM-dd HH:mm","Error",JOptionPane.ERROR_MESSAGE);
     
        }}
}