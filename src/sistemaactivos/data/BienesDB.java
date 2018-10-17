/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos.data;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        System.out.print(sql);
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception();
        }
    }
    
    public static Bien UsuarioGet(String codigo) throws SQLException{
        
        String sql="select * from Bienes where codigo= %d";
        sql = String.format(sql,codigo);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            int _codigo = rs.getInt("codigo");
            String _descripcion = rs.getString("clave");
            String _marca = rs.getString("marca");
            String _model = rs.getString("modelo");
            double _precioU = rs.getDouble("precioUnitario");
            int codigo_soli = rs.getInt("Solicitudes_codigo");
            return new Bien(_codigo,_descripcion,_marca,_model,_precioU , codigo_soli);
        }
        else{
            return null;
        }
    }
}
