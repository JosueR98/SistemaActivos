/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.jefePresentation.agregarR;

/**
 *
 * @author Andrés
 */
public class AgregarRController {

    AgregarRModel model;
    AgregarRView view;

    public AgregarRController(AgregarRModel model, AgregarRView view) {
        this.model = model;
        this.view = view;
        view.setController(this);
        view.setModel(model);
    }

}
