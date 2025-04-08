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
    private final Connection connection;

    // Constructor principal
    public RegistroDAO(Connection connection) {
        this.connection = connection;
    }

    public RegistroDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Crear un nuevo registro
    public boolean insertarRegistro(Registro registro) {
        String sql = "INSERT INTO registros (id, persona_id, usuario_id, fecha_hora, observaciones, tipo_registro, elemento_id, vehiculo_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, registro.getId());
            stmt.setInt(2, registro.getPersona().getId());
            stmt.setInt(3, registro.getUsuario().getId());
            stmt.setTimestamp(4, Timestamp.valueOf(registro.getFechaHora()));
            stmt.setString(5, registro.getObservaciones());
            stmt.setString(6, registro.getTipoRegistro().name());

            if (registro.getElemento() != null) {
                stmt.setInt(7, registro.getElemento().getId());
            } else {
                stmt.setNull(7, Types.INTEGER);
            }

            if (registro.getVehiculo() != null) {
                stmt.setInt(8, registro.getVehiculo().getId());
            } else {
                stmt.setNull(8, Types.INTEGER);
            }

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todos los registros
    public List<Registro> obtenerRegistros() throws SQLException {
        List<Registro> registros = new ArrayList<>();
        String sql = "SELECT * FROM registros";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
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

    // Obtener un registro por ID
    public Registro obtenerRegistroPorId(int id) {
        String sql = "SELECT * FROM registros WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Registro(
                    rs.getInt("id"),
                    obtenerPersona(rs.getInt("persona_id")),
                    obtenerUsuario(rs.getInt("usuario_id")),
                    rs.getTimestamp("fecha_hora").toLocalDateTime(),
                    rs.getString("observaciones"),
                    convertirTipoAccion(rs.getString("tipo_registro")),
                    obtenerElemento(rs.getInt("elemento_id")),
                    obtenerVehiculo(rs.getInt("vehiculo_id"))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Actualizar un registro
    public boolean actualizarRegistro(Registro registro) {
        String sql = "UPDATE registros SET observaciones = ?, tipo_registro = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, registro.getObservaciones());
            stmt.setString(2, registro.getTipoRegistro().name());
            stmt.setInt(3, registro.getId());
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar un registro
    public boolean eliminarRegistro(int id) {
        String sql = "DELETE FROM registros WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // --- Métodos auxiliares para obtener objetos relacionados ---
    private Persona obtenerPersona(int id) {
        return new Persona("Nombre", "12345678", id); // Temporal. Reemplazar con consulta real si es necesario.
    }

    private Usuario obtenerUsuario(int id) {
        return new Usuario("usuario@example.com", id); // Temporal. Reemplazar con consulta real si es necesario.
    }

    private Elemento obtenerElemento(int id) {
        return new Elemento("Laptop"); // Temporal. Reemplazar con consulta real si es necesario.
    }

    private Vehiculo obtenerVehiculo(int id) {
        return new Vehiculo("Moto", "ABC123", id); // Temporal. Reemplazar con consulta real si es necesario.
    }

    private Registro.TipoAccion convertirTipoAccion(String tipo) {
        if (tipo.equalsIgnoreCase("ENTRADA")) {
            return Registro.TipoAccion.ENTRADA;
        } else if (tipo.equalsIgnoreCase("SALIDA")) {
            return Registro.TipoAccion.SALIDA;
        } else {
            throw new IllegalArgumentException("Tipo de acción desconocido: " + tipo);
        }
    }

    public boolean guardarRegistro(Registro nuevoRegistro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}