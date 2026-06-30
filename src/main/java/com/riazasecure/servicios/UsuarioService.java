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
}