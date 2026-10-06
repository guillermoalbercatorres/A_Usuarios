package com.IesBosco.repository;

import com.IesBosco.modelo.Telefono;

import java.sql.Connection;
import java.sql.SQLException;

public interface TelefonoDAO {
    void añadirTelefono(Telefono telefono, Connection conexion) throws SQLException;

    void eliminarTelefono(Telefono telefono, Connection conexion) throws SQLException;

    void verConsulta(String sqlSentence, Connection conexion) throws SQLException;
}
