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
    private double precio;

    public Bien() {
        this.codigo = -1;
        this.marca = "Indf";
        this.modelo = "Indf";
        this.descripcion = "Indf";
        this.precio = -1.0;
    }

    public Bien(int codigo, String marca, String modelo, String descripcion, double precio) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio = precio;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bien other = (Bien) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Bien{" + "codigo=" + codigo + ", marca=" + marca + ", modelo=" + modelo + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }

}
