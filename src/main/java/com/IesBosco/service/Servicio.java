package com.IesBosco.service;

import com.IesBosco.repository.UsuarioDAO;
import com.IesBosco.repository.UsuarioDAOIm;

import java.sql.Connection;

public class Servicio {
    private UsuarioDAO usuarioDAO;

    public Servicio(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public  void buscarLocalidad(String localidad, Connection conexion) throws Exception {
        if(localidad.toCharArray().length>40){
            throw new Exception("ERROR");
        }
        this.usuarioDAO.mostrarUsuarioPorLocaidad(localidad,conexion);

    }

}
