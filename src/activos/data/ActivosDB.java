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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josue R
 */
public class ActivosDB {
    
     static final RelDatabase db = new RelDatabase();
     
     
    public static void add(Activo activo) throws Exception{
      String sql="insert into Activos (categoria, descripcion, Funcionarios_cedula)"+
                "values('%s','%s', %d)";
  
        sql=String.format(sql,activo.getCategoria(),activo.getDescripcion(),activo.getEncargado().getCedula());

        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception();
        }
        
        // Obteniendo consecutivo
        int consecutivo = -1;
        ResultSet rs = db.executeQuery("SELECT max(codigo) FROM activos");
        try {
            if (rs.next()) {
                consecutivo = rs.getInt(1);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
       
        activo.setCodigo(consecutivo);
    }
    
    public static Activo get(int codigo) throws SQLException {
        Activo _activo = new Activo();
        String sql="select * from activos where codigo= %d";
        sql = String.format(sql,codigo);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            _activo.setCodigo(rs.getInt("codigo"));
            _activo.setCategoria(rs.getString("categoria"));
            _activo.setDescripcion(rs.getString("descripcion"));
            _activo.setEncargado(rs.getInt("Funcionarios_cedula"));

            return _activo;
        }
        else{
            return null;
        }
    }

    public static List<Activo> getListaPorFuncionario(Funcionario _funcionario) throws SQLException {
        List<Activo> activoos = new ArrayList<>();
        Activo _activo = null;
        String sql="select * from activos where Funcionarios_cedula= %d" ;
        sql = String.format(sql,_funcionario.getCedula());
        ResultSet rs =  db.executeQuery(sql);
        while(rs.next()){
            _activo = new Activo();
            _activo.setCodigo(rs.getInt("codigo"));
            _activo.setDescripcion(rs.getString("descripcion"));
            _activo.setCategoria(rs.getString("categoria"));
            _activo.setEncargado(_funcionario);
            activoos.add(_activo);
        }
        return activoos;
    }
    
}
