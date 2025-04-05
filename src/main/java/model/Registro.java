/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author sando
 */
public class Registro {
    private int id;
    private Persona persona;
    private Usuario usuario;
    private LocalDateTime fechaHora;
    private String observaciones;
    private TipoAccion tipoRegistro;  // Usamos el enum TipoAccion
    private Elemento elemento;
    private Vehiculo vehiculo;

    // Constructor
    public Registro(int id, Persona persona, Usuario usuario, LocalDateTime fechaHora, 
                    String observaciones, TipoAccion tipoRegistro, Elemento elemento, Vehiculo vehiculo) {
        this.id = id;
        this.persona = persona;
        this.usuario = usuario;
        this.fechaHora = fechaHora;
        this.observaciones = observaciones;
        this.tipoRegistro = tipoRegistro;
        this.elemento = elemento;
        this.vehiculo = vehiculo;
    }

    Registro(int id, Persona persona, Usuario usuario, LocalDateTime fechaHora, String observaciones, String tipoRegistro, Elemento elemento, Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public TipoAccion getTipoRegistro() {
        return tipoRegistro;
    }
    public void setTipoRegistro(TipoAccion tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
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

    // Métodos adicionales
    public boolean actualizarObservaciones(String nuevaObservacion) {
        if (nuevaObservacion != null && !nuevaObservacion.isEmpty()) {
            this.observaciones = nuevaObservacion;
            return true;
        }
        return false;
    }

    public boolean actualizarTipoRegistro(TipoAccion nuevoTipo) {
        if (nuevoTipo == TipoAccion.ENTRADA || nuevoTipo == TipoAccion.SALIDA) {
            this.tipoRegistro = nuevoTipo;
            return true;
        }
        return false;
    }

    public void eliminarRegistro() {
        this.persona = null;
        this.usuario = null;
        this.fechaHora = null;
        this.observaciones = null;
        this.tipoRegistro = null;
        this.elemento = null;
        this.vehiculo = null;
    }

    @Override
    public String toString() {
        return "Registro{" +
               "id=" + id +
               ", persona=" + persona.getNombreCompleto() +
               ", usuario=" + usuario.getNombre() +
               ", fechaHora=" + fechaHora +
               ", observaciones='" + observaciones + '\'' +
               ", tipoRegistro=" + tipoRegistro +  // Mostramos el tipo de acción (ENTRADA o SALIDA)
               ", elemento=" + (elemento != null ? elemento.getNombre() : "N/A") +
               ", vehiculo=" + (vehiculo != null ? vehiculo.getMarca() + " " + vehiculo.getModelo() : "N/A") +
               '}';
    }

    void setTipoRegistro(String nuevoTipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Enum 
    public enum TipoAccion {
        ENTRADA,
        SALIDA
    }
}