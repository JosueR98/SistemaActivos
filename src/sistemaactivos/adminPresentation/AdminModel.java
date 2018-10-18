/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos.adminPresentation;

import java.util.Observable;
import sistemaactivos.adminPresentation.agregarSolicitud.agregarSolicitudController;
import sistemaactivos.adminPresentation.agregarSolicitud.agregarSolicitudModel;
import sistemaactivos.adminPresentation.agregarSolicitud.agregarSolicitudView;
import sistemaactivos.logic.Usuario;

/**
 *
 * @author Josue R
 */
public class AdminModel extends Observable {
    
     Usuario current;
     
     //Agregar
     agregarSolicitudModel agregarModel;
     agregarSolicitudController agregarControlador;
     agregarSolicitudView agregarView;
     
    public AdminModel() {
        current = sistemaactivos.loginPresentation.loginModel.getCurrent();
        agregarModel = new agregarSolicitudModel();
        agregarView = new agregarSolicitudView();
        agregarControlador = new agregarSolicitudController(agregarModel,agregarView);
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
