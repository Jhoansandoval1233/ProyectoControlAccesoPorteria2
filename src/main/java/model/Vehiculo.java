/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sando
 */
public class Vehiculo {
    private int id;
    private String tipo;
    private String placa;

    public Vehiculo(String tipo1, String placa1, String id1) {
    }

    public Vehiculo(int id, String tipo, String placa) {
        this.id = id;
        this.tipo = tipo;
        this.placa = placa;
    }

    public Vehiculo(String moto, String abC123, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Vehiculo(String vehiculoString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Vehiculo(int i, String tipoVehiculo, String placa, Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
               "id=" + id +
               ", tipo='" + tipo + '\'' +
               ", placa='" + placa + '\'' +
               '}';
    }
}