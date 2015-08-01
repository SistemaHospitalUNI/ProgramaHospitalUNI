package Pojo;
// Generated Aug 1, 2015 12:23:44 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * EnfermedadCronica generated by hbm2java
 */
public class EnfermedadCronica  implements java.io.Serializable {


     private Integer idEc;
     private String nombre;
     private String descripcion;
     private Set padecimientoEcs = new HashSet(0);

    public EnfermedadCronica() {
    }

	
    public EnfermedadCronica(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public EnfermedadCronica(String nombre, String descripcion, Set padecimientoEcs) {
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.padecimientoEcs = padecimientoEcs;
    }
   
    public Integer getIdEc() {
        return this.idEc;
    }
    
    public void setIdEc(Integer idEc) {
        this.idEc = idEc;
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
    public Set getPadecimientoEcs() {
        return this.padecimientoEcs;
    }
    
    public void setPadecimientoEcs(Set padecimientoEcs) {
        this.padecimientoEcs = padecimientoEcs;
    }




}


