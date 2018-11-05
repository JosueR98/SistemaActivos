/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.registrador.verBienes;

import activos.logic.Bien;

/**
 *
 * @author Josue R
 */
public class bienesController {
    bienesModel model;
    bienesView view;

    public bienesController(bienesModel model, bienesView view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }

    public bienesModel getModel() {
        return model;
    }

    public bienesView getView() {
        return view;
    } 

    public boolean verificar() {
   
       for(Bien bien: model.getBienes()){
           if(!bien.isEstaRegistrado())
               return false;
    }
       return true;
}
}
