/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.adminPresentation;

import java.util.Observable;
import activos.adminPresentation.agregar.agregarController;
import activos.adminPresentation.agregar.agregarModel;
import activos.adminPresentation.agregar.agregarView;
import activos.adminPresentation.verEspecifica.verController;
import activos.adminPresentation.verEspecifica.verModel;
import activos.adminPresentation.verEspecifica.verView;
import activos.logic.Usuario;
import java.sql.SQLException;

/**
 *
 * @author Josue R
 */
public class AdminModel extends Observable {
    
     Usuario current;
     
     //Agregar
     agregarModel agregarModel;
     agregarController agregarControlador;
     agregarView agregarView;
     
     //Ver
     verModel verModel;
     verController verController;
     verView verView;
     
    public AdminModel() {
        current = activos.loginPresentation.loginModel.getCurrent();
        agregarModel = new agregarModel();
        agregarView = new agregarView();
        agregarControlador = new agregarController(agregarModel,agregarView);
    }
    
    public void verTrio(int codigo) throws SQLException{
        verModel = new verModel(codigo);
        verView = new verView();
        verController = new verController(verModel,verView);
    }
    
    public Usuario getCurrent() {
        return current;
    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }

    public agregarController getAgregarControlador() {
        return agregarControlador;
    }

    public verController getVerController() {
        return verController;
    }
    
    
}
