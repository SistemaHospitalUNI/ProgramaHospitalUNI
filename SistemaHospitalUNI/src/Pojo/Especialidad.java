package Pojo;
// Generated Aug 1, 2015 12:23:44 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Especialidad generated by hbm2java
 */
public class Especialidad  implements java.io.Serializable {


     private Integer idEspecialidad;
     private String nombreEspecialidad;
     private String descripcion;
     private Set medicos = new HashSet(0);

    public Especialidad() {
    }

	
    public Especialidad(String nombreEspecialidad, String descripcion) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.descripcion = descripcion;
    }
    public Especialidad(String nombreEspecialidad, String descripcion, Set medicos) {
       this.nombreEspecialidad = nombreEspecialidad;
       this.descripcion = descripcion;
       this.medicos = medicos;
    }
   
    public Integer getIdEspecialidad() {
        return this.idEspecialidad;
    }
    
    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }
    public String getNombreEspecialidad() {
        return this.nombreEspecialidad;
    }
    
    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getMedicos() {
        return this.medicos;
    }
    
    public void setMedicos(Set medicos) {
        this.medicos = medicos;
    }




}


