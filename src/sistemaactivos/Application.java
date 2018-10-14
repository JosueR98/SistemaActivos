/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos;

import sistemaactivos.data.BienesDB;
import sistemaactivos.logic.Bien;

/**
 *
 * @author Josue R
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        BienesDB db = new BienesDB();
    
        db.BienAdd(new Bien(00001,"Acer","Aspire","Computadora para laboratorio",300000));
        
        
    }
    
}
