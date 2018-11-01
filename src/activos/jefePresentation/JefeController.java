/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.jefePresentation;

/**
 *
 * @author Andrés
 */
public class JefeController {
    
    JefeView view;
    JefeModel model;
    
    public JefeController(JefeModel model, JefeView view) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public JefeView getView() {
        return view;
    }

    public void setView(JefeView view) {
        this.view = view;
    }

    public JefeModel getModel() {
        return model;
    }

    public void setModel(JefeModel model) {
        this.model = model;
    }
}
