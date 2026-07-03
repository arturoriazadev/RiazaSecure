package com.riazasecure.servicios;

import java.util.ArrayList;

import com.riazasecure.modelo.Usuario;

import com.riazasecure.dao.UsuarioDAO;

public class UsuarioService {

    private ArrayList<Usuario> usuarios;
    private UsuarioDAO usuarioDAO;

    public UsuarioService() {
        usuarios = new ArrayList<>();
        usuarioDAO = new UsuarioDAO();
    }

    public void crearUsuario(Usuario usuario) {
        usuarios.add(usuario);
        usuarioDAO.insertarUsuario(usuario);
    }

   public void listarUsuarios() {

    for (Usuario usuario : usuarioDAO.listarUsuarios()) {
        System.out.println(usuario);
    }

}

    public int getNumeroUsuarios() {
        return usuarios.size();
    }

    public Usuario buscarPorDni(String dni) {
    return usuarioDAO.buscarPorDni(dni);
}

    public boolean eliminarUsuario(String dni) {
    return usuarioDAO.eliminarUsuario(dni);
}
    public boolean actualizarUsuario(String dni, Usuario usuarioActualizado) {
    return usuarioDAO.actualizarUsuario(dni, usuarioActualizado);
}
    }
