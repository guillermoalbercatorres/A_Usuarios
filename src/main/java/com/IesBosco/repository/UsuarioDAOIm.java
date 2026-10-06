package com.IesBosco.repository;

import com.IesBosco.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOIm implements UsuarioDAO{


    @Override
    public void añadirUser(Usuario usuario,Connection conexion) throws SQLException {
        ResultSet rs=null;
        String sqlSentence
                = "insert into usuarios values (?,?,?,?,?);";
        PreparedStatement pstmt = conexion.prepareStatement(sqlSentence);

        pstmt.setInt(1, usuario.getCod());
        pstmt.setString(2, usuario.getNombre());
        pstmt.setString(3, usuario.getApellidos());
        pstmt.setString(4, usuario.getDireccion());
        pstmt.setString(5, usuario.getLocalidad());

        rs = pstmt.executeQuery();
        verLaConsulta(rs);
    }

    @Override
    public void eliminarUser(Usuario usuario, Connection conexion) throws SQLException {

        ResultSet rs=null;
        String sqlSentence
                = "DELETE FROM usuarios WHERE cod = ?;";
        PreparedStatement pstmt = conexion.prepareStatement(sqlSentence);


        pstmt.setInt(1, usuario.getCod());

        rs = pstmt.executeQuery();
        verLaConsulta(rs);


    }

    @Override
    public void verConsulta(String sqlSentence, Connection conexion) throws SQLException {
        ResultSet rs=null;
        PreparedStatement pstmt = conexion.prepareStatement(sqlSentence);

        rs = pstmt.executeQuery();


        verLaConsulta(rs);


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
