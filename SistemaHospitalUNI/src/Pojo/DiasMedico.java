package Pojo;
// Generated Aug 1, 2015 12:23:44 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * DiasMedico generated by hbm2java
 */
public class DiasMedico  implements java.io.Serializable {


     private Integer idDiaMedico;
     private Medico medico;
     private boolean lunes;
     private boolean martes;
     private boolean miercoles;
     private boolean jueves;
     private boolean viernes;
     private boolean sabado;
     private boolean domingo;
     private Set horarioMedicos = new HashSet(0);

    public DiasMedico() {
    }

	
    public DiasMedico(Medico medico, boolean lunes, boolean martes, boolean miercoles, boolean jueves, boolean viernes, boolean sabado, boolean domingo) {
        this.medico = medico;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.domingo = domingo;
    }
    public DiasMedico(Medico medico, boolean lunes, boolean martes, boolean miercoles, boolean jueves, boolean viernes, boolean sabado, boolean domingo, Set horarioMedicos) {
       this.medico = medico;
       this.lunes = lunes;
       this.martes = martes;
       this.miercoles = miercoles;
       this.jueves = jueves;
       this.viernes = viernes;
       this.sabado = sabado;
       this.domingo = domingo;
       this.horarioMedicos = horarioMedicos;
    }
   
    public Integer getIdDiaMedico() {
        return this.idDiaMedico;
    }
    
    public void setIdDiaMedico(Integer idDiaMedico) {
        this.idDiaMedico = idDiaMedico;
    }
    public Medico getMedico() {
        return this.medico;
    }
    
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public boolean isLunes() {
        return this.lunes;
    }
    
    public void setLunes(boolean lunes) {
        this.lunes = lunes;
    }
    public boolean isMartes() {
        return this.martes;
    }
    
    public void setMartes(boolean martes) {
        this.martes = martes;
    }
    public boolean isMiercoles() {
        return this.miercoles;
    }
    
    public void setMiercoles(boolean miercoles) {
        this.miercoles = miercoles;
    }
    public boolean isJueves() {
        return this.jueves;
    }
    
    public void setJueves(boolean jueves) {
        this.jueves = jueves;
    }
    public boolean isViernes() {
        return this.viernes;
    }
    
    public void setViernes(boolean viernes) {
        this.viernes = viernes;
    }
    public boolean isSabado() {
        return this.sabado;
    }
    
    public void setSabado(boolean sabado) {
        this.sabado = sabado;
    }
    public boolean isDomingo() {
        return this.domingo;
    }
    
    public void setDomingo(boolean domingo) {
        this.domingo = domingo;
    }
    public Set getHorarioMedicos() {
        return this.horarioMedicos;
    }
    
    public void setHorarioMedicos(Set horarioMedicos) {
        this.horarioMedicos = horarioMedicos;
    }




}


