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
public class Puesto {
    private int codigo;
    private String rol;
    Funcionario funcionario;
    Dependencia dependencia;
    
    
    public Puesto(int codigo, String rol, Funcionario funcionario, Dependencia dependencia) {
        this.codigo = codigo;
        this.rol = rol;
        this.funcionario = funcionario;
        this.dependencia = dependencia;
    }

    public Puesto(int codigo, String rol, Dependencia dependencia) {
        this.codigo = codigo;
        this.rol = rol;
        this.dependencia = dependencia;
    }

    public Puesto() {
       dependencia = null;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
   
    public void setFuncionario(int funcionario) throws SQLException {
        this.funcionario = activos.data.FuncionariosDB.get(funcionario);
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }
    
      public void setDependencia(int dependencia) throws SQLException {
        this.dependencia = activos.data.DependenciasDB.get(dependencia);
    }
    
}
