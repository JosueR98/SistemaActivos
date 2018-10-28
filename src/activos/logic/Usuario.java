/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.logic;

import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Josue R
 */
public class Usuario {
    // Usuarios por tipo
    public static final int INDEFINIDO = 0;
    public static final int ADMINISTRADOR_DEPENDENCIA = 1;
    public static final int SECRETARIA_OCCB = 2;
    public static final int JEFE_OCCB = 3;
    public static final int REGISTRADOR_BIENES = 4;
    public static final int JEFE_RRH = 5;
    public static final int JEFE_OCBB_RHH= 7;

    private String id;
    private String clave;
    private int tipo;
    private Dependencia dependencia;
    private Funcionario funcionario;
    
    public Usuario() {
    }

    public Usuario(String id, String clave, int tipoUsuario, Funcionario funcionario, Dependencia dependencia) {
        this.id = id;
        this.clave = clave;
        this.tipo = tipoUsuario;
        this.dependencia = dependencia;
        this.funcionario = funcionario;
    }

    public Usuario(String id, String clave, int tipo, Dependencia dependencia) {
        this.id = id;
        this.clave = clave;
        this.tipo = tipo;
        this.dependencia = dependencia;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTipoUsuario() {
        return tipo;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipo = tipoUsuario;
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(int funcionario) throws SQLException {
        this.funcionario = activos.data.FuncionariosDB.get(funcionario);
    }
    
     public void setFuncionario(Funcionario funcionario) throws SQLException {
        this.funcionario = funcionario;
    }
    
}
