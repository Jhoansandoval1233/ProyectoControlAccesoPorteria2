/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author sando
 */
import java.time.LocalDateTime;
import model.Persona;
import java.util.Scanner;
import model.DAO.RegistroDAO;
import model.Elemento;
import model.Registro;
import model.Usuario;
import model.Vehiculo;

public class RegistroController {
    private final RegistroDAO registroDAO;
    private final Scanner scanner;

    public RegistroController(RegistroDAO registroDAO) {
        this.registroDAO = registroDAO;
        this.scanner = new Scanner(System.in);
    }

    // Método para insertar un nuevo registro
    public void insertarRegistro() {
        System.out.println("Ingrese los datos del nuevo registro:");
        System.out.print("ID de la persona: ");
        int personaId = scanner.nextInt();

        System.out.print("ID del usuario: ");
        int usuarioId = scanner.nextInt();
        scanner.nextLine();  // Consumir salto de línea

        System.out.print("Observaciones: ");
        String observaciones = scanner.nextLine();

        System.out.print("Tipo de registro (ENTRADA/SALIDA): ");
        String tipo = scanner.nextLine().toUpperCase();

        System.out.print("ID del elemento (0 si no aplica): ");
        int elementoId = scanner.nextInt();

        System.out.print("ID del vehículo (0 si no aplica): ");
        int vehiculoId = scanner.nextInt();

        // Crear objetos base
        Persona persona = new Persona(personaId);
        Usuario usuario = new Usuario(usuarioId);

        // Crear elemento si aplica
        Elemento elemento = null;
        if (elementoId > 0) {
            elemento = new Elemento("Tipo", "Serial", "id");
            elemento.setId(elementoId);
        }

        // Crear vehículo si aplica
        Vehiculo vehiculo = null;
        if (vehiculoId > 0) {
            vehiculo = new Vehiculo("Tipo", "Placa", "id");
            vehiculo.setId(vehiculoId);
        }

        // Crear registro
        Registro nuevoRegistro = new Registro(
                0,
                persona,
                usuario,
                LocalDateTime.now(),
                observaciones,
                Registro.TipoAccion.valueOf(tipo),
                elemento,
                vehiculo
        );

        // Insertar en la base de datos
        if (registroDAO.insertarRegistro(nuevoRegistro)) {
            System.out.println("Registro insertado con éxito.");
        } else {
            System.out.println("Error al insertar el registro.");
        }
    }

    // Método para consultar un registro por ID
    public void consultarRegistro() {
        System.out.print("Ingrese el ID del registro a consultar: ");
        int id = scanner.nextInt();
        Registro registro = registroDAO.obtenerRegistroPorId(id);
        if (registro != null) {
            System.out.println("Registro encontrado: " + registro);
        } else {
            System.out.println("Registro no encontrado.");
        }
    }

    // Método para actualizar un registro
    public void actualizarRegistro() {
        System.out.print("Ingrese el ID del registro a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        Registro registro = registroDAO.obtenerRegistroPorId(id);
        if (registro == null) {
            System.out.println("Registro no encontrado.");
            return;
        }

        System.out.print("Nuevas observaciones: ");
        String observaciones = scanner.nextLine();

        System.out.print("Nuevo tipo de registro (ENTRADA/SALIDA): ");
        String tipo = scanner.nextLine().toUpperCase();

        registro.setObservaciones(observaciones);
        registro.setTipoRegistro(Registro.TipoAccion.valueOf(tipo));

        if (registroDAO.actualizarRegistro(registro)) {
            System.out.println("Registro actualizado con éxito.");
        } else {
            System.out.println("Error al actualizar el registro.");
        }
    }

    // Método para eliminar un registro
    public void eliminarRegistro() {
        System.out.print("Ingrese el ID del registro a eliminar: ");
        int id = scanner.nextInt();
        if (registroDAO.eliminarRegistro(id)) {
            System.out.println("Registro eliminado con éxito.");
        } else {
            System.out.println("Error al eliminar el registro.");
        }
    }

    // Menú de operaciones
    public void mostrarMenu() {
        while (true) {
            System.out.println("\n------ Menú de Registro ------");
            System.out.println("1. Insertar registro");
            System.out.println("2. Consultar registro");
            System.out.println("3. Actualizar registro");
            System.out.println("4. Eliminar registro");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> insertarRegistro();
                case 2 -> consultarRegistro();
                case 3 -> actualizarRegistro();
                case 4 -> eliminarRegistro();
                case 5 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}