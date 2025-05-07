package com.example.loginapp.dao;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.loginapp.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsuarioDao {
    private List<Usuario> usuarios;
    private SharedPreferences sp;
    private final String PREF_NAME = "AppLoginApp";
    private final String KEY_DATA = "usuarios_data";

    public UsuarioDao(Context c) {
        usuarios = new ArrayList<>();
        sp = c.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        this.cargarUsuariosToList();
    }

    private void cargarUsuariosToList() {
        usuarios.clear();
        String data = sp.getString(KEY_DATA, "");
        if (!data.isEmpty()) {
            String[] registros = data.split(";");
            for (String reg : registros) {
                String[] campos = reg.split(",");
                Usuario usuario = new Usuario(campos[0], campos[1], campos[2]);
                usuarios.add(usuario);
            }
        }
        System.out.println(usuarios);
    }

    public void guardarUsuariosToSP() {
        SharedPreferences.Editor edt = sp.edit();
        StringBuilder sb = new StringBuilder();
        for (Usuario u : usuarios) {
            sb.append(u.getEmail()).append(",");
            sb.append(u.getNombreCompleto()).append(",");
            sb.append(u.getPassword()).append(";");
        }
        edt.putString(KEY_DATA, sb.toString());
        edt.commit();
    }

    public boolean add(Usuario u) {
        usuarios.add(u);
        this.guardarUsuariosToSP();
        return true;
    }

    public boolean modify(Usuario u) {
        int i = this.getIndex(u.getEmail());
        usuarios.set(i, u);
        this.guardarUsuariosToSP();
        return true;
    }

    private int getIndex(String e) {
        int i = -1;
        for (Usuario usuario : usuarios) {
            i++;
            if (e.equals(usuario.getEmail())) {
                return i;
            }
        }
        return -1;
    }

    public Usuario findBy(String e) {
        for (Usuario u : usuarios) {
            if (e.equals(u.getEmail())) {
                return u;
            }
        }
        return null;
    }

    public Usuario findByIndex(int i) {
        return usuarios.get(i);
    }

    public boolean removeBy(String e) {
        for (Usuario u : usuarios) {
            if (e.equals(u.getEmail())) {
                usuarios.remove(usuarios);
                return true;
            }
        }
        this.guardarUsuariosToSP();
        return false;
    }

    public Usuario removeByIndex(int i) {
        return usuarios.remove(i);
    }

    public boolean exist(String e) {
        for (Usuario u : usuarios) {
            if (e.equals(u.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList<>();
        return usuarios;
    }
}
