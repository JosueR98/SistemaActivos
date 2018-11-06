/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.jefe_RRHH.agregarPuesto;

/**
 *
 * @author Josue R
 */
public class agregarPController {
    agregarPModel model;
    agregarPView view;

    public agregarPController(agregarPModel model, agregarPView view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }

    public agregarPModel getModel() {
        return model;
    }

    public agregarPView getView() {
        return view;
    }
    
    public void atras(){
        this.model.getControladorPadre().getView().setVisible(true);
        view.setVisible(false);
    }
}
