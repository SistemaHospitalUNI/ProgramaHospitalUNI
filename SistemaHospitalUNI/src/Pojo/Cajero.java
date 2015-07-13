package Pojo;
// Generated Jul 8, 2015 3:59:24 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cajero generated by hbm2java
 */
public class Cajero  implements java.io.Serializable {


     private Integer idCajero;
     private String nombre;
     private String apellido;
     private String direccion;
     private String telefono;
     private String estadocivil;
     private String correo;
     private boolean estado;
     private String cedula;
     private byte[] foto;
     private Set facturaExamens = new HashSet(0);
     private Set facturaProcedimientos = new HashSet(0);
     private Set facturaConsultas = new HashSet(0);

    public Cajero() {
    }

    public Cajero(Integer idCajero, String nombre, String apellido, String direccion, String telefono, String estadocivil, String correo, boolean estado, String cedula, byte[] foto) {
        this.idCajero = idCajero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estadocivil = estadocivil;
        this.correo = correo;
        this.estado = estado;
        this.cedula = cedula;
        this.foto = foto;
    }

    public Integer getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(Integer idCajero) {
        this.idCajero = idCajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Set getFacturaExamens() {
        return facturaExamens;
    }

    public void setFacturaExamens(Set facturaExamens) {
        this.facturaExamens = facturaExamens;
    }

    public Set getFacturaProcedimientos() {
        return facturaProcedimientos;
    }

    public void setFacturaProcedimientos(Set facturaProcedimientos) {
        this.facturaProcedimientos = facturaProcedimientos;
    }

    public Set getFacturaConsultas() {
        return facturaConsultas;
    }

    public void setFacturaConsultas(Set facturaConsultas) {
        this.facturaConsultas = facturaConsultas;
    }

	



}


