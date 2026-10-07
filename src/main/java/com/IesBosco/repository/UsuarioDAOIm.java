package com.IesBosco.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOIm implements UsuarioDAO{


    @Override
    public void anadirUser(Usuario usuario, Connection conexion) throws SQLException {
        String sqlSentence = "INSERT INTO usuarios (cod, nombre, apellidos, direccion, localidad) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement pstmt = conexion.prepareStatement(sqlSentence)) {
            pstmt.setInt(1, usuario.getCod());
            pstmt.setString(2, usuario.getNombre());
            pstmt.setString(3, usuario.getApellidos());
            pstmt.setString(4, usuario.getDireccion());
            pstmt.setString(5, usuario.getLocalidad());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void eliminarUser(Usuario usuario, Connection conexion) throws SQLException {

        String sqlSentence = "DELETE FROM usuarios WHERE cod = ?;";
        try (PreparedStatement pstmt = conexion.prepareStatement(sqlSentence)) {
            pstmt.setInt(1, usuario.getCod());
            pstmt.executeUpdate();
        }

    }

    @Override
    public void verConsulta(String sqlSentence, Connection conexion) throws SQLException {
        try (PreparedStatement pstmt = conexion.prepareStatement(sqlSentence);
             ResultSet rs = pstmt.executeQuery()) {
            verLaConsulta(rs);
        }

    }

    private static void verLaConsulta(ResultSet rs) throws SQLException {
        while (rs.next()) {
            int cod = rs.getInt("cod");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String direccion = rs.getString("direccion");
            String localidad = rs.getString("localidad");

            System.out.println(cod + " | " + nombre + " | " + apellidos + " | " + direccion + " | " + localidad);
        }
    }
}
