/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.adminPresentation.verEspecifica;

/**
 *
 * @author Josue R
 */
public class verController {

    private verModel model;
    private verView view;
    
    
    public verController(verModel verModel, verView verView) {
       this.model = verModel;
       this.view = verView;
       view.setController(this);
       view.setModel(verModel);
    }

    public verModel getModel() {
        return model;
    }

    public void setModel(verModel model) {
        this.model = model;
    }

    public verView getView() {
        return view;
    }

    public void setView(verView view) {
        this.view = view;
      
    }

    
    
}
