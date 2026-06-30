package com.riazasecure;

import com.riazasecure.enums.Rol;
import com.riazasecure.modelo.Usuario;
import com.riazasecure.servicios.UsuarioService;

public class App {

    public static void main(String[] args) {

        UsuarioService servicio = new UsuarioService();

        Usuario usuario1 = new Usuario(
                1,
                "Arturo",
                "Riaza",
                "12345678A",
                "arturo@gmail.com",
                "600123123",
                "1234",
                Rol.ADMINISTRADOR,
                true
        );

        Usuario usuario2 = new Usuario(
                2,
                "Juan",
                "Pérez",
                "87654321B",
                "juan@gmail.com",
                "611222333",
                "abcd",
                Rol.VIGILANTE,
                true
        );

        servicio.crearUsuario(usuario1);
        servicio.crearUsuario(usuario2);

        servicio.listarUsuarios();
    }
}
