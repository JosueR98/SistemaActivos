/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.funcionarios;

import activos.funcionarios.agregar.agregarFController;
import activos.funcionarios.agregar.agregarFModel;
import activos.funcionarios.agregar.agregarFView;
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
public class FuncionariosModel extends Observable {
    private Usuario current;
    private List<Funcionario> funcionarios;
    
    //Hijos
    private agregarFModel agregarModel;
    private  agregarFController agregarController;
    private agregarFView agregarView;
    
    
    public FuncionariosModel() throws SQLException {
        this.current = activos.loginPresentation.loginModel.getUsuarioActual();
        cargarLista();
        agregarModel = new agregarFModel();
        agregarView = new agregarFView();
        agregarController = new agregarFController(agregarModel,agregarView);
        
    }

    public Usuario getCurrent() {
        return current;
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        notifyObservers();
    }
    
    public void cargarLista() throws SQLException{
        funcionarios = activos.data.FuncionariosDB.getLista();
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public agregarFModel getAgregarModel() {
        return agregarModel;
    }

    public agregarFController getAgregarController() {
        return agregarController;
    }

    public agregarFView getAgregarView() {
        return agregarView;
    }
    
}
