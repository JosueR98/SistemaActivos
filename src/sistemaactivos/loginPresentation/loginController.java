/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos.loginPresentation;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemaactivos.logic.Usuario;

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

    public void login(Usuario typed) throws Exception{
        Usuario _user = sistemaactivos.data.UsuariosDB.UsuarioGet(typed.getId(), typed.getClave());
        model.setCurrent(_user);
        view.setVisible(false);
    }   

    public void logout(){
        model.setCurrent(new Usuario());
        view.setVisible(true);
        exit();
    }
    
    public Usuario validar(String id, String clave){
   
        Usuario _user = null;
        
        try {
            _user = sistemaactivos.data.UsuariosDB.UsuarioGet(id, clave);
        } catch (SQLException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(_user != null)
            return _user;
        else 
            return null;

    }
    
    public void exit(){
        System.exit(0);
    }
}
