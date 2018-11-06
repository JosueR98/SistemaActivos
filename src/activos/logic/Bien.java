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

    private int codigo;
    private String marca;
    private String modelo;
    private String descripcion;
    private double precio_unitario;
    private Solicitud solicitud;
    private Usuario registrador;
    private boolean estaRegistrado;
    // Atributo comodin  
    private int cantidad;

    public Bien() {
    }

    public Bien(String marca, String modelo, String descripcion, double precio_unitario) {
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio_unitario = precio_unitario;
        solicitud = null;
        registrador = null;
        estaRegistrado = false;
    }

    public Bien(int codigo, String marca, String modelo, double precio_unitario, Solicitud solicitud, Usuario registrador) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.precio_unitario = precio_unitario;
        this.solicitud = solicitud;
        this.registrador = registrador;
        estaRegistrado = false;
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

    public void setSolicitud(int solicitud) throws SQLException, Exception {
        this.solicitud = activos.data.SolicitudesDB.get(solicitud);
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

    public void setRegistrador(String id_registrador) throws Exception {
        this.registrador = activos.data.UsuariosDB.get(id_registrador);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isEstaRegistrado() {
        return estaRegistrado;
    }

    public void setEstaRegistrado(boolean estaRegistrado) {
        this.estaRegistrado = estaRegistrado;
    }

}
