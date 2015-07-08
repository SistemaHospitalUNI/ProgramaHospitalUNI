/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decoracion;

import java.awt.Image;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.ImageIcon;

/**
 *
 * @author crdzbird
 */
public class Imagenes {

    public static final ImageIcon ELIMINAR
            = new javax.swing.ImageIcon(Imagenes.class.getResource("/imagenes/1389270705_Remove-Male-User.png"));
    public static final ImageIcon ACTIVAR
            = new javax.swing.ImageIcon(Imagenes.class.getResource("/imagenes/1389270712_Accept-Male-User.png"));
    public static final ImageIcon MODIFICAR
            = new javax.swing.ImageIcon(Imagenes.class.getResource("/imagenes/1389270890_Edit-Male-User.png"));
    public static final ImageIcon NUEVO
            = new javax.swing.ImageIcon(Imagenes.class.getResource("/imagenes/1389270701_Add-Male-User.png"));
    public static final ImageIcon CERRAR
            = new javax.swing.ImageIcon(Imagenes.class.getResource("/imagenes/1389271259_close.png"));
    public static final ImageIcon PDF
            = new javax.swing.ImageIcon(Imagenes.class.getResource("/imagenes/pdf.png"));
    public static final ImageIcon LOGOUT
            = new javax.swing.ImageIcon(Imagenes.class.getResource("/imagenes/logout.png"));
    public static final ImageIcon CAFE
            = new javax.swing.ImageIcon(Imagenes.class.getResource("/imagenes/coffee.jpg"));
    public static final ImageIcon OK
            = new javax.swing.ImageIcon(Imagenes.class.getResource("/imagenes/ok.png"));
    public static final ImageIcon CANCEL
            = new javax.swing.ImageIcon(Imagenes.class.getResource("/imagenes/cancel.png"));

    public static ImageIcon getImageIcon(byte[] array) {
        return new ImageIcon(array);
    }

    public static byte[] getByteArray(Path path) throws IOException {
        return Files.readAllBytes(path);
    }

    public static ImageIcon getScaledInstance(ImageIcon icon, int width, int height) {
        return new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    }
}
