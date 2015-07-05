/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.text.JTextComponent;

/**
 *
 * @author crdzbird
 */
public class Validador {

    public static void validaTexto(KeyEvent evt) {
        if (!(Character.isLetter(evt.getKeyChar()) || Character.isSpaceChar(evt.getKeyChar()))) {
            evt.consume();
        }
    }

    public static void validaDecimal(KeyEvent evt) {
        JTextComponent component = (JTextComponent) evt.getSource();
        if (!(Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == '.' && !component.getText().contains(".") && component.getSelectionStart() != 0))) {
            evt.consume();
        }
    }

    public static void validaEntero(KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }

    public static void validaEntero(MouseEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
