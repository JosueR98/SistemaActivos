/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos.logic;

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
    
    
    public Bien() {
        this.codigo = 11111;
        this.marca = "Indf";
        this.modelo = "Indf";
        this.descripcion = "Indf";
        this.precio_unitario = 0;
    }

    public Bien(int codigo,String marca, String modelo, String descripcion, double precio_unitario) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio_unitario = precio_unitario;
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

    public double getPrecio() {
        return precio_unitario;
    }

    public void setPrecio(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    

    @Override
    public String toString() {
        return "Bien{" + "marca=" + marca + ", modelo=" + modelo + ", descripcion=" + descripcion + ", precio_unitario=" + precio_unitario + '}';
    }
    


}
