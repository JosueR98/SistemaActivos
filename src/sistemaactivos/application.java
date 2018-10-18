/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemaactivos.logic.Bien;
import sistemaactivos.logic.SolicitudBien;
import sistemaactivos.loginPresentation.loginController;
import sistemaactivos.loginPresentation.loginModel;
import sistemaactivos.loginPresentation.loginView;


/**
 *
 * @author Josue R
 */

public class application {
    //
     public static loginModel login_model = new loginModel();
     public static loginView login_view = new loginView();
     public static loginController login_controller= new loginController(login_model,login_view);
    

    public static void main(String[] args) throws Exception {

     login_view.setVisible(false);
     login_controller.ingresoAdmin();
    
    }
}
