/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.registrador;

import activos.logic.Bien;
import activos.logic.Solicitud;

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

    public void setModel(RegistradorModel model) {
        this.model = model;
    }

    public void setView(RegistradorView view) {
        this.view = view;
    }

    boolean todosLosBienesRegistrados(Solicitud soli) {
        boolean todos = true;

        for (Bien bien : soli.getLista_bienes()) {
            if (!bien.isEstaRegistrado()) {
                todos = false;
            }
        }

        return todos;
    }
    
    public void exit() {
        System.exit(0);
    }
}
