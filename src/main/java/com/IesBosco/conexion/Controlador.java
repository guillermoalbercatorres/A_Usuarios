package com.IesBosco.conexion;

import com.IesBosco.repository.UsuarioDAO;
import com.IesBosco.repository.UsuarioDAOIm;

public class Controlador {

    private UsuarioDAO usuarioDAO;
    private UsuarioDAOIm usuarioDAOIm;

    public Controlador(UsuarioDAO usuarioDAO, UsuarioDAOIm usuarioDAOIm) {
        this.usuarioDAO = usuarioDAO;
        this.usuarioDAOIm = usuarioDAOIm;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public UsuarioDAOIm getUsuarioDAOIm() {
        return usuarioDAOIm;
    }

    public void setUsuarioDAOIm(UsuarioDAOIm usuarioDAOIm) {
        this.usuarioDAOIm = usuarioDAOIm;
    }

    @Override
    public String toString() {
        return "Controlador{" +
                "usuarioDAO=" + usuarioDAO +
                ", usuarioDAOIm=" + usuarioDAOIm +
                '}';
    }
}
