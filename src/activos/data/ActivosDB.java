/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.data;

import activos.logic.Activo;
import activos.logic.Puesto;
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

    public static void add(Activo activo) throws Exception {
        String sql = "insert into Activos (codigo, categoria, descripcion, Puestos_codigo)"
                + "values(0,'%s','%s',%d)";

        sql = String.format(sql, activo.getCategoria(), activo.getDescripcion(), activo.getEncargado().getCodigo());

        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception();
        }

        // Obteniendo consecutivo
        int consecutivo = -1;
        ResultSet rs = db.executeQuery("SELECT max(codigo) FROM activos");
        try {
            if (rs.next()) {
                consecutivo = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        activo.setCodigo(consecutivo);
    }

    public static Activo get(int codigo) throws SQLException {
        Activo _activo = new Activo();
        String sql = "select * from activos where codigo= %d";
        sql = String.format(sql, codigo);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            _activo.setCodigo(rs.getInt("codigo"));
            _activo.setCategoria(rs.getString("categoria"));
            _activo.setDescripcion(rs.getString("descripcion"));
            _activo.setEncargado(rs.getInt("Puestos_codigo"));

            return _activo;
        } else {
            return null;
        }
    }

    public static List<Activo> getListaPorPuesto(Puesto _puesto) throws SQLException {
        List<Activo> activoos = new ArrayList<>();
        Activo _activo = null;
        String sql = "select * from activos where Puestos_codigo= %d";
        sql = String.format(sql, _puesto.getCodigo());
        ResultSet rs = db.executeQuery(sql);
        while (rs.next()) {
            _activo = new Activo();
            _activo.setCodigo(rs.getInt("codigo"));
            _activo.setCategoria(rs.getString("categoria"));
            _activo.setDescripcion(rs.getString("descripcion"));
            _activo.setEncargado(_puesto);
            activoos.add(_activo);
        }
        return activoos;
    }

}
