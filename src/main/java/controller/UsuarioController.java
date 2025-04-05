/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;
import model.Usuario;
import model.DAO.UsuarioDAO;

public class UsuarioController {
    private final UsuarioService usuarioService;

    // Constructor
    public UsuarioController() {
        this.usuarioService = new UsuarioService();  // Inicializamos el servicio
    }

    // Método para insertar un usuario
    public void insertarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los detalles del nuevo usuario:");

        System.out.print("Id: ");
        String Id = scanner.nextLine();
        
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();
        
        // Crear el objeto Usuario
        Usuario nuevoUsuario = new Usuario(nombre, correo, contrasena);
        
        // Usar el servicio para insertar el usuario
        if (usuarioService.insertarUsuario(nuevoUsuario)) {
            System.out.println("Usuario insertado con éxito.");
        } else {
            System.out.println("Error al insertar el usuario.");
        }
    }

    // Método para consultar un usuario por su ID
    public void consultarUsuario() {
        
        System.out.print("Ingrese el ID del usuario a consultar: ");
        int id = scanner.nextInt();
        
        Usuario usuario = usuarioService.consultarUsuario(id);
        
        if (usuario != null) {
            System.out.println("Usuario encontrado: ");
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nombre: " + usuario.getNombres());
            System.out.println("Correo: " + usuario.getCorreo());
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // Método para actualizar los datos de un usuario
    public void actualizarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del usuario a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Nuevo correo: ");
        String correo = scanner.nextLine();
        
        System.out.print("Nueva contraseña: ");
        String contrasena = scanner.nextLine();
        
        // Crear el objeto Usuario con los nuevos datos
        Usuario usuarioActualizar = new Usuario(id, nombre, correo, contrasena);
        
        // Usar el servicio para actualizar el usuario
        if (usuarioService.actualizarUsuario(usuarioActualizar)) {
            System.out.println("Usuario actualizado con éxito.");
        } else {
            System.out.println("Error al actualizar el usuario.");
        }
    }

    // Método para eliminar un usuario por su ID
    public void eliminarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del usuario a eliminar: ");
        int id = scanner.nextInt();
        
        // Usar el servicio para eliminar el usuario
        if (usuarioService.eliminarUsuario(id)) {
            System.out.println("Usuario eliminado con éxito.");
        } else {
            System.out.println("Error al eliminar el usuario.");
        }
    }

    // Método para mostrar el menú de operaciones
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n------ Menú de Usuario ------");
            System.out.println("1. Insertar usuario");
            System.out.println("2. Consultar usuario");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    insertarUsuario();  // Llama al método para insertar un usuario
                    break;
                case 2:
                    consultarUsuario();  // Llama al método para consultar un usuario
                    break;
                case 3:
                    actualizarUsuario();  // Llama al método para actualizar un usuario
                    break;
                case 4:
                    eliminarUsuario();  // Llama al método para eliminar un usuario
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    return;  // Sale del menú
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }

    private static class UsuarioService {

        public UsuarioService() {
        }

        private boolean insertarUsuario(Usuario nuevoUsuario) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private boolean actualizarUsuario(Usuario usuarioActualizar) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private boolean eliminarUsuario(int id) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private Usuario consultarUsuario(int id) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    private static class scanner {

        private static int nextInt() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public scanner() {
        }
    }
}
