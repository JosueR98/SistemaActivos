/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.adminPresentation;

/**
 *
 * @author Josue R
 */
public class AdminController {
     AdminModel model;  
     AdminView view;
    
    public AdminController(AdminModel model, AdminView view) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public AdminModel getModel() {
        return model;
    }

    public void setModel(AdminModel model) {
        this.model = model;
    }

    public AdminView getView() {
        return view;
    }

    public void setView(AdminView view) {
        this.view = view;
    }
    
    public void exit(){
        System.exit(0);
    }
}
