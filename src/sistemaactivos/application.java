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

     //login_view.setVisible(false);
    // login_controller.ingresoAdmin();
     
     // Creando nueva solicitud 
     List<Bien> listaBienes = new ArrayList<>();
     Bien _bien = new Bien(1,"acer","aspire","computadora para laboratorio",3330000);
     Bien _bien2 = new Bien(2,"acer","aspire","computadora para laboratorio",3330000);
     Bien _bien3 = new Bien(3,"acer","aspire","computadora para laboratorio",3330000);
     
     listaBienes.add(_bien);
     listaBienes.add(_bien2);
     listaBienes.add(_bien3);
     
     
     SolicitudBien solicitud = new SolicitudBien(
     100, new Date(), listaBienes, 2
     );
     
     sistemaactivos.data.SolicitudesDB.SolicitudAdd(solicitud);
   
     sistemaactivos.data.BienesDB.bienAdd(_bien);
      sistemaactivos.data.BienesDB.bienAdd(_bien2);
       sistemaactivos.data.BienesDB.bienAdd(_bien3);
    }
}
