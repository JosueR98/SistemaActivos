/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.jefe_RRHH.agregarPuesto;

import activos.jefe_RRHH.RRHHController;
import activos.logic.Dependencia;
import activos.logic.Funcionario;
import activos.logic.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Josue R
 */
public class agregarPModel extends Observable{
    RRHHController controladorPadre;
    Usuario current;
    List<Dependencia> dependencias;
    List<Funcionario> funcionarios;

    public agregarPModel() throws SQLException {
        current = activos.loginPresentation.loginModel.getUsuarioActual();
        cargarDependencias();
        cargarFuncionarios();
    }

    public RRHHController getControladorPadre() {
        return controladorPadre;
    }

    public void setControladorPadre(RRHHController controladorPadre) {
        this.controladorPadre = controladorPadre;
    }

    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        notifyObservers();
    }

    public void cargarDependencias() throws SQLException {
       dependencias = activos.data.DependenciasDB.getLista();
    }

    public List<Dependencia> getDependencias() {
        return dependencias;
    }

    public void cargarFuncionarios() throws SQLException {
       this.funcionarios = activos.data.FuncionariosDB.getLista();
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    
}
