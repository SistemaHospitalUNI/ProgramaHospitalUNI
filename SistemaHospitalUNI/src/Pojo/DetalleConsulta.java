package Pojo;
// Generated Jul 31, 2015 11:10:47 PM by Hibernate Tools 4.3.1



/**
 * DetalleConsulta generated by hbm2java
 */
public class DetalleConsulta  implements java.io.Serializable {


     private Integer idDetconsulta;
     private Consulta consulta;
     private String altura;
     private String peso;

    public DetalleConsulta() {
    }

    public DetalleConsulta(Consulta consulta, String altura, String peso) {
       this.consulta = consulta;
       this.altura = altura;
       this.peso = peso;
    }
   
    public Integer getIdDetconsulta() {
        return this.idDetconsulta;
    }
    
    public void setIdDetconsulta(Integer idDetconsulta) {
        this.idDetconsulta = idDetconsulta;
    }
    public Consulta getConsulta() {
        return this.consulta;
    }
    
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    public String getAltura() {
        return this.altura;
    }
    
    public void setAltura(String altura) {
        this.altura = altura;
    }
    public String getPeso() {
        return this.peso;
    }
    
    public void setPeso(String peso) {
        this.peso = peso;
    }




}


