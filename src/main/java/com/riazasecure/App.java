package com.riazasecure;

import java.util.Scanner;

import com.riazasecure.enums.Rol;
import com.riazasecure.modelo.Incidencia;
import com.riazasecure.servicios.IncidenciaService;
import com.riazasecure.modelo.Usuario;
import com.riazasecure.servicios.UsuarioService;
import com.riazasecure.ui.Menu;

public class App {

    public static void main(String[] args) {

        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        UsuarioService servicio = new UsuarioService();
        IncidenciaService incidenciaService = new IncidenciaService();
        int opcion;

        do {

            opcion = menu.mostrarMenuPrincipal();

            switch (opcion) {

                // ===========================
                // GESTIÓN DE USUARIOS
                // ===========================
                case 1:

                    int opcionUsuarios;

                    do {

                        opcionUsuarios = menu.mostrarMenuUsuarios();

                        switch (opcionUsuarios) {

                            // Crear usuario
                            case 1:

                                scanner.nextLine();

                                System.out.print("Nombre: ");
                                String nombre = scanner.nextLine();

                                System.out.print("Apellidos: ");
                                String apellidos = scanner.nextLine();

                                System.out.print("DNI: ");
                                String dni = scanner.nextLine();

                                System.out.print("Email: ");
                                String email = scanner.nextLine();

                                System.out.print("Teléfono: ");
                                String telefono = scanner.nextLine();

                                System.out.print("Contraseña: ");
                                String password = scanner.nextLine();

                                Usuario usuario = new Usuario(
                                        servicio.getNumeroUsuarios() + 1,
                                        nombre,
                                        apellidos,
                                        dni,
                                        email,
                                        telefono,
                                        password,
                                        Rol.USUARIO,
                                        true);

                                servicio.crearUsuario(usuario);

                                System.out.println();
                                System.out.println("=========================================");
                                System.out.println("      USUARIO CREADO CORRECTAMENTE");
                                System.out.println("=========================================");
                                System.out.println("Nombre    : " + usuario.getNombre());
                                System.out.println("Apellidos : " + usuario.getApellidos());
                                System.out.println("DNI       : " + usuario.getDni());
                                System.out.println("Email     : " + usuario.getEmail());
                                System.out.println("=========================================");
                                break;

                            // Listar usuarios
                            case 2:

                                System.out.println();
                                System.out.println("=========================================");
                                System.out.println("         LISTA DE USUARIOS");
                                System.out.println("=========================================");

                                servicio.listarUsuarios();

                                System.out.println("=========================================");
                                break;

                            // Buscar usuario
                            case 3:

                                System.out.println();
                                System.out.println("========== BUSCAR INCIDENCIA ==========");

                                System.out.print("Introduce el ID: ");
                                long idBuscar = scanner.nextLong();

                                Incidencia incidenciaEncontrada = incidenciaService.buscarPorId(idBuscar);

                                if (incidenciaEncontrada != null) {

                                    System.out.println();
                                    System.out.println("======================================");
                                    System.out.println("      INCIDENCIA ENCONTRADA");
                                    System.out.println("======================================");
                                    System.out.println("ID          : " + incidenciaEncontrada.getId());
                                    System.out.println("Descripción : " + incidenciaEncontrada.getDescripcion());
                                    System.out.println("Fecha       : " + incidenciaEncontrada.getFecha());
                                    System.out.println("Estado      : " + incidenciaEncontrada.getEstado());
                                    System.out.println("======================================");

                                } else {

                                    System.out.println();
                                    System.out.println("❌ No existe ninguna incidencia con ese ID.");

                                }

                                break;

                            // Actualizar usuario
                            case 4:

                                System.out.println("\nActualizar usuario (próximamente)");
                                break;

                            // Eliminar usuario
                            case 5:

                                scanner.nextLine();

                                System.out.print("Introduce el DNI del usuario a eliminar: ");
                                String dniEliminar = scanner.nextLine();

                                if (servicio.eliminarUsuario(dniEliminar)) {
                                    System.out.println();
                                    System.out.println("=========================================");
                                    System.out.println("      USUARIO ELIMINADO");
                                    System.out.println("=========================================");
                                    System.out.println("DNI : " + dniEliminar);
                                    System.out.println("=========================================");
                                } else {
                                    System.out.println("\nNo existe ese usuario.");
                                }

                                break;

                            case 0:
                                System.out.println("Volviendo al menú principal...");
                                break;

                            default:
                                System.out.println("Opción incorrecta.");
                        }

                    } while (opcionUsuarios != 0);

                    break;

                // ===========================
                // GESTIÓN DE INCIDENCIAS
                // ===========================
                case 2:

                    int opcionIncidencias;

                    do {

                        opcionIncidencias = menu.mostrarMenuIncidencias();

                        switch (opcionIncidencias) {

                            case 1:

                                scanner.nextLine();

                                System.out.print("Descripción: ");
                                String descripcion = scanner.nextLine();

                                System.out.print("Fecha: ");
                                String fecha = scanner.nextLine();

                                System.out.print("Estado: ");
                                String estado = scanner.nextLine();

                                Incidencia incidencia = new Incidencia(
                                        incidenciaService.getNumeroIncidencias() + 1,
                                        descripcion,
                                        fecha,
                                        estado);

                                incidenciaService.crearIncidencia(incidencia);

                                System.out.println();
                                System.out.println("=========================================");
                                System.out.println("     INCIDENCIA CREADA CORRECTAMENTE");
                                System.out.println("=========================================");
                                System.out.println("ID          : " + incidencia.getId());
                                System.out.println("Descripción : " + incidencia.getDescripcion());
                                System.out.println("Fecha       : " + incidencia.getFecha());
                                System.out.println("Estado      : " + incidencia.getEstado());
                                System.out.println("=========================================");

                                break;

                            case 2:

                                System.out.println();
                                System.out.println("=========================================");
                                System.out.println("       LISTA DE INCIDENCIAS");
                                System.out.println("=========================================");

                                incidenciaService.listarIncidencias();

                                System.out.println("=========================================");

                                break;

                            case 3:

                                System.out.println();
                                System.out.println("========== BUSCAR INCIDENCIA ==========");

                                System.out.print("Introduce el ID: ");
                                long idBuscar = scanner.nextLong();

                                Incidencia encontrada = incidenciaService.buscarPorId(idBuscar);

                                if (encontrada != null) {

                                    System.out.println();
                                    System.out.println("=========================================");
                                    System.out.println("        INCIDENCIA ENCONTRADA");
                                    System.out.println("=========================================");
                                    System.out.println("ID          : " + encontrada.getId());
                                    System.out.println("Descripción : " + encontrada.getDescripcion());
                                    System.out.println("Fecha       : " + encontrada.getFecha());
                                    System.out.println("Estado      : " + encontrada.getEstado());
                                    System.out.println("=========================================");

                                } else {

                                    System.out.println();
                                    System.out.println("❌ No existe ninguna incidencia con ese ID.");

                                }

                                break;

                            case 4:

                                scanner.nextLine();

                                System.out.print("Introduce el DNI del usuario a actualizar: ");
                                String dniActualizar = scanner.nextLine();

                                Usuario usuarioExistente = servicio.buscarPorDni(dniActualizar);

                                if (usuarioExistente != null) {

                                    System.out.print("Nuevo nombre: ");
                                    String nuevoNombre = scanner.nextLine();

                                    System.out.print("Nuevos apellidos: ");
                                    String nuevosApellidos = scanner.nextLine();

                                    System.out.print("Nuevo email: ");
                                    String nuevoEmail = scanner.nextLine();

                                    System.out.print("Nuevo teléfono: ");
                                    String nuevoTelefono = scanner.nextLine();

                                    System.out.print("Nueva contraseña: ");
                                    String nuevaPassword = scanner.nextLine();

                                    Usuario usuarioActualizado = new Usuario(
                                            usuarioExistente.getId(),
                                            nuevoNombre,
                                            nuevosApellidos,
                                            usuarioExistente.getDni(),
                                            nuevoEmail,
                                            nuevoTelefono,
                                            nuevaPassword,
                                            usuarioExistente.getRol(),
                                            usuarioExistente.isActivo());

                                    servicio.actualizarUsuario(dniActualizar, usuarioActualizado);

                                    System.out.println();
                                    System.out.println("=========================================");
                                    System.out.println("     USUARIO ACTUALIZADO");
                                    System.out.println("=========================================");
                                    System.out.println("Nombre    : " + nuevoNombre);
                                    System.out.println("Apellidos : " + nuevosApellidos);
                                    System.out.println("Email     : " + nuevoEmail);
                                    System.out.println("Teléfono  : " + nuevoTelefono);
                                    System.out.println("=========================================");

                                } else {

                                    System.out.println("\nNo existe ese usuario.");

                                }

                                break;

                            case 5:
                                System.out.println("Eliminar incidencia");
                                break;

                            case 0:
                                System.out.println("Volviendo al menú principal...");
                                break;

                            default:
                                System.out.println("Opción incorrecta.");
                        }

                    } while (opcionIncidencias != 0);

                    break;

                // Salir
                case 0:
                    System.out.println("Hasta pronto.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}