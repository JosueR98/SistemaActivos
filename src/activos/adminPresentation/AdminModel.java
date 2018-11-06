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

    private Usuario usuarioActual;

    //Agregar
    private agregarModel agregarModel;
    private agregarController agregarControlador;
    private agregarView agregarView;

    //Ver
    private verModel verModel;
    private verController verController;
    private verView verView;

    public AdminModel() {
        usuarioActual = activos.loginPresentation.loginModel.getUsuarioActual();
        agregarModel = new agregarModel();
        agregarView = new agregarView();
        agregarControlador = new agregarController(agregarModel, agregarView);
    }

    public void verTrio(int codigo) throws SQLException, Exception {
        verModel = new verModel(codigo);
        verView = new verView();
        verController = new verController(verModel, verView);
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }

    public agregarModel getAgregarModel() {
        return agregarModel;
    }

    public agregarController getAgregarControlador() {
        return agregarControlador;
    }

    public agregarView getAgregarView() {
        return agregarView;
    }

    public verModel getVerModel() {
        return verModel;
    }

    public verController getVerController() {
        return verController;
    }

    public verView getVerView() {
        return verView;
    }

}
