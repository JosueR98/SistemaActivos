/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import sistemaactivos.logic.Bien;


/**
 *
 * @author Josue R
 */
public class BienesDB {
    static final RelDatabase db = new RelDatabase();
    
    public static void  bienAdd(Bien bien) throws Exception{
      String sql="insert into Bienes (codigo, descripcion, marca, modelo, precioUnitario, Solicitudes_codigo)"+
                "values(%d,'%s','%s','%s',%f,%d)";
  
        sql=String.format(sql,bien.getCodigo(),bien.getDescripcion(),bien.getMarca(),bien.getModelo(),
                bien.getPrecio_unitario(),bien.getSolicitud().getCodigoSolicitud());
       
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception();
        }
    }
    
    public static Bien BienGet(int codigo) throws SQLException{
        
        String sql="select * from Bienes where codigo= %d";
        sql = String.format(sql,codigo);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            int _codigo = rs.getInt("codigo");
            String _descripcion = rs.getString("descripcion");
            String _marca = rs.getString("marca");
            String _model = rs.getString("modelo");
            double _precioU = rs.getDouble("precioUnitario");
            int codigo_soli = rs.getInt("Solicitudes_codigo");
            
            Bien b = new Bien(_codigo,_descripcion,_marca,_model,_precioU);
            b.setSolicitud(codigo_soli);
            return b;
        }
        else{
            return null;
        }
    }
    
    public static List<Bien> BienGetBySoli(int codigo_solicitud){
          List<Bien> resultado = new ArrayList<Bien>();
   
        try {
            String sql="select * from "+
                    "bienes "+
                    "where Solicitudes_codigo = %d";
            
            sql=String.format(sql,codigo_solicitud);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
            int _codigo = rs.getInt("codigo");
            String _descripcion = rs.getString("descripcion");
            String _marca = rs.getString("marca");
            String _model = rs.getString("modelo");
            double _precioU = rs.getDouble("precioUnitario");
            int codigo_soli = rs.getInt("Solicitudes_codigo");
            Bien b = new Bien(_codigo,_descripcion,_marca,_model,_precioU);
            b.setSolicitud(codigo_soli);
            resultado.add(b);
            }
        } catch (SQLException ex) { }
        
        
        
        return resultado;
        
      
    }
}
