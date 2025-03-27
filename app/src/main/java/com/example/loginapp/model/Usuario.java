package com.example.loginapp.model;

public class Usuario {
    private String email;
    private String nombreCompleto;
    private String password;

    public Usuario() {
        this.email = "";
        this.nombreCompleto = "";
        this.password = "";
    }

    public Usuario(String email, String nombreCompleto, String password) {
        this.email = email;
        this.nombreCompleto = nombreCompleto;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario = {" +
                "email = '" + email + '\'' +
                ", nombreCompleto = '" + nombreCompleto + '\'' +
                ", password = '" + password + '\'' +
                '}';
    }
}
