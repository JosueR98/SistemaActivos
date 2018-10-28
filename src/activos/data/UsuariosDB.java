/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.data;

import activos.logic.Dependencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import activos.logic.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josue R
 */
public class UsuariosDB {
    static final RelDatabase db = new RelDatabase();
    
    public static void add(Usuario user) throws Exception{
      String sql="insert into usuarios (id, clave, tipo, Dependencias_codigo, Funcionarios_cedula)"+
                "values('%s','%s',%d, %d ,%d)";
        
        sql=String.format(sql,user.getId(),user.getClave(),user.getTipoUsuario(),
                user.getDependencia().getCodigoPostal(),user.getFuncionario().getCedula());
        
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception();
        }
    }
    
    public static Usuario get(String id, String clave) throws SQLException, Exception{
        
        String sql="select * from usuarios where id= '%s' AND clave = '%s'";
        sql = String.format(sql,id,clave);
        Usuario _user = new Usuario();
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            _user.setId(rs.getString("id"));
            _user.setClave( rs.getString("clave"));
            _user.setTipoUsuario(rs.getInt("tipo"));
            _user.setDependencia(rs.getInt("Dependencias_codigo"));
            _user.setFuncionario(rs.getInt("Funcionarios_cedula"));
            return _user;
        }
        else{
            return null;
        }
    }
    
      public static Usuario get(String id) throws SQLException, Exception{
        
        String sql="select * from usuarios where id='%s'";
        sql = String.format(sql,id);
        Usuario _user = new Usuario();
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            _user.setId(rs.getString("id"));
            _user.setClave( rs.getString("clave"));
            _user.setTipoUsuario(rs.getInt("tipo"));
            _user.setDependencia(rs.getInt("Dependencias_codigo"));
            _user.setFuncionario(rs.getInt("Funcionarios_cedula"));
            return _user;
        }
        else{
            return null;
        }
    }

    public static List<Usuario> getListaPorDependencia(Dependencia _dependencia) throws SQLException {
       List<Usuario> salida = new ArrayList<>();
       Usuario _usuario = null;
       String sql="select * from usuarios where Dependencias_codigo= %d" ;
        sql = String.format(sql,_dependencia.getCodigoPostal());
        ResultSet rs =  db.executeQuery(sql);
        while(rs.next()){
            _usuario = new Usuario();
            _usuario.setId(rs.getString("id"));
            _usuario.setClave(rs.getString("clave"));
            _usuario.setDependencia(_dependencia);
            _usuario.setTipoUsuario(rs.getInt("tipo"));
            _usuario.setFuncionario(rs.getInt("Funcionarios_cedula"));
            salida.add(_usuario);
        }
       return salida;
    }
    
    
    
}
