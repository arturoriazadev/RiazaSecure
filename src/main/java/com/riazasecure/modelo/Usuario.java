package com.riazasecure.modelo;

import com.riazasecure.enums.Rol;

public class Usuario {

    private long id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private String telefono;
    private String password;
    private Rol rol;
    private boolean activo;

    public Usuario() {
    }

    public Usuario(long id,
            String nombre,
            String apellidos,
            String dni,
            String email,
            String telefono,
            String password,
            Rol rol,
            boolean activo) {

        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
        this.rol = rol;
        this.activo = activo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", email="
                + email
                + ", telefono=" + telefono + ", password=" + password + ", rol=" + rol + ", activo=" + activo + "]";
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}