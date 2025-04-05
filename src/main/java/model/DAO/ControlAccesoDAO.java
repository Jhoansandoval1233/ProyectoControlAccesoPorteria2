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
import model.ControlAcceso;
import utilities.Conexion;

/**
 *
 * @author sando
 */
public class ControlAccesoDAO {

    private Connection conn;

    public ControlAccesoDAO() {
        conn = Conexion.getConnection();
    }

    public boolean registrarAcceso(ControlAcceso acceso) {
        String sql = "INSERT INTO control_acceso (id_persona, fecha_hora, tipo_acceso) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, acceso.getIdPersona());
            stmt.setTimestamp(2, acceso.getFechaHora());
            stmt.setString(3, acceso.getTipoAcceso());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ControlAcceso> obtenerTodosLosAccesos() {
        List<ControlAcceso> accesos = new ArrayList<>();
        String sql = "SELECT * FROM control_acceso";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ControlAcceso acceso = new ControlAcceso(
                    rs.getInt("id"),
                    rs.getInt("id_persona"),
                    rs.getTimestamp("fecha_hora"),
                    rs.getString("tipo_acceso")
                );
                accesos.add(acceso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accesos;
    }

    public ControlAcceso obtenerAccesoPorId(int id) {
        String sql = "SELECT * FROM control_acceso WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ControlAcceso(
                    rs.getInt("id"),
                    rs.getInt("id_persona"),
                    rs.getTimestamp("fecha_hora"),
                    rs.getString("tipo_acceso")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean eliminarAcceso(int id) {
        String sql = "DELETE FROM control_acceso WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
