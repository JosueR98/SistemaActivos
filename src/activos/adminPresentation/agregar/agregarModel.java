/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.adminPresentation.agregar;

import java.util.Observable;
import java.util.Observer;
import activos.logic.Usuario;
import java.util.List;
import activos.logic.Bien;
import activos.logic.SolicitudBien;
import java.util.ArrayList;

/**
 *
 * @author Josue R
 */
public class agregarModel extends Observable {
        
     Usuario current;
     List<Bien> bienes;
     SolicitudBien solicitud;
     
    public agregarModel() {
        current = activos.loginPresentation.loginModel.getCurrent();
        bienes = new ArrayList<>();
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

    public List<Bien> getBienes() {
        return bienes;
    }

    public void setBienes(List<Bien> bienes) {
        this.bienes = bienes;
    }

    public SolicitudBien getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudBien solicitud) {
        this.solicitud = solicitud;
    }
    
    public double getTotal(){
        double total = 0;
        for(Bien bien: bienes){
            total += bien.getPrecio_unitario();
        }
        return total;
    }
    
    
    
}
