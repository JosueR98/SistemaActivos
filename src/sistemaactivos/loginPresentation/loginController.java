/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos.loginPresentation;

import sistemaactivos.data.UsuariosDB;
import sistemaactivos.logic.Usuario;

/**
 *
 * @author Josue R
 */
public class loginController {
    UsuariosDB db;
    loginModel model;  
    loginView view;
    
    public loginController(loginModel model, loginView view) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void login(Usuario typed) throws Exception{
        model.setCurrent(typed);
        Usuario real = db.UsuarioGet(typed.getId(), typed.getClave());
        view.setVisible(false);
    }   

    public void logout(){
        model.setCurrent(new Usuario());
        view.setVisible(true);
        exit();
    }
    
    public void exit(){
        System.exit(0);
    }
}
