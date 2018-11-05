/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.funcionarios.agregar;

import activos.funcionarios.FuncionariosController;
import activos.logic.Usuario;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Josue R
 */
public class agregarFModel extends Observable{
    FuncionariosController controladorPadre;
    Usuario current;

    public agregarFModel() {
        this.current = activos.loginPresentation.loginModel.getUsuarioActual();
    }

    public FuncionariosController getControladorPadre() {
        return controladorPadre;
    }

    public void setControladorPadre(FuncionariosController controladorPadre) {
        this.controladorPadre = controladorPadre;
    }

    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        notifyObservers();
    }
    
}
