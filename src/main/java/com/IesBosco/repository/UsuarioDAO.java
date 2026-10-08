package com.IesBosco.repository;

import com.IesBosco.modelo.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UsuarioDAO {

    void anadirUser(Usuario usuario, Connection conexion) throws SQLException;

    void eliminarUser(Usuario usuario, Connection conexion) throws SQLException;

    void verConsulta(String sqlSentence, Connection conexion) throws SQLException;

    List<Usuario> mostrarUsuarios(Connection conexion)throws SQLException;

    List<Usuario> mostrarUsuarioPorLocaidad(String localidad,Connection conexion) throws SQLException;
    Optional<Usuario> mostrarUsuarioPorCodigo(int cod, Connection conexion) throws SQLException;
}
