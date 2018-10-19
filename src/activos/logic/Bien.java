/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.logic;

import java.sql.SQLException;

/**
 *
 * @author Josue R
 */
public class Bien {
     int codigo;
     String marca;
     String modelo;
     String descripcion;
     double precio_unitario;
     SolicitudBien solicitud;
     int cantidad;

    public Bien() {
    }

    public Bien(String marca, String modelo, String descripcion, double precio_unitario) {
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio_unitario = precio_unitario;
    }
    
    public Bien(int codigo,String marca, String modelo, String descripcion, double precio_unitario) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio_unitario = precio_unitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public SolicitudBien getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(int solicitud) throws SQLException {
         this.solicitud = activos.data.SolicitudesDB.SolicitudGet(solicitud);
    }
    
     public void setSolicitud(SolicitudBien solicitud) throws SQLException {
         this.solicitud = solicitud;
    }

    @Override
    public String toString() {
        return "Bien{" + "codigo=" + codigo + ", marca=" + marca + ", modelo=" + modelo + ", descripcion=" + descripcion + ", precio_unitario=" + precio_unitario + ", solicitud=" + solicitud.getCodigoSolicitud() + '}';
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   
     
     
}
