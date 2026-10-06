package com.IesBosco.modelo;

public class Usuario {
    private int cod;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String localidad;

    public Usuario(int cod, String nombre, String apellidos, String localidad, String direccion) {
        this.cod = cod;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.localidad = localidad;
        this.direccion = direccion;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "cod=" + cod +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                '}';
    }
}
