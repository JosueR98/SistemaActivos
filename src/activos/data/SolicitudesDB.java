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
import activos.logic.Dependencia;
import activos.logic.Solicitud;
import java.util.ArrayList;

/**
 *
 * @author Josue R
 */
public class SolicitudesDB {
     static final RelDatabase db = new RelDatabase();
    
    public static void add(Solicitud soli) throws Exception{
        
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd"); 
    java.sql.Date sqlDate=new java.sql.Date(soli.getFecha().getDate());
    String currentTime = sdf1.format(soli.getFecha());
    
      String sql="insert into Solicitudes (codigo, fecha, montoTotal,cantidad, estado, tipo, Dependencias_codigo)"+
                "values(%d,'%s',%f,%d,%d,%d,%d)";
      
        sql=String.format(sql,0,currentTime,soli.getMontoTotal(),soli.getCantidad_bienes(),soli.getEstado(),soli.getTipo(),soli.getDependencia().getCodigoPostal());
        System.out.print(sql);
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
    
    public static Solicitud get(int codigo) throws SQLException, Exception{
        
        Solicitud _solicitud = new Solicitud();
        String sql="select * from solicitudes where codigo= %d" ;
        sql = String.format(sql,codigo);
        
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            _solicitud.setCodigoSolicitud(rs.getInt("codigo"));
            _solicitud.setFecha(rs.getDate("fecha"));
            _solicitud.setEstado(rs.getInt("estado"));
            _solicitud.setTipo(rs.getInt("tipo"));
            _solicitud.setMotivoC(rs.getString("motivoC"));
            _solicitud.setDependencia(rs.getInt("Dependencias_codigo"));
            List<Bien> list = activos.data.BienesDB.listaPorSolicitud(_solicitud);
            _solicitud.setLista_bienes(list);
            return _solicitud;
        }
        else{
            return null;
        }
    }
    
    public static List<Solicitud> getListaPorDependencia(Dependencia dependencia) throws SQLException, Exception{
        List<Solicitud> solicitudes = new ArrayList<>();
        Solicitud _solicitud = null;
        String sql="select * from solicitudes where Dependencias_codigo= %d" ;
        sql = String.format(sql,dependencia.getCodigoPostal());
        ResultSet rs =  db.executeQuery(sql);
        while(rs.next()){
            _solicitud = new Solicitud();
            _solicitud.setCodigoSolicitud(rs.getInt("codigo"));
            _solicitud.setFecha(rs.getDate("fecha"));
            _solicitud.setEstado(rs.getInt("estado"));
             List<Bien> list = activos.data.BienesDB.listaPorSolicitud(_solicitud);
            _solicitud.setLista_bienes(list);
            _solicitud.setTipo(rs.getInt("tipo"));
            _solicitud.setMotivoC(rs.getString("motivoC"));
            _solicitud.setDependencia(dependencia);
            solicitudes.add(_solicitud);
        }
        return solicitudes;
    }
  
     
    public static void delete(int codigo) throws SQLException{
        //Borrar los bienes asocicados a ese codigo
        String queryA = "delete from bienes where Solicitudes_codigo = %d";
        queryA = String.format(queryA, codigo);
        int count = db.executeUpdate(queryA);
        if(count == 0){
            throw new SQLException("No existe registro en bien asociado con codigo de solitiud " + codigo);
        }
        
        //Borrar la solicitud
         String queryB = "delete from solicitudes where codigo = %d";
        queryB = String.format(queryB, codigo);
        int countB = db.executeUpdate(queryB);
        if(countB == 0){
            throw new SQLException("No existe registro con codigo de solitiud " + codigo);
        }
    }
    
     public static void aceptar(int codigo) throws SQLException{
        String str= "update solicitudes set estado = 2 where codigo= %d";
        str =  String.format(str, codigo);
        int count = db.executeUpdate(str);
        if(count == 0){
            throw new SQLException("No existe registro en bien asociado con codigo de solitiud " + codigo);
        }
        
    }
    
   public static void reclinar(int codigo, String motivo) throws SQLException{
        String str= "update solicitudes set estado= 3, motivoC= '%s' where codigo= %d";
        str =  String.format(str, motivo, codigo);
        int count = db.executeUpdate(str);
        if(count == 0){
            throw new SQLException("No existe registro en bien asociado con codigo de solitiud " + codigo);
        }
    }
   
}
