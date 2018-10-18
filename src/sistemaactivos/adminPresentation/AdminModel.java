/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos.adminPresentation;

import java.util.Observable;
import sistemaactivos.logic.Usuario;

/**
 *
 * @author Josue R
 */
public class AdminModel extends Observable {
    
     Usuario current;

    public AdminModel() {
        current = sistemaactivos.loginPresentation.loginModel.getCurrent();
    }
    
    public Usuario getCurrent() {
        return current;
    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
