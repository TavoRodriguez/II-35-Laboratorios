/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab06;

/**
 *
 * @author grnar
 */
public class Persona {
        // Atributos privados
    private String nombre;
    private String apellido;
    private String cedula;

    // Constructor vacío (por defecto)
    public Persona() {
    }

    // Constructor con parámetros
    public Persona(String nombre, String apellido, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + 
               ", Apellido: " + apellido + 
               ", Cédula: " + cedula;
    }

}
