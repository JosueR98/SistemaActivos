/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos;
import activos.loginPresentation.loginController;
import activos.loginPresentation.loginModel;
import activos.loginPresentation.loginView;


/**
 *
 * @author Josue R
 */

public class application {
    // Ultimos cambios
     public static loginModel login_model = new loginModel();
     public static loginView login_view = new loginView();
     public static loginController login_controller= new loginController(login_model,login_view);
    

    public static void main(String[] args) throws Exception {

    login_view.setVisible(true);
     //login_controller.ingresoAdmin();
    }
}
