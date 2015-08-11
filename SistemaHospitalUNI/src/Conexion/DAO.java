/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Pojo.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author crdzbird
 */
public class DAO {

    private static Session s = null;
    private static SessionFactory sf;

    private static boolean valid;

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
            if (id == horMed.getDiasMedico().getIdDiaMedico()) {
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

    public static FacturaExamen busquedaFacturaExamenId(int id) {

        s = sf.openSession();
        List<FacturaExamen> listfactex = s.createQuery("from FacturaExamen").list();
        for (FacturaExamen fe : listfactex) {
            if (fe.getIdFacturaex() == id) {
                s.close();
                return fe;
            }
        }
        s.close();
        return null;
    }
      public static FacturaConsulta busquedaFacturaConsultaId(int id) {

        s = sf.openSession();
        List<FacturaConsulta> listfactex = s.createQuery("from FacturaConsulta").list();
        for (FacturaConsulta fe : listfactex) {
            if (fe.getIdFactura() == id) {
                s.close();
                return fe;
            }
        }
        s.close();
        return null;
    }

    public static Especialidad busquedaEspecialidadId(int id) {
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

    public static Especialidad busquedaEspecialidadNomre(String nombre) {
        s = sf.openSession();
        List<Especialidad> lstEspecialidades = (List<Especialidad>) s.createQuery("from Especialidad").list();
        for (Especialidad esp : lstEspecialidades) {
            if (nombre.equals(esp.getNombreEspecialidad())) {
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
        List<CatalogoExamen> lstCatalogoExamen = (List<CatalogoExamen>) s.createQuery("from CatalogoExamen").list();
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

    public static DiasMedico busquedaDiasMedicosId(int id) {
        s = sf.openSession();
        List<DiasMedico> lstDiasMedicos = (List<DiasMedico>) s.createQuery("from DiasMedico").list();
        for (DiasMedico diasMedicos : lstDiasMedicos) {
            if (id == diasMedicos.getIdDiaMedico()) {
                return diasMedicos;
            }
        }
        s.close();
        return null;
    }

    public static Cita busquedaCitaId(int id) {
        s = sf.openSession();
        List<Cita> lstCita = (List<Cita>) s.createQuery("from Cita").list();
        for (Cita cita : lstCita) {
            if (id == cita.getMedico().getIdMedico()) {
                System.out.println("CITA ENCONTRADA!!");
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

    public static List<Pojo.Cajero> Listar_Cajero() {
        s = sf.openSession();
        List<Cajero> lstCajero = (List<Cajero>) s.createQuery("from Cajero").list();
        s.close();
        return lstCajero;
    }

    public static List<CatalogoExamen> Listar_CatalogoExamen() {
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

    public static List<Cita> Listar_Cita_Medico_Especifico() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-mm-dd");
        s = sf.openSession();
        List<Cita> lstCita = (List<Cita>) s.createQuery("from Cita").list();
        for (Cita cit : lstCita) {
            System.out.println("ID CITA:" + cit.getIdCita());
            System.out.println("HORA DE LA CITA:" + cit.getHora());
            System.out.println("FECHA DE LA CITA:" + dateFormat.format(cit.getFecha()));
            System.out.println("MEDICO A CARGO:" + cit.getMedico().getPrimernombre() + " " + cit.getMedico().getSegundonombre() + " " + cit.getMedico().getPrimerapellido() + " " + cit.getMedico().getSegundoapellido());
            System.out.println("PACIENTE DE LA CITA:" + cit.getPaciente().getNombre() + " " + cit.getPaciente().getApellido());
        }
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

    public static List<Sector> Listar_Sectores() {
        s = sf.openSession();
        List<Sector> lstSector = (List<Sector>) s.createQuery("from Sector").list();
        s.close();
        return lstSector;
    }

    public  List<FacturaConsulta> ListarFacturaConsulta() {
        s = sf.openSession();
        List<FacturaConsulta> lista = s.createQuery("from FacturaConsulta").list();
        s.close();
        return lista;
    }
    public  List<DetalleFacturaEx> ListarDetFactEx() {
        s = sf.openSession();
        List<DetalleFacturaEx> lista = s.createQuery("from DetalleFacturaEx").list();
        s.close();
        return lista;
    }
    
    public  List<DetalleFactpro> ListarDetFactPro() {
        s = sf.openSession();
        List<DetalleFactpro> lista = s.createQuery("from DetalleFactpro").list();
        s.close();
        return lista;
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

    public static int GuardarEspecialidad(String nombre, String descripcion) {
        s = sf.openSession();
        try {
            int flag;

            Especialidad especialidad = new Especialidad();
            especialidad.setNombreEspecialidad(nombre);
            especialidad.setDescripcion(descripcion);
            s.beginTransaction();
            flag = (int) s.save(especialidad);
            s.getTransaction().commit();
            return flag;
        } catch (Exception ex) {
            return -1;
        } finally {
            s.close();
        }

    }

    public static int GuardarCajero(Cajero cajero) {
        cajero.setEstado(true);
        int id = -1;
        s = sf.openSession();
        s.beginTransaction();
        id = (int) s.save(cajero);
        s.getTransaction().commit();
        s.close();
        return id;
    }

    public static int GuardarCita(int idMedico, int idPaciente, String fecha, String hora, boolean estado) {
        int flag;
        s = sf.openSession();
        try {

            Transaction t = s.beginTransaction();
            Cita cita = new Cita();
            cita.setMedico((Medico) s.get(Medico.class, idMedico));
            cita.setPaciente((Paciente) s.get(Paciente.class, idPaciente));
            cita.setFecha(java.sql.Date.valueOf(fecha));
            cita.setHora(hora);
            cita.setEstado(estado);
            flag = (int) s.save(cita);
            t.commit();
            return flag;
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage() + " CAUSA: " + ex.getCause() + " LOCALIZACION: " + ex.getLocalizedMessage());

            return -1;
        } finally {
            s.close();
        }
    }

    public static int guardarSector(String barrio, String distrito) {
        s = sf.openSession();
        try {
            int ss;
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
        } finally {
            s.close();
        }
    }

    public static int GuardarHorarioMedico(int idDiaMedico, String horaInicio, String horaFinal) {
        s = sf.openSession();
        try {
            int flag;
            Transaction t = s.beginTransaction();
            HorarioMedico horarioMedico = new HorarioMedico();
            horarioMedico.setDiasMedico((DiasMedico) s.get(DiasMedico.class, idDiaMedico));
            horarioMedico.setHoraEntrada(horaInicio);
            horarioMedico.setHoraSalida(horaFinal);
            flag = (int) s.save(horarioMedico);//Retorna el ID con el que guardo            
            t.commit();
            return flag;
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + " CAUSA: " + ex.getCause());
            return -1;
        } finally {
            s.close();
        }
    }

    public static int GuardarDiaMedico(int idMedico, boolean Lunes, boolean Martes, boolean Miercoles, boolean Jueves, boolean Viernes, boolean Sabado, boolean Domingo) {
        s = sf.openSession();
        try {
            int id;
            Transaction t = s.beginTransaction();
            DiasMedico diasMedico = new DiasMedico();
            diasMedico.setMedico((Medico) s.get(Medico.class, idMedico));
            diasMedico.setLunes(Lunes);
            diasMedico.setMartes(Martes);
            diasMedico.setMiercoles(Miercoles);
            diasMedico.setJueves(Jueves);
            diasMedico.setViernes(Viernes);
            diasMedico.setSabado(Sabado);
            diasMedico.setDomingo(Domingo);
            id = (int) s.save(diasMedico);//Retorna el ID con el que guardo            
            t.commit();
            return id;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        } finally {
            s.close();
        }
    }

    public static int GuardarCatalogoExamen(CatalogoExamen c) {
        s = sf.openSession();
        try {
            int ss;
            Transaction t = s.beginTransaction();
            ss = (int) s.save(c);//Retorna el ID con el que guardo            
            t.commit();
            // return true;
            return ss;// ss contiene el ID del objeto que se guarda en la base de datos
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        } finally {
            s.close();
        }

    }

    public static int GuardarProcedimiento(ProcedimientosEspeciales c) {
        s = sf.openSession();
        try {
            int ss;
            Transaction t = s.beginTransaction();
            ss = (int) s.save(c);//Retorna el ID con el que guardo            
            t.commit();
            // return true;
            return ss;// ss contiene el ID del objeto que se guarda en la base de datos
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        } finally {
            s.close();
        }

    }

    public static int GuardarMedico(String nombre, String SNombre, String Apellido, String SApellido, String cedula, int idEspecialidad, String usuario, String direccion, boolean estado, byte[] fotos) {
        
        s = sf.openSession();
        try {
            int bandera;
            Transaction t = s.beginTransaction();
            Medico medico = new Medico();
            medico.setPrimernombre(nombre);
            medico.setSegundonombre(SNombre);
            medico.setPrimerapellido(Apellido);
            medico.setSegundoapellido(SApellido);
            medico.setCedula(cedula);
            medico.setEspecialidad((Especialidad) s.get(Especialidad.class, idEspecialidad));
            medico.setUsuario(usuario);
            medico.setDireccion(direccion);
            medico.setEstado(estado);
            medico.setFoto(fotos);
            bandera = (int) s.save(medico);
            t.commit();
            return bandera;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage() + "  CAUSA: " + ex.getCause());
            return -1;
        } finally {
            s.close();
        }

    }

    public static int ActualizarDiasMedico(DiasMedico dMedico) {
        int flag;
        if (s.isOpen()) {
            s.close();
            System.out.println("SESSION ABIERTA EN DIA MEDICO!!!");
        }
        s = sf.openSession();
        try {
            s.beginTransaction();
            s.update(dMedico);
            s.getTransaction().commit();
            flag = 1;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage() + "  CAUSA: " + ex.getCause() + " LUGAR: " + ex.getLocalizedMessage());
            flag = -1;
        } finally {
            s.close();
        }
        return flag;
    }

    public static int ActualizarHorasMedico(HorarioMedico hMedico) {
        int flag;
        if (s.isOpen()) {
            s.close();
            System.out.println("SESSION ABIERTA EN HORAS MEDICO!!!");
        }
        s = sf.openSession();
        try {
            s.beginTransaction();
            s.update(hMedico);
            s.getTransaction().commit();
            flag = 1;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage() + "  CAUSA: " + ex.getCause());
            flag = -1;
        } finally {
            s.close();
        }
        return flag;
    }

    public static int ActualizarMedico(String usuarioNuevo, Medico medico, String pass) {
        int flag;
        s = sf.openSession();
        //valid = Usuarios.ActualizarUsuario(usuarioNuevo, pass);
        //if (!valid) {
        //    System.out.println("USUARIO NO ACTUALIZADO!");
        //}
        System.out.println("USUARIO ACTUALIZADO!");
        try {
            s.beginTransaction();
            s.update(medico);
            s.getTransaction().commit();
            flag = 1;
        } catch (Exception ex) {
            System.out.println("Medico no Actualizado");
            System.out.println("Error: " + ex.getMessage() + "  CAUSA: " + ex.getCause() + " LUGAR: " + ex.getLocalizedMessage());
            flag = -1;
        } finally {
            s.close();
        }
        return flag;
    }

    public static boolean ActualizarEspecialidad(int id, String nombre, String descripcion) {
        s = sf.openSession();
        Especialidad especialidad = new Especialidad();
        especialidad.setIdEspecialidad(id);
        especialidad.setNombreEspecialidad(nombre);
        especialidad.setDescripcion(descripcion);
        s.beginTransaction();
        s.update(especialidad);
        s.getTransaction().commit();
        s.close();
        return true;
    }

//------------- Fin Metodos Guardar Objetos ----------------------------------- 
    public static boolean ActualizarCatalogoEx(CatalogoExamen ce) {
        s = sf.openSession();
        s.beginTransaction();
        s.update(ce);
        s.getTransaction().commit();
        s.close();
        return true;
    }

    public static boolean ActualizarProcEsp(ProcedimientosEspeciales ce) {
        s = sf.openSession();
        s.beginTransaction();
        s.update(ce);
        s.getTransaction().commit();
        s.close();
        return true;
    }

    public static boolean ActualizarCajero(Cajero ce) {
        s = sf.openSession();
        s.beginTransaction();
        s.update(ce);
        s.getTransaction().commit();
        s.close();
        return true;
    }

    public static boolean ActualizarFacturaExamen(FacturaExamen fe) {
        s = sf.openSession();
        s.beginTransaction();
        s.update(fe);
        s.getTransaction().commit();
        s.close();
        return true;

    }

    public  List<FacturaExamen> ListarFacturaExamen() {
        s = sf.openSession();
        List<FacturaExamen> lista = (List<FacturaExamen>) s.createQuery("from FacturaExamen").list();
        return lista;
    }
    
    public int GuardarFacturaConsulta(FacturaConsulta fc){
      s = sf.openSession();
        try {
            int id = -1;
            Transaction t = s.beginTransaction();
            id = (int) s.save(fc);//Retorna el ID con el que guardo            
            t.commit();
            return id;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        } finally {
            s.close();

        }
    
    }
    
    /*
     public static List<FacturaProcedimiento> ListarFacturaProcedimiento() {
     s = sf.openSession();
     List<FacturaProcedimiento> lista = (List<FacturaProcedimiento>) s.createQuery("from FacturaProcedimiento").list();
     return lista;
     }

     public static boolean GuardarFacturapro(FacturaProcedimiento fpro) {
     try {
     s = sf.openSession();
     Transaction t = s.beginTransaction();
     s.save(fpro);//Retorna el ID con el que guardo            
     t.commit();
     return true;
     } catch (Exception ex) {
     System.out.println(ex.getMessage());
     return false;
     }
     }
     */

    public static int GuardarFacturaex(FacturaExamen fex) {
        s = sf.openSession();
        try {
            int id = -1;
            Transaction t = s.beginTransaction();
            id = (int) s.save(fex);//Retorna el ID con el que guardo            
            t.commit();
            return id;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        } finally {
            s.close();

        }
    }

    public static boolean GuardarDetalleFacturaPro(DetalleFactpro ex) {
        s = sf.openSession();
        try {
            Transaction t = s.beginTransaction();
            s.save(ex);//Retorna el ID con el que guardo            
            t.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            s.close();

        }
    }

    public static boolean GuardarDetalleFacturaEx(DetalleFacturaEx ex) {
        s = sf.openSession();
        try {
            Transaction t = s.beginTransaction();
            s.save(ex);//Retorna el ID con el que guardo            
            t.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            s.close();

        }
    }

    public static boolean BorrarExamen(String nombre) {
        s = sf.openSession();
        try {
            int id = 0;
            Transaction t = s.beginTransaction();
            List<CatalogoExamen> lista = s.createQuery("from CatalogoExamen").list();
            for (CatalogoExamen ce : lista) {
                if (ce.getNombre().equals(nombre)) {
                    id = ce.getIdExamen();
                }
            }
            CatalogoExamen e = (CatalogoExamen) s.get(CatalogoExamen.class, id);
            s.delete(e);
            t.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            s.close();

        }
    }

    public static boolean BorrarPE(String nombre) {
        s = sf.openSession();
        try {
            int id = 0;
            Transaction t = s.beginTransaction();
            List<ProcedimientosEspeciales> lista = s.createQuery("from ProcedimientosEspeciales").list();
            for (ProcedimientosEspeciales ce : lista) {
                if (ce.getNombre().equals(nombre)) {
                    id = ce.getIdProc();
                }
            }
            ProcedimientosEspeciales e = (ProcedimientosEspeciales) s.get(ProcedimientosEspeciales.class, id);
            s.delete(e);
            t.commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            s.close();
        }
    }
}
