/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.registrador;

/**
 *
 * @author Josue R
 */
public class RegistradorController {
    RegistradorModel model;
    RegistradorView view;

    public RegistradorController(RegistradorModel model, RegistradorView view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }

    public RegistradorModel getModel() {
        return model;
    }

   public RegistradorView getView() {
        return view;
    }
    
    
}
