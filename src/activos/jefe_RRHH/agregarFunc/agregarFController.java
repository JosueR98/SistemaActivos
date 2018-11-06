/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.jefe_RRHH.agregarFunc;

/**
 *
 * @author Josue R
 */
public class agregarFController {

    agregarFModel model;
    agregarFView view;

    public agregarFController(agregarFModel model, agregarFView view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }

    public agregarFModel getModel() {
        return model;
    }

    public void setModel(agregarFModel model) {
        this.model = model;
    }

    public agregarFView getView() {
        return view;
    }

    public void setView(agregarFView view) {
        this.view = view;
    }

}
