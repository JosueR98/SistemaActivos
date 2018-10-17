/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import sistemaactivos.logic.Usuario;

/**
 *
 * @author Josue R
 */
public class UsuariosDB {
    static final RelDatabase db = new RelDatabase();
    
    public static void  UsuarioAdd(Usuario user) throws Exception{
      String sql="insert into usuarios (id, clave, tipo)"+
                "values('%s','%s',%d)";
        sql=String.format(sql,user.getId(),user.getClave(),user.getTipoUsuario());
        System.out.print(sql);
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("NEIN");
        }
    }
    
    public static Usuario UsuarioGet(String id, String clave) throws SQLException{
        
        String sql="select * from usuarios where id='%s' AND clave = '%s'";
        sql = String.format(sql,id,clave);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            String _id = rs.getString("id");
            String _clave = rs.getString("clave");
            int usuario = rs.getInt("tipo");
            return new Usuario(_id,_clave,usuario);
        }
        else{
            return null;
        }
    }
}
