package com.riazasecure.ui;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenuPrincipal() {

        System.out.println();
        System.out.println("========== RIAZASECURE ==========");
        System.out.println("1. Gestionar usuarios");
        System.out.println("2. Gestionar incidencias");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");

        return scanner.nextInt();
    }

    public int mostrarMenuUsuarios() {

        System.out.println();
        System.out.println("======= GESTIÓN DE USUARIOS =======");
        System.out.println("1. Crear usuario");
        System.out.println("2. Listar usuarios");
        System.out.println("3. Buscar usuario");
        System.out.println("4. Actualizar usuario");
        System.out.println("5. Eliminar usuario");
        System.out.println("0. Volver");
        System.out.print("Seleccione una opción: ");

        return scanner.nextInt();
    }

    public int mostrarMenuIncidencias() {

        System.out.println();
        System.out.println("======= GESTIÓN DE INCIDENCIAS =======");
        System.out.println("1. Crear incidencia");
        System.out.println("2. Listar incidencias");
        System.out.println("3. Buscar incidencia");
        System.out.println("4. Actualizar incidencia");
        System.out.println("5. Eliminar incidencia");
        System.out.println("0. Volver");
        System.out.print("Seleccione una opción: ");

        return scanner.nextInt();
    }
}