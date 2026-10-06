package com.IesBosco.repository;

import com.IesBosco.modelo.Usuario;

import java.sql.Connection;
import java.sql.SQLException;

public interface UsuarioDAO {

    public void añadirUser(Usuario usuario,Connection conexion) throws SQLException;
    public void eliminarUser(Usuario usuario,Connection conexion) throws SQLException;
    public void verConsulta(String sqlSentence, Connection conexion) throws SQLException;
}
