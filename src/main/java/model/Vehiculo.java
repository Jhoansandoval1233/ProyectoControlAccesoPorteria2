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
    private String tipo;
    private String placa;

    public Vehiculo(int tipo) {
        this.tipo = tipo;
        this.placa = placa;
    }
//actualizacion git 
    public Vehiculo() {
    }

    public Vehiculo(String marca_Ejemplo, String modelo_Ejemplo, String abC123) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Vehiculo(String vehiculoString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
               "tipo='" + tipo + '\'' +
               ", placa='" + placa + '\'' +
               '}';
    }

}
