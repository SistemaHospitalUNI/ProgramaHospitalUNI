package Pojo;
// Generated Aug 1, 2015 12:23:44 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Examen generated by hbm2java
 */
public class Examen  implements java.io.Serializable {


     private Integer idExamenDiagnostico;
     private Diagnostico diagnostico;
     private String nombre;
     private String descripcion;
     private Date fecha;

    public Examen() {
    }

    public Examen(Diagnostico diagnostico, String nombre, String descripcion, Date fecha) {
       this.diagnostico = diagnostico;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.fecha = fecha;
    }
   
    public Integer getIdExamenDiagnostico() {
        return this.idExamenDiagnostico;
    }
    
    public void setIdExamenDiagnostico(Integer idExamenDiagnostico) {
        this.idExamenDiagnostico = idExamenDiagnostico;
    }
    public Diagnostico getDiagnostico() {
        return this.diagnostico;
    }
    
    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


