/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.adminPresentation.agregar;

import java.util.Observable;
import java.util.Observer;
import activos.logic.Usuario;

/**
 *
 * @author Josue R
 */
public class agregarModel extends Observable {
        
     Usuario current;

    public agregarModel() {
        current = activos.loginPresentation.loginModel.getCurrent();
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
