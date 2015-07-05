/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decoracion;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JLayer;
import javax.swing.plaf.LayerUI;

/**
 *
 * @author crdzbird
 */
public class Animacion {

    public static JLayer<JComponent> gradiente(JComponent component, final float opacidad, final Color color1, final Color color2) {
        LayerUI<JComponent> layerUI = new LayerUI<JComponent>() {
            @Override
            public void paint(Graphics g, JComponent c) {
                super.paint(g, c); //To change body of generated methods, choose Tools | Templates.
                Graphics2D g2 = (Graphics2D) g.create();
                //.3
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacidad));
                g2.setPaint(new GradientPaint(0, 0, color1, 0, c.getHeight(), color2));
                g2.fillRect(0, 0, c.getWidth(), c.getHeight());
                g2.dispose();
            }
        };
        return new JLayer<>(component, layerUI);
    }
}
