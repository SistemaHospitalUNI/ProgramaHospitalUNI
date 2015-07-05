package Pojo;
// Generated Jul 5, 2015 7:44:36 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Cita generated by hbm2java
 */
public class Cita  implements java.io.Serializable {


     private Integer idCita;
     private Medico medico;
     private Paciente idPaciente;
     private Date fecha;
     private Date hora;
     private String estado;

    public Cita() {
    }

    public Cita(Medico medico, Paciente idPaciente, Date fecha, Date hora, String estado) {
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
    public Paciente getIdPaciente() {
        return this.idPaciente;
    }
    
    public void setIdPaciente(Paciente idPaciente) {
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
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


