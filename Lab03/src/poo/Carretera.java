/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

import java.util.ArrayList;

/**
 *
 * @author grnar
 */
public class Carretera {

    private String nombre;
    private ArrayList<Carro> carros; //<Carro> fuerzo el array a que sea Carro, solo pueda meter carros a la carretera 

    public Carretera(String nombre) {
        this.nombre = nombre;
        this.carros = new ArrayList();
    }

    //Metodos 
    public void agregarCarro(Carro carro) {
        this.carros.add(carro);
        this.verificarEstado();
    }

    public int cantidaDeCarros() {
        return this.carros.size();
    }

    public void verificarEstado() {
        int cantidad = cantidaDeCarros();
        if (cantidad < 3) {
            System.out.printf("La carretera %s tiene un flujo ligero %n", this.nombre);
        } else if (cantidad >= 4 && cantidad <= 6) {
            System.out.printf("La carretera %s tiene un flujo moderado %n", this.nombre);
        } else if (cantidad >= 7 && cantidad <= 9) {
            System.out.printf("La carretera %s está comenzando a congestionarse %n", this.nombre);
        } else if (cantidad >= 10 && cantidad <= 12) {
            System.out.printf("Se está generando un embotellamiento en la carretera %s%n", this.nombre);
        } else {
            System.out.printf("La carretera está colapsada, hay mucho embotellamiento%n");
        }

    }

    public void listarCarros() {
        var it = this.carros.iterator();
        while (it.hasNext()) {
            Carro next = it.next();
            System.out.printf("%s[%s]%n", next.getMarca(), next.getModelo());
        }
    }

    public void removerCarrosAntiguos() {
        var it = this.carros.iterator();
        int añoActual = java.time.Year.now().getValue(); // Obtiene el año actual
        while (it.hasNext()) {
            Carro next = it.next();
            // Validar antigüedad del carro (más de 20 años)
            if (añoActual - next.getAño()> 20) {
                it.remove();
            } else {
                System.out.printf("%s[%s]%n", next.getMarca(), next.getModelo());
            }
        }
    }

}
