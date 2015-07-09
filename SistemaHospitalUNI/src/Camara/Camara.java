/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Camara;

import Decoracion.RedimensionarImagen;
import InternalFrames.Cajero;
import Medicos.FrameMedicos;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.VideoInputFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;
import static com.googlecode.javacv.cpp.opencv_core.cvFlip;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author crdzbird
 */
public class Camara extends javax.swing.JInternalFrame {

    /**
     * Creates new form Camara
     */
    camara camara;
    public int NumeroCamara = 0;
    public opencv_core.IplImage img;
    public FrameGrabber grabber;
    boolean Flag = true;
    BufferedImage imageV;
    ImageIcon icon;
    
    public Camara() {
        initComponents();
        this.CargarCamara();
    }
    FrameMedicos frMedicos;
    public Camara(FrameMedicos frMedicos) {
        initComponents();
        this.CargarCamara();
        this.frMedicos = frMedicos;
    }
Cajero cajerofr;

    public Camara(Cajero cajerofr) {
        initComponents();
        this.CargarCamara();
        this.cajerofr = cajerofr;
    }
    public void GuardarMetodoGrabber() {
        try {

            Icon icono = lblPic.getIcon();
            RedimensionarImagen redimImagen = new RedimensionarImagen();

            if (this.frMedicos != null) {
                icono = redimImagen.imageToIcon(redimImagen.iconToBufferedImage(icono).getScaledInstance(frMedicos.lblImagen.getWidth(), frMedicos.lblImagen.getHeight(), 0));
                frMedicos.imagenMedico = img.getBufferedImage();
                frMedicos.lblImagen.setIcon(icono);
                frMedicos.lblImagen.setText(null);
            }
            this.CerrarCamara();
            this.dispose();

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            System.out.println("+ " + e.getCause());
            JOptionPane.showMessageDialog(null, "Error al guardar la foto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     public void GuardarMetodoGrabberc() {
        try {

            Icon icono = lblPic.getIcon();
            RedimensionarImagen redimImagen = new RedimensionarImagen();

            if (this.cajerofr != null) {
                icono = redimImagen.imageToIcon(redimImagen.iconToBufferedImage(icono).getScaledInstance(cajerofr.lblImagen.getWidth(), cajerofr.lblImagen.getHeight(), 0));
                cajerofr.imagen = img.getBufferedImage();
                cajerofr.lblImagen.setIcon(icono);
                cajerofr.lblImagen.setText(null);
            }
            this.CerrarCamara();
            this.dispose();

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            System.out.println("+ " + e.getCause());
            JOptionPane.showMessageDialog(null, "Error al guardar la foto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) {
        try {
            int w = bufferedImage.getWidth();
            int h = bufferedImage.getHeight();
            BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
            Graphics2D g = bufim.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
            g.dispose();
            return bufim;
        } catch (NullPointerException n) {
            return null;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPic = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Camara");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        lblPic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton4.setText("Iniciar captura");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setText("Tomar foto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (camara != null) {
            CerrarCamara();
            camara.stop();
        }

        Flag = true;

        NumeroCamara = jComboBox1.getSelectedIndex();
        camara = new camara();
        camara.start();
        lblPic.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(cajerofr != null){
       this.GuardarMetodoGrabberc();
       }
       if(frMedicos !=null){
        GuardarMetodoGrabber();}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        this.CerrarCamara();
    }//GEN-LAST:event_formInternalFrameClosing

    public void CerrarCamara() {
        try {
            Flag = false;
            grabber.release();
        } catch (Exception e) {
        }

    }

    public void CargarCamara() {
        jComboBox1.removeAllItems();
        String[] Devices = null;
        try {
            Devices = VideoInputFrameGrabber.getDeviceDescriptions();
        } catch (FrameGrabber.Exception ex) {
            JOptionPane.showMessageDialog(null, "No Se Han Encontrado Cámaras Conectadas", "Cámaras No Encontradas", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (String Dev : Devices) {
            jComboBox1.addItem(Dev);
        }

    }

    public void MetodoGrabber() {
        try {
            grabber = new OpenCVFrameGrabber(NumeroCamara);
            grabber.start();
            while (Flag) {
                img = grabber.grab();
                if (img != null) {
                    cvFlip(img, img, 1);

                }

                icon = new ImageIcon(img.getBufferedImage());
                ImageIcon ic = new ImageIcon(resize(img.getBufferedImage(), 500, 400));
                lblPic.setIcon(ic);
            }//Fin while
        } catch (Exception ex) {
            System.out.println("");
        }

    }

    class camara extends Thread {

        public void run() {
            MetodoGrabber();
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    public javax.swing.JLabel lblPic;
    // End of variables declaration//GEN-END:variables
}
