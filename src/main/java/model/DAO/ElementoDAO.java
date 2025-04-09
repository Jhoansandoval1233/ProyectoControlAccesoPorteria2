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
import utilities.Conexion;


public class ElementoDAO {
    private final Connection connection;

    public ElementoDAO(Connection connection) {
        this.connection = connection;
    }

    public ElementoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

      public boolean guardarElemento(Elemento elemento) {
        String sql = "INSERT INTO elementos (tipo, serial, persona_id) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, elemento.getTipo());
            stmt.setString(2, elemento.getSerial());
            stmt.setInt(3, elemento.getPersona().getId());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al guardar el elemento: " + e.getMessage());
            return false;
        }
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

    // Leer un Elemento por ID
    public Elemento obtenerElementoPorId(int id) {
        String query = "SELECT id, tipo, serial FROM elementos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Elemento(
                    rs.getString("tipo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Actualizar un Elemento
    public void update(Elemento elemento) throws SQLException {
        String query = "UPDATE elementos SET tipo = ?, serial = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, elemento.getTipo());
            stmt.setString(2, elemento.getSerial());
            stmt.setInt(3, elemento.getId());
            stmt.executeUpdate();
        }
    }

    // Eliminar un Elemento por ID
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM elementos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}