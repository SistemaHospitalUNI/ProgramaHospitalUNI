package Pojo;
// Generated Jul 31, 2015 11:10:47 PM by Hibernate Tools 4.3.1



/**
 * HorarioMedico generated by hbm2java
 */
public class HorarioMedico  implements java.io.Serializable {


     private Integer idHorariomedico;
     private DiasMedico diasMedico;
     private String horaEntrada;
     private String horaSalida;

    public HorarioMedico() {
    }

    public HorarioMedico(DiasMedico diasMedico, String horaEntrada, String horaSalida) {
       this.diasMedico = diasMedico;
       this.horaEntrada = horaEntrada;
       this.horaSalida = horaSalida;
    }
   
    public Integer getIdHorariomedico() {
        return this.idHorariomedico;
    }
    
    public void setIdHorariomedico(Integer idHorariomedico) {
        this.idHorariomedico = idHorariomedico;
    }
    public DiasMedico getDiasMedico() {
        return this.diasMedico;
    }
    
    public void setDiasMedico(DiasMedico diasMedico) {
        this.diasMedico = diasMedico;
    }
    public String getHoraEntrada() {
        return this.horaEntrada;
    }
    
    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    public String getHoraSalida() {
        return this.horaSalida;
    }
    
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }




}


