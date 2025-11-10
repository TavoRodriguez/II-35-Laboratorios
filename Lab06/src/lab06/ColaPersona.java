/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab06;

import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author grnar
 */
public class ColaPersona {
        // Cola de personas (estructura FIFO)
    private Queue<Persona> fila = new LinkedList<>();

    // Encolar Persona
    public void addPersona(Persona persona) {
        fila.offer(persona);
    }

    // Desencolar Persona
    public Persona pollPersona() {
        return fila.poll();
    }

    // Consultar la siguiente Persona
    public Persona peekPersona() {
        return fila.peek();
    }

    // Tamaño de la cola
    public int size() {
        return fila.size();
    }

    // Verificar si la cola está vacía
    public boolean isEmpty() {
        return fila.isEmpty();
    }

    // Listar todas las personas en la cola
    public String listar() {
        StringBuilder salida = new StringBuilder();
        for (Persona persona : fila) {
            salida.append(persona).append("\n");
        }
        return salida.toString();
    }

      // Método principal para probar la cola
    public static void main(String[] args) {
        ColaPersona fila = new ColaPersona();

        System.out.println("¿Fila vacía?: " + (fila.isEmpty() ? "Sí" : "No"));

        Persona p1 = new Persona("Juan", "Ramírez", "123456789");
        Persona p2 = new Persona("María", "López", "987654321");
        Persona p3 = new Persona("Carlos", "González", "456789123");

        fila.addPersona(p1);
        fila.addPersona(p2);
        fila.addPersona(p3);

        System.out.println("Hay " + fila.size() + " personas en la fila.");
        System.out.println("Contenido de la fila:\n" + fila.listar());

        System.out.println("Atendiendo a: " + fila.pollPersona());
        System.out.println("Siguiente en la fila: " + fila.peekPersona());
        System.out.println("Personas restantes: " + fila.size());
    }
}
