package Pojo;
// Generated Jul 8, 2015 3:59:24 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * ProcedimientosEspeciales generated by hbm2java
 */
public class ProcedimientosEspeciales  implements java.io.Serializable {


     private Integer idProc;
     private FacturaConsulta facturaConsulta;
     private String nombre;
     private String descripcion;
     private float precio;
     private Set detalleFactpros = new HashSet(0);

    public ProcedimientosEspeciales() {
    }

	
    public ProcedimientosEspeciales(FacturaConsulta facturaConsulta, String nombre, String descripcion, float precio) {
        this.facturaConsulta = facturaConsulta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public ProcedimientosEspeciales(FacturaConsulta facturaConsulta, String nombre, String descripcion, float precio, Set detalleFactpros) {
       this.facturaConsulta = facturaConsulta;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.precio = precio;
       this.detalleFactpros = detalleFactpros;
    }
   
    public Integer getIdProc() {
        return this.idProc;
    }
    
    public void setIdProc(Integer idProc) {
        this.idProc = idProc;
    }
    public FacturaConsulta getFacturaConsulta() {
        return this.facturaConsulta;
    }
    
    public void setFacturaConsulta(FacturaConsulta facturaConsulta) {
        this.facturaConsulta = facturaConsulta;
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
    public Set getDetalleFactpros() {
        return this.detalleFactpros;
    }
    
    public void setDetalleFactpros(Set detalleFactpros) {
        this.detalleFactpros = detalleFactpros;
    }




}


