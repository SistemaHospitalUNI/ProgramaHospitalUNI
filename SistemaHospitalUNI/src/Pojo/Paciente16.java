package Pojo;
// Generated Jul 8, 2015 6:12:54 AM by Hibernate Tools 4.3.1



/**
 * Paciente16 generated by hbm2java
 */
public class Paciente16  implements java.io.Serializable {


     private Integer idPaciente;
     private String cedula;
     private byte[] foto;

    public Paciente16() {
    }

	
    public Paciente16(String cedula) {
        this.cedula = cedula;
    }
    public Paciente16(String cedula, byte[] foto) {
       this.cedula = cedula;
       this.foto = foto;
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
    public byte[] getFoto() {
        return this.foto;
    }
    
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }




}


