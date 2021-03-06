package Pojo;
// Generated Aug 13, 2015 4:52:50 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * AlergiaMedicamento generated by hbm2java
 */
public class AlergiaMedicamento  implements java.io.Serializable {


     private Integer idAlergia;
     private String nombre;
     private String descripcion;
     private Set padecimientoAms = new HashSet(0);

    public AlergiaMedicamento() {
    }

    public AlergiaMedicamento(String nombre, String descripcion, Set padecimientoAms) {
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.padecimientoAms = padecimientoAms;
    }
   
    public Integer getIdAlergia() {
        return this.idAlergia;
    }
    
    public void setIdAlergia(Integer idAlergia) {
        this.idAlergia = idAlergia;
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
    public Set getPadecimientoAms() {
        return this.padecimientoAms;
    }
    
    public void setPadecimientoAms(Set padecimientoAms) {
        this.padecimientoAms = padecimientoAms;
    }




}


