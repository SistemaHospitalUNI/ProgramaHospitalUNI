/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FramePrincipal;

import Conexion.DAO;
import Conexion.NewHibernateUtil;
import Decoracion.Animacion;
import MenuSistema.SistemaPrincipal;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
//import de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author crdzbird
 */
public class Logueo extends javax.swing.JFrame {

    private static SessionFactory sf;
    private static Session s;

    public Logueo() {
        initComponents();
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Salir");
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put("Salir", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSalirActionPerformed(e);
            }
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnVerPassword = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(453, 151));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Principal Login", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 3, 14))); // NOI18N
        jPanel1.setMinimumSize(new java.awt.Dimension(453, 151));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(453, 151));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setMinimumSize(new java.awt.Dimension(313, 121));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(313, 109));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setMinimumSize(new java.awt.Dimension(186, 48));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(186, 48));

        btnInicio.setText("Iniciar Sesión");
        btnInicio.setPreferredSize(new java.awt.Dimension(130, 38));
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        jPanel3.add(btnInicio);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalir);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        jPanel2.add(jPanel3, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        jPanel2.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        jPanel2.add(jLabel3, gridBagConstraints);

        txtUsuario.setText("root");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        jPanel2.add(txtUsuario, gridBagConstraints);

        txtPassword.setText("1234");
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        jPanel2.add(txtPassword, gridBagConstraints);

        btnVerPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1436171051_eye-24.png"))); // NOI18N
        btnVerPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVerPasswordMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnVerPasswordMouseReleased(evt);
            }
        });
        btnVerPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPasswordActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 3);
        jPanel2.add(btnVerPassword, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        jPanel1.add(jPanel2, gridBagConstraints);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario-icono-7991-64.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jLabel1, gridBagConstraints);

        /*

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        */
        getContentPane().add(Animacion.gradiente(jPanel1, .3f, Color.DARK_GRAY, Color.WHITE), java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnVerPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerPasswordMousePressed
        // TODO add your handling code here:
        txtPassword.setEchoChar('\0');
    }//GEN-LAST:event_btnVerPasswordMousePressed

    private void btnVerPasswordMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerPasswordMouseReleased
        // TODO add your handling code here:
        txtPassword.setEchoChar('\u25cf');
    }//GEN-LAST:event_btnVerPasswordMouseReleased

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        // TODO add your handling code here:
        Ejecutar();
        intentos++;
    }//GEN-LAST:event_btnInicioActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            Ejecutar();
            intentos++;
       }
       
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void btnVerPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerPasswordActionPerformed

    private void validarEntrada() {
        if (txtUsuario.getText().isEmpty() || txtPassword.getPassword().length == 0) {
            if (btnInicio.isEnabled()) {
                btnInicio.setEnabled(false);
            }

        } else {
            if (!btnInicio.isEnabled()) {
                btnInicio.setEnabled(true);
            }
        }
    }
    
    public void esperar (int segundos) {

        try {

            Thread.sleep (segundos*1000);
               
           this.btnInicio.setEnabled(true);
           this.btnVerPassword.setEnabled(true);
        } catch (Exception e) {
             System.out.println("error");
        }
        
    }
    
    public static String getUser(){
        return txtUsuario.getText();
    }
    
    public static String getPass(){
        return txtPassword.getText();
    }
      public static void enviarMail(){
        
        try{
               javax.mail.Session ss;
                Properties p = new Properties();
                p.put("mail.smtp.host", "smtp.gmail.com");
                p.setProperty("mail.smtp.starttls.enable", "true");
                p.setProperty("mail.smtp.port", "587");
                p.setProperty("mail.smtp.user", "cristhianaguirre75@gmai.com");
                p.setProperty("mail.smtp.auth", "true");
                
                ss = javax.mail.Session.getDefaultInstance(p,null);
                BodyPart texto = new MimeBodyPart();
                texto.setText("El usuario "+txtUsuario.getText()+" ha intentado entrar con contraseña incorrecta");
                MimeMultipart m = new MimeMultipart();
                m.addBodyPart(texto);
                MimeMessage mensaje = new MimeMessage(ss);
                mensaje.setFrom(new InternetAddress("cristhianaguirre95@gmail.com"));
                mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress("cristhianaguirre75@gmail.com"));
                mensaje.setSubject("Usuario Entrando");
                mensaje.setContent(m);
                
                Transport t = ss.getTransport("smtp");
                t.connect("cristhianaguirre75@gmail.com", "doihwfymjviitkpe");
                t.sendMessage(mensaje, mensaje.getAllRecipients());
                t.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }

    int intentos = 0;

    private void Ejecutar() {

        if(intentos == 3){
                      this.btnInicio.setEnabled(false);
                this.btnVerPassword.setEnabled(false);
                    enviarMail();
            JOptionPane.showMessageDialog(this, "Numero de intentos maximos, intente en 1 min",
                    "Espere por favor",JOptionPane.WARNING_MESSAGE);
            
                esperar(60);
               
                intentos = 0;
           
            return;
        }
        
        if (txtUsuario.getText().length() == 0 || txtPassword.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Atencion, se deben llenar todos "
                    + "los campos para continuar", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            sf = NewHibernateUtil.conexion(txtUsuario.getText(), txtPassword.getText(), "3306", "localhost");
            if (sf != null) {
                SistemaPrincipal sisPrin = new SistemaPrincipal(sf);
                sisPrin.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Revise su usuario y contraseña", "error en la conexion", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

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
            UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
        }  catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Logueo.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logueo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JPasswordField txtPassword;
    public static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
