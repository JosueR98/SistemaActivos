/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.adminPresentation.agregar;

/**
 *
 * @author Josue R
 */
public class agregarController {
    agregarModel model;  
    agregarView view;
    
    public agregarController(agregarModel model, agregarView view) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public agregarModel getModel() {
        return model;
    }

    public void setModel(agregarModel model) {
        this.model = model;
    }

    public agregarView getView() {
        return view;
    }

    public void setView(agregarView view) {
        this.view = view;
    }
    
    public boolean esNumero(String text){
        
        if(text.charAt(0) == '.' || text.charAt(text.length()-1) == '.') return false;
        
        for(int i=0;i<text.length();i++){
            if(!(text.charAt(i) == '0' || text.charAt(i) == '1' || text.charAt(i) == '2' ||
                    text.charAt(i) == '3' || text.charAt(i) == '4' || text.charAt(i) == '5'
                    || text.charAt(i) == '6' || text.charAt(i) == '7' || text.charAt(i) == '8' 
                    || text.charAt(i) == '9' || text.charAt(i) == '.'))
                return false;
        }
        return true;
    }
    
    public void exit(){
        System.exit(0);
    }
}
