/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Usuario {
    private int id; 
    private String nombres;
    private String apellidos;
    private String correo;
    private String password;
    public int getid;

    public Usuario(int usuarioId) {
    }

    public Usuario(String nombres) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.id=id;
        this.correo = correo;
        this.password = password;
    }

    public Usuario(String usuario, int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public Usuario(int id, String nombre, String correo, String contrasena) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public Usuario(String nombre, String correo, String contrasena) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Usuario(int aInt, String string, String string0, String string1, String string2, String string3) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String getNombre() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getapellidos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getnombres() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getcorreo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

