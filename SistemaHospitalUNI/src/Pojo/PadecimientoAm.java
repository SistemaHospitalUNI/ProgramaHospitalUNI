package Pojo;
// Generated Aug 9, 2015 5:24:41 PM by Hibernate Tools 4.3.1



/**
 * PadecimientoAm generated by hbm2java
 */
public class PadecimientoAm  implements java.io.Serializable {


     private Integer idPadecimientoam;
     private AlergiaMedicamento alergiaMedicamento;
     private Paciente paciente;

    public PadecimientoAm() {
    }

	
    public PadecimientoAm(AlergiaMedicamento alergiaMedicamento) {
        this.alergiaMedicamento = alergiaMedicamento;
    }
    public PadecimientoAm(AlergiaMedicamento alergiaMedicamento, Paciente paciente) {
       this.alergiaMedicamento = alergiaMedicamento;
       this.paciente = paciente;
    }
   
    public Integer getIdPadecimientoam() {
        return this.idPadecimientoam;
    }
    
    public void setIdPadecimientoam(Integer idPadecimientoam) {
        this.idPadecimientoam = idPadecimientoam;
    }
    public AlergiaMedicamento getAlergiaMedicamento() {
        return this.alergiaMedicamento;
    }
    
    public void setAlergiaMedicamento(AlergiaMedicamento alergiaMedicamento) {
        this.alergiaMedicamento = alergiaMedicamento;
    }
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }




}


