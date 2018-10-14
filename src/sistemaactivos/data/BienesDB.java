/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos.data;

import java.sql.PreparedStatement;
import sistemaactivos.logic.Bien;

public class BienesDB {
    RelDatabase db;
    
    public BienesDB(){
        db= new RelDatabase();
    }
 
    public void BienAdd(Bien p) throws Exception{
        String sql="insert into Bienes (codigo_bien, marca, modelo, precio, descripcion, Comprobante_codigo_comprobante)"+
                "values(123456,'DATOS DE','PRUEBA',1000,'assfsafafsafsa',1234)";
       // sql=String.format(sql,p.getCodigo(),p.getMarca(),p.getModelo(),p.getPrecio(),
         //       p.getDescripcion(),55555);

        int count=db.executeUpdate(sql);
        System.out.print("Bien agregado correctamente");
        if (count==0){
            System.out.print("Bien NO agregado correctamente");
            throw new Exception("NEIN");
        }
    }

    
}
