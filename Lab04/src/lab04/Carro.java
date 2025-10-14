/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab04;

import java.util.HashSet;

/**
 *
 * @author grnar
 */
public class Carro extends Vehiculo {

    private int puertas;
    private String traccion;
    private int pasajeros;
    private String[] extras;

    public Carro() {
        super(4); //Cada que cree un vehiculo y no paso ningun valor la cantidad de ruedas va a ser 4
    }

    public Carro(String marca, String modelo, String color) {
        super(marca, modelo, 4);
    }

    public Carro(String marca, String modelo, String color, int año) {
        super(marca, modelo, 4);
        super.setColor(color);
        super.setAño(año);    
    }

    public Carro(int año, String marca, String modelo) {
        super(marca, modelo, 4);
        super.setAño(año);
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public String[] getExtras() {
        return extras;
    }

    public void setExtras(String[] extras) {
        this.extras = extras;
    }

    @Override
    public String toString() {
        return "Carro (" + "marca: " + super.getMarca() + ", modelo: " + super.getModelo()
                + ", año: " + getAño()
                + ", kilometraje: " + getKilometraje()
                + ", nuevo: " + (isNuevo() ? "Si" : "No") + ")";

    }

    public static void main(String[] args) {
        Carro c = new Carro(2025, "Toyota", "Corolla");
        System.out.println(c);
        c.setKilometraje(10000.0);
        System.out.println(c);
    }

}
