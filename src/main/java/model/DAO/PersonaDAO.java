/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Elemento;
import model.Persona;
import model.Vehiculo;
import utilities.Conexion;

public class PersonaDAO {
    private final Conexion conexion;

    // Constructor para inicializar la conexión
    public PersonaDAO(Conexion conexion ) {
        this.conexion = conexion;
    }

    // 1. Agregar una persona
    public void agregarPersona(Persona persona) {
        String query = "INSERT INTO persona (nombre_completo, tipo_id, id, elemento, vehiculo) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            
            // Establecer los parámetros en la consulta
            statement.setString(1, persona.getNombreCompleto());
            statement.setString(2, persona.getTipoId());
            statement.setInt(3, persona.getId());
            statement.setString(4, persona.getElemento().toString()); // Convertir elemento a String
            statement.setString(5, persona.getVehiculo().toString()); // Convertir vehiculo a String

            // Ejecutar la actualización
            statement.executeUpdate();
            System.out.println("Persona agregada: " + persona.getNombreCompleto());
        } catch (SQLException e) {
        }
    }

    // 2. Obtener una persona por su ID
    public Persona obtenerPersonaPorId(int id) {
        String query = "SELECT * FROM persona WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Crear un objeto Persona con los datos obtenidos de la base de datos
                    String nombreCompleto = resultSet.getString("nombre_completo");
                    String tipoId = resultSet.getString("tipo_id");
                    int personaId = resultSet.getInt("id");
                    String elementoString = resultSet.getString("elemento");
                    String vehiculoString = resultSet.getString("vehiculo");
                    
                    // Suponemos que el tipo Elemento y Vehiculo tienen constructores adecuados
                    Elemento elemento = new Elemento(elementoString); 
                    Vehiculo vehiculo = new Vehiculo(vehiculoString);
                    
                    return new Persona(personaId);
                }
            }
        } catch (SQLException e) {
        }
        return null; // Retorna null si no se encuentra la persona
    }

    // 3. Obtener todas las personas registradas
    public List<Persona> obtenerTodasLasPersonas() {
        String query = "SELECT * FROM persona";
        List<Persona> personas = new ArrayList<>();

        try (PreparedStatement statement = conexion.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                // Extraer datos de la fila y crear el objeto Persona
                String nombreCompleto = resultSet.getString("nombre_completo");
                String tipoId = resultSet.getString("tipo_id");
                int personaId = resultSet.getInt("id");
                String elementoString = resultSet.getString("elemento");
                String vehiculoString = resultSet.getString("vehiculo");

                Elemento elemento = new Elemento(elementoString); 
                Vehiculo vehiculo = new Vehiculo(vehiculoString);

                personas.add(new Persona(personaId));
            }
        } catch (SQLException e) {
        }
        return personas;
    }

    // 4. Actualizar los datos de una persona
    public void actualizarPersona(Persona persona) {
        String query = "UPDATE persona SET nombre_completo = ?, tipo_id = ?, elemento = ?, vehiculo = ? WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, persona.getNombreCompleto());
            statement.setString(2, persona.getTipoId());
            statement.setString(3, persona.getElemento().toString());
            statement.setString(4, persona.getVehiculo().toString());
            statement.setInt(5, persona.getId());

            // Ejecutar la actualización
            statement.executeUpdate();
            System.out.println("Persona actualizada: " + persona.getNombreCompleto());
        } catch (SQLException e) {
        }
    }

    // 5. Eliminar una persona por su ID
    public void eliminarPersonaPorId(int id) {
        String query = "DELETE FROM persona WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);

            // Ejecutar la eliminación
            statement.executeUpdate();
            System.out.println("Persona eliminada con ID: " + id);
        } catch (SQLException e) {
        }
    }
}