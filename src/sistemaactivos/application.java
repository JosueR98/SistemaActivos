/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos;

import sistemaactivos.data.UsuariosDB;
import sistemaactivos.logic.Usuario;

/**
 *
 * @author Josue R
 */
public class application {
    

    public static void main(String[] args) throws Exception {

     UsuariosDB DB = new UsuariosDB();
     Usuario prueba = DB.UsuarioGet("admin_dependencia", "admin_clave");
     
     System.out.print(prueba.getTipoUsuario());
    }
}
