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

    public Dependencia(int codigoPostal, String nombre, String ubicacion) {
        this.codigoPostal = codigoPostal;
        this.nombre = nombre;
        this.ubicacion = ubicacion;

    }

    public Dependencia() {
    }

    public Dependencia(int codigoPostal, String nombre, String ubicacion, List<Usuario> usuarios, List<Solicitud> solicitudes, List<Activo> activos) {
        this.codigoPostal = codigoPostal;
        this.nombre = nombre;
        this.ubicacion = ubicacion;

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

}
