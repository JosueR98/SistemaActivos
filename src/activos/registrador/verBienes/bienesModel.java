/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.registrador.verBienes;

import activos.logic.Bien;
import activos.logic.Solicitud;
import activos.registrador.RegistradorController;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Josue R
 */
public class bienesModel extends Observable{
    
    private Solicitud solicitud;
    private List<Bien> bienes;
    private RegistradorController controladorPadre;

    public bienesModel(int soli) throws Exception {
        solicitud = activos.data.SolicitudesDB.get(soli);
        bienes = activos.data.BienesDB.listaPorSolicitud(solicitud);
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(int soli) throws Exception {
        solicitud = activos.data.SolicitudesDB.get(soli);
        bienes = activos.data.BienesDB.listaPorSolicitud(solicitud);
        setChanged();
        notifyObservers();
    }

    public List<Bien> getBienes() {
        return bienes;
    }

    public RegistradorController getControladorPadre() {
        return controladorPadre;
    }

    public void setControladorPadre(RegistradorController controladorPadre) {
        this.controladorPadre = controladorPadre;
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        notifyObservers();
    }

}
