package com.IesBosco.modelo;

public class Telefono {
    private int cod;
    private String telefono;

    public Telefono(int cod, String telefono) {
        this.cod = cod;
        this.telefono = telefono;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "cod=" + cod +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
