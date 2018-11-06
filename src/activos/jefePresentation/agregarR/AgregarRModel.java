/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.jefePresentation.agregarR;

import activos.jefePresentation.JefeController;
import activos.logic.Solicitud;
import activos.logic.Usuario;
import java.util.Observable;

/**
 *
 * @author Andrés
 */
public class AgregarRModel extends Observable {

    private Usuario usuarioActual;

    private Solicitud solicitud;
    public JefeController _controladorPadre;

    public AgregarRModel(int soli) throws Exception {
        usuarioActual = activos.loginPresentation.loginModel.getUsuarioActual();
        this.solicitud = activos.data.SolicitudesDB.get(soli);

    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public JefeController getControladorPadre() {
        return _controladorPadre;
    }

    public void setControladorPadre(JefeController _controladorPadre) {
        this._controladorPadre = _controladorPadre;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

}
