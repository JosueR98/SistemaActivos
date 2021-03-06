/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.loginPresentation;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import activos.adminPresentation.AdminController;
import activos.adminPresentation.AdminModel;
import activos.adminPresentation.AdminView;
import activos.jefe_RRHH.RRHHController;
import activos.jefe_RRHH.RRHHModel;
import activos.jefe_RRHH.RRHHView;
import activos.jefePresentation.JefeController;
import activos.jefePresentation.JefeModel;
import activos.jefePresentation.JefeView;
import activos.logic.Usuario;
import activos.registrador.RegistradorController;
import activos.registrador.RegistradorModel;
import activos.registrador.RegistradorView;

/**
 *
 * @author Josue R
 */
public class loginController {

    loginModel model;
    loginView view;

    public loginController(loginModel model, loginView view) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void login(Usuario typed) throws Exception {
        Usuario _user = activos.data.UsuariosDB.get(typed.getId(), typed.getClave());
        model.setCurrent(_user);
        view.setVisible(false);
    }

    public void logout() {
        model.setCurrent(new Usuario());
        view.setVisible(true);
        exit();
    }

    public Usuario validar(String id, String clave) throws Exception {

        Usuario _user = null;

        try {
            _user = activos.data.UsuariosDB.get(id, clave);
        } catch (SQLException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (_user != null) {
            return _user;
        } else {
            return null;
        }

    }

    public void ingresoAdmin() {
        AdminModel _model = new AdminModel();
        AdminView _view = new AdminView();
        AdminController _control = new AdminController(_model, _view);
        _view.setVisible(true);
        view.setVisible(false);
    }

    public void ingresoJefe() {
        JefeModel _model = new JefeModel();
        JefeView _view = new JefeView();
        JefeController _control = new JefeController(_model, _view);
        _view.setVisible(true);
        view.setVisible(false);
    }

    public void exit() {
        System.exit(0);
    }

    void ingresoRegistrador() throws Exception {
        RegistradorModel _model = new RegistradorModel();
        RegistradorView _view = new RegistradorView();
        RegistradorController _controller = new RegistradorController(_model, _view);
        _view.setVisible(true);
        view.setVisible(false);
    }

    void ingresoJefeRHHH() throws SQLException {
        RRHHModel _model = new RRHHModel();
        RRHHView _view = new RRHHView();
        RRHHController _controller = new RRHHController(_model, _view);
        _view.setVisible(true);
        view.setVisible(false);
    }
}
