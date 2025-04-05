/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import model.DAO.VehiculoDAO;
import model.Vehiculo;

/**
 *
 * @author sando
 */
public class VehiculoController {
    private final VehiculoDAO vehiculoDAO;

    public VehiculoController(VehiculoDAO vehiculoDAO) {
        this.vehiculoDAO = vehiculoDAO;
    }

    // Registrar un nuevo vehículo
    public boolean registrarVehiculo(Vehiculo vehiculo) {
        try {
            vehiculoDAO.create(vehiculo);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    // Obtener un vehículo por placa
    public Vehiculo obtenerVehiculoPorPlaca(String placa) {
        try {
            return vehiculoDAO.read(placa);
        } catch (SQLException e) {
            return null;
        }
    }

    // Actualizar información de un vehículo
    public boolean actualizarVehiculo(Vehiculo vehiculo) {
        try {
            vehiculoDAO.update(vehiculo);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    // Eliminar un vehículo por placa
    public boolean eliminarVehiculo(String placa) throws SQLException {
        vehiculoDAO.delete(placa);
        return true;
    }
}
