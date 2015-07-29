/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author crdzbird
 */
public class Usuarios {

    private static SessionFactory sf;
    private static Session s;

    public Usuarios(SessionFactory sf) {
        this.sf = sf;
    }

    public static boolean ActualizarUsuario(String nombreUsuarioNuevo, String nombreUsuario, String password) {
        try {
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            String query2 = "RENAME USER '" + nombreUsuario + "'@localhost TO '" + nombreUsuarioNuevo + "'@localhost;";
            String query = "UPDATE mysql.user SET Password=PASSWORD('" + password + "')" + "Where User='" + nombreUsuario + "' AND Host='localhost';";
            Query q2 = s.createSQLQuery(query2);
            q2.executeUpdate();
            
            System.out.println("" + query);
            Query q = s.createSQLQuery(query);
            q.executeUpdate();
            t.commit();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() + " CAUSA: " + e.getCause());
            return false;
        } finally {
            s.close();
        }

        return true;
    }

    public static boolean CrearUsuario(String nombreUsuario, String password) {
        try {
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            String query = "create User '" + nombreUsuario + "'@'localhost' identified by '" + password + "';";
            System.out.println("" + query);
            Query q = s.createSQLQuery(query);
            q.executeUpdate();
            t.commit();

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() + " CAUSA: " + e.getCause());
            return false;
        } finally {
            s.close();
        }

        return true;
    }

    public boolean ExisteUsuario(String nombreUsuario) {
        try {
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            Query q = s.createQuery("from Medico where Usuario =:parametro");
            q.setString("parametro", nombreUsuario);
            if (q.list().size() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage() + " CAUSA: " + e.getCause());
            return true;
        } finally {
            s.close();
        }
    }

    //root   lacb2208
    public static boolean AsignarPermisosSecretaria(String usuario) {
        try {
            s = sf.openSession();
            Transaction t = s.beginTransaction();

            String query = "grant select,insert,update on SistemaHospital.Cajero to '" + usuario + "'@'localhost';";
            String query2 = "grant select,insert,update on SistemaHospital.CatalogoExamen to '" + usuario + "'@'localhost';";
            String query4 = "grant insert,select on SistemaHospital.Cita to '" + usuario + "'@'localhost';";
            String query5 = "grant insert,select on SistemaHospital.Consulta to '" + usuario + "'@'localhost';";
            String query6 = "grant insert,select on SistemaHospital.DetalleConsulta to '" + usuario + "'@'localhost';";
            String query7 = "grant select on SistemaHospital.DetalleFacturaExamen to '" + usuario + "'@'localhost';";
            String query8 = "grant select,insert on SistemaHospital.DetalleFacturaProcedimiento to '" + usuario + "'@'localhost';";
            String query9 = "grant select,insert on SistemaHospital.DiasMedico to '" + usuario + "'@'localhost';";
            String query10 = "grant select,insert on SistemaHospital.Especialidad to '" + usuario + "'@'localhost';";
            String query11 = "grant insert on SistemaHospital.Examen to '" + usuario + "'@'localhost';";
            String query12 = "grant insert on SistemaHospital.FacturaConsulta to '" + usuario + "'@'localhost';";
            String query13 = "grant select on SistemaHospital.FacturaExamen to '" + usuario + "'@'localhost';";
            String query14 = "grant select on SistemaHospital.HorarioMedico to '" + usuario + "'@'localhost';";
            String query15 = "grant select on SistemaHospital.Medico to '" + usuario + "'@'localhost';";
            String query16 = "grant select on SistemaHospital.ProcedimientosEspeciales to '" + usuario + "'@'localhost';";
            String query17 = "grant select on SistemaHospital.Receta to '" + usuario + "'@'localhost';";
            Query q = s.createSQLQuery(query);
            q.executeUpdate();

            q = s.createSQLQuery(query2);
            q.executeUpdate();

            q = s.createSQLQuery(query4);
            q.executeUpdate();

            q = s.createSQLQuery(query5);
            q.executeUpdate();

            q = s.createSQLQuery(query6);
            q.executeUpdate();

            q = s.createSQLQuery(query7);
            q.executeUpdate();

            q = s.createSQLQuery(query8);
            q.executeUpdate();

            q = s.createSQLQuery(query9);
            q.executeUpdate();

            q = s.createSQLQuery(query10);
            q.executeUpdate();

            q = s.createSQLQuery(query11);
            q.executeUpdate();

            q = s.createSQLQuery(query12);
            q.executeUpdate();

            q = s.createSQLQuery(query13);
            q.executeUpdate();

            q = s.createSQLQuery(query14);
            q.executeUpdate();

            q = s.createSQLQuery(query15);
            q.executeUpdate();

            q = s.createSQLQuery(query16);
            q.executeUpdate();

            q = s.createSQLQuery(query17);
            q.executeUpdate();
            t.commit();

        } catch (Exception e) {

            return false;
        } finally {
            s.close();
        }

        return true;
    }

    public static boolean AsignarPermisosMedicos(String usuario) {
        try {
            s = sf.openSession();
            Transaction t = s.beginTransaction();

            String query = "grant select,insert,update on SistemaHospital.AlergiaMedicamento to '" + usuario + "'@'localhost';";
            String query2 = "grant select,insert,update on SistemaHospital.CatalogoExamen to '" + usuario + "'@'localhost';";
            String query4 = "grant insert,select on SistemaHospital.Cita to '" + usuario + "'@'localhost';";
            String query5 = "grant insert,select on SistemaHospital.Consulta to '" + usuario + "'@'localhost';";
            String query6 = "grant insert,select on SistemaHospital.DetalleConsulta to '" + usuario + "'@'localhost';";
            String query7 = "grant select on SistemaHospital.Diagnostico to '" + usuario + "'@'localhost';";
            String query8 = "grant select,insert on SistemaHospital.DiasMedico to '" + usuario + "'@'localhost';";
            String query9 = "grant select,insert on SistemaHospital.EnfermedadCronica to '" + usuario + "'@'localhost';";
            String query10 = "grant select,insert on SistemaHospital.Especialidad to '" + usuario + "'@'localhost';";
            String query11 = "grant insert on SistemaHospital.Examen to '" + usuario + "'@'localhost';";
            String query12 = "grant insert on SistemaHospital.HorarioMedico to '" + usuario + "'@'localhost';";
            String query13 = "grant select on SistemaHospital.Medico to '" + usuario + "'@'localhost';";
            String query14 = "grant select on SistemaHospital.Paciente16 to '" + usuario + "'@'localhost';";
            String query15 = "grant select on SistemaHospital.PadecimientoAM to '" + usuario + "'@'localhost';";
            String query16 = "grant select on SistemaHospital.PadecimientoEC to '" + usuario + "'@'localhost';";
            String query17 = "grant select on SistemaHospital.ProcedimientosEspeciales to '" + usuario + "'@'localhost';";
            String query18 = "grant select on SistemaHospital.Receta to '" + usuario + "'@'localhost';";
            String query19 = "grant select on SistemaHospital.Sector to '" + usuario + "'@'localhost';";
            Query q = s.createSQLQuery(query);
            q.executeUpdate();

            q = s.createSQLQuery(query2);
            q.executeUpdate();

            q = s.createSQLQuery(query4);
            q.executeUpdate();

            q = s.createSQLQuery(query5);
            q.executeUpdate();

            q = s.createSQLQuery(query6);
            q.executeUpdate();

            q = s.createSQLQuery(query7);
            q.executeUpdate();

            q = s.createSQLQuery(query8);
            q.executeUpdate();

            q = s.createSQLQuery(query9);
            q.executeUpdate();

            q = s.createSQLQuery(query10);
            q.executeUpdate();

            q = s.createSQLQuery(query11);
            q.executeUpdate();

            q = s.createSQLQuery(query12);
            q.executeUpdate();

            q = s.createSQLQuery(query13);
            q.executeUpdate();

            q = s.createSQLQuery(query14);
            q.executeUpdate();

            q = s.createSQLQuery(query15);
            q.executeUpdate();

            q = s.createSQLQuery(query16);
            q.executeUpdate();

            q = s.createSQLQuery(query17);
            q.executeUpdate();

            q = s.createSQLQuery(query18);
            q.executeUpdate();

            q = s.createSQLQuery(query19);
            q.executeUpdate();
            t.commit();

        } catch (Exception e) {

            return false;
        } finally {
            s.close();
        }

        return true;

    }

    public static boolean AsignarPermisosAdministrador(String usuario) {

        try {
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            String query = "GRANT ALL ON SistemaHospital.* TO '" + usuario + "'@'localhost';";
            Query q = s.createSQLQuery(query);
            q.executeUpdate();
            t.commit();
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }

        return true;

    }

}
