package com.IesBosco.repository;

import com.IesBosco.modelo.Telefono;
import com.IesBosco.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Usuario> mostrarUsuarios(Connection conexion) throws SQLException {
        String sqlSentence="select * from usuario";
        List<Usuario> usuarioList =new ArrayList<>();
        try (PreparedStatement pstmt = conexion.prepareStatement(sqlSentence);
             ResultSet rs = pstmt.executeQuery()) {


            while (rs.next()) {
                int cod = rs.getInt("cod");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String direccion = rs.getString("direccion");
                String localidad = rs.getString("localidad");

                usuarioList.add(new Usuario(cod , nombre , apellidos,direccion,localidad));
            }

        }

        return List.of();
    }

    @Override
    public List<Usuario> mostrarUsuarioPorLocaidad( String localidad,Connection conexion) throws SQLException {
        String sqlSentence="select * from usuario u where  u.localidad=?";
        List<Usuario> usuarioList =new ArrayList<>();
        try (PreparedStatement pstmt = conexion.prepareStatement(sqlSentence);
             ) {
            pstmt.setString(1,localidad);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int cod = rs.getInt("cod");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String direccion = rs.getString("direccion");
                String localidad1 = rs.getString("localidad");

                usuarioList.add(new Usuario(cod , nombre , apellidos,direccion,localidad1));
            }

        }
        return usuarioList;
    }

    @Override
    public Optional<Usuario> mostrarUsuarioPorCodigo(int cod, Connection conexion) throws SQLException {
        String sqlSentence="select u.*,t.telefono from usuarios u  left JOIN  Telefonos t on t.cod = u.cod where u.cod=?";
        Usuario u= new Usuario();
        List<Telefono> telefonoList = new ArrayList<>();
        try (PreparedStatement pstmt = conexion.prepareStatement(sqlSentence);
        ) {
            pstmt.setInt(1,cod);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                if(u == null){
                    int cod1 = rs.getInt("cod");
                    String nombre = rs.getString("nombre");
                    String apellidos = rs.getString("apellidos");
                    String direccion = rs.getString("direccion");
                    String localidad = rs.getString("localidad");
                    u.setCod(cod);
                    u.setNombre(nombre);
                    u.setApellidos(apellidos);
                    u.setDireccion(direccion);
                    u.setLocalidad(localidad);
                }

                    telefonoList.add(new Telefono(rs.getInt("cod"), rs.getString("telefono")));


            }
            u.setTelefonoList(telefonoList);

        }
        return Optional.of(u);
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
