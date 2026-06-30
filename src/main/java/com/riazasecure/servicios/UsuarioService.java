package com.riazasecure.servicios;

import java.util.ArrayList;

import com.riazasecure.modelo.Usuario;

public class UsuarioService {

    private ArrayList<Usuario> usuarios;

    public UsuarioService() {
        usuarios = new ArrayList<>();
    }

    public void crearUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public int getNumeroUsuarios() {
        return usuarios.size();
    }

    public Usuario buscarPorDni(String dni) {

        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni)) {
                return usuario;
            }
        }

        return null;
    }

    public boolean eliminarUsuario(String dni) {

        Usuario usuario = buscarPorDni(dni);

        if (usuario != null) {
            usuarios.remove(usuario);
            return true;
        }

        return false;
    }

    public boolean actualizarUsuario(String dni, Usuario usuarioActualizado) {

        Usuario usuario = buscarPorDni(dni);

        if (usuario != null) {
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setApellidos(usuarioActualizado.getApellidos());
            usuario.setEmail(usuarioActualizado.getEmail());
            usuario.setTelefono(usuarioActualizado.getTelefono());
            usuario.setPassword(usuarioActualizado.getPassword());
            usuario.setRol(usuarioActualizado.getRol());
            usuario.setActivo(usuarioActualizado.isActivo());

            return true;
        }

        return false;
    }
}