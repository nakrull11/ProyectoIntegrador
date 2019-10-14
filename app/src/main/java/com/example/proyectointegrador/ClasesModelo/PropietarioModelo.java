package com.example.proyectointegrador.ClasesModelo;

public class PropietarioModelo {

    private int IdPropietario;
    private int dni;
    private String apellido;
    private String nombre;
    private String telefono;
    private String email;
    private String password;

    public PropietarioModelo(int idPropietario, int dni, String apellido, String nombre, String telefono, String email, String password) {
        IdPropietario = idPropietario;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    public int getIdPropietario() {
        return IdPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        IdPropietario = idPropietario;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
