/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PermisosUsuarios;

import Conexion.DAO;
import static Decoracion.CentrarInternal.Centrar;
import static Medicos.FrameMedicos.IdModificar;
import MenuSistema.SistemaPrincipal;
import Pojo.Medico;
import Validaciones.procesamientoImagenes;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.TreeSelectionModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author crdzbird
 */
public class AsignacionPermisos extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public void InicializarTabla() {
        dtm.addColumn("Id");
        dtm.addColumn("Nombre Completo");
        dtm.addColumn("Cedula");
        dtm.addColumn("Direccion");
        dtm.addColumn("Usuario");
        dtm.addColumn("Estado");
        jTable1.setModel(dtm);
        llenartabla();
    }

    public void llenartabla() {
        limpiar();
        DAO d = new DAO(sf);
        List<Medico> listaMedicos = DAO.Listar_Medicos();
        if (listaMedicos.isEmpty()) {
            System.out.println("Lista Vacia");
            return;
        } else {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            for (Medico medico : listaMedicos) {
                if (medico.isEstado()) {
                    EstadoMedico = "Activo";
                } else {
                    EstadoMedico = "Inactivo";
                }
                cmbId.addItem(medico.getIdMedico());
                modelo.addRow(new Object[]{medico.getIdMedico(), medico.getPrimernombre() + " " + medico.getSegundonombre() + " " + medico.getPrimerapellido() + " " + medico.getSegundoapellido(), medico.getCedula(), medico.getDireccion(), medico.getUsuario(), EstadoMedico});
            }
            jTable1.setModel(modelo);
        }
    }

    public void limpiar() {
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Id", "Nombre Completo", "Cedula", "Direccion", "Usuario", "Estado"}
        ) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

        });
    }

    Session s;
    SessionFactory sf;

    public BufferedImage imagenMedico;
    Date fecha;
    public boolean estado;
    public static int IdModificar;
    private byte[] arregloImagenCamara;
    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;
    private int returnStatus = RET_CANCEL;
    String NombreUsuario, NombreCompleto, EstadoMedico;
    int IdMedicoSeleccionado;
    SistemaPrincipal mdi;

    public AsignacionPermisos(SessionFactory sf, SistemaPrincipal mdi) {
        initComponents();
        this.sf = sf;
        this.mdi = mdi;
        InicializarTabla();
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void VaciarCampos() {
        txtCedula.setText(null);
        txtDireccion.setText(null);
        txtEspecialidad.setText(null);
        txtEstado.setText(null);
        txtNombre.setText(null);
        txtUsuario.setText(null);
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
        cmbId = new javax.swing.JComboBox();
        btnPermisos = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JFormattedTextField();
        txtDireccion = new javax.swing.JTextField();
        txtEspecialidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Asignacion de Permisos");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione un medico"));

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(4, 4, 4))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );

        btnPermisos.setText("Permisos");
        btnPermisos.setEnabled(false);
        btnPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermisosActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario"));

        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setText("No hay fotografia");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel2.setText("Nombre Usuario:");

        jLabel3.setText("Nombre:");

        jLabel7.setText("Cedula:");

        jLabel8.setText("Direccion");

        jLabel4.setText("Especialidad:");

        txtUsuario.setEditable(false);
        txtUsuario.setEnabled(false);

        txtNombre.setEditable(false);
        txtNombre.setEnabled(false);

        txtCedula.setEditable(false);
        try {
            txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-######-####U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula.setEnabled(false);

        txtDireccion.setEditable(false);
        txtDireccion.setEnabled(false);

        txtEspecialidad.setEditable(false);
        txtEspecialidad.setEnabled(false);

        jLabel5.setText("Estado:");

        txtEstado.setEditable(false);
        txtEstado.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(251, 251, 251))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEspecialidad)
                                    .addComponent(txtDireccion)
                                    .addComponent(txtEstado)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsuario)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(cmbId, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbId, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPermisos, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermisosActionPerformed
        // TODO add your handling code here:
        if (txtEstado.getText().equals("Activo")) {
            EleccionPermisos ep = new EleccionPermisos(IdMedicoSeleccionado, txtUsuario.getText(), txtNombre.getText(),sf);
            Centrar(ep,this.getDesktopPane());
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un medico activo", "Medico Inactivo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPermisosActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        btnPermisos.setEnabled(true);
        int fila = this.jTable1.getSelectedRow();
        IdMedicoSeleccionado = Integer.parseInt(jTable1.getValueAt(fila, 0).toString());
        txtUsuario.setText(jTable1.getValueAt(fila, 4).toString());
        txtNombre.setText(jTable1.getValueAt(fila, 1).toString());
        txtCedula.setText(jTable1.getValueAt(fila, 2).toString());
        txtDireccion.setText(jTable1.getValueAt(fila, 3).toString());
        txtEstado.setText(jTable1.getValueAt(fila, 5).toString());
        s = sf.openSession();
        List<Medico> lstMedicos = (List<Medico>) s.createQuery("from Medico").list();
        for (Medico medico : lstMedicos) {
            if (medico.getIdMedico().equals(IdMedicoSeleccionado)) {
                txtEspecialidad.setText(medico.getEspecialidad().getNombreEspecialidad());
                if (medico.getFoto() != null) {
                    try {
                        int height = lblImagen.getHeight();
                        int width = lblImagen.getWidth();
                        BufferedImage imag = ImageIO.read(new ByteArrayInputStream(medico.getFoto()));
                        procesamientoImagenes pi = new procesamientoImagenes();
                        this.imagenMedico = imag;
                        this.lblImagen.setIcon((pi.imageToIcon(pi.imageToBufferedImage(imag).getScaledInstance(width, height, 0))));
                        this.lblImagen.setText(null);
                    } catch (Exception ex) {
                        System.out.println("ERROR: " + ex.getMessage() + " CAUSA: " + ex.getCause());
                    }
                }
                s.close();
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        try {
            setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AsignacionPermisos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPermisos;
    private javax.swing.JComboBox cmbId;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEspecialidad;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}