/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package turnos;

import algo.ListaCircular;

/**
 *
 * @author fbarg
 */
public class Turnos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaCircular<String> lista = new ListaCircular<>();
        lista.agregarTurno("Juan");
        lista.agregarTurno("Ana");
        lista.agregarTurno("Luis");

        System.out.println("Turno actual: " + lista.obtenerActual());
        System.out.println("Siguiente: " + lista.avanzar());
        System.out.println("Anterior: " + lista.retroceder());

    }

}
