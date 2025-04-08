
import java.sql.SQLException;
import model.DAO.ElementoDAO;
import model.Elemento;
import utilities.Conexion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class ElementoController {
    private final ElementoDAO elementoDAO;

    public ElementoController() {
        this.elementoDAO = new ElementoDAO(Conexion.getConnection());
    }

    // Método para agregar un nuevo elemento
    public void agregarElemento(String tipo, String serial, int id) {
        Elemento elemento = new Elemento(tipo);
        try {
            elementoDAO.create(elemento);
            System.out.println("Elemento agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar el elemento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para obtener un elemento por ID
    public Elemento obtenerElementoPorId(int id) {
        return elementoDAO.obtenerElementoPorId(id);
    }

    // Método para actualizar un elemento
    public void actualizarElemento(String tipo, String serial, int id) {
        Elemento elemento = new Elemento(tipo);
        try {
            elementoDAO.update(elemento);
            System.out.println("Elemento actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el elemento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para eliminar un elemento por ID
    public void eliminarElemento(int id) throws SQLException {
        elementoDAO.delete(id);
        System.out.println("Elemento eliminado correctamente.");
    }
}