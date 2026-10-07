package com.IesBosco.conexion;

import com.IesBosco.modelo.Telefono;
import com.IesBosco.repository.TelefonoDAO;
import com.IesBosco.repository.UsuarioDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

/** Coordina las operaciones de la aplicación delegándolas en los DAO. */
public class Controlador {

    private UsuarioDAO usuarioDAO;
    private TelefonoDAO telefonoDAO;

    public Controlador(UsuarioDAO usuarioDAO, TelefonoDAO telefonoDAO) {
        this.usuarioDAO = Objects.requireNonNull(usuarioDAO, "usuarioDAO no puede ser null");
        this.telefonoDAO = Objects.requireNonNull(telefonoDAO, "telefonoDAO no puede ser null");
    }

    /** Compatibilidad con el constructor anterior, que recibía las implementaciones por duplicado. */
    public Controlador(UsuarioDAO usuarioDAO, UsuarioDAO ignoredUsuarioDAOIm,
                       com.IesBosco.repository.TelefonoDAOIm ignoredTelefonoDAOIm,
                       TelefonoDAO telefonoDAO) {
        this(usuarioDAO, telefonoDAO);
    }

    public void startApplication() {
        System.out.println("Aplicación iniciada.");
    }

    public void añadirUsuario(Usuario usuario, Connection conexion) throws SQLException {
        usuarioDAO.anadirUser(usuario, conexion);
    }

    public void eliminarUsuario(Usuario usuario, Connection conexion) throws SQLException {
        usuarioDAO.eliminarUser(usuario, conexion);
    }

    public void consultarUsuarios(String consulta, Connection conexion) throws SQLException {
        usuarioDAO.verConsulta(consulta, conexion);
    }

    public void añadirTelefono(Telefono telefono, Connection conexion) throws SQLException {
        telefonoDAO.añadirTelefono(telefono, conexion);
    }

    public void eliminarTelefono(Telefono telefono, Connection conexion) throws SQLException {
        telefonoDAO.eliminarTelefono(telefono, conexion);
    }

    public void consultarTelefonos(String consulta, Connection conexion) throws SQLException {
        telefonoDAO.verConsulta(consulta, conexion);
    }

    public UsuarioDAO getUsuarioDAO() { return usuarioDAO; }
    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = Objects.requireNonNull(usuarioDAO, "usuarioDAO no puede ser null");
    }

    public TelefonoDAO getTelefonoDAO() { return telefonoDAO; }
    public void setTelefonoDAO(TelefonoDAO telefonoDAO) {
        this.telefonoDAO = Objects.requireNonNull(telefonoDAO, "telefonoDAO no puede ser null");
    }

    @Override
    public String toString() {
        return "Controlador{" + "usuarioDAO=" + usuarioDAO + ", telefonoDAO=" + telefonoDAO + '}';
    }
}
