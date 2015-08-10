package Pojo;
// Generated Aug 9, 2015 5:24:41 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Cita generated by hbm2java
 */
public class Cita  implements java.io.Serializable {


     private Integer idCita;
     private Medico medico;
     private Paciente paciente;
     private Date fecha;
     private String hora;
     private boolean estado;

    public Cita() {
    }

    public Cita(Medico medico, Paciente paciente, Date fecha, String hora, boolean estado) {
       this.medico = medico;
       this.paciente = paciente;
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
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return this.hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }




}


