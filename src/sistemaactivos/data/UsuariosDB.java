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
    RelDatabase db;
    
    public UsuariosDB(){
        db= new RelDatabase();
    }
 
    public void UsuarioAdd(Usuario user) throws Exception{
      String sql="insert into usuarios (id, clave, tipo_usuario)"+
                "values('%s','%s',%d)";
        sql=String.format(sql,user.getId(),user.getClave(),user.getTipoUsuario());
        System.out.print(sql);
        int count=db.executeUpdate(sql);
        System.out.print("Bien agregado correctamente");
        if (count==0){
            System.out.print("Bien NO agregado correctamente");
            throw new Exception("NEIN");
        }
    }
    
    public Usuario UsuarioGet(String id, String clave) throws SQLException{
        
        String sql="select * from usuarios where id='%s' AND clave = '%s'";
        sql = String.format(sql,id,clave);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            String _id = rs.getString("id");
            String _clave = rs.getString("clave");
            int usuario = rs.getInt("tipo_usuario");
            return new Usuario(_id,_clave,usuario);
        }
        else{
            return null;
        }
    }
}
