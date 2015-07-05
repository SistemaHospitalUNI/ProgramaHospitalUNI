package Pojo;
// Generated Jul 5, 2015 1:46:36 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Medico generated by hbm2java
 */
public class Medico  implements java.io.Serializable {


     private Integer idMedico;
     private String nombre;
     private String apellido;
     private byte[] foto;
     private String especialidad;
     private String cedula;
     private Set citas = new HashSet(0);
     private Set medicoHorarioMedicos = new HashSet(0);

    public Medico() {
    }

	
    public Medico(String nombre, String apellido, String especialidad, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.cedula = cedula;
    }
    public Medico(String nombre, String apellido, byte[] foto, String especialidad, String cedula, Set citas, Set medicoHorarioMedicos) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.foto = foto;
       this.especialidad = especialidad;
       this.cedula = cedula;
       this.citas = citas;
       this.medicoHorarioMedicos = medicoHorarioMedicos;
    }
   
    public Integer getIdMedico() {
        return this.idMedico;
    }
    
    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public byte[] getFoto() {
        return this.foto;
    }
    
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    public String getEspecialidad() {
        return this.especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public Set getCitas() {
        return this.citas;
    }
    
    public void setCitas(Set citas) {
        this.citas = citas;
    }
    public Set getMedicoHorarioMedicos() {
        return this.medicoHorarioMedicos;
    }
    
    public void setMedicoHorarioMedicos(Set medicoHorarioMedicos) {
        this.medicoHorarioMedicos = medicoHorarioMedicos;
    }




}

