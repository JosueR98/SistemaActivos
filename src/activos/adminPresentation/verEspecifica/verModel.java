/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.adminPresentation.verEspecifica;

import activos.adminPresentation.AdminController;
import activos.logic.Solicitud;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Josue R
 */
public class verModel extends Observable {

    private Solicitud solicitud;

    public AdminController _controladorPadre;

    public verModel(int solicitud) throws SQLException, Exception {
        this.solicitud = activos.data.SolicitudesDB.get(solicitud);
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(int solicitud) throws SQLException, Exception {
        this.solicitud = activos.data.SolicitudesDB.get(solicitud);
        setChanged();
        notifyObservers();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        notifyObservers();
    }

    public AdminController getControladorPadre() {
        return _controladorPadre;
    }

    public void setControladorPadre(AdminController _controladorPadre) {
        this._controladorPadre = _controladorPadre;
    }

}
