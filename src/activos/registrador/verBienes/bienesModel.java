/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.registrador.verBienes;

import activos.logic.Bien;
import activos.logic.Solicitud;
import activos.registrador.RegistradorController;
import activos.registrador.Registrar.RegistrarController;
import activos.registrador.Registrar.RegistrarModel;
import activos.registrador.Registrar.RegistrarView;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author Josue R
 */
public class bienesModel extends Observable {

    private Solicitud solicitud;
    private List<Bien> bienes;
    private RegistradorController controladorPadre;

    private RegistrarController Rcontroller;
    private RegistrarModel Rmodel;
    private RegistrarView Rview;

    public bienesModel(int soli) throws Exception {
        solicitud = activos.data.SolicitudesDB.get(soli);
        bienes = activos.data.BienesDB.listaPorSolicitud(solicitud);
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void recargarLista() throws Exception {
        bienes = null;
        bienes = activos.data.BienesDB.listaPorSolicitud(solicitud);
    }

    public void RegistrarTrio(int cod) throws Exception {
        Rmodel = new RegistrarModel(cod);
        Rview = new RegistrarView();
        Rcontroller = new RegistrarController(Rmodel, Rview);

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

    public RegistrarController getRcontroller() {
        return Rcontroller;
    }

    public void setRcontroller(RegistrarController Rcontroller) {
        this.Rcontroller = Rcontroller;
    }

    public RegistrarModel getRmodel() {
        return Rmodel;
    }

    public void setRmodel(RegistrarModel Rmodel) {
        this.Rmodel = Rmodel;
    }

    public RegistrarView getRview() {
        return Rview;
    }

    public void setRview(RegistrarView Rview) {
        this.Rview = Rview;
    }

}
