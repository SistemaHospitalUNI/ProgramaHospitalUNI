/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author crdzbird
 */
public class NewHibernateUtil {

    private static SessionFactory sessionFactory = null;

    public static SessionFactory conexion(String login, String Contraseña, String Puerto, String IP) {
        try {
            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:" + Puerto + "/SistemaHospital", login, Contraseña);
                conexion.close();
            } catch (SQLException e) {
                return null;
            }
            sessionFactory = (SessionFactory) new Configuration()
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:" + Puerto + "/SistemaHospital")
                    .setProperty("hibernate.connection.username", login)
                    .setProperty("hibernate.connection.password", Contraseña)
                    .addResource("Pojo/AlergiaMedicamento.hbm.xml")
                    .addResource("Pojo/Cajero.hbm.xml")
                    .addResource("Pojo/CatalogoExamen.hbm.xml")
                    .addResource("Pojo/Cita.hbm.xml")
                    .addResource("Pojo/Consulta.hbm.xml")
                    .addResource("Pojo/DetalleConsulta.hbm.xml")
                    .addResource("Pojo/DetalleFactpro.hbm.xml")
                    .addResource("Pojo/DetalleFacturaEx.hbm.xml")
                    .addResource("Pojo/Diagnostico.hbm.xml")
                    .addResource("Pojo/DiasMedico.hbm.xml")
                    .addResource("Pojo/EnfermedadCronica.hbm.xml")
                    .addResource("Pojo/Especialidad.hbm.xml")
                    .addResource("Pojo/Examen.hbm.xml")
                    .addResource("Pojo/FacturaConsulta.hbm.xml")
                    .addResource("Pojo/FacturaExamen.hbm.xml")
                    .addResource("Pojo/HorarioMedico.hbm.xml")
                    .addResource("Pojo/Medico.hbm.xml")
                    .addResource("Pojo/Paciente.hbm.xml")
                    .addResource("Pojo/Paciente16.hbm.xml")
                    .addResource("Pojo/PadecimientoAm.hbm.xml")
                    .addResource("Pojo/PadecimientoEc.hbm.xml")
                    .addResource("Pojo/ProcedimientosEspeciales.hbm.xml")
                    .addResource("Pojo/Receta.hbm.xml")
                    .addResource("Pojo/Sector.hbm.xml")
                    .buildSessionFactory();

        } catch (HibernateException ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        return sessionFactory;
    }
}
