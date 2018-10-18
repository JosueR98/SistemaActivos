/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos.adminPresentation.agregarSolicitud;

/**
 *
 * @author Josue R
 */
public class agregarSolicitudController {
    agregarSolicitudModel model;  
    agregarSolicitudView view;
    
    public agregarSolicitudController(agregarSolicitudModel model, agregarSolicitudView view) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public agregarSolicitudModel getModel() {
        return model;
    }

    public void setModel(agregarSolicitudModel model) {
        this.model = model;
    }

    public agregarSolicitudView getView() {
        return view;
    }

    public void setView(agregarSolicitudView view) {
        this.view = view;
    }
    
    public void exit(){
        System.exit(0);
    }
}
