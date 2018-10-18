/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.adminPresentation.agregar;

/**
 *
 * @author Josue R
 */
public class agregarController {
    agregarModel model;  
    agregarView view;
    
    public agregarController(agregarModel model, agregarView view) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public agregarModel getModel() {
        return model;
    }

    public void setModel(agregarModel model) {
        this.model = model;
    }

    public agregarView getView() {
        return view;
    }

    public void setView(agregarView view) {
        this.view = view;
    }
    
    public void exit(){
        System.exit(0);
    }
}
