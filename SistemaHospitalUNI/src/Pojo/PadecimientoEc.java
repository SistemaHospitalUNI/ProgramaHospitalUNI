package Pojo;
// Generated Jul 8, 2015 1:41:49 PM by Hibernate Tools 4.3.1



/**
 * PadecimientoEc generated by hbm2java
 */
public class PadecimientoEc  implements java.io.Serializable {


     private Integer idPadecimientoec;
     private EnfermedadCronica enfermedadCronica;
     private Paciente paciente;
     private String descripcion;

    public PadecimientoEc() {
    }

    public PadecimientoEc(EnfermedadCronica enfermedadCronica, Paciente paciente, String descripcion) {
       this.enfermedadCronica = enfermedadCronica;
       this.paciente = paciente;
       this.descripcion = descripcion;
    }
   
    public Integer getIdPadecimientoec() {
        return this.idPadecimientoec;
    }
    
    public void setIdPadecimientoec(Integer idPadecimientoec) {
        this.idPadecimientoec = idPadecimientoec;
    }
    public EnfermedadCronica getEnfermedadCronica() {
        return this.enfermedadCronica;
    }
    
    public void setEnfermedadCronica(EnfermedadCronica enfermedadCronica) {
        this.enfermedadCronica = enfermedadCronica;
    }
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}


