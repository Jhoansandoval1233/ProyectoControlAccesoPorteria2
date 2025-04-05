/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

/**
 *
 * @author sando
 */

import model.Registro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Elemento;
import model.Persona;
import model.Usuario;
import model.Vehiculo;

public class RegistroDAO {

    private Connection connection;

    // Constructor que inicializa la conexión
    public RegistroDAO(Connection connection) {
        this.connection = connection;
    }

    // Crear un nuevo registro
    public void crearRegistro(Registro registro) throws SQLException {
        String sql = "INSERT INTO registros (id, persona_id, usuario_id, fecha_hora, observaciones, tipo_registro, elemento_id, vehiculo_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, registro.getId());
            stmt.setInt(2, registro.getPersona().getId());
            stmt.setInt(3, registro.getUsuario().getId());
            stmt.setTimestamp(4, Timestamp.valueOf(registro.getFechaHora()));
            stmt.setString(5, registro.getObservaciones());
               stmt.setString(6, registro.getTipoRegistro().name()); 
            // Verificación si el Elemento es nulo antes de insertarlo
            if (registro.getElemento() != null) {
                stmt.setInt(7, registro.getElemento().getId());
            } else {
                stmt.setNull(7, Types.INTEGER);  // Si es null, asigna un valor nulo
            }
            // Verificación si el Vehículo es nulo antes de insertarlo
            if (registro.getVehiculo() != null) {
                stmt.setInt(8, registro.getVehiculo().getId());
            } else {
                stmt.setNull(8, Types.INTEGER);  // Si es null, asigna un valor nulo
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime el error
            throw e;  // Propaga la excepción
        }
    }

    // Obtener todos los registros
    public List<Registro> obtenerRegistros() throws SQLException {
        List<Registro> registros = new ArrayList<>();
        String sql = "SELECT * FROM registros";
        
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // Aquí mapeamos el ResultSet a objetos Registro
                Registro registro = new Registro(
                    rs.getInt("id"),
                    obtenerPersona(rs.getInt("persona_id")),
                    obtenerUsuario(rs.getInt("usuario_id")),
                    rs.getTimestamp("fecha_hora").toLocalDateTime(),
                    rs.getString("observaciones"),
                    convertirTipoAccion(rs.getString("tipo_registro")), 
                    obtenerElemento(rs.getInt("elemento_id")),
                    obtenerVehiculo(rs.getInt("vehiculo_id"))
                );
                registros.add(registro);
            }
        }
        return registros;
    }

    // Actualizar un registro
    public void actualizarRegistro(Registro registro) throws SQLException {
        String sql = "UPDATE registros SET observaciones = ?, tipo_registro = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, registro.getObservaciones());
            stmt.setString(2, registro.getTipoRegistro().name());
            stmt.setInt(3, registro.getId());
            stmt.executeUpdate();
        }
    }

    // Eliminar un registro
    public void eliminarRegistro(int id) throws SQLException {
        String sql = "DELETE FROM registros WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Métodos auxiliares para obtener los objetos relacionados (Persona, Usuario, Elemento, Vehiculo)
    private Persona obtenerPersona(int id) throws SQLException {
        // Implementar método para obtener una Persona a partir de su id
        // Aquí deberías hacer la consulta correspondiente a la base de datos para obtener la persona
        return new Persona("Nombre Ejemplo", "DNI", id); // Solo como ejemplo
    }

    private Usuario obtenerUsuario(int id) throws SQLException {
        return new Usuario("Usuario Ejemplo", id); // Solo como ejemplo
    }

    private Elemento obtenerElemento(int id) throws SQLException {
        return new Elemento("Elemento Ejemplo"); // Solo como ejemplo
    }

    private Vehiculo obtenerVehiculo(int id) throws SQLException {
        return new Vehiculo("Marca Ejemplo", "Modelo Ejemplo", "ABC123"); // Solo como ejemplo
    }

    private Registro.TipoAccion convertirTipoAccion(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean insertarRegistro(Registro nuevoRegistro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Registro obtenerRegistroPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}