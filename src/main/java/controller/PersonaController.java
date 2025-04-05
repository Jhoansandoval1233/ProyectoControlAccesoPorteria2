/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.DAO.PersonaDAO;
import model.Elemento;
import model.Persona;
import model.Vehiculo;
import utilities.Conexion;

/**
 *
 * @author sando
 */

public class PersonaController {
    private PersonaDAO personaDAO;

    public PersonaController(Conexion conexion) {
        this.personaDAO = new PersonaDAO(conexion);
    }

    // Método para agregar una persona
    public void agregarPersona(String nombreCompleto, String tipoId, int id) {
        Persona persona = new Persona(id, nombreCompleto, tipoId);
        personaDAO.agregarPersona(persona);
    }

    // Método para obtener una persona por ID
    public Persona obtenerPersonaPorId(int id) {
        return personaDAO.obtenerPersonaPorId(id);
    }

    // Método para obtener todas las personas
    public List<Persona> obtenerTodasLasPersonas() {
        return personaDAO.obtenerTodasLasPersonas();
    }

    // Método para actualizar una persona
    public void actualizarPersona(int id, String nuevoNombre, String nuevoTipoId, Elemento nuevoElemento, Vehiculo nuevoVehiculo) {
        Persona persona = new Persona(id, nuevoNombre, nuevoTipoId);
        persona.setElemento(nuevoElemento);
        persona.setVehiculo(nuevoVehiculo);
        personaDAO.actualizarPersona(persona);
    }

    // Método para eliminar una persona por ID
    public void eliminarPersona(int id) {
        personaDAO.eliminarPersonaPorId(id);
    }
}
