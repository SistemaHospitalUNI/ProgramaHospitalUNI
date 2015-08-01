package Pojo;
// Generated Aug 1, 2015 12:23:44 AM by Hibernate Tools 4.3.1



/**
 * Receta generated by hbm2java
 */
public class Receta  implements java.io.Serializable {


     private Integer idReceta;
     private Diagnostico diagnostico;
     private String medicamento;
     private String dosis;
     private int cantidad;

    public Receta() {
    }

    public Receta(Diagnostico diagnostico, String medicamento, String dosis, int cantidad) {
       this.diagnostico = diagnostico;
       this.medicamento = medicamento;
       this.dosis = dosis;
       this.cantidad = cantidad;
    }
   
    public Integer getIdReceta() {
        return this.idReceta;
    }
    
    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }
    public Diagnostico getDiagnostico() {
        return this.diagnostico;
    }
    
    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
    public String getMedicamento() {
        return this.medicamento;
    }
    
    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }
    public String getDosis() {
        return this.dosis;
    }
    
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }




}


