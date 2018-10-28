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
public class Funcionario {
    private int cedula;
    private String nombre;
    private String puesto;
    private List<Activo> activos;
    
    public Funcionario() {
        activos  = null;
    }

    
    public Funcionario(int cedula, String nombre, String puesto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.puesto = puesto;
         activos  = null;
    }

    public Funcionario(int cedula, String nombre, String puesto, List<Activo> activos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.puesto = puesto;
        this.activos = activos;
    }

    public List<Activo> getActivos() {
        return activos;
    }

    public void setActivos(List<Activo> activos) {
        this.activos = activos;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    
}
