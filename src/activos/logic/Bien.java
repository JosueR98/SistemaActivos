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
   
     public static int FALSE = 0;
     public static int TRUE = 1;
     
     int codigo;
     String marca;
     String modelo;
     String descripcion;
     double precio_unitario;
     Solicitud solicitud;
     Usuario registrador;
     int esActivo;
     
   // Atributo comodin  
     int cantidad;

    public Bien() {
        codigo = -1;
        marca = modelo = descripcion = "INDEFINIDA";
        precio_unitario = 1.0;
        registrador = null;
        esActivo = FALSE;
        solicitud = null;
    }

    public Bien(String marca, String modelo, String descripcion, double precio_unitario) {
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio_unitario = precio_unitario;
        esActivo = FALSE;
        solicitud = null;
        registrador = null;
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

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(int solicitud) throws SQLException {
         this.solicitud = activos.data.SolicitudesDB.SolicitudGet(solicitud);
    }
    
     public void setSolicitud(Solicitud solicitud) throws SQLException {
         this.solicitud = solicitud;
    }

    public Usuario getRegistrador() {
        return registrador;
    }

    public void setRegistrador(Usuario registrador) {
        this.registrador = registrador;
    }
    
    public void setRegistrador(String id_registrador) throws SQLException {
        this.registrador = activos.data.UsuariosDB.UsuarioGet(id_registrador);
    }

    public int getEsActivo() {
        return esActivo;
    }

    public void setEsActivo(int esActivo) {
        this.esActivo = esActivo;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
