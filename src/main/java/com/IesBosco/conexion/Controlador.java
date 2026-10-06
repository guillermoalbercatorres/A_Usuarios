package com.IesBosco.conexion;

import com.IesBosco.repository.TelefonoDAO;
import com.IesBosco.repository.TelefonoDAOIm;
import com.IesBosco.repository.UsuarioDAO;
import com.IesBosco.repository.UsuarioDAOIm;

public class Controlador {

    private UsuarioDAO usuarioDAO;
    private UsuarioDAOIm usuarioDAOIm;
    private TelefonoDAO telefonoDAO;
    private TelefonoDAOIm telefonoDAOIm;

    public Controlador(UsuarioDAO usuarioDAO, UsuarioDAOIm usuarioDAOIm, TelefonoDAOIm telefonoDAOIm, TelefonoDAO telefonoDAO) {
        this.usuarioDAO = usuarioDAO;
        this.usuarioDAOIm = usuarioDAOIm;
        this.telefonoDAOIm = telefonoDAOIm;
        this.telefonoDAO = telefonoDAO;
    }

    public void startApplication(){
        //this.usuarioDAO.añadirUser();
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

    public TelefonoDAO getTelefonoDAO() {
        return telefonoDAO;
    }

    public void setTelefonoDAO(TelefonoDAO telefonoDAO) {
        this.telefonoDAO = telefonoDAO;
    }

    public TelefonoDAOIm getTelefonoDAOIm() {
        return telefonoDAOIm;
    }

    public void setTelefonoDAOIm(TelefonoDAOIm telefonoDAOIm) {
        this.telefonoDAOIm = telefonoDAOIm;
    }

    @Override
    public String toString() {
        return "Controlador{" +
                "usuarioDAO=" + usuarioDAO +
                ", usuarioDAOIm=" + usuarioDAOIm +
                ", telefonoDAO=" + telefonoDAO +
                ", telefonoDAOIm=" + telefonoDAOIm +
                '}';
    }
}
