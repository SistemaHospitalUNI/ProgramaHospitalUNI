/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuSistema;

import Citas.FrameCitas;
import Especialidades.FrameEspecialidades;
import FramePrincipal.Logueo;
import InternalFrames.*;
import Medicos.FrameMedicos;
import Medicos.ListarMedicos;
import PermisosUsuarios.AsignacionPermisos;
import Pojo.AlergiaMedicamento;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import java.beans.PropertyVetoException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import org.hibernate.SessionFactory;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author crdzbird
 */
public class SistemaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form SistemaPrincipal
     */
    private static SessionFactory sf;

    public SistemaPrincipal(SessionFactory sf) {
        initComponents();
        SistemaPrincipal.sf = sf;
        menuUsuario.setText(Logueo.getUser());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.jDesktopPane1.setBorder(new ImagenFondo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuBarInformacion = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuEspe = new javax.swing.JMenu();
        menuItemEspc = new javax.swing.JMenuItem();
        menuAlergia = new javax.swing.JMenu();
        menuItemAlergia = new javax.swing.JMenuItem();
        menuEnfermedades = new javax.swing.JMenu();
        menuAgregarEnfermedad = new javax.swing.JMenuItem();
        menuCatalogo = new javax.swing.JMenu();
        itemExa = new javax.swing.JMenuItem();
        menuProcEsp = new javax.swing.JMenuItem();
        menuFactura = new javax.swing.JMenu();
        facturaConsulta = new javax.swing.JMenuItem();
        menuExayProc = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuPaciente = new javax.swing.JMenu();
        menuItemSector = new javax.swing.JMenuItem();
        menuItemPaciente = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuMedico = new javax.swing.JMenu();
        menuItemAgregarMedico = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuHorarioMedico = new javax.swing.JMenuItem();
        menuCajero = new javax.swing.JMenu();
        menuItemCajero = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuItemExpediente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuUsuarios = new javax.swing.JMenu();
        jMenuItemVerusuariosmedicos = new javax.swing.JMenuItem();
        jMenuItemVerUsuarios = new javax.swing.JMenuItem();
        menuUsuario = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sistema Consultorio");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1029, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );

        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        jMenuBar1.setMaximumSize(new java.awt.Dimension(623, 32769));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(623, 53));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1436181702_vector_65_13.png"))); // NOI18N
        jMenu1.setText("Catálogo");
        jMenu1.setMargin(new java.awt.Insets(0, 0, 0, 20));

        menuBarInformacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuBarInformacion.setText("Opciones Generales");
        jMenu1.add(menuBarInformacion);
        jMenu1.add(jSeparator1);

        menuEspe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/diagram_v2_26.png"))); // NOI18N
        menuEspe.setText("Especialidad");

        menuItemEspc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/file_add 16x16.png"))); // NOI18N
        menuItemEspc.setText("Nueva Especialidad");
        menuItemEspc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEspcActionPerformed(evt);
            }
        });
        menuEspe.add(menuItemEspc);

        jMenu1.add(menuEspe);

        menuAlergia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1436428282_pill.png"))); // NOI18N
        menuAlergia.setText("Alergia");

        menuItemAlergia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/file_add 16x16.png"))); // NOI18N
        menuItemAlergia.setText("Agregar Alergia");
        menuItemAlergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAlergiaActionPerformed(evt);
            }
        });
        menuAlergia.add(menuItemAlergia);

        jMenu1.add(menuAlergia);

        menuEnfermedades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1436438357_medical_bag.png"))); // NOI18N
        menuEnfermedades.setText("Enfermedades Cronica");

        menuAgregarEnfermedad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/file_add 16x16.png"))); // NOI18N
        menuAgregarEnfermedad.setText("Agregar Enfermedad Cronica");
        menuAgregarEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgregarEnfermedadActionPerformed(evt);
            }
        });
        menuEnfermedades.add(menuAgregarEnfermedad);

        jMenu1.add(menuEnfermedades);

        menuCatalogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/hacer-una-lista-icono-7189-32.png"))); // NOI18N
        menuCatalogo.setText("Catálogo Laboratorio");

        itemExa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/file_add 16x16.png"))); // NOI18N
        itemExa.setText("Exámenes");
        itemExa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExaActionPerformed(evt);
            }
        });
        menuCatalogo.add(itemExa);

        menuProcEsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/file_add 16x16.png"))); // NOI18N
        menuProcEsp.setText("Procedimientos Especiales");
        menuProcEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProcEspActionPerformed(evt);
            }
        });
        menuCatalogo.add(menuProcEsp);

        jMenu1.add(menuCatalogo);

        menuFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lists.png"))); // NOI18N
        menuFactura.setText("Factura");
        menuFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFacturaActionPerformed(evt);
            }
        });

        facturaConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/file_add 16x16.png"))); // NOI18N
        facturaConsulta.setText("Factura Consulta");
        menuFactura.add(facturaConsulta);

        menuExayProc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/file_add 16x16.png"))); // NOI18N
        menuExayProc.setText("Facura Examenes y Procedimientos");
        menuExayProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExayProcActionPerformed(evt);
            }
        });
        menuFactura.add(menuExayProc);

        jMenuItem4.setText("Ver Facturas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuFactura.add(jMenuItem4);

        jMenu1.add(menuFactura);

        jMenuBar1.add(jMenu1);

        menuPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1436247377_8.png"))); // NOI18N
        menuPaciente.setText("Paciente");
        menuPaciente.setMargin(new java.awt.Insets(0, 20, 0, 0));

        menuItemSector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/file_add 16x16.png"))); // NOI18N
        menuItemSector.setText("Agregar Sector");
        menuItemSector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSectorActionPerformed(evt);
            }
        });
        menuPaciente.add(menuItemSector);

        menuItemPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/file_add 16x16.png"))); // NOI18N
        menuItemPaciente.setText("Agregar Paciente");
        menuItemPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPacienteActionPerformed(evt);
            }
        });
        menuPaciente.add(menuItemPaciente);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1436709931_health.png"))); // NOI18N
        jMenu5.setText("Alergias y Enfermedades Cronicas");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/file_add 16x16.png"))); // NOI18N
        jMenuItem2.setText("Agregar Alergia");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/file_add 16x16.png"))); // NOI18N
        jMenuItem3.setText("Agregar Enfermedad Cronica");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        menuPaciente.add(jMenu5);

        jMenuBar1.add(menuPaciente);

        menuMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1436173501_Doctor.png"))); // NOI18N
        menuMedico.setText("Médico");
        menuMedico.setMargin(new java.awt.Insets(0, 20, 0, 0));

        menuItemAgregarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/file_add 16x16.png"))); // NOI18N
        menuItemAgregarMedico.setText("Agregar Médico");
        menuItemAgregarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAgregarMedicoActionPerformed(evt);
            }
        });
        menuMedico.add(menuItemAgregarMedico);

        jMenuItem5.setText("Citas Medicas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuMedico.add(jMenuItem5);

        menuHorarioMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/x_office_calendar.png"))); // NOI18N
        menuHorarioMedico.setText("Listado Medicos");
        menuHorarioMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHorarioMedicoActionPerformed(evt);
            }
        });
        menuMedico.add(menuHorarioMedico);

        jMenuBar1.add(menuMedico);

        menuCajero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/man_black.png"))); // NOI18N
        menuCajero.setText("Cajero");
        menuCajero.setMargin(new java.awt.Insets(0, 20, 0, 0));

        menuItemCajero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/file_add 16x16.png"))); // NOI18N
        menuItemCajero.setText("Agregar Cajero");
        menuItemCajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCajeroActionPerformed(evt);
            }
        });
        menuCajero.add(menuItemCajero);

        jMenuBar1.add(menuCajero);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1436182029_my-reports.png"))); // NOI18N
        jMenu4.setText("   Reportes");
        jMenu4.setMargin(new java.awt.Insets(0, 20, 0, 0));

        menuItemExpediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1439028669_add-notes.png"))); // NOI18N
        menuItemExpediente.setText("Generar Expediente");
        menuItemExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExpedienteActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemExpediente);

        jMenuBar1.add(jMenu4);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1436182141_Information.png"))); // NOI18N
        jMenu2.setText("   Info");
        jMenu2.setMargin(new java.awt.Insets(0, 40, 0, 0));
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1436172711_help-browser.png"))); // NOI18N
        jMenu3.setText("    Ayuda");
        jMenu3.setActionCommand("   Ayuda");
        jMenu3.setMargin(new java.awt.Insets(0, 40, 0, 0));
        jMenuBar1.add(jMenu3);

        jMenuUsuarios.setText("Usuarios");

        jMenuItemVerusuariosmedicos.setText("Ver usuarios medicos");
        jMenuItemVerusuariosmedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerusuariosmedicosActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(jMenuItemVerusuariosmedicos);

        jMenuItemVerUsuarios.setText("Ver Usuarios");
        jMenuUsuarios.add(jMenuItemVerUsuarios);

        jMenuBar1.add(jMenuUsuarios);

        menuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1436182236_preferences-contact-list.png"))); // NOI18N
        menuUsuario.setText("   Usuario");
        menuUsuario.setMargin(new java.awt.Insets(0, 20, 0, 0));
        menuUsuario.setPreferredSize(new java.awt.Dimension(113, 51));
        menuUsuario.setRequestFocusEnabled(false);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1436428083_Settings.png"))); // NOI18N
        jMenuItem9.setText("Configurar");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        menuUsuario.add(jMenuItem9);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1434275747_Delete.png"))); // NOI18N
        jMenuItem1.setText("Cerrar Sesión");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuUsuario.add(jMenuItem1);

        jMenuBar1.add(Box.createHorizontalGlue());

        jMenuBar1.add(menuUsuario);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        JOptionPane.showMessageDialog(this, "Programa Realizado por: \n  -Cristhian Aguirre\n  -Luis Cardoza\n  -Rossel Morales \nBase de datos II 2015",
                "Información de la Aplicación", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        new Logueo().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public boolean activo(Object object) {

        JInternalFrame[] activos = this.jDesktopPane1.getAllFrames();

        boolean mostrar = true;

        for (int a = 0; a < jDesktopPane1.getComponentCount(); a++) {
            if (object.getClass().isInstance(jDesktopPane1.getComponent(a))) {

                mostrar = false;
            }
        }
        return mostrar;
    }

    private void menuItemPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPacienteActionPerformed
        PacienteAgregar pa = new PacienteAgregar(sf);
        if (activo(pa)) {
            this.jDesktopPane1.add(pa);
            pa.setVisible(true);
        }

    }//GEN-LAST:event_menuItemPacienteActionPerformed

    private void menuItemSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSectorActionPerformed
        SectorAgregar pa = new SectorAgregar(sf);
        if (activo(pa)) {
            this.jDesktopPane1.add(pa);
            pa.setVisible(true);
        }
    }//GEN-LAST:event_menuItemSectorActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        int resultado = JOptionPane.showConfirmDialog(this, "Hay una sesion abierta, ¿Desea cerrarla?",
                "Sesion Abierta", JOptionPane.YES_NO_OPTION);
        if (resultado == JOptionPane.YES_OPTION) {

            new Logueo().setVisible(true);
            this.dispose();
            sf.close();

        }

    }//GEN-LAST:event_formWindowClosing

    private void menuItemAgregarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAgregarMedicoActionPerformed
        // TODO add your handling code here:
        FrameMedicos fm = new FrameMedicos(sf);
        if (activo(fm)) {
            this.jDesktopPane1.add(fm);
            fm.setVisible(true);
        }
    }//GEN-LAST:event_menuItemAgregarMedicoActionPerformed

    private void menuProcEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProcEspActionPerformed
        ProcEsp ce = new ProcEsp(sf);
        if (activo(ce)) {
            this.jDesktopPane1.add(ce);
            ce.setVisible(true);
        }
    }//GEN-LAST:event_menuProcEspActionPerformed

    private void itemExaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExaActionPerformed
        C_Examenes ce = new C_Examenes(sf);
        if (activo(ce)) {
            this.jDesktopPane1.add(ce);
            ce.setVisible(true);
        }
    }//GEN-LAST:event_itemExaActionPerformed

    private void menuItemCajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCajeroActionPerformed
        Cajero ce = new Cajero(sf);
        if (activo(ce)) {
            this.jDesktopPane1.add(ce);
            ce.setVisible(true);
            try {
                ce.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(SistemaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_menuItemCajeroActionPerformed

    private void menuItemEspcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEspcActionPerformed
        // TODO add your handling code here:
        FrameEspecialidades frEsp = new FrameEspecialidades(sf);
        if (activo(frEsp)) {
            this.jDesktopPane1.add(frEsp);
            frEsp.setVisible(true);
        }
    }//GEN-LAST:event_menuItemEspcActionPerformed

    private void menuItemAlergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAlergiaActionPerformed
       
        AlergiaMedic frEsp = new AlergiaMedic(sf);
        if (activo(frEsp)) {
            this.jDesktopPane1.add(frEsp);
            frEsp.setVisible(true);
        }
        
    }//GEN-LAST:event_menuItemAlergiaActionPerformed

    private void menuAgregarEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgregarEnfermedadActionPerformed
     
        Enfermedad_Cronica frEsp = new Enfermedad_Cronica(sf);
        if (activo(frEsp)) {
            this.jDesktopPane1.add(frEsp);
            frEsp.setVisible(true);
        }
        
    }//GEN-LAST:event_menuAgregarEnfermedadActionPerformed

    private void menuExayProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExayProcActionPerformed
if(!Logueo.getUser().substring(0, 2).equals("ca")){
        JOptionPane.showMessageDialog(this,"Necesita ser un cajero para acceder","",JOptionPane.ERROR_MESSAGE);
        }
else{
        FacturaExt fext = new FacturaExt(sf);
         if (activo(fext)) {
            this.jDesktopPane1.add(fext);
            fext.setVisible(true);
            try {
                fext.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(SistemaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
    }//GEN-LAST:event_menuExayProcActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       Padecimiento_AlergiaMed fext = new Padecimiento_AlergiaMed(sf);
         if (activo(fext)) {
            this.jDesktopPane1.add(fext);
            fext.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Padecimiento_EnfermedadCronica fext = new Padecimiento_EnfermedadCronica(sf);
         if (activo(fext)) {
            this.jDesktopPane1.add(fext);
            fext.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
//         TODO add your handling code here:
       
        ConfiguracionUsuario cu = new ConfiguracionUsuario(sf);
        if(activo(cu)){
        this.jDesktopPane1.add(cu);
        cu.setVisible(true);
        }
        
        
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItemVerusuariosmedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerusuariosmedicosActionPerformed
        AsignacionPermisos asignacion = new AsignacionPermisos(sf,this);
        if (activo(asignacion)) {
            this.jDesktopPane1.add(asignacion);
            asignacion.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemVerusuariosmedicosActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try {
            // TODO add your handling code here:
            FrameCitas citas = new FrameCitas(sf);
            if (activo(citas)) {
                this.jDesktopPane1.add(citas);
                citas.setVisible(true);
            }
        } catch (ParseException ex) {
            Logger.getLogger(SistemaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void menuHorarioMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHorarioMedicoActionPerformed
        // TODO add your handling code here:
            ListarMedicos citas = new ListarMedicos(sf);
            if (activo(citas)) {
                this.jDesktopPane1.add(citas);
                citas.setVisible(true);
            }
    }//GEN-LAST:event_menuHorarioMedicoActionPerformed

    private void menuFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuFacturaActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       VerFacturas cf = new VerFacturas(sf);
       if(activo(cf)){
           try {
               this.jDesktopPane1.add(cf);
               cf.setMaximum(true);
               cf.setVisible(true);
           } catch (PropertyVetoException ex) {
               Logger.getLogger(SistemaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void menuItemExpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExpedienteActionPerformed
     VentanaReporteExpediente cf = new VentanaReporteExpediente(sf);
       if(activo(cf)){        
               this.jDesktopPane1.add(cf);          
               cf.setVisible(true);
          
        }     
    }//GEN-LAST:event_menuItemExpedienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }

            UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());

//            }
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SistemaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemaPrincipal(sf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem facturaConsulta;
    private javax.swing.JMenuItem itemExa;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemVerUsuarios;
    private javax.swing.JMenuItem jMenuItemVerusuariosmedicos;
    private javax.swing.JMenu jMenuUsuarios;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem menuAgregarEnfermedad;
    private javax.swing.JMenu menuAlergia;
    private javax.swing.JMenuItem menuBarInformacion;
    private javax.swing.JMenu menuCajero;
    private javax.swing.JMenu menuCatalogo;
    private javax.swing.JMenu menuEnfermedades;
    private javax.swing.JMenu menuEspe;
    private javax.swing.JMenuItem menuExayProc;
    private javax.swing.JMenu menuFactura;
    private javax.swing.JMenuItem menuHorarioMedico;
    private javax.swing.JMenuItem menuItemAgregarMedico;
    private javax.swing.JMenuItem menuItemAlergia;
    private javax.swing.JMenuItem menuItemCajero;
    private javax.swing.JMenuItem menuItemEspc;
    private javax.swing.JMenuItem menuItemExpediente;
    private javax.swing.JMenuItem menuItemPaciente;
    private javax.swing.JMenuItem menuItemSector;
    private javax.swing.JMenu menuMedico;
    private javax.swing.JMenu menuPaciente;
    private javax.swing.JMenuItem menuProcEsp;
    private javax.swing.JMenu menuUsuario;
    // End of variables declaration//GEN-END:variables

}
