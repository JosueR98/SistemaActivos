/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.logic;

import java.sql.SQLException;
import java.util.List;
import java.util.Date;

/**
 *
 * @author Josue R
 */


public class Solicitud {
    
    //Tipos de solicitudes
    public static int INDF = 0;
    public static int COMPRA = 1;
    public static int DONACION = 2;
    public static int PRODUCCION = 3;
    
    //Estados
    public static int RECIBIDA = 1;
    public static int POR_VERIFICAR = 2;
    public static int RECHAZADA = 3;
    public static int ESPERA_ROTULACION = 4;
    public static int PROCESADA = 5;
    
    private int codigoSolicitud;
    private Date fecha;
    private List<Bien> lista_bienes;
    private int estado; 
    private int cantidad_bienes;
    private double montoTotal;
    private int tipo;
    private String motivoC; 
    private Dependencia dependencia;
     
    public Solicitud() {
    }

    public Solicitud(Date fecha, List<Bien> lista_bienes, int tipo, Dependencia depe) throws SQLException {
        this.fecha = fecha;
        this.lista_bienes = lista_bienes;
        this.estado = RECIBIDA;
        this.cantidad_bienes = lista_bienes.size();
        this.tipo = tipo;
        this.motivoC = "No cancelada";
        this.dependencia = depe;
        
        for(Bien _bien : this.lista_bienes){
            _bien.setSolicitud(this);
            this.montoTotal += _bien.getPrecio_unitario();
        }
 
    }

    public Solicitud(int codigoSolicitud, Date fecha, List<Bien> lista_bienes, int estado, int cantidad_bienes, double montoTotal, int tipo, String motivoC, Dependencia dependencia) throws SQLException {
        this.codigoSolicitud = codigoSolicitud;
        this.fecha = fecha;
        this.lista_bienes = lista_bienes;
        this.estado = estado;
        this.cantidad_bienes = cantidad_bienes;
        this.montoTotal = montoTotal;
        this.tipo = tipo;
        this.motivoC = motivoC;
        this.dependencia = dependencia;
        
           for(Bien _bien : this.lista_bienes){
            _bien.setSolicitud(this);
            this.montoTotal += _bien.getPrecio_unitario();
        }
    }
     
  

    public int getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setCodigoSolicitud(int codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Bien> getLista_bienes() {
        return lista_bienes;
    }

    public void setLista_bienes(List<Bien> lista_bienes) throws SQLException {
        this.lista_bienes = lista_bienes;
        this.cantidad_bienes = this.lista_bienes.size();
        montoTotal = 0;
           for(Bien _bien : this.lista_bienes){
            _bien.setSolicitud(this);
            this.montoTotal += _bien.getPrecio_unitario();
           }
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCantidad_bienes() {
        return cantidad_bienes;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setMotivoC(String motivoC) {
        this.motivoC = motivoC;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }
    
      public void setDependencia(int dependencia) throws SQLException {
       this.dependencia = activos.data.DependenciasDB.get(dependencia);
    }

    public String getMotivoC() {
        return motivoC;
    }

}
