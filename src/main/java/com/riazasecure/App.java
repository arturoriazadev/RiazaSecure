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

        // Crear usuarios
        servicio.crearUsuario(usuario1);
        servicio.crearUsuario(usuario2);

        // Listar usuarios
        servicio.listarUsuarios();

        // Buscar usuario por DNI
        Usuario encontrado = servicio.buscarPorDni("12345678A");

        if (encontrado != null) {
            System.out.println("\nUsuario encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println("\nNo existe ese usuario.");
        }

        // Actualizar usuario
        System.out.println("\nActualizando usuario...");

        Usuario usuarioActualizado = new Usuario(
                1,
                "Arturo",
                "Riaza García",
                "12345678A",
                "arturo@riazasecure.com",
                "699999999",
                "nuevaPassword",
                Rol.SUPERVISOR,
                true
        );

        boolean actualizado = servicio.actualizarUsuario("12345678A", usuarioActualizado);

        if (actualizado) {
            System.out.println("Usuario actualizado correctamente.");
        } else {
            System.out.println("No se encontró el usuario.");
        }

        System.out.println("\nLista tras actualizar:");
        servicio.listarUsuarios();

        // Eliminar usuario
        System.out.println("\nEliminando usuario...");

        boolean eliminado = servicio.eliminarUsuario("87654321B");

        if (eliminado) {
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("No existe ese usuario.");
        }

        // Mostrar lista final
        System.out.println("\nLista actualizada:");

        servicio.listarUsuarios();
    }
}