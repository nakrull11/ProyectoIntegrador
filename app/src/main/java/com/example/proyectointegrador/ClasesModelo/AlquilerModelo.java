package com.example.proyectointegrador.ClasesModelo;

import java.util.Date;

public class AlquilerModelo {

    private int IdAlquiler;
    private double precio;
    private Date fechaInicio;
    private Date fechaFin;
    private InquilinoModelo inquilino;
    private InmuebleModelo inmueble;

    public AlquilerModelo(int idAlquiler, double precio, Date fechaInicio, Date fechaFin, InquilinoModelo inquilino, InmuebleModelo inmueble) {
        IdAlquiler = idAlquiler;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.inquilino = inquilino;
        this.inmueble = inmueble;
    }

    public int getIdAlquiler() {
        return IdAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        IdAlquiler = idAlquiler;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public InquilinoModelo getInquilino() {
        return inquilino;
    }

    public void setInquilino(InquilinoModelo inquilino) {
        this.inquilino = inquilino;
    }

    public InmuebleModelo getInmueble() {
        return inmueble;
    }

    public void setInmueble(InmuebleModelo inmueble) {
        this.inmueble = inmueble;
    }
}
