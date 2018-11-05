/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.registrador.Registrar;

import activos.logic.Bien;
import activos.logic.Puesto;
import activos.registrador.RegistradorController;
import activos.registrador.verBienes.bienesController;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author Andrés
 */
public class RegistrarModel extends Observable {

    private Bien bien;
    List<Puesto> puestos;
    private bienesController controllerPadre;
    
    public RegistrarModel(int codigo) throws Exception {
        bien=activos.data.BienesDB.get(codigo);
        puestos=activos.data.PuestosDB.getListaPorDependencia(activos.loginPresentation.loginModel.getUsuarioActual().getDependencia());
    }

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public bienesController getControllerPadre() {
        return controllerPadre;
    }

    public void setControllerPadre(bienesController controllerPadre) {
        this.controllerPadre = controllerPadre;
    }

    public List<Puesto> getPuestos() {
        return puestos;
    }

    public void setPuestos(List<Puesto> puestos) {
        this.puestos = puestos;
    }
    
    
    
    
    
}
