/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.data;

import activos.logic.Dependencia;
import activos.logic.Solicitud;
import activos.logic.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Josue R
 */
public class DependenciasDB {
     static final RelDatabase db = new RelDatabase();
     
    public static void  add(Dependencia dependencia) throws Exception{
           
        String sql="insert into Dependencias (codigo, nombre, Ubicacion)" +
                "values(%d,'%s','%s')";
  
        sql=String.format(sql,dependencia.getCodigoPostal(),dependencia.getNombre(),dependencia.getUbicacion());

        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception();
        }
           
    }
    
    public static Dependencia get(int codigo) throws SQLException{
         
        Dependencia _dependencia = new Dependencia();
        String sql="select * from Dependencias where codigo= %d";
        sql = String.format(sql,codigo);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            _dependencia.setCodigoPostal(rs.getInt("codigo"));
            _dependencia.setNombre(rs.getString("nombre"));
            _dependencia.setUbicacion(rs.getString("Ubicacion"));
            
             List<Solicitud> solicitudes = activos.data.SolicitudesDB.getListaPorDependencia(_dependencia);
             List<Usuario> usuarios = activos.data.UsuariosDB.getListaPorDependencia(_dependencia);
            
            
            _dependencia.setUsuarios(usuarios);
            _dependencia.setSolicitudes(solicitudes);
           
            return _dependencia;
        }
        else{
            return null;
        }
        
    }
        
   
}