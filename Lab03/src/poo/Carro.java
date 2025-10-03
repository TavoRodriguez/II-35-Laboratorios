/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

/**
 *
 * @author grnar
 */
public class Carro {
    //Atributos
    private String marca;
    private String modelo;
    private String color; 
    private int año;
    private final String SIN_COLOR = "SIN COLOR";
    private final int DEFAULT_YEAR = 2000;
    
    //Metodo

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
        
    //Constructor 
    public Carro() {
        this.marca = "INDICAR MARCA";
        this.modelo = "INDICAR MODELO";
        this.color = SIN_COLOR;
        this.año = DEFAULT_YEAR ;
    }
        
    public Carro(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = SIN_COLOR;
        this.año = DEFAULT_YEAR ;
    }

    public Carro(String marca, String modelo, String color, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.año = año;
    }
    
    
    //metodo
    @Override
    public String toString() {
        return "Carro{" + "marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", a\u00f1o=" + año + '}';
    }
    
    
    
            
}
