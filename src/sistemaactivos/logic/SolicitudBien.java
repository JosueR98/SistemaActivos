/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos.logic;

import java.sql.SQLException;
import java.util.List;
import java.util.Date;

/**
 *
 * @author Josue R
 */
public class SolicitudBien {
     int codigoSolicitud;
     Date fecha;
     List<Bien> lista_bienes;
     int estado; // 1- Recibida 2- Cancelada 3-Procesada
     int cantidad_bienes;
     double montoTotal;

    public SolicitudBien() {
    }

    public SolicitudBien(Date fecha, List<Bien> lista_bienes, int estado) throws SQLException {
        this.fecha = fecha;
        this.lista_bienes = lista_bienes;
        this.estado = estado;
        this.cantidad_bienes = lista_bienes.size();
        
        for(Bien _bien : this.lista_bienes){
            _bien.setSolicitud(this);
            this.montoTotal += _bien.getPrecio_unitario();
        }
 
    }
     
    
    public SolicitudBien(int codigoSolicitud, Date fecha, List<Bien> lista_bienes, int estado) throws SQLException {
        this.codigoSolicitud = codigoSolicitud;
        this.fecha = fecha;
        this.lista_bienes = lista_bienes;
        this.estado = estado;
        this.cantidad_bienes = lista_bienes.size();
        
        
        
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

    public void setLista_bienes(List<Bien> lista_bienes) {
        this.lista_bienes = lista_bienes;
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

    public void setCantidad_bienes(int cantidad_bienes) {
        this.cantidad_bienes = cantidad_bienes;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Override
    public String toString() {
        String cadena = "";
        cadena += codigoSolicitud + ", ";
        cadena += fecha.toString() + ", ";
        cadena += estado + ", ";
        cadena += cantidad_bienes + ", ";
        cadena += 55 + ", Bienes{";
        
        
        for(Bien _bien : this.lista_bienes){
            cadena += _bien.toString() + "} " ;
        }
        
     return cadena;   
    }
    
}
