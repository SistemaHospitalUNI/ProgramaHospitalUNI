/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicos;

import Camara.Camara;
import Conexion.DAO;
import Conexion.Usuarios;
import static Decoracion.CentrarInternal.Centrar;
import Decoracion.RedimensionarImagen;
import Pojo.DiasMedico;
import Pojo.Especialidad;
import Pojo.HorarioMedico;
import Pojo.Medico;
import Validaciones.ValidacionCedula;
import Validaciones.procesamientoImagenes;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.TreeSelectionModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author crdzbird
 */
public class FrameMedicos extends javax.swing.JInternalFrame {

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
        dtm.addColumn("Usuario");
        dtm.addColumn("Estado");
        jTable1.setModel(dtm);
        llenartabla();
    }
    /**
     * Creates new form FrameMedicos
     */
    public BufferedImage imagenMedico;
    SessionFactory sf;
    public Medico medicoEspecial;

    Date fecha;
    public boolean estado;
    public String UsuarioNuevo;
    public static int IdModificar;
    private byte[] arregloImagenCamara;
    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;
    private int returnStatus = RET_CANCEL;

    public FrameMedicos(SessionFactory sf) {
        initComponents();
        //InicializarTabla();
        cmbInicio.setSelectedIndex(0);
        cmbFinal.setSelectedIndex(0);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.sf = sf;
    }

    public int getReturnStatus() {
        return returnStatus;
    }

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    public BufferedImage abrirImagen() {
        BufferedImage bmp = null;
        JFileChooser selector = new JFileChooser();
        selector.setDialogTitle("Seleccione una imagen");
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP & PNG", "jpg", "gif", "bmp", "png");
        selector.setFileFilter(filtroImagen);
        int flag = selector.showOpenDialog(null);
        if (flag == JFileChooser.APPROVE_OPTION) {
            try {
                File imagenSeleccionada = selector.getSelectedFile();
                bmp = ImageIO.read(imagenSeleccionada);
            } catch (Exception e) {
            }

        }
        return bmp;
    }
    List<Especialidad> listaEspecialidadModificar = new ArrayList<>();

    public void llenarCombo() {
        Session s;
        s = sf.openSession();
        DAO d = new DAO(sf);
        List<Especialidad> lstEspecialidad = DAO.Listar_Especialidades();
        for (Especialidad p : lstEspecialidad) {

            cmbEspecialidad.addItem(p.getNombreEspecialidad());
            listaEspecialidadModificar.add(p);

        }
        s.close();
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
                cmbId.addItem(medico.getIdMedico());
                modelo.addRow(new Object[]{medico.getIdMedico(), medico.getPrimernombre() + " " + medico.getSegundonombre() + medico.getPrimerapellido() + " " + medico.getSegundoapellido(), medico.getCedula(), medico.getUsuario(), est});
            }
            jTable1.setModel(modelo);
        }
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbEspecialidad = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        chkLunes = new javax.swing.JCheckBox();
        chkMartes = new javax.swing.JCheckBox();
        chkMiercoles = new javax.swing.JCheckBox();
        chkJueves = new javax.swing.JCheckBox();
        chkViernes = new javax.swing.JCheckBox();
        chkSabado = new javax.swing.JCheckBox();
        chkDomingo = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        cmbInicio = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cmbFinal = new javax.swing.JComboBox();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        chkEditarMedico = new javax.swing.JCheckBox();
        cmbId = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro Medico");
        setAutoscrolls(true);
        setMaximumSize(new java.awt.Dimension(823, 702));
        setMinimumSize(new java.awt.Dimension(823, 702));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(823, 702));
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

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido:");

        jLabel5.setText("Seg. Nombre:");

        jLabel6.setText("Seg. Apellido:");

        jLabel3.setText("Especialidad:");

        cmbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Especialidad" }));

        jLabel8.setText("Cedula:");

        try {
            txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-######-####U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Dias de Trabajo"));

        chkLunes.setText("Lunes");

        chkMartes.setText("Martes");

        chkMiercoles.setText("Miercoles");

        chkJueves.setText("Jueves");

        chkViernes.setText("Viernes");

        chkSabado.setText("Sabado");

        chkDomingo.setText("Domingo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkLunes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkMartes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chkMiercoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chkJueves, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chkViernes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chkSabado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkDomingo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(chkLunes)
                .addComponent(chkMartes)
                .addComponent(chkMiercoles)
                .addComponent(chkJueves)
                .addComponent(chkViernes)
                .addComponent(chkSabado)
                .addComponent(chkDomingo))
        );

        jLabel4.setText("Hora Inicio");

        cmbInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "24:00" }));

        jLabel7.setText("Hora Final");

        cmbFinal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "24:00" }));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1436251885_Save.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1434275747_Delete.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Fotografia"));

        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setText("No hay Fotografia");
        lblImagen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblImagen.setMaximumSize(new java.awt.Dimension(480, 288));
        lblImagen.setMinimumSize(new java.awt.Dimension(480, 288));
        lblImagen.setPreferredSize(new java.awt.Dimension(436, 288));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
        );

        jButton3.setText("Tomar Fotografia");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Elegir Foto");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setEnabled(false);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel9.setText("Contraseña:");

        jLabel11.setText("Estado:");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));

        jLabel12.setText("Usuario:");

        jLabel13.setText("Direccion:");

        txtDireccion.setColumns(20);
        txtDireccion.setLineWrap(true);
        txtDireccion.setRows(5);
        jScrollPane1.setViewportView(txtDireccion);

        chkEditarMedico.setText("Editar Medico");
        chkEditarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEditarMedicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(3, 3, 3)
                                .addComponent(cmbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel7)
                                .addGap(6, 6, 6)
                                .addComponent(cmbFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel1))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel12))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtSApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSNombre, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(2, 2, 2))
                                    .addComponent(cmbEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(88, 88, 88))
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(228, 228, 228)
                                                .addComponent(cmbId, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(152, 152, 152)
                                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(31, 31, 31))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(chkEditarMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrar)
                            .addComponent(chkEditarMedico))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtSNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtSApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(cmbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cmbFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(cmbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbId, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ValidarImagenes() {
        ByteArrayOutputStream os;
        if (lblImagen != null) {

            os = new ByteArrayOutputStream();

            try {
                ImageIO.write(imagenMedico, "jpg", os);
                os.flush();
                String base64String = Base64.encode(os.toByteArray());
                os.close();

                arregloImagenCamara = Base64.decode(base64String);

            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }

        } else {
            JOptionPane.showInternalMessageDialog(this, "Asegurese de haber cargado/tomado una imágen", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;
            //System.out.println(" la imagen esta null");
        }
    }

    private int idMedico, idEspecialidad, idDiaMedico, idHorarioMedico, idEspecial, idModificarMedicoViejo;

    public void ObtenerEspecialidad() {
        int n = cmbEspecialidad.getSelectedIndex();
        DAO d = new DAO(sf);
        idEspecialidad = DAO.busquedaEspecialidadId(n).getIdEspecialidad();
        System.out.println("Especialidad: " + idEspecialidad);
        GuardarMedico(idEspecialidad);
    }

    public void MostrarDiasActualizados(int idMedicos) {
        DAO df = new DAO(sf);
        DiasMedico dMedico;
        dMedico = DAO.busquedaDiasMedicosId(idMedicos);
        if (dMedico.isLunes()) {
            chkLunes.setSelected(true);
        }
        if (dMedico.isMartes()) {
            chkMartes.setSelected(true);
        }
        if (dMedico.isMiercoles()) {
            chkMiercoles.setSelected(true);
        }
        if (dMedico.isJueves()) {
            chkJueves.setSelected(true);
        }
        if (dMedico.isViernes()) {
            chkViernes.setSelected(true);
        }
        if (dMedico.isSabado()) {
            chkSabado.setSelected(true);
        }
        if (dMedico.isDomingo()) {
            chkDomingo.setSelected(true);
        }
        System.out.println("DIAS: " + idDiaMedico);
        MostrarHorarioActualizado(dMedico.getIdDiaMedico());
    }

    DiasMedico dMedico = new DiasMedico();

    public void ActualizarMedico(int idMedico) {
        UsuarioNuevo = txtUsuario.getText();
        Especialidad especialidadModificada = new Especialidad();
        DAO d = new DAO(sf);
        for (Especialidad espe : listaEspecialidadModificar) {
            if (espe.getNombreEspecialidad().equals(cmbEspecialidad.getSelectedItem().toString())) {
                especialidadModificada = espe;
                break;
            }
        }

        medicoEspecial.setCedula(txtCedula.getText());
        medicoEspecial.setEstado(estado);
        medicoEspecial.setPrimernombre(txtNombre.getText());
        medicoEspecial.setSegundonombre(txtSNombre.getText());
        medicoEspecial.setPrimerapellido(txtApellido.getText());
        medicoEspecial.setSegundoapellido(txtSApellido.getText());
        medicoEspecial.setEspecialidad((especialidadModificada));
        medicoEspecial.setFoto(arregloImagenCamara);
        medicoEspecial.setDireccion(txtDireccion.getText());
        int flag = DAO.ActualizarMedico(UsuarioNuevo, medicoEspecial, txtContraseña.getText());
        System.out.println(flag);
        if (flag != -1) {
            System.out.println("MEDICO: " + idMedico);
            ObtenerDiaMedicoActualizado(idMedico);
        } else {
            System.out.println("MEDICO NO ACTUALIZADO!!!");
        }

        // GuardarDias(idMedico);
    }

    public void LimpiarCampos() {
        txtApellido.setText(null);
        txtCedula.setText(null);
        txtContraseña.setText(null);
        txtDireccion.setText(null);
        txtNombre.setText(null);
        txtSApellido.setText(null);
        txtSNombre.setText(null);
        txtUsuario.setText(null);
    }

    public void ObtenerDiaMedicoActualizado(int idMedico) {
        DAO d = new DAO(sf);
        dMedico = DAO.busquedaDiasMedicosId(idMedico);
        System.out.println("DIA RELACIONADO: " + dMedico.getIdDiaMedico());
        GuardarDiasMedicoActualizado(dMedico.getIdDiaMedico());

    }

    public void ObtenerHorarioMedicoActualizado(int idDiaActualizado) {
        HorarioMedico horaMedico = new HorarioMedico();
        DAO d = new DAO(sf);
        horaMedico = DAO.busquedaHorarioMedicoId(idDiaActualizado);
        System.out.println("HORA RELACIONADA: " + horaMedico.getHoraEntrada() + "  HORA SALIDA:" + horaMedico.getHoraSalida());
        HorarioMedicoActualizar(idDiaActualizado, horaMedico);
    }

    public void GuardarMedico(int idEspecial) {
        if (cmbEstado.getSelectedItem().toString().equals("Activo")) {
            estado = true;
        }
        if (cmbEstado.getSelectedItem().toString().equals("Inactivo")) {
            estado = false;
        }
        DAO d = new DAO(sf);
        idMedico = DAO.GuardarMedico(txtNombre.getText().trim(), txtSNombre.getText().trim(), txtApellido.getText().trim(), txtSApellido.getText().trim(), txtCedula.getText().trim(), idEspecial, txtUsuario.getText().trim(), txtContraseña.getText(), txtDireccion.getText().trim(), estado, arregloImagenCamara);
        System.out.println("MEDICO: " + idMedico);
        GuardarDias(idMedico);
    }

    public void CargarImagen(Medico medico) {
        imagenMedico = this.abrirImagen();
        procesamientoImagenes pi = new procesamientoImagenes();
        int height = lblImagen.getHeight();
        int width = lblImagen.getWidth();
        lblImagen.setIcon((pi.imageToIcon(pi.imageToBufferedImage(imagenMedico).getScaledInstance(width, height, 0))));
        lblImagen.setText(null);
    }

    public void ModificarMedico(int IdMedico) {
        Session s = sf.openSession();
        try {
            String Estado = "";
            List<Medico> lstMedicos = (List<Medico>) s.createQuery("from Medico").list();
            for (Medico medico : lstMedicos) {
                for (int i = 0; i < cmbEspecialidad.getItemCount(); i++) {
                    if (medico.getEspecialidad().getNombreEspecialidad().equals(cmbEspecialidad.getItemAt(i).toString())) {
                        System.out.println("ESPECIALIDAD: " + cmbEspecialidad.getItemAt(i).toString());
                        cmbEspecialidad.setSelectedIndex(i);
                        idEspecial = medico.getEspecialidad().getIdEspecialidad();

                    }
                }
                if (medico.getIdMedico().equals(IdModificar)) {
                    medicoEspecial = medico;
                    idModificarMedicoViejo = medico.getIdMedico();
                    txtNombre.setText(medico.getPrimernombre());
                    txtSNombre.setText(medico.getSegundonombre());
                    txtApellido.setText(medico.getPrimerapellido());
                    txtSApellido.setText(medico.getSegundoapellido());
                    txtCedula.setText(medico.getCedula());
                    txtUsuario.setText(medico.getUsuario());
                    txtDireccion.setText(medico.getDireccion());
                    if (medico.isEstado()) {
                        Estado = "Activo";
                    }
                    for (int i = 0; i < cmbEstado.getItemCount(); i++) {
                        if (Estado.equals(cmbEstado.getItemAt(i))) {
                            cmbEstado.setSelectedIndex(i);
                        }
                    }
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
                    txtContraseña.setText(title);
                }
            }
            
        } catch (Exception ex) {
            System.out.println("ERRORES!!");
        }finally{
            s.close();
        }
    }

    public void GuardarDiasMedicoActualizado(int idMedicoActualizado) {
        DAO df = new DAO(sf);
        boolean l, m, mi, ju, vi, sa, dom;
        l = chkLunes.isSelected();
        dMedico.setLunes(l);
        m = chkMartes.isSelected();
        dMedico.setMartes(m);
        mi = chkMiercoles.isSelected();
        dMedico.setMiercoles(mi);
        ju = chkJueves.isSelected();
        dMedico.setJueves(ju);
        vi = chkViernes.isSelected();
        dMedico.setViernes(vi);
        sa = chkSabado.isSelected();
        dMedico.setSabado(sa);
        dom = chkDomingo.isSelected();
        dMedico.setDomingo(dom);
        int idDiaActualizado = DAO.ActualizarDiasMedico(dMedico);
        if (idDiaActualizado != -1) {
            System.out.println("DIA MEDICO ACTUALIZADO: " + dMedico.getIdDiaMedico());
            ObtenerHorarioMedicoActualizado(dMedico.getIdDiaMedico());
        }
    }

    public void HorarioMedicoActualizar(int idDiaActualizado, HorarioMedico horasMedico) {
        DAO df = new DAO(sf);
        horasMedico.setHoraEntrada(cmbInicio.getSelectedItem().toString());
        horasMedico.setHoraSalida(cmbFinal.getSelectedItem().toString());
        idHorarioMedico = DAO.ActualizarHorasMedico(horasMedico);
        if (idHorarioMedico != -1) {
            JOptionPane.showMessageDialog(this, "Medico Actualizado");
            System.out.println("Horario: " + idHorarioMedico);
        }
    }

    public void GuardarDias(int idMedicos) {
        DAO df = new DAO(sf);
        idDiaMedico = DAO.GuardarDiaMedico(idMedicos, chkLunes.isSelected(), chkMartes.isSelected(), chkMiercoles.isSelected(), chkJueves.isSelected(), chkViernes.isSelected(), chkSabado.isSelected(), chkDomingo.isSelected());
        System.out.println("DIAS: " + idDiaMedico);
        GuardarHorario(idDiaMedico);
    }

    public void MostrarHorarioActualizado(int idDiasMedicoMostrar) {
        DAO df = new DAO(sf);
        HorarioMedico hMedico = new HorarioMedico();
        hMedico = DAO.busquedaHorarioMedicoId(idDiasMedicoMostrar);
        System.out.println("Horario: " + hMedico.getHoraEntrada() + hMedico.getHoraSalida());
        for (int i = 0; i < cmbInicio.getItemCount(); i++) {
            if (hMedico.getHoraEntrada().equals(cmbInicio.getItemAt(i))) {
                cmbInicio.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < cmbFinal.getItemCount(); i++) {
            if (hMedico.getHoraSalida().equals(cmbFinal.getItemAt(i))) {
                cmbFinal.setSelectedIndex(i);
            }
        }
    }

    public void GuardarHorario(int idDiasMedicos) {
        DAO df = new DAO(sf);
        idHorarioMedico = DAO.GuardarHorarioMedico(idDiasMedicos, cmbInicio.getSelectedItem().toString(), cmbFinal.getSelectedItem().toString());
        System.out.println("Horario: " + idHorarioMedico);
        JOptionPane.showMessageDialog(this, "Medico Registrado", "Guardado Exitoso", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        llenarCombo();
        llenartabla();
        try {
            this.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FrameMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        imagenMedico = this.abrirImagen();
        RedimensionarImagen renderImagen = new RedimensionarImagen();
        int height = lblImagen.getHeight();
        int width = lblImagen.getWidth();
        lblImagen.setIcon((renderImagen.imageToIcon(renderImagen.imageToBufferedImage(imagenMedico).getScaledInstance(width, height, 0))));
        lblImagen.setText(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Camara c = new Camara(this);
        Centrar(c, this.getDesktopPane());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        ValidarImagenes();
        if (cmbEstado.getSelectedItem().toString().equals("Activo")) {
            estado = true;
        }
        if (cmbEstado.getSelectedItem().toString().equals("Inactivo")) {
            estado = false;
        }
        if (!new ValidacionCedula().Validacion(txtCedula.getText())) {
            JOptionPane.showInternalMessageDialog(this, "Por favor ingrese un número de cédula válida", "Ventana de Notificación", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (txtNombre.getText().isEmpty() || txtSNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtSApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe de llenar los campos vacios", "Insuficiencia de datos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!chkLunes.isSelected() && !chkMartes.isSelected() && !chkMiercoles.isSelected() && !chkJueves.isSelected() && !chkViernes.isSelected() && !chkSabado.isSelected() && !chkDomingo.isSelected()) {
            JOptionPane.showMessageDialog(this, "Seleccion los dia que trabajara", "Indicar Fechas", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (cmbInicio.getSelectedIndex() == cmbFinal.getSelectedIndex()) {
            JOptionPane.showMessageDialog(this, "Las horas de trabajo no pueden ser las mismas", "Horario Erroneo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (cmbEspecialidad.getSelectedItem().toString().equals("Seleccione Especialidad")) {
            JOptionPane.showMessageDialog(this, "Seleccione una Especialidad", "Error de Especialidad", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (txtUsuario.equals("")) {
            JOptionPane.showInternalMessageDialog(this, "El nombre de usuario no puede dejarse vacio", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;
        }
//        if (new Usuarios(sf).ExisteUsuario(txtUsuario.getText().trim())) {
//            JOptionPane.showInternalMessageDialog(this, "El nombre de usuario ya ha sido usado", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
        if (chkEditarMedico.isSelected()) {
            ActualizarMedico(idMedicoAntiguo);
        } else {
            ObtenerEspecialidad();
            //GuardarMedico();
            // GuardarDias();
            // GuardarHorario();
        }
        this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed
    public int idMedicoAntiguo;
    private void chkEditarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEditarMedicoActionPerformed
        // TODO add your handling code here:
        if (chkEditarMedico.isSelected()) {
            LimpiarCampos();
            btnRegistrar.setText("Modificar");
            jTable1.setEnabled(true);
            jTable1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            txtUsuario.setEditable(false);
            txtUsuario.setEnabled(false);
        } else {
            LimpiarCampos();
            jTable1.setEnabled(false);
            btnRegistrar.setText("Registrar");
        }
    }//GEN-LAST:event_chkEditarMedicoActionPerformed

    public void LimpiarCheckBox() {
        chkDomingo.setSelected(false);
        chkJueves.setSelected(false);
        chkLunes.setSelected(false);
        chkMartes.setSelected(false);
        chkMiercoles.setSelected(false);
        chkViernes.setSelected(false);
        chkSabado.setSelected(false);
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        LimpiarCheckBox();
        int fila = this.jTable1.getSelectedRow();
        IdModificar = Integer.parseInt(jTable1.getValueAt(fila, 0).toString());
        idMedicoAntiguo = IdModificar;
        MostrarDiasActualizados(IdModificar);
        ModificarMedico(IdModificar);
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JCheckBox chkDomingo;
    private javax.swing.JCheckBox chkEditarMedico;
    private javax.swing.JCheckBox chkJueves;
    private javax.swing.JCheckBox chkLunes;
    private javax.swing.JCheckBox chkMartes;
    private javax.swing.JCheckBox chkMiercoles;
    private javax.swing.JCheckBox chkSabado;
    private javax.swing.JCheckBox chkViernes;
    private javax.swing.JComboBox cmbEspecialidad;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbFinal;
    private javax.swing.JComboBox cmbId;
    private javax.swing.JComboBox cmbInicio;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel lblImagen;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSApellido;
    private javax.swing.JTextField txtSNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
