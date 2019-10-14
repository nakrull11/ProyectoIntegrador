package com.example.proyectointegrador.ClasesModelo;

public class InmuebleModelo {
    private int IdInmueble;
    private String direccion;
    private int ambientes;
    private String tipo;
    private String uso;
    private double precio;
    private boolean disponible;
    private PropietarioModelo propietario;

    public InmuebleModelo(int idInmueble, String direccion, int ambientes, String tipo, String uso, double precio, boolean disponible, PropietarioModelo propietario) {
        IdInmueble = idInmueble;
        this.direccion = direccion;
        this.ambientes = ambientes;
        this.tipo = tipo;
        this.uso = uso;
        this.precio = precio;
        this.disponible = disponible;
        this.propietario = propietario;
    }

    public int getIdInmueble() {
        return IdInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        IdInmueble = idInmueble;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(int ambientes) {
        this.ambientes = ambientes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public PropietarioModelo getPropietario() {
        return propietario;
    }

    public void setPropietario(PropietarioModelo propietario) {
        this.propietario = propietario;
    }
}
