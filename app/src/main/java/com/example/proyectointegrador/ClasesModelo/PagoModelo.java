package com.example.proyectointegrador.ClasesModelo;

import java.util.Date;

public class PagoModelo {

    private int IdPago;
    private int nroPago;
    private Date fecha;
    private double importe;
    private AlquilerModelo alquiler;

    public PagoModelo(int idPago, int nroPago, Date fecha, double importe, AlquilerModelo alquiler) {
        IdPago = idPago;
        this.nroPago = nroPago;
        this.fecha = fecha;
        this.importe = importe;
        this.alquiler = alquiler;
    }

    public int getIdPago() {
        return IdPago;
    }

    public void setIdPago(int idPago) {
        IdPago = idPago;
    }

    public int getNroPago() {
        return nroPago;
    }

    public void setNroPago(int nroPago) {
        this.nroPago = nroPago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public AlquilerModelo getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(AlquilerModelo alquiler) {
        this.alquiler = alquiler;
    }
}
