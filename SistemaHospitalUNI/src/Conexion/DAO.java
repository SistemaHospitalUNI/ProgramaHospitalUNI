/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Pojo.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author crdzbird
 */
public class DAO {

    private static SessionFactory sf;
    private static Session s;
    
    public DAO(SessionFactory sf) {
        this.sf = sf;
    }

//------------- METODOS DE BUSQUEDA UNICA --------------------------------------
//------------ psdt: Tengo Sueño :'( -------------------------------------------
    public static Medico busquedaMedicoId(int id) {
        s = sf.openSession();
        List<Medico> lstMedico = (List<Medico>) s.createQuery("from Medico").list();
        for (Medico med : lstMedico) {
            if (id == med.getIdMedico()) {
                s.close();
                return med;
            }
        }
        s.close();
        return null;
    }

    public static Sector busquedaSectorId(int id) {
        s = sf.openSession();
        List<Sector> lstSector = (List<Sector>) s.createQuery("from Sector").list();
        for (Sector sect : lstSector) {
            if (id == sect.getIdSector()) {
                s.close();
                return sect;
            }
        }
        s.close();
        return null;
    }

    public static Paciente busquedaPacienteId(int id) {
        s = sf.openSession();
        List<Paciente> lstPaciente = (List<Paciente>) s.createQuery("from Paciente").list();
        for (Paciente pac : lstPaciente) {
            if (id == pac.getIdPaciente()) {
                s.close();
                return pac;
            }
        }
        s.close();
        return null;
    }

    public static Receta busquedaRecetaId(int id) {
        s = sf.openSession();
        List<Receta> lstReceta = (List<Receta>) s.createQuery("from Receta").list();
        for (Receta rec : lstReceta) {
            if (id == rec.getIdReceta()) {
                s.close();
                return rec;
            }
        }
        s.close();
        return null;
    }

    public static ProcedimientosEspeciales busquedaProcedimientosEspecialesId(int id) {
        s = sf.openSession();
        List<ProcedimientosEspeciales> lstProcedimientosEspeciales = (List<ProcedimientosEspeciales>) s.createQuery("from ProcedimientosEspeciales").list();
        for (ProcedimientosEspeciales procEspeciales : lstProcedimientosEspeciales) {
            if (id == procEspeciales.getIdProc()) {
                s.close();
                return procEspeciales;
            }
        }
        s.close();
        return null;
    }

    public static PadecimientoEc busquedaPadecimientoEcId(int id) {
        s = sf.openSession();
        List<PadecimientoEc> lstPadecimientoEc = (List<PadecimientoEc>) s.createQuery("from Padecimiento_EC").list();
        for (PadecimientoEc padec : lstPadecimientoEc) {
            if (id == padec.getIdPadecimientoec()) {
                s.close();
                return padec;
            }
        }
        s.close();
        return null;
    }

    public static Paciente16 busquedaPaciente16Id(int id) {
        s = sf.openSession();
        List<Paciente16> lstPaciente16 = (List<Paciente16>) s.createQuery("from Paciente_16").list();
        for (Paciente16 pac16 : lstPaciente16) {
            if (id == pac16.getIdPaciente()) {
                s.close();
                return pac16;
            }
        }
        s.close();
        return null;
    }

    public static HorarioMedico busquedaHorarioMedicoId(int id) {
        s = sf.openSession();
        List<HorarioMedico> lstHorarioMedico = (List<HorarioMedico>) s.createQuery("from HorarioMedico").list();
        for (HorarioMedico horMed : lstHorarioMedico) {
            if (id == horMed.getIdHorariomedico()) {
                s.close();
                return horMed;
            }
        }
        s.close();
        return null;
    }

    public static Examen busquedaExamenId(int id) {
        s = sf.openSession();
        List<Examen> lstExamen = (List<Examen>) s.createQuery("from Examen").list();
        for (Examen exam : lstExamen) {
            if (id == exam.getIdExamenDiagnostico()) {
                s.close();
                return exam;
            }
        }
        s.close();
        return null;
    }

    public static Especialidad busquedaEspecialidades(int id) {
        s = sf.openSession();
        List<Especialidad> lstEspecialidades = (List<Especialidad>) s.createQuery("from Especialidad").list();
        for (Especialidad esp : lstEspecialidades) {
            if (id == esp.getIdEspecialidad()) {
                s.close();
                return esp;
            }
        }
        s.close();
        return null;
    }

    public static EnfermedadCronica busquedaEnfermedadCronicaId(int id) {
        s = sf.openSession();
        List<EnfermedadCronica> lstEnfermedadCronica = (List<EnfermedadCronica>) s.createQuery("from Enfermedad_Cronica").list();
        for (EnfermedadCronica enfCron : lstEnfermedadCronica) {
            if (id == enfCron.getIdEc()) {
                s.close();
                return enfCron;
            }
        }
        s.close();
        return null;
    }

    public static Consulta busquedaConsultaId(int id) {
        s = sf.openSession();
        List<Consulta> lstConsulta = (List<Consulta>) s.createQuery("from Consulta").list();
        for (Consulta consulta : lstConsulta) {
            if (id == consulta.getIdConsulta()) {
                s.close();
                return consulta;
            }
        }
        s.close();
        return null;
    }

    public static CatalogoExamen busquedaCatalogoExamenId(int id) {
        s = sf.openSession();
        List<CatalogoExamen> lstCatalogoExamen = (List<CatalogoExamen>) s.createQuery("from Catalogo_Examen").list();
        for (CatalogoExamen catExam : lstCatalogoExamen) {
            if (id == catExam.getIdExamen()) {
                s.close();
                return catExam;
            }
        }
        s.close();
        return null;
    }

    public static Cajero busquedaCajeroId(int id) {
        s = sf.openSession();
        List<Cajero> lstCajero = (List<Cajero>) s.createQuery("from Cajero").list();
        for (Cajero cajero : lstCajero) {
            if (id == cajero.getIdCajero()) {
                s.close();
                return cajero;
            }
        }
        s.close();
        return null;
    }

    public static Diagnostico busquedaDiagnosticoId(int id) {
        s = sf.openSession();
        List<Diagnostico> lstDiagnostico = (List<Diagnostico>) s.createQuery("from Diagnostico").list();
        for (Diagnostico diagnos : lstDiagnostico) {
            if (id == diagnos.getIdDiagnostico()) {
                s.close();
                return diagnos;
            }
        }
        s.close();
        return null;
    }

    public static Cita busquedaCitaId(int id) {
        s = sf.openSession();
        List<Cita> lstCita = (List<Cita>) s.createQuery("from Cita").list();
        for (Cita cita : lstCita) {
            if (id == cita.getIdCita()) {
                s.close();
                return cita;
            }
        }
        s.close();
        return null;
    }

    public static PadecimientoAm busquedaPadecimientoAmId(int id) {
        s = sf.openSession();
        List<PadecimientoAm> lstPadecimientoAm = (List<PadecimientoAm>) s.createQuery("from Padecimiento_AM").list();
        for (PadecimientoAm padecimientoAm : lstPadecimientoAm) {
            if (id == padecimientoAm.getIdPadecimientoam()) {
                s.close();
                return padecimientoAm;
            }
        }
        s.close();
        return null;
    }

    public static AlergiaMedicamento busquedaAlergiaMedicamentoId(int id) {
        s = sf.openSession();
        List<AlergiaMedicamento> lstAlergiaMedicamento = (List<AlergiaMedicamento>) s.createQuery("from AlergiaMedicamento").list();
        for (AlergiaMedicamento alergiaMed : lstAlergiaMedicamento) {
            if (id == alergiaMed.getIdAlergia()) {
                s.close();
                return alergiaMed;
            }
        }
        s.close();
        return null;
    }
//------------- Metodos De Busqueda Final -------------------------------------

//------------- Metodos de Listar Tablas --------------------------------------
    public static List<AlergiaMedicamento> Listar_AlergiaMedicamento() {
        s = sf.openSession();
        List<AlergiaMedicamento> lstAlergiaMed = (List<AlergiaMedicamento>) s.createQuery("from AlergiaMedicamento").list();
        s.close();
        return lstAlergiaMed;
    }

    public static List<Cajero> Listar_Cajero() {
        s = sf.openSession();
        List<Cajero> lstCajero = (List<Cajero>) s.createQuery("from Cajero").list();
        s.close();
        return lstCajero;
    }

    public List<CatalogoExamen> Listar_CatalogoExamen() {
        s = sf.openSession();
        List<CatalogoExamen> lstCatalogoExamen = (List<CatalogoExamen>) s.createQuery("from CatalogoExamen").list();
        s.close();
        return lstCatalogoExamen;
    }

    public static List<Cita> Listar_Cita() {
        s = sf.openSession();
        List<Cita> lstCita = (List<Cita>) s.createQuery("from Cita").list();
        s.close();
        return lstCita;
    }

    public static List<Consulta> Listar_Consulta() {
        s = sf.openSession();
        List<Consulta> lstConsulta = (List<Consulta>) s.createQuery("from Consulta").list();
        s.close();
        return lstConsulta;
    }

    public static List<EnfermedadCronica> Listar_EnfermedadCronica() {
        s = sf.openSession();
        List<EnfermedadCronica> lstEnfermedadCronica = (List<EnfermedadCronica>) s.createQuery("from Enfermedad_Cronica").list();
        s.close();
        return lstEnfermedadCronica;
    }

    public static List<Diagnostico> listar_Diagnostico() {
        s = sf.openSession();
        List<Diagnostico> listDiagnostico = (List<Diagnostico>) s.createQuery("from Diagnostico").list();
        s.close();
        return listDiagnostico;
    }

    public static List<Examen> Listar_Examen() {
        s = sf.openSession();
        List<Examen> lstExamen = (List<Examen>) s.createQuery("from Examen").list();
        s.close();
        return lstExamen;
    }

    public static List<Especialidad> Listar_Especialidades() {
        s = sf.openSession();
        List<Especialidad> lstEspecialidades = (List<Especialidad>) s.createQuery("from Especialidad").list();
        s.close();
        return lstEspecialidades;
    }

    public static List<HorarioMedico> Listar_HorarioMedico() {
        s = sf.openSession();
        List<HorarioMedico> lstHorarioMedico = (List<HorarioMedico>) s.createQuery("from HorarioMedico").list();
        s.close();
        return lstHorarioMedico;
    }

    public static List<Medico> Listar_Medicos() {
        s = sf.openSession();
        List<Medico> lstMedico = (List<Medico>) s.createQuery("from Medico").list();
        s.close();
        return lstMedico;
    }

    public static List<Paciente> Listar_Pacientes() {
        s = sf.openSession();
        List<Paciente> prov = (List<Paciente>) s.createQuery("from Paciente").list();
        s.close();
        return prov;
    }

    public static List<Paciente16> Listar_Pacientes16() {
        s = sf.openSession();
        List<Paciente16> prov = (List<Paciente16>) s.createQuery("from Paciente_16").list();
        s.close();
        return prov;
    }

    public static List<PadecimientoAm> Listar_PadecimientoAm() {
        s = sf.openSession();
        List<PadecimientoAm> prov = (List<PadecimientoAm>) s.createQuery("from Padecimiento_AM").list();
        s.close();
        return prov;
    }

    public static List<PadecimientoEc> Listar_PadecimientoEc() {
        s = sf.openSession();
        List<PadecimientoEc> lstPadecimientoEc = (List<PadecimientoEc>) s.createQuery("from Padecimiento_EC").list();
        s.close();
        return lstPadecimientoEc;
    }

    public static List<ProcedimientosEspeciales> Listar_ProcedimientosEspeciales() {
        s = sf.openSession();
        List<ProcedimientosEspeciales> lstProcedimientosEspeciales = (List<ProcedimientosEspeciales>) s.createQuery("from ProcedimientosEspeciales").list();
        s.close();
        return lstProcedimientosEspeciales;
    }

    public static List<Receta> Listar_Recetas() {
        s = sf.openSession();
        List<Receta> lstReceta = (List<Receta>) s.createQuery("from Receta").list();
        s.close();
        return lstReceta;
    }

    public List<Sector> Listar_Sectores() {
        s = sf.openSession();
        List<Sector> lstSector = (List<Sector>) s.createQuery("from Sector").list();

        return lstSector;
    }
//------------- Fin Metodos Listar Tablas -------------------------------------

//------------- Inicio Metodos Guardar Objetos --------------------------------
    public static boolean GuardarAlergiaMedicamento(String nombre, String descr) {
        s = sf.openSession();
        AlergiaMedicamento alergiaMed = new AlergiaMedicamento();
        alergiaMed.setNombre(nombre);
        alergiaMed.setDescripcion(descr);
        s.beginTransaction();
        s.save(alergiaMed);
        s.getTransaction().commit();
        s.close();
        return true;
    }

    public static boolean GuardarCajero(String nombre, String apellido, String cedula, byte[] foto) {
        s = sf.openSession();
        Cajero cajero = new Cajero();
        cajero.setNombre(nombre);
        cajero.setApellido(apellido);
        cajero.setCedula(cedula);
        cajero.setFoto(foto);
        s.beginTransaction();
        s.save(cajero);
        s.getTransaction().commit();
        s.close();
        return true;
    }
/*
    public static boolean GuardarCita(int idMedico, int idPaciente, String fecha, String hora, String estado) {
        s = sf.openSession();
        Cita cita = new Cita();
        cita.setMedico((Medico) s.get(Medico.class, idMedico));
        cita.setPaciente((Paciente) s.get(Paciente.class, idPaciente));
        cita.setFecha(java.sql.Date.valueOf(fecha));
        cita.setHora(java.sql.Time.valueOf(hora));
        cita.setEstado(estado);
        s.beginTransaction();
        s.save(cita);
        s.getTransaction().commit();
        s.close();
        return true;
    }
*/
    public int guardarSector(String barrio, String distrito) {
        try {
            int ss;
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            Sector sector = new Sector();
            sector.setBarrio(barrio);
            sector.setDistrito(distrito);
            ss = (int) s.save(sector);//Retorna el ID con el que guardo            
            t.commit();
            // return true;
            return ss;// ss contiene el ID del objeto que se guarda en la base de datos
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
   
    public int GuardarCatalogoExamen(CatalogoExamen c){
         try{
            int ss;
            s = sf.openSession();
            Transaction t = s.beginTransaction();
            ss =(int) s.save(c);//Retorna el ID con el que guardo            
            t.commit();
           // return true;
            return ss;// ss contiene el ID del objeto que se guarda en la base de datos
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return -1;
        }
    
    }
   
//------------- Fin Metodos Guardar Objetos ----------------------------------- 
//    public DefaultTableModel TablaCatalogoExamen(){
//try{
//    s = sf.openSession();
//    t= s.beginTransaction();
//    String col[]={"Nombre","Precio","Descripcion"};
//    m.setColumnIdentifiers(col);
//        listaCatalogo = (List<CatalogoExamen>) s.createQuery("from Catalogo_Examen").list();
//        for(CatalogoExamen c : listaCatalogo){
//        String vector[]={c.getNombre(),String.valueOf(c.getPrecio()),c.getDescripcion()};
//        m.addRow(vector);
//        vector=null;
//        }
//        t.commit();
//        s.close();
//            }catch(Exception e){JOptionPane.showMessageDialog(null, "Error Al cargar tabla");
//            System.out.println(""+e.getMessage());}
//
//    return m;
//    
//}
}
