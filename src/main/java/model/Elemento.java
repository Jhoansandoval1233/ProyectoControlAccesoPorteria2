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
    private int id;
    private String tipo;
    private String serial;
    private Persona persona;

    public Elemento() {}

    public Elemento(String tipo) {
        this.tipo = tipo;
        this.serial = serial;
        this.persona = persona;
    }

   public Elemento(int id, String tipo, String serial, Persona persona) {
    this.id = id;
    this.tipo = tipo;
    this.serial = serial;
    this.persona = persona;
}

    public Elemento(String tipo, String serial, String id) {
         this.tipo = tipo;
         this.serial = serial;
         
    }


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

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}