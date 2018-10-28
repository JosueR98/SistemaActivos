/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.logic;

import java.sql.SQLException;

/**
 *
 * @author Josue R
 */
public class Activo {
    private int codigo;
    private String categoria;
    private String descripcion;
    private Funcionario encargado;
    

    public Activo() {
    }

    public Activo(int codigo, String categoria, String descripcion, Funcionario encargado) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.encargado = encargado;
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

    public Funcionario getEncargado() {
        return encargado;
    }

    public void setEncargado(Funcionario encargado) {
        this.encargado = encargado;
    }
    
     public void setEncargado(int encargado) throws SQLException {
         this.encargado = activos.data.FuncionariosDB.get(encargado);
    }
    
}
