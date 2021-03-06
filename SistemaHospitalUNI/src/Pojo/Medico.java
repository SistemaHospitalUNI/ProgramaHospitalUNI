package Pojo;
// Generated Aug 13, 2015 4:52:50 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Medico generated by hbm2java
 */
public class Medico  implements java.io.Serializable {


     private Integer idMedico;
     private Especialidad especialidad;
     private String primernombre;
     private String segundonombre;
     private String primerapellido;
     private String segundoapellido;
     private String cedula;
     private String usuario;
     private String direccion;
     private boolean estado;
     private byte[] foto;
     private Set diasMedicos = new HashSet(0);
     private Set citas = new HashSet(0);

    public Medico() {
    }

	
    public Medico(Especialidad especialidad, String primernombre, String primerapellido, String cedula, String usuario, String direccion, boolean estado) {
        this.especialidad = especialidad;
        this.primernombre = primernombre;
        this.primerapellido = primerapellido;
        this.cedula = cedula;
        this.usuario = usuario;
        this.direccion = direccion;
        this.estado = estado;
    }
    public Medico(Especialidad especialidad, String primernombre, String segundonombre, String primerapellido, String segundoapellido, String cedula, String usuario, String direccion, boolean estado, byte[] foto, Set diasMedicos, Set citas) {
       this.especialidad = especialidad;
       this.primernombre = primernombre;
       this.segundonombre = segundonombre;
       this.primerapellido = primerapellido;
       this.segundoapellido = segundoapellido;
       this.cedula = cedula;
       this.usuario = usuario;
       this.direccion = direccion;
       this.estado = estado;
       this.foto = foto;
       this.diasMedicos = diasMedicos;
       this.citas = citas;
    }
   
    public Integer getIdMedico() {
        return this.idMedico;
    }
    
    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }
    public Especialidad getEspecialidad() {
        return this.especialidad;
    }
    
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    public String getPrimernombre() {
        return this.primernombre;
    }
    
    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }
    public String getSegundonombre() {
        return this.segundonombre;
    }
    
    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }
    public String getPrimerapellido() {
        return this.primerapellido;
    }
    
    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }
    public String getSegundoapellido() {
        return this.segundoapellido;
    }
    
    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public byte[] getFoto() {
        return this.foto;
    }
    
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    public Set getDiasMedicos() {
        return this.diasMedicos;
    }
    
    public void setDiasMedicos(Set diasMedicos) {
        this.diasMedicos = diasMedicos;
    }
    public Set getCitas() {
        return this.citas;
    }
    
    public void setCitas(Set citas) {
        this.citas = citas;
    }




}


