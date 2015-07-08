package Pojo;
// Generated Jul 8, 2015 7:18:50 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Diagnostico generated by hbm2java
 */
public class Diagnostico  implements java.io.Serializable {


     private Integer idDiagnostico;
     private Consulta consulta;
     private String descripcion;
     private Set examens = new HashSet(0);
     private Set recetas = new HashSet(0);

    public Diagnostico() {
    }

	
    public Diagnostico(Consulta consulta, String descripcion) {
        this.consulta = consulta;
        this.descripcion = descripcion;
    }
    public Diagnostico(Consulta consulta, String descripcion, Set examens, Set recetas) {
       this.consulta = consulta;
       this.descripcion = descripcion;
       this.examens = examens;
       this.recetas = recetas;
    }
   
    public Integer getIdDiagnostico() {
        return this.idDiagnostico;
    }
    
    public void setIdDiagnostico(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }
    public Consulta getConsulta() {
        return this.consulta;
    }
    
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getExamens() {
        return this.examens;
    }
    
    public void setExamens(Set examens) {
        this.examens = examens;
    }
    public Set getRecetas() {
        return this.recetas;
    }
    
    public void setRecetas(Set recetas) {
        this.recetas = recetas;
    }




}


