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
public class Activo {
    private int codigo;
    private String categoria;
    private String descripcion;
    private Dependencia dependencia;

    public Activo() {
    }

    public Activo(int codigo, String categoria, String descripcion, Dependencia depe) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.dependencia = depe;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }
    
    
}
