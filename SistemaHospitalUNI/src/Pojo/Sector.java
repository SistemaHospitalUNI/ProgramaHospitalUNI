package Pojo;
// Generated Jul 5, 2015 1:46:36 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Sector generated by hbm2java
 */
public class Sector  implements java.io.Serializable {


     private Integer idSector;
     private String barrio;
     private String distrito;
     private Set pacientes = new HashSet(0);

    public Sector() {
    }

	
    public Sector(String barrio, String distrito) {
        this.barrio = barrio;
        this.distrito = distrito;
    }
    public Sector(String barrio, String distrito, Set pacientes) {
       this.barrio = barrio;
       this.distrito = distrito;
       this.pacientes = pacientes;
    }
   
    public Integer getIdSector() {
        return this.idSector;
    }
    
    public void setIdSector(Integer idSector) {
        this.idSector = idSector;
    }
    public String getBarrio() {
        return this.barrio;
    }
    
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
    public String getDistrito() {
        return this.distrito;
    }
    
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
    public Set getPacientes() {
        return this.pacientes;
    }
    
    public void setPacientes(Set pacientes) {
        this.pacientes = pacientes;
    }




}


