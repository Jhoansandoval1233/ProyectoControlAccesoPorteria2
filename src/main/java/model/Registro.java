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
    public Registro(int id, Persona persona, Usuario usuario, LocalDateTime fechaHora, String observaciones, TipoAccion tipoRegistro, Elemento elemento, Vehiculo vehiculo) {
        this.id = id;
        this.persona = persona;
        this.usuario = usuario;
        this.fechaHora = fechaHora;
        this.observaciones = observaciones;
        this.tipoRegistro = tipoRegistro;
        this.elemento = elemento;
        this.vehiculo = vehiculo;
    }
 // Constructor para casos de texto (por ejemplo, cuando necesitas insertar desde una interfaz de usuario)
    public Registro(String string, String string0, String string1, String pedro_Perez, String aprendiz, String sn) {
        CharSequence fecha = null;
                // Aquí deberías hacer la conversión de los valores string a los tipos correspondientes (por ejemplo, LocalDateTime)
        this.fechaHora = LocalDateTime.parse(fecha);  // Suponiendo que el formato es "yyyy-MM-dd'T'HH:mm:ss"
        this.persona = new Persona(persona, "12345678", id);  // O como corresponda para crear la persona
        this.usuario = new Usuario("user_example");  // Similarmente, crea el usuario
        this.observaciones = observaciones;
        Object entrada = null;
        this.tipoRegistro = (entrada != null) ? TipoAccion.ENTRADA : TipoAccion.SALIDA;
        this.elemento = null;  // Podrías agregar lógica si también se registra un elemento
        this.vehiculo = null;  // Similarmente, añade lógica para el vehículo
    }

     public Registro(int id, Persona persona, Usuario usuario, LocalDateTime fechaHora, 
       String observaciones, String tipoRegistro, Elemento elemento, Vehiculo vehiculo) {
       this.id = id;
       this.persona = persona;
       this.usuario = usuario;
       this.fechaHora = fechaHora;
       this.observaciones = observaciones;
       //this.tipoRegistro = tipoRegistro;
       this.elemento = elemento;
       this.vehiculo = vehiculo;
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
               ", elemento=" + (elemento != null ? elemento.getTipo() : "N/A") +
               ", vehiculo=" + (vehiculo != null ? vehiculo.getTipo() + " " + vehiculo.getPlaca() : "N/A") +
               '}';
    }

     // Métodos para la tabla de consulta, devuelven los datos que necesitas mostrar
    public Object getFecha() {
        return this.fechaHora.toLocalDate(); // Devuelve solo la fecha
    }

    public Object getEntrada() {
        return this.tipoRegistro == TipoAccion.ENTRADA ? this.fechaHora.toLocalTime() : null;  // Solo si es entrada
    }

    public Object getSalida() {
        return this.tipoRegistro == TipoAccion.SALIDA ? this.fechaHora.toLocalTime() : null;  // Solo si es salida
    }

    public Object getCargo() {
        return this.persona != null ? this.persona.getCargo() : "N/A";  // Devuelve el cargo de la persona
    }

    void setTipoRegistro(String nuevoTipo) {
        if (nuevoTipo == null || nuevoTipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de registro no puede ser vacío");
        }
        try {
            this.tipoRegistro = TipoAccion.valueOf(nuevoTipo.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de registro desconocido: " + nuevoTipo, e);
        }
    }

    public Object getHoraEntrada() {
        if (this.tipoRegistro == TipoAccion.ENTRADA && this.fechaHora != null) {
            return this.fechaHora.toLocalTime();
        }
        return null;
    }

    public Object getHoraSalida() {
        if (this.tipoRegistro == TipoAccion.SALIDA && this.fechaHora != null) {
            return this.fechaHora.toLocalTime();
        }
        return null;
    }

    // Enum 
    public enum TipoAccion {
        ENTRADA,
        SALIDA
    }
}