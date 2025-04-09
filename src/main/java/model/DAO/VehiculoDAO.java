/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Vehiculo;

public class VehiculoDAO {
    private final Connection connection;

    // Constructor que inicializa la conexión
    public VehiculoDAO(Connection connection) {
        this.connection = connection;
    }

    public VehiculoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Crear un nuevo Vehículo
    public void create(Vehiculo vehiculo) throws SQLException {
        String query = "INSERT INTO vehiculo (tipo, placa) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, vehiculo.getTipo());
            stmt.setString(2, vehiculo.getPlaca());
            stmt.executeUpdate();
        }
    }

    // Leer un Vehículo a partir de la placa
    public Vehiculo read(String placa) throws SQLException {
        String query = "SELECT tipo, placa FROM vehiculo WHERE placa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, placa);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String tipo = rs.getString("tipo");
                    return new Vehiculo(tipo);
                } else {
                    return null;  // Si no se encuentra el vehículo, devuelve null
                }
            }
        }
    }

    // Actualizar un Vehículo
    public void update(Vehiculo vehiculo) throws SQLException {
        String query = "UPDATE vehiculo SET tipo = ? WHERE placa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, vehiculo.getTipo());
            stmt.setString(2, vehiculo.getPlaca());
            stmt.executeUpdate();
        }
    }

    // Eliminar un Vehículo
    public void delete(String placa) throws SQLException {
        String query = "DELETE FROM vehiculo WHERE placa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, placa);
            stmt.executeUpdate();
        }
    }

    public void guardarVehiculo(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}