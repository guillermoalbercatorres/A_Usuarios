package com.IesBosco.repository;

import com.IesBosco.modelo.Usuario;

import java.sql.Connection;
import java.sql.SQLException;

public interface UsuarioDAO {

    void anadirUser(Usuario usuario, Connection conexion) throws SQLException;

    void eliminarUser(Usuario usuario, Connection conexion) throws SQLException;

    void verConsulta(String sqlSentence, Connection conexion) throws SQLException;
}
