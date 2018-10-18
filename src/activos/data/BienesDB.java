/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import activos.logic.Bien;
import activos.logic.SolicitudBien;


/**
 *
 * @author Josue R
 */
public class BienesDB {
    static final RelDatabase db = new RelDatabase();
    
    public static void  bienAdd(Bien bien) throws Exception{
      String sql="insert into bienes (codigo, descripcion, marca, modelo, precioUnitario, Solicitudes_codigo)"+
                "values(0,'%s','%s','%s',%f,%d)";
  
        sql=String.format(sql,bien.getDescripcion(),bien.getMarca(),bien.getModelo(),
                bien.getPrecio_unitario(),bien.getSolicitud().getCodigoSolicitud());
       System.out.print(sql);
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception();
        }
        
        
        // Obteniendo consecutivo
        int consecutivo = -1;
        ResultSet rs = db.executeQuery("SELECT max(codigo) FROM bienes");
        try {
            if (rs.next()) {
                consecutivo = rs.getInt(1);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
       
        bien.setCodigo(consecutivo);
    }
    
    public static Bien BienGet(int codigo) throws SQLException{
        
        Bien _bien = new Bien();
        String sql="select * from Bienes where codigo= %d";
        sql = String.format(sql,codigo);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            
            _bien.setCodigo(rs.getInt("codigo"));
            _bien.setDescripcion(rs.getString("descripcion"));
            _bien.setMarca(rs.getString("marca"));
            _bien.setModelo(rs.getString("modelo"));
            _bien.setPrecio_unitario(rs.getDouble("precioUnitario"));
            _bien.setSolicitud(rs.getInt("Solicitudes_codigo"));

            return _bien;
        }
        else{
            return null;
        }
    }
    
    public static List<Bien> BienGetBySoli(SolicitudBien solicitud){
          List<Bien> resultado = new ArrayList<Bien>();
          Bien _bien =null;
        try {
            String sql="select * from "+
                    "bienes "+
                    "where Solicitudes_codigo = %d";
            
            sql=String.format(sql,solicitud.getCodigoSolicitud());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
            _bien = new Bien();
            _bien.setCodigo(rs.getInt("codigo"));
            _bien.setDescripcion(rs.getString("descripcion"));
            _bien.setMarca(rs.getString("marca"));
            _bien.setModelo(rs.getString("modelo"));
            _bien.setPrecio_unitario(rs.getDouble("precioUnitario"));
            _bien.setSolicitud(solicitud);

            resultado.add(_bien);
      
            }
        } catch (SQLException ex) { }
        
        
        
        return resultado;
        

    }
}