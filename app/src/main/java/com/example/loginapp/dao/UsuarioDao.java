package com.example.loginapp.dao;

import com.example.loginapp.model.Usuario;

public class UsuarioDao extends ConnectFileXML {
    public boolean guardar(Usuario u) {
        return false;
    }

    public Usuario consultar(String email) {
        return null;
    }
}
