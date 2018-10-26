/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.loginPresentation;

import activos.logic.Dependencia;
import java.util.Observable;
import activos.logic.Usuario;

/**
 *
 * @author Josue R
 */
public class loginModel extends Observable {
    
    static Usuario usuarioActual;
    static Dependencia dependenciaActual;
    
    public loginModel() {
        usuarioActual = new Usuario();
    }
    
    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static Dependencia getDependenciaActual() {
        return dependenciaActual;
    }

    public void setCurrent(Usuario usuarioActual, Dependencia dependencia) {
        this.usuarioActual = usuarioActual;
        this.dependenciaActual = dependencia;
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
