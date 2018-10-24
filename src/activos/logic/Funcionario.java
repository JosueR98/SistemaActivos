/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.logic;

/**
 *
 * @author Josue R
 */
public class Funcionario {
    private int cedula;
    private String nombre;
    private String puesto;

    public Funcionario(int cedula, String nombre, String puesto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.puesto = puesto;
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
