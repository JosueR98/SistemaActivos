/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.adminPresentation.agregar;

import activos.adminPresentation.AdminController;
import java.util.Observable;
import java.util.Observer;
import activos.logic.Usuario;
import java.util.List;
import activos.logic.Bien;
import activos.logic.Dependencia;
import activos.logic.Solicitud;
import java.util.ArrayList;

/**
 *
 * @author Josue R
 */
public class agregarModel extends Observable {
        
     private Usuario usuarioActual;
     private Dependencia dependenciaActual; 
     private List<Bien> bienes;
     private Solicitud solicitud;   
     
     private AdminController _controladorPadre;
     
    public agregarModel() {
        usuarioActual = activos.loginPresentation.loginModel.getUsuarioActual();
        dependenciaActual = activos.loginPresentation.loginModel.getDependenciaActual();
        bienes = new ArrayList<>();
        solicitud = new Solicitud();
    }
    
    public void setControllerPadre(AdminController cp){
        this._controladorPadre = cp;
    }
    
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }

    public List<Bien> getBienes() {
        return bienes;
    }

    public void setBienes(List<Bien> bienes) {
        this.bienes = bienes;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    
    public double getTotal(){
        double total = 0;
        for(Bien bien: bienes){
            total += bien.getPrecio_unitario();
        }
        return total;
    }

    public Dependencia getDependenciaActual() {
        return dependenciaActual;
    }

    public AdminController getControladorPadre() {
        return _controladorPadre;
    }
    
    
    
}
