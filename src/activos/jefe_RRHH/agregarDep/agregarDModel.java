/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.jefe_RRHH.agregarDep;

import activos.jefe_RRHH.RRHHController;
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
public class agregarDModel extends Observable {
    
    Usuario current;
    List<Funcionario> funcionarios;
    RRHHController controladorPadre;

    public agregarDModel() throws SQLException {
        current = activos.loginPresentation.loginModel.getUsuarioActual();
        cargarListaFuncionarios();
        
    }

    public void cargarListaFuncionarios() throws SQLException {
        funcionarios = activos.data.FuncionariosDB.getLista();
    }

    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        notifyObservers();
    
}

    public RRHHController getControladorPadre() {
        return controladorPadre;
    }

    public void setControladorPadre(RRHHController controladorPadre) {
        this.controladorPadre = controladorPadre;
    }
    
}
