/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.jefe_RRHH;

/**
 *
 * @author Josue R
 */
public class RRHHController {

    RRHHModel model;
    RRHHView view;

    public RRHHController(RRHHModel model, RRHHView view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
        model.getAgregarFModel().setControladorPadre(this);
        model.getAgregarPModel().setControladorPadre(this);
        model.getAgregarDModel().setControladorPadre(this);
    }

    public RRHHModel getModel() {
        return model;
    }

    public RRHHView getView() {
        return view;
    }

}
