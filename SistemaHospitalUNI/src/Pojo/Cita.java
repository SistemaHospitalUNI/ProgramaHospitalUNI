package Pojo;
// Generated Jul 8, 2015 1:41:49 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Cita generated by hbm2java
 */
public class Cita  implements java.io.Serializable {


     private Integer idCita;
     private Medico medico;
     private int idPaciente;
     private Date fecha;
     private Date hora;
     private boolean estado;

    public Cita() {
    }

    public Cita(Medico medico, int idPaciente, Date fecha, Date hora, boolean estado) {
       this.medico = medico;
       this.idPaciente = idPaciente;
       this.fecha = fecha;
       this.hora = hora;
       this.estado = estado;
    }
   
    public Integer getIdCita() {
        return this.idCita;
    }
    
    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }
    public Medico getMedico() {
        return this.medico;
    }
    
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public int getIdPaciente() {
        return this.idPaciente;
    }
    
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Date getHora() {
        return this.hora;
    }
    
    public void setHora(Date hora) {
        this.hora = hora;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }




}


