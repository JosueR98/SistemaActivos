/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import activos.logic.Bien;
import activos.logic.SolicitudBien;

/**
 *
 * @author Josue R
 */
public class SolicitudesDB {
     static final RelDatabase db = new RelDatabase();
    
    public static void SolicitudAdd(SolicitudBien soli) throws Exception{
        
   
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd"); 
    java.sql.Date sqlDate=new java.sql.Date(soli.getFecha().getDate());
    String currentTime = sdf1.format(soli.getFecha());
    
      String sql="insert into solicitudes (codigo, fecha, montoTotal,cantidad, estado)"+
                "values(%d,'%s',%f,%d,%d)";
      
        sql=String.format(sql,0,currentTime,soli.getMontoTotal(),soli.getCantidad_bienes(),soli.getEstado());
     
        int count=db.executeUpdate(sql);
  
        if (count==0){
            throw new Exception();
        }
        
        // Obteniendo consecutivo
        int consecutivo = -1;
        ResultSet rs = db.executeQuery("SELECT max(codigo) FROM solicitudes");
        try {
            if (rs.next()) {
                consecutivo = rs.getInt(1);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
       
        soli.setCodigoSolicitud(consecutivo);
    }
    
    public static SolicitudBien SolicitudGet(int codigo) throws SQLException{
        
        SolicitudBien _solicitud = new SolicitudBien();
        String sql="select * from solicitudes where codigo= %d";
        sql = String.format(sql,codigo);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            _solicitud.setCodigoSolicitud(rs.getInt("codigo"));
            _solicitud.setFecha(rs.getDate("fecha"));
            _solicitud.setEstado(rs.getInt("estado"));
            List<Bien> list = activos.data.BienesDB.BienGetBySoli(_solicitud);
            _solicitud.setLista_bienes(list);
            return _solicitud;
        }
        else{
            return null;
        }
    }
    
   
}
