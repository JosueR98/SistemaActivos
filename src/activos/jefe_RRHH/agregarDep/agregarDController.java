/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.jefe_RRHH.agregarDep;

/**
 *
 * @author Josue R
 */
public class agregarDController {
    agregarDModel model;
    agregarDView view;

    public agregarDController(agregarDModel model, agregarDView view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
        
    }

    public agregarDModel getModel() {
        return model;
    }

    public void setModel(agregarDModel model) {
        this.model = model;
    }

    public agregarDView getView() {
        return view;
    }

    public void setView(agregarDView view) {
        this.view = view;
    }
    
    public void atras(){
        this.model.getControladorPadre().getView().setVisible(true);
        view.setVisible(false);
    }
}
