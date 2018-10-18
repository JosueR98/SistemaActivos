/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos.data;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import sistemaactivos.logic.Bien;
import sistemaactivos.logic.SolicitudBien;

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
    
      String sql="insert into solicitudes (codigo, fecha, montoTotal, estado)"+
                "values(%d,'%s',%f,%d)";
      
        sql=String.format(sql,soli.getCodigoSolicitud(),currentTime,soli.getMontoTotal(),soli.getEstado());
     
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception();
        }
    }
    
    public static SolicitudBien SolicitudGet(int codigo) throws SQLException{
        
        String sql="select * from solicitudes where codigo= %d";
        sql = String.format(sql,codigo);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            int cod = rs.getInt("codigo");
            Date d = rs.getDate("fecha");
            List<Bien> list = sistemaactivos.data.BienesDB.BienGetBySoli(codigo);
            int estado = rs.getInt("estado");
         
            return new SolicitudBien(cod,d,list,estado);
        }
        else{
            return null;
        }
    }
}
