/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab04;

/**
 *
 * @author grnar
 */
public class Vehiculo {

    private final String SIN_COLOR = "SIN COLOR";
    private final int DEFAULT_YEAR = 2000;
    private static final double KILOMETRAJE_VIEJO = 50000.0;

    private Double kilometraje = 0.0;
    private int año;

    private String marca;
    private String modelo;
    private String color;
    private int ruedas;

    private boolean nuevo = true;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    
    public boolean isNuevo() {
        return nuevo;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public Double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Double kilometraje) {
        this.kilometraje = kilometraje;

    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Vehiculo(int ruedas) {
        this.ruedas = ruedas;
        
    }

    public Vehiculo(String marca, String modelo, int ruedas) {
        this.marca = marca;
        this.modelo = modelo;
        this.ruedas = ruedas;
    }
    

}
