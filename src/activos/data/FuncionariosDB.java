/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.data;

import activos.logic.Activo;
import activos.logic.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Josue R
 */
public class FuncionariosDB {

     static final RelDatabase db = new RelDatabase();
     
     
    public static void add(Funcionario funcionario) throws Exception{
      String sql="insert into bienes (cedula, nombre, puesto)"+
                "values(%d,'%s','%s')";
  
        sql=String.format(sql,funcionario.getCedula(),funcionario.getNombre(),funcionario.getPuesto());

        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception();
        }
    }
    
    public static Funcionario get(int cedula) throws SQLException {
        Funcionario _funcionario = new Funcionario();
        String sql="select * from Funcionarios where cedula= %d";
        sql = String.format(sql,cedula);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            _funcionario = new Funcionario();
            _funcionario.setCedula(rs.getInt("cedula"));
            _funcionario.setNombre(rs.getString("nombre"));
            _funcionario.setPuesto(rs.getString("puesto"));
            return _funcionario;
        }
        else{
            return null;
        }
    }
    
}
