package Pojo;
// Generated Jul 31, 2015 11:10:47 PM by Hibernate Tools 4.3.1



/**
 * DetalleFactpro generated by hbm2java
 */
public class DetalleFactpro  implements java.io.Serializable {


     private Integer idDetfactpro;
     private FacturaExamen facturaExamen;
     private ProcedimientosEspeciales procedimientosEspeciales;

    public DetalleFactpro() {
    }

    public DetalleFactpro(FacturaExamen facturaExamen, ProcedimientosEspeciales procedimientosEspeciales) {
       this.facturaExamen = facturaExamen;
       this.procedimientosEspeciales = procedimientosEspeciales;
    }
   
    public Integer getIdDetfactpro() {
        return this.idDetfactpro;
    }
    
    public void setIdDetfactpro(Integer idDetfactpro) {
        this.idDetfactpro = idDetfactpro;
    }
    public FacturaExamen getFacturaExamen() {
        return this.facturaExamen;
    }
    
    public void setFacturaExamen(FacturaExamen facturaExamen) {
        this.facturaExamen = facturaExamen;
    }
    public ProcedimientosEspeciales getProcedimientosEspeciales() {
        return this.procedimientosEspeciales;
    }
    
    public void setProcedimientosEspeciales(ProcedimientosEspeciales procedimientosEspeciales) {
        this.procedimientosEspeciales = procedimientosEspeciales;
    }




}


