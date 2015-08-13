package Pojo;
// Generated Aug 12, 2015 9:23:15 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Consulta generated by hbm2java
 */
public class Consulta  implements java.io.Serializable {


     private Integer idConsulta;
     private Cita cita;
     private String descripcion;
     private Float precio;
     private Set diagnosticos = new HashSet(0);
     private Set facturaConsultas = new HashSet(0);
     private Set detalleConsultas = new HashSet(0);

    public Consulta() {
    }

	
    public Consulta(Cita cita, String descripcion) {
        this.cita = cita;
        this.descripcion = descripcion;
    }
    public Consulta(Cita cita, String descripcion, Float precio, Set diagnosticos, Set facturaConsultas, Set detalleConsultas) {
       this.cita = cita;
       this.descripcion = descripcion;
       this.precio = precio;
       this.diagnosticos = diagnosticos;
       this.facturaConsultas = facturaConsultas;
       this.detalleConsultas = detalleConsultas;
    }
   
    public Integer getIdConsulta() {
        return this.idConsulta;
    }
    
    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }
    public Cita getCita() {
        return this.cita;
    }
    
    public void setCita(Cita cita) {
        this.cita = cita;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Float getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    public Set getDiagnosticos() {
        return this.diagnosticos;
    }
    
    public void setDiagnosticos(Set diagnosticos) {
        this.diagnosticos = diagnosticos;
    }
    public Set getFacturaConsultas() {
        return this.facturaConsultas;
    }
    
    public void setFacturaConsultas(Set facturaConsultas) {
        this.facturaConsultas = facturaConsultas;
    }
    public Set getDetalleConsultas() {
        return this.detalleConsultas;
    }
    
    public void setDetalleConsultas(Set detalleConsultas) {
        this.detalleConsultas = detalleConsultas;
    }




}


