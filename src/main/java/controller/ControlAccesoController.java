/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.ControlAcceso;
import model.DAO.ControlAccesoDAO;

/**
 *
 * @author sando
 */
public class ControlAccesoController {
    private final ControlAccesoDAO controlAccesoDAO;

    public ControlAccesoController() {
        this.controlAccesoDAO = new ControlAccesoDAO();
    }

    // Registrar un nuevo acceso
    public boolean registrarAcceso(ControlAcceso acceso) {
        return controlAccesoDAO.registrarAcceso(acceso);
    }

    // Obtener acceso por ID
    public ControlAcceso obtenerAccesoPorId(int id) {
        return controlAccesoDAO.obtenerAccesoPorId(id);
    }

    // Obtener todos los accesos
    public List<ControlAcceso> listarAccesos() {
        return controlAccesoDAO.obtenerTodosLosAccesos();
    }

    // Eliminar un acceso por ID
    public boolean eliminarAcceso(int id) {
        return controlAccesoDAO.eliminarAcceso(id);
    }
}
