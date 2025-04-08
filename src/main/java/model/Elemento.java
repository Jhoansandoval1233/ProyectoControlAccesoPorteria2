/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sando
 */
public class Elemento {
    private String tipoElemento;
    private String serial;
    private int id;

    // Constructor con todos los campos
    public Elemento(String tipo) {
        this.tipoElemento = tipo;
        this.serial = serial;
        this.id = id;
    }

    public Elemento(String tipo, String serial, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters y Setters
    public String getTipo() {
        return tipoElemento;
    }

    public void setTipo(String tipo) {
        this.tipoElemento = tipo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Elemento{" +
               "tipo='" + tipoElemento + '\'' +
               ", serial='" + serial + '\'' +
               ", id=" + id +
               '}';
    }
}