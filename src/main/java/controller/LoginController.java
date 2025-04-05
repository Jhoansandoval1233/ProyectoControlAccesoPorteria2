package controller;


import model.Usuario;


public class LoginController {

    public boolean login(String correo, String password) {
        Usuario usuarioAlmacenado = obtenerUsuarioPorCorreo(correo);
        if (usuarioAlmacenado != null) {
            return usuarioAlmacenado.getPassword().equals(password);
        } else {
            return false; 
        }
    }

    private Usuario obtenerUsuarioPorCorreo(String correo) {
        if ("usuario@ejemplo.com".equals(correo)) {
         Usuario usuario = new Usuario("Juan", "Pérez", Integer.parseInt("12345678"), correo, "password123");
            return usuario;
        } else {
            return null; 
        }
    }

    public void registrarUsuario(String nombres, String apellidos, int id, String correo, String password) {
        Usuario nuevoUsuario = new Usuario(nombres, apellidos, id, correo, password);
   
        System.out.println("Usuario registrado: " + nuevoUsuario.getNombres() + " " + nuevoUsuario.getApellidos());
    }

    public boolean validarLogin(String usuario, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}