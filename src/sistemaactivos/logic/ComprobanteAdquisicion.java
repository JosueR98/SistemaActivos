/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Josue R
 */
public class ComprobanteAdquisicion {
    private int codigoComprobante;
    private Date fechaAdquisicion;
    private List<Bien> listaBienes;
    
    ComprobanteAdquisicion(){
        codigoComprobante = 11111;
        fechaAdquisicion = new Date();
        listaBienes = new ArrayList<>();
    }

    public ComprobanteAdquisicion(int codigo_comprobante, Date fecha_adquisicion, List<Bien> lista_bienes) {
        this.codigoComprobante = codigo_comprobante;
        this.fechaAdquisicion = fecha_adquisicion;
        this.listaBienes = lista_bienes;
    }

    public int getCodigoComprobante() {
        return codigoComprobante;
    }

    public void setCodigoComprobante(int codigoComprobante) {
        this.codigoComprobante = codigoComprobante;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public List<Bien> getListaBienes() {
        return listaBienes;
    }

    public void setListaBienes(List<Bien> listaBienes) {
        this.listaBienes = listaBienes;
    }
    
    public int getCantidadBienes(){
        return listaBienes.size();
    }
    
    public double getMontoTotal(){
        double sumatoria = 0;
        for(Bien _bien: listaBienes){
            sumatoria = sumatoria + _bien.getPrecio();
        }
        return sumatoria;
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
        final ComprobanteAdquisicion other = (ComprobanteAdquisicion) obj;
        if (this.codigoComprobante != other.codigoComprobante) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ComprobanteAdquisicion{" + "codigoComprobante=" + codigoComprobante + ", fechaAdquisicion=" + fechaAdquisicion + ", listaBienes=" + listaBienes + '}';
    }
}
