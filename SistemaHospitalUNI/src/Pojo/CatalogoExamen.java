package Pojo;
// Generated Jul 8, 2015 6:12:54 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * CatalogoExamen generated by hbm2java
 */
public class CatalogoExamen  implements java.io.Serializable {


     private Integer idExamen;
     private String nombre;
     private String descripcion;
     private float precio;
     private Set detalleFacturas = new HashSet(0);

    public CatalogoExamen() {
    }

	
    public CatalogoExamen(String nombre, String descripcion, float precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public CatalogoExamen(String nombre, String descripcion, float precio, Set detalleFacturas) {
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.precio = precio;
       this.detalleFacturas = detalleFacturas;
    }
   
    public Integer getIdExamen() {
        return this.idExamen;
    }
    
    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
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
    public float getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public Set getDetalleFacturas() {
        return this.detalleFacturas;
    }
    
    public void setDetalleFacturas(Set detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }




}


