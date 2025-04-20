/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sando
 */
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ControlAcceso {
    private final List<Registro> registros;
    private int idPersona;
    private Timestamp fechaHora;
    private String tipoAcceso;

    public ControlAcceso(int aInt, int aInt1, Timestamp timestamp, String string) {
        this.registros = new ArrayList<>();
    }

    // 1. Inserción: Registrar un nuevo acceso
    public void registrarAcceso(int id, Persona persona, Usuario usuario, LocalDateTime fechaHora, 
                                 String observaciones, String tipoRegistro, Elemento elemento, Vehiculo vehiculo) {
        if (!tipoRegistro.equals("entrada") && !tipoRegistro.equals("salida")) {
            throw new IllegalArgumentException("Tipo de registro inválido. Debe ser 'entrada' o 'salida'.");
        }
        Registro nuevoRegistro = new Registro(id, persona, usuario, fechaHora, observaciones, tipoRegistro, elemento, vehiculo);
        registros.add(nuevoRegistro);
    }

    // 2. Consulta: Obtener todos los registros
    public List<Registro> obtenerRegistros() {
        return registros;
    }

    // 3. Consulta: Obtener solo los registros de entrada
    public List<Registro> obtenerRegistrosEntrada() {
        List<Registro> entradas = new ArrayList<>();
        for (Registro registro : registros) {
            if (registro.getTipoRegistro().equals("entrada")) {
                entradas.add(registro);
            }
        }
        return entradas;
    }

    // 4. Consulta: Obtener solo los registros de salida
    public List<Registro> obtenerRegistrosSalida() {
        List<Registro> salidas = new ArrayList<>();
        for (Registro registro : registros) {
            if (registro.getTipoRegistro().equals("salida")) {
                salidas.add(registro);
            }
        }
        return salidas;
    }

    // 5. Actualización: Actualizar observaciones de un registro por ID
    public boolean actualizarObservaciones(int id, String nuevaObservacion) {
        // Buscar el registro por ID
        Optional<Registro> registroOpt = registros.stream()
                .filter(registro -> registro.getId() == id)
                .findFirst();

        if (registroOpt.isPresent()) {
            Registro registro = registroOpt.get();
            registro.setObservaciones(nuevaObservacion); // Actualizamos las observaciones
            return true;
        }
        return false; // Si no se encuentra el registro
    }

    // 6. Actualización: Cambiar el tipo de registro (entrada/salida)
    public boolean actualizarTipoRegistro(int id, String nuevoTipo) {
        if (!nuevoTipo.equals("entrada") && !nuevoTipo.equals("salida")) {
            throw new IllegalArgumentException("Tipo de registro inválido. Debe ser 'entrada' o 'salida'.");
        }

        Optional<Registro> registroOpt = registros.stream()
                .filter(registro -> registro.getId() == id)
                .findFirst();

        if (registroOpt.isPresent()) {
            Registro registro = registroOpt.get();
            registro.setTipoRegistro(nuevoTipo);
            return true;
        }
        return false;
    }

    public boolean eliminarRegistro(int id) {
        return registros.removeIf(registro -> registro.getId() == id);
    }
public int getIdPersona() {
    return this.idPersona;
}

public Timestamp getFechaHora() {
    return this.fechaHora;
}

public String getTipoAcceso() {
    return this.tipoAcceso;
}

}
