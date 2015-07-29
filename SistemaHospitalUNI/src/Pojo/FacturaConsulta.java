package Pojo;
// Generated Jul 28, 2015 10:43:47 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * FacturaConsulta generated by hbm2java
 */
public class FacturaConsulta  implements java.io.Serializable {


     private Integer idFactura;
     private Cajero cajero;
     private Consulta consulta;
     private Date fecha;
     private float total;
     private float pago;
     private float cambio;

    public FacturaConsulta() {
    }

    public FacturaConsulta(Cajero cajero, Consulta consulta, Date fecha, float total, float pago, float cambio) {
       this.cajero = cajero;
       this.consulta = consulta;
       this.fecha = fecha;
       this.total = total;
       this.pago = pago;
       this.cambio = cambio;
    }
   
    public Integer getIdFactura() {
        return this.idFactura;
    }
    
    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }
    public Cajero getCajero() {
        return this.cajero;
    }
    
    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }
    public Consulta getConsulta() {
        return this.consulta;
    }
    
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public float getTotal() {
        return this.total;
    }
    
    public void setTotal(float total) {
        this.total = total;
    }
    public float getPago() {
        return this.pago;
    }
    
    public void setPago(float pago) {
        this.pago = pago;
    }
    public float getCambio() {
        return this.cambio;
    }
    
    public void setCambio(float cambio) {
        this.cambio = cambio;
    }




}


