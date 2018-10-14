/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos.logic;

import java.util.Date;

/**
 *
 * @author Josue R
 */
public class SolicitudBien {
    private int codigoSolicitud;
    private int estado; // 1- Recibida 2- Cancelada 3-Procesada
    private Date fecha;
    private ComprobanteAdquisicion comprobante;
    
    public SolicitudBien() {
        codigoSolicitud = 11111;
        estado = 0;
        fecha = new Date();
    }

    public SolicitudBien(int codigoSolicitud, int estado, Date fecha) {
        this.codigoSolicitud = codigoSolicitud;
        this.estado = estado;
        this.fecha = fecha;
    }

    public int getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setCodigoSolicitud(int codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ComprobanteAdquisicion getComprobante() {
        return comprobante;
    }

    public void setComprobante(ComprobanteAdquisicion comprobante) {
        this.comprobante = comprobante;
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
        final SolicitudBien other = (SolicitudBien) obj;
        if (this.codigoSolicitud != other.codigoSolicitud) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SolicitudBien{" + "codigoSolicitud=" + codigoSolicitud + ", estado=" + estado + ", fecha=" + fecha + ", comprobante=" + comprobante + '}';
    }
    
}
