/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.logic;

import java.util.List;

/**
 *
 * @author Josue R
 */
public class Dependencia {
    private int codigoPostal;
    private String nombre;
    private String ubicacion;
    private List<Usuario> usuarios;
    private List<Solicitud> solicitudes;
    private List<Activo> activos;

    public Dependencia(int codigoPostal, String nombre, String ubicacion) {
        this.codigoPostal = codigoPostal;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.usuarios = null;
        this.solicitudes = null;
        this.activos =  null;
    }

    public Dependencia() {
    }

    public Dependencia(int codigoPostal, String nombre, String ubicacion, List<Usuario> usuarios, List<Solicitud> solicitudes, List<Activo> activos) {
        this.codigoPostal = codigoPostal;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.usuarios = usuarios;
        this.solicitudes = solicitudes;
        this.activos = activos;
        
        for(Usuario user: this.usuarios){
            user.setDependencia(this);
        }
        for( Solicitud soli : this.solicitudes){
            soli.setDependencia(this);
        }
        for(Activo activo : this.activos){
            activo.setDependencia(this);
        }
        
    }

    
    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }
    
    
}
