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
import activos.logic.Usuario;

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
     
    public AdminModel() {
        current = activos.loginPresentation.loginModel.getCurrent();
        agregarModel = new agregarModel();
        agregarView = new agregarView();
        agregarControlador = new agregarController(agregarModel,agregarView);
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
}
