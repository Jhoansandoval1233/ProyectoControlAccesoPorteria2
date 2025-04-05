/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Elemento;

public class ElementoDAO {
    private final Connection connection;

    public ElementoDAO(Connection connection) {
        this.connection = connection;
    }

    // Crear un nuevo Elemento
    public void create(Elemento elemento) throws SQLException {
        String query = "INSERT INTO elementos (tipo, serial) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, elemento.getTipo());
            stmt.setString(2, elemento.getSerial());
            stmt.executeUpdate();
        }
    }

    // Leer un Elemento a partir de su serial
    public Elemento read(String serial) throws SQLException {
        String query = "SELECT tipo, serial FROM elementos WHERE serial = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, serial);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String tipo = rs.getString("tipo");
                    return new Elemento(tipo);
                } else {
                    return null;  // Si no se encuentra, devolver null
                }
            }
        }
    }

    // Actualizar un Elemento
    public void update(Elemento elemento) throws SQLException {
        String query = "UPDATE elementos SET tipo = ? WHERE serial = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, elemento.getTipo());
            stmt.setString(2, elemento.getSerial());
            stmt.executeUpdate();
        }
    }

    // Eliminar un Elemento
    public void delete(String serial) throws SQLException {
        String query = "DELETE FROM elementos WHERE serial = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, serial);
            stmt.executeUpdate();
        }
    }

    public Elemento obtenerElementoPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}