package com.IesBosco.repository;

import com.IesBosco.modelo.Telefono;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelefonoDAOIm implements TelefonoDAO {

    @Override
    public void añadirTelefono(Telefono telefono, Connection conexion) throws SQLException {
        String sqlSentence = "INSERT INTO telefonos (cod, telefono) VALUES (?, ?);";
        try (PreparedStatement pstmt = conexion.prepareStatement(sqlSentence)) {
            pstmt.setInt(1, telefono.getCod());
            pstmt.setString(2, telefono.getTelefono());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void eliminarTelefono(Telefono telefono, Connection conexion) throws SQLException {
        String sqlSentence = "DELETE FROM telefonos WHERE telefono = ?;";
        try (PreparedStatement pstmt = conexion.prepareStatement(sqlSentence)) {
            pstmt.setString(1, telefono.getTelefono());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void verConsulta(String sqlSentence, Connection conexion) throws SQLException {
        try (PreparedStatement pstmt = conexion.prepareStatement(sqlSentence);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int cod = rs.getInt("cod");
                String telefono = rs.getString("telefono");
                System.out.println(cod + " | " + telefono);
            }
        }
    }
}
