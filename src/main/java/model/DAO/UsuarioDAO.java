/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import utilities.Conexion;


public class UsuarioDAO {
  private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    // Método para registrar un nuevo usuario
    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombres, apellidos, id, correo, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getnombres());
            stmt.setString(2, usuario.getapellidos());
            stmt.setInt(3, usuario.getid);
            stmt.setString(4, usuario.getcorreo());
            stmt.setString(5, usuario.getPassword()); // Se recomienda hashear antes
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            return false;
        }
    }
    
    
        public boolean validarCredenciales(String correo, String contrasena) {
                // Credenciales de prueba
    if ("admin@sena.com".equals(correo) && "123".equals(contrasena)) {
        return true; // Credenciales temporales válidas
    }
        String sql = "SELECT * FROM acceso_porteria.usuario WHERE correo = ? AND contraseña = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, correo);
            stmt.setString(2, contrasena);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Si encuentra un resultado, las credenciales son correctas
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Obtener un usuario por ID
    public Usuario obtenerUsuario(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("id"),
                        rs.getString("correo"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
        }
        return null; // Si no se encuentra el usuario
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                usuarios.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("id"),
                        rs.getString("correo"),
                        rs.getString("password")
                ));
            }
        } catch (SQLException e) {
        }
        return usuarios;
    }

    // Actualizar un usuario existente
    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombres = ?, apellidos = ?, identificacion = ?, correo = ?, password = ? WHERE id = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombres());
            stmt.setString(2, usuario.getApellidos());
            stmt.setInt(3, usuario.getid());
            stmt.setString(4, usuario.getCorreo());
            stmt.setString(5, usuario.getPassword());
            stmt.setInt(6, usuario.getId());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    // Eliminar un usuario por ID
    public boolean eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    Usuario obtenerUsuarioPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
