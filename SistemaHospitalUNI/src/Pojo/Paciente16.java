package Pojo;
// Generated Jul 31, 2015 11:10:47 PM by Hibernate Tools 4.3.1



/**
 * Paciente16 generated by hbm2java
 */
public class Paciente16  implements java.io.Serializable {


     private Integer idPaciente;
     private String cedula;

    public Paciente16() {
    }

    public Paciente16(String cedula) {
       this.cedula = cedula;
    }
   
    public Integer getIdPaciente() {
        return this.idPaciente;
    }
    
    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }




}


