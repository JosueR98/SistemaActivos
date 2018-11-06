/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.jefe_RRHH;

import activos.jefe_RRHH.agregarDep.agregarDController;
import activos.jefe_RRHH.agregarDep.agregarDModel;
import activos.jefe_RRHH.agregarDep.agregarDView;
import activos.jefe_RRHH.agregarFunc.agregarFController;
import activos.jefe_RRHH.agregarFunc.agregarFModel;
import activos.jefe_RRHH.agregarFunc.agregarFView;
import activos.jefe_RRHH.agregarPuesto.agregarPController;
import activos.jefe_RRHH.agregarPuesto.agregarPModel;
import activos.jefe_RRHH.agregarPuesto.agregarPView;
import activos.logic.Dependencia;
import activos.logic.Funcionario;
import activos.logic.Puesto;
import activos.logic.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Josue R
 */
public class RRHHModel extends Observable {

    private Usuario current;
    private List<Funcionario> funcionarios;
    private List<Dependencia> dependencias;
    private List<Puesto> puestos;

    //Hijos
    private agregarFModel agregarFModel;
    private agregarFController agregarFController;
    private agregarFView agregarFView;
    
    private agregarPModel agregarPModel;
    private agregarPController agregarPController;
    private agregarPView agregarPView;

    private agregarDModel agregarDModel;
    private agregarDView agregarDView;
    agregarDController agregarDController;
    
    
    public RRHHModel() throws SQLException {
        this.current = activos.loginPresentation.loginModel.getUsuarioActual();
        cargarListaFuncionarios();
        cargarListaPuestos();
        cargarListaDependencias();
        
        //LOADING MVC
        agregarFModel = new agregarFModel();
        agregarFView = new agregarFView();
        agregarFController = new agregarFController(agregarFModel, agregarFView);
        
        agregarPModel = new agregarPModel();
        agregarPView = new agregarPView();
        agregarPController = new agregarPController(agregarPModel, agregarPView);
        
        agregarDModel = new agregarDModel();
        agregarDView = new agregarDView();
        agregarDController = new agregarDController(agregarDModel,agregarDView);

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

    public void cargarListaFuncionarios() throws SQLException {
        funcionarios = activos.data.FuncionariosDB.getLista();
    }

    public void cargarListaPuestos() throws SQLException {
        puestos = activos.data.PuestosDB.getLista();
    }

    public void cargarListaDependencias() throws SQLException {
        dependencias = activos.data.DependenciasDB.getLista();
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public agregarFModel getAgregarFModel() {
        return agregarFModel;
    }

    public agregarFController getAgregarFController() {
        return agregarFController;
    }

    public agregarFView getAgregarFView() {
        return agregarFView;
    }

    public List<Dependencia> getDependencias() {
        return dependencias;
    }

    public List<Puesto> getPuestos() {
        return puestos;
    }

    public agregarPModel getAgregarPModel() {
        return agregarPModel;
    }

    public agregarPController getAgregarPController() {
        return agregarPController;
    }

    public agregarPView getAgregarPView() {
        return agregarPView;
    }

    public agregarDModel getAgregarDModel() {
        return agregarDModel;
    }

    public void setAgregarDModel(agregarDModel agregarDModel) {
        this.agregarDModel = agregarDModel;
    }

    public agregarDView getAgregarDView() {
        return agregarDView;
    }

    public void setAgregarDView(agregarDView agregarDView) {
        this.agregarDView = agregarDView;
    }

    public agregarDController getAgregarDController() {
        return agregarDController;
    }

    public void setAgregarDController(agregarDController agregarDController) {
        this.agregarDController = agregarDController;
    }
    
}
