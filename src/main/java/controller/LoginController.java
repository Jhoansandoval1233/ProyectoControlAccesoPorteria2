package controller;


import model.DAO.UsuarioDAO;
import model.Usuario;
import utilities.Conexion;


public class LoginController {
    private final UsuarioDAO usuarioDAO;

    // Constructor que crea el DAO usando la conexión real
    public LoginController() {
        this.usuarioDAO = new UsuarioDAO(Conexion.getConnection());
    }

    // Constructor alternativo por si querés inyectar el DAO desde otro lugar
    public LoginController(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    // Método que valida directamente con la base de datos
    public boolean login(String correo, String password) {
        return usuarioDAO.validarCredenciales(correo, password);
    }
}