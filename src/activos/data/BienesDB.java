/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import activos.logic.Bien;
import activos.logic.Solicitud;
import activos.logic.Usuario;


/**
 *
 * @author Josue R
 */
public class BienesDB {
    static final RelDatabase db = new RelDatabase();
    
    public static void  add(Bien bien) throws Exception{
      String sql="insert into bienes (codigo, descripcion, marca, modelo, precioUnitario, estaRegistrado, Solicitudes_codigo, Usuarios_id)"+
                "values(0,'%s','%s','%s',%f,%b,%d,NULL)";
  
        sql=String.format(sql,bien.getDescripcion(),bien.getMarca(),bien.getModelo(), 
                bien.getPrecio_unitario(),bien.isEstaRegistrado(),bien.getSolicitud().getCodigoSolicitud());

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
    
    public static Bien get(int codigo) throws SQLException, Exception{
        
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
            _bien.setRegistrador(rs.getString("Registador_id"));
            _bien.setEstaRegistrado(rs.getBoolean("estaRegistrado"));
            return _bien;
        }
        else{
            return null;
        }
    }
    
    public static List<Bien> listaPorSolicitud(Solicitud solicitud) throws Exception{
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
            _bien.setRegistrador(rs.getString("Usuarios_id"));
            _bien.setEstaRegistrado(rs.getBoolean("estaRegistrado"));
            resultado.add(_bien);
            }
        } catch (SQLException ex) { }
        
        
        return resultado;
    }

    public static List<Bien> listaPorRegistrador(Usuario _usuario) throws Exception {
       List<Bien> salida = null;
            
       Bien _bien = null;
        try {
            String sql="select * from "+
                    "bienes "+
                    "where Usuarios_id = '%s'";
            
            sql=String.format(sql,_usuario.getId());
            ResultSet rs =  db.executeQuery(sql);
            
            if(rs.next()){
            while (rs.next()) {
            _bien = new Bien();
            _bien.setCodigo(rs.getInt("codigo"));
            _bien.setDescripcion(rs.getString("descripcion"));
            _bien.setMarca(rs.getString("marca"));
            _bien.setModelo(rs.getString("modelo"));
            _bien.setPrecio_unitario(rs.getDouble("precioUnitario"));
            _bien.setSolicitud(rs.getInt("Solicitudes_codigo"));
            _bien.setRegistrador(_usuario);
            _bien.setEstaRegistrado(rs.getBoolean("estaRegistrado"));
            salida.add(_bien);
            }
            }
        } catch (SQLException ex) {
            return null;
        }
        return salida;
    }
    
    public static void addRegistrador(int codigoBien, Usuario registrador) throws Exception{
        String query = "update bienes set Usuarios_id = '%s' where codigo = %d";
        query = String.format(query, registrador.getId(), codigoBien);
        int count = db.executeUpdate(query);
        if(count == 0){
            throw new  Exception("No sea actualizo nada");
        }
    }
    
     public static void registrar(int codigo) throws Exception{
        String query = "update bienes set estaRegistrado = 1 where codigo = %d";
        query = String.format(query, codigo);
        int count = db.executeUpdate(query);
        if(count == 0){
            throw new  Exception("No sea registro nada");
        }
    }

    
}
