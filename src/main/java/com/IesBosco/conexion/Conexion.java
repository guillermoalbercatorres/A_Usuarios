package com.IesBosco.conexion;

import com.IesBosco.repository.TelefonoDAO;
import com.IesBosco.repository.UsuarioDAO;

import java.util.Objects;

/** Coordina las operaciones de la aplicación delegándolas en los DAO. */
public class Conexion {

    private UsuarioDAO usuarioDAO;
    private TelefonoDAO telefonoDAO;

    public Conexion(UsuarioDAO usuarioDAO, TelefonoDAO telefonoDAO) {
        this.usuarioDAO = Objects.requireNonNull(usuarioDAO, "usuarioDAO no puede ser null");
        this.telefonoDAO = Objects.requireNonNull(telefonoDAO, "telefonoDAO no puede ser null");
    }

    /** Compatibilidad con el constructor anterior, que recibía las implementaciones por duplicado. */
    public Conexion(UsuarioDAO usuarioDAO, UsuarioDAO ignoredUsuarioDAOIm,
                    com.IesBosco.repository.TelefonoDAOIm ignoredTelefonoDAOIm,
                    TelefonoDAO telefonoDAO) {
        this(usuarioDAO, telefonoDAO);
    }

    public void startApplication() {



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
