/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.data;

import activos.logic.Dependencia;
import activos.logic.Puesto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josue R
 */
public class PuestosDB {
    
    static final RelDatabase db = new RelDatabase();
    
    public static void add(Puesto puesto) throws Exception {
        String sql = "insert into Puestos (codigo, rol, Funcionarios_cedula, Dependencias_codigo)"
                + "values(0,'%s',%d, %d)";
        
        sql = String.format(sql, puesto.getRol(), puesto.getFuncionario().getCedula(), puesto.getDependencia().getCodigoPostal());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception();
        }

        // Obteniendo consecutivo
        int consecutivo = -1;
        ResultSet rs = db.executeQuery("SELECT max(codigo) FROM puestos");
        try {
            if (rs.next()) {
                consecutivo = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        puesto.setCodigo(consecutivo);
    }
    
        public static void addSinF(Puesto puesto) throws Exception {
        String sql = "insert into Puestos (codigo, rol, Funcionarios_cedula, Dependencias_codigo)"
                + "values(0,'%s',NULL, %d)";
        
        sql = String.format(sql, puesto.getRol(),puesto.getDependencia().getCodigoPostal());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception();
        }

        // Obteniendo consecutivo
        int consecutivo = -1;
        ResultSet rs = db.executeQuery("SELECT max(codigo) FROM puestos");
        try {
            if (rs.next()) {
                consecutivo = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        puesto.setCodigo(consecutivo);
    }
    
    public static Puesto get(int codigo) throws SQLException {
        Puesto _puesto = new Puesto();
        String sql = "select * from puestos where codigo= %d";
        sql = String.format(sql, codigo);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            _puesto.setCodigo(rs.getInt("codigo"));
            _puesto.setRol(rs.getString("rol"));
            _puesto.setFuncionario(rs.getInt("Funcionarios_cedula"));
            _puesto.setDependencia(rs.getInt("Dependencias_codigo"));
            
            return _puesto;
        } else {
            return null;
        }
    }
    
    public static List<Puesto> getLista() throws SQLException {
        List<Puesto> salida = new ArrayList<>();
        Puesto _puesto = null;
        String sql = "select * from puestos";
        ResultSet rs = db.executeQuery(sql);
        while (rs.next()) {
            _puesto = new Puesto();
            _puesto.setCodigo(rs.getInt("codigo"));
            _puesto.setRol(rs.getString("rol"));
            _puesto.setFuncionario(rs.getInt("Funcionarios_cedula"));
            _puesto.setDependencia(rs.getInt("Dependencias_codigo"));
            salida.add(_puesto);
        }
        return salida;
    }
    
    public static List<Puesto> getListaPorDependencia(Dependencia _dependencia) throws SQLException {
        List<Puesto> salida = new ArrayList<>();
        Puesto _puesto = null;
        String sql = "select * from puestos where Dependencias_codigo = %d";
        sql = String.format(sql, _dependencia.getCodigoPostal());
        ResultSet rs = db.executeQuery(sql);
        while (rs.next()) {
            _puesto = new Puesto();
            _puesto.setCodigo(rs.getInt("codigo"));
            _puesto.setRol(rs.getString("rol"));
            _puesto.setFuncionario(rs.getInt("Funcionarios_cedula"));
            _puesto.setDependencia(_dependencia);
            salida.add(_puesto);
        }
        return salida;
    }
    
    public static int getSiguienteCodigo() throws SQLException {
        int consecutivo = -1;
        ResultSet rs = db.executeQuery("select max(codigo) from puestos");
        if (rs.next()) {
            consecutivo = rs.getInt(1);
        }
        consecutivo += 1;
        return consecutivo;        
    }
    
    public static List<Puesto> getVacantes() throws SQLException {
        List<Puesto> salida = new ArrayList<>();
        Puesto _puesto = null;
        String sql = "select * from puestos where Funcionarios_cedula IS NULL";
        ResultSet rs = db.executeQuery(sql);
        while (rs.next()) {
            _puesto = new Puesto();
            _puesto.setCodigo(rs.getInt("codigo"));
            _puesto.setRol(rs.getString("rol"));
            _puesto.setDependencia(rs.getInt("Dependencias_codigo"));
            salida.add(_puesto);
        }
        
        return salida;
    }
    
    public static void ocupar(int puestoCodigo, int cedula) throws Exception {
        String sql = "update puestos set Funcionarios_cedula = %d where codigo = %d";
        sql = String.format(sql, cedula, puestoCodigo);
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("ERROR A LA HORA DE OCUPAR PUESTO");
        }
    }
    
}
