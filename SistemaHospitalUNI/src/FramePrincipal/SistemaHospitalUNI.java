/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FramePrincipal;

import Conexion.DAO;
import Conexion.NewHibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author LuisAlfonso
 */
public class SistemaHospitalUNI {

    /**
     * @param args the command line arguments
     */
    private static SessionFactory sf;
    private static Session s;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Ejecutar();
        
    }
    
    private static void Ejecutar (){
            sf = NewHibernateUtil.conexion("root", "lacb2208", "3306", "localhost");
            if (sf != null) {
                    JOptionPane.showMessageDialog(null, "Hola "+" se ha conectado con exito a la base de datos!!", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                    
            } else {
                JOptionPane.showMessageDialog(null, "Revise su usuario y contraseña", "error en la coneccion", JOptionPane.ERROR_MESSAGE);
            }

        
    }
    
}
