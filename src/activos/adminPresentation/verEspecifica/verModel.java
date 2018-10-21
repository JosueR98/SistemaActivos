/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.adminPresentation.verEspecifica;

import activos.adminPresentation.AdminController;
import activos.logic.SolicitudBien;
import java.sql.SQLException;
import java.util.Observable;

/**
 *
 * @author Josue R
 */
public class verModel extends Observable {
    private SolicitudBien solicitud;
    
    
    public AdminController _controladorPadre;
    
    public verModel(int solicitud) throws SQLException {
        this.solicitud = activos.data.SolicitudesDB.SolicitudGet(solicitud);
    }

    public SolicitudBien getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(int solicitud) throws SQLException {
       this.solicitud = activos.data.SolicitudesDB.SolicitudGet(solicitud);
       setChanged();
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers(); //To change body of generated methods, choose Tools | Templates.
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
