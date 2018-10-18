/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.loginPresentation;

import java.util.Observable;
import activos.logic.Usuario;

/**
 *
 * @author Josue R
 */
public class loginModel extends Observable {
    
    static Usuario current;

    public loginModel() {
        current = new Usuario();
    }
    
    public static Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
        setChanged();
        notifyObservers();
    }
    
  
    
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
