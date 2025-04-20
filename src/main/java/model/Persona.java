/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sando
 */
public class Persona {
    private String nombreCompleto;
    private String tipoId;
    private int id;
    private String cargo;
    private String telefono;
    private String correo;
    private Elemento elemento; 
    private Vehiculo vehiculo; 

    // Constructor principal
    public Persona(String nombreCompleto, String tipoId, int id, String cargo, String telefono, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.tipoId = tipoId;
        this.id = id;
        this.cargo = cargo;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Constructor simplificado con nombre y ID
    public Persona(String nombreCompleto, int id) {
        this.nombreCompleto = nombreCompleto;
        this.id = id;
    }

    // Constructor alternativo
    public Persona(String nombreCompleto, String tipoId, int id) {
        this.nombreCompleto = nombreCompleto;
        this.tipoId = tipoId;
        this.id = id;
    }

    // Constructor con orden diferente
    public Persona(int id, String nombreCompleto, String tipoId) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.tipoId = tipoId;
    }

    // Constructor que copia otra persona pero cambia nombre e id
    public Persona(Persona persona, String nuevoNombre, int nuevoId) {
        this.nombreCompleto = nuevoNombre;
        this.id = nuevoId;
        this.tipoId = persona.tipoId;
        this.cargo = persona.cargo;
        this.telefono = persona.telefono;
        this.correo = persona.correo;
        this.elemento = persona.elemento;
        this.vehiculo = persona.vehiculo;
    }

 
    public Persona(int id) {
    this.id = id;
}

    // Getters y Setters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}