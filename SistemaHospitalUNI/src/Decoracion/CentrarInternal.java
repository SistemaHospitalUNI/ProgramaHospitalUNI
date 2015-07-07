/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decoracion;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author crdzbird
 */
public class CentrarInternal {

    public static void Centrar(JInternalFrame ia, JDesktopPane Escritorio) {
        int x = (Escritorio.getWidth() / 2) - ia.getWidth() / 2;
        int y = (Escritorio.getHeight() / 2) - ia.getHeight() / 2;
        Escritorio.add(ia);
        ia.setLocation(x, y);
        ia.setVisible(true);
    }
}
