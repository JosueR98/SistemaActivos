/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.registrador.Registrar;

/**
 *
 * @author Andrés
 */
public class RegistrarController {

    RegistrarModel model;
    RegistrarView view;

    public RegistrarController(RegistrarModel _model, RegistrarView _view) {
        this.model = _model;
        this.view = _view;
        view.setModel(model);
        view.setController(this);
    }

    public RegistrarModel getModel() {
        return model;
    }

    public void setModel(RegistrarModel model) {
        this.model = model;
    }

    public RegistrarView getView() {
        return view;
    }

    public void setView(RegistrarView view) {
        this.view = view;
    }

}
