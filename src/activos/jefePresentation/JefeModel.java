/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.jefePresentation;

import activos.jefePresentation.agregarR.AgregarRController;
import activos.jefePresentation.agregarR.AgregarRModel;
import activos.jefePresentation.agregarR.AgregarRView;
import activos.logic.Usuario;
import java.util.Observable;

/**
 *
 * @author Andrés
 */
public class JefeModel extends Observable {

    private Usuario usuarioActual;

    private AgregarRController ARcontroller;
    private AgregarRModel ARmodel;
    private AgregarRView ARview;

    public JefeModel() {
        usuarioActual = activos.loginPresentation.loginModel.getUsuarioActual();
    }

    public void AgregarRTrio(int codigo) throws Exception {
        ARmodel = new AgregarRModel(codigo);
        ARview = new AgregarRView();
        ARcontroller = new AgregarRController(ARmodel, ARview);
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public AgregarRController getARcontroller() {
        return ARcontroller;
    }

    public void setARcontroller(AgregarRController ARcontroller) {
        this.ARcontroller = ARcontroller;
    }

    public AgregarRModel getARmodel() {
        return ARmodel;
    }

    public void setARmodel(AgregarRModel ARmodel) {
        this.ARmodel = ARmodel;
    }

    public AgregarRView getARview() {
        return ARview;
    }

    public void setARview(AgregarRView ARview) {
        this.ARview = ARview;
    }

}
