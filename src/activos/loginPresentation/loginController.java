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
import activos.logic.Dependencia;
import activos.logic.Usuario;

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

    public void login(Usuario typed, Dependencia choosed) throws Exception{
        Usuario _user = activos.data.UsuariosDB.UsuarioGet(typed.getId(), typed.getClave());
        model.setCurrent(_user,choosed);
        view.setVisible(false);
    }   

    public void logout(){
        model.setCurrent(new Usuario(), new Dependencia());
        view.setVisible(true);
        exit();
    }
    
    public Usuario validar(String id, String clave){
   
        Usuario _user = null;
        
        try {
            _user = activos.data.UsuariosDB.UsuarioGet(id, clave);
        } catch (SQLException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(_user != null)
            return _user;
        else 
            return null;

    }
      public void ingresoAdmin(){
       AdminModel _model = new AdminModel();
       AdminView _view = new AdminView();
       AdminController _control = new AdminController(_model,_view);
       _view.setVisible(true);
       view.setVisible(false);
    }
      
    public void exit(){
        System.exit(0);
    }
}
