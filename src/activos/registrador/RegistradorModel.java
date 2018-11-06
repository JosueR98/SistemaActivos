/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.registrador;

import activos.logic.Bien;
import activos.logic.Solicitud;
import activos.logic.Usuario;
import activos.registrador.verBienes.bienesController;
import activos.registrador.verBienes.bienesModel;
import activos.registrador.verBienes.bienesView;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Josue R
 */
public class RegistradorModel extends Observable {

    Usuario usuarioActual;

    List<Bien> bienesPorRegistrar;
    List<Solicitud> solicitudes;

    //HIJOS
    bienesController controller_bienes;
    bienesView view_bienes;
    bienesModel model_bienes;

    public RegistradorModel() throws Exception {
        this.usuarioActual = activos.loginPresentation.loginModel.getUsuarioActual();

        cargarListas();
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public List<Bien> getBienesPorRegistrar() {
        return bienesPorRegistrar;
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        notifyObservers();
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void initTrioVerBienes(int codigo) throws Exception {
        model_bienes = new bienesModel(codigo);
        view_bienes = new bienesView();
        controller_bienes = new bienesController(model_bienes, view_bienes);
    }

    public bienesController getController_bienes() {
        return controller_bienes;
    }

    public bienesView getView_bienes() {
        return view_bienes;
    }

    public bienesModel getModel_bienes() {
        return model_bienes;
    }
    public void cargarListas() throws Exception{
        this.bienesPorRegistrar = activos.data.BienesDB.listaPorRegistrador(usuarioActual);
        solicitudes = new ArrayList<>();

        int codigoTMP = -1;
        for (Bien bien : bienesPorRegistrar) {
            if (codigoTMP != bien.getSolicitud().getCodigoSolicitud()) {
                solicitudes.add(bien.getSolicitud());
                codigoTMP = bien.getSolicitud().getCodigoSolicitud();
            }
        }
    }
}
