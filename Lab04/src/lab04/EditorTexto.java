/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab04;

import java.util.Scanner;
import java.util.Stack; //Stack Clase de java para hacer una pila

/**
 *
 * @author fbarg
 */
public class EditorTexto {

    private final Stack<String> acciones = new Stack<>();
    private final Stack<String> accionesUndo = new Stack<>();

    public void escribir(String texto) {
        acciones.push(texto);
        System.out.println("Escribiendo: " + texto);
    }

//    public void deshacer() {
//        if (!acciones.isEmpty()) {
//            String textDeshecho = acciones.pop();
//            acciones.add(textDeshecho);
//            System.out.println("Deshaciendo: " + textDeshecho);
//        } else {
//            System.err.println("No hay acciones para deshacer.");
//        }
//    }
    public void deshacer() {

        if (acciones.isEmpty()) {
            System.err.println("No hay acciones para deshacer.");
            return;
        }

        String textDeshecho = acciones.pop();
        acciones.add(textDeshecho);
        System.out.println("Deshaciendo: " + textDeshecho);
    }

    public void rehacer() {
        if (accionesUndo.isEmpty()) {
            return;
        }
        String texto = accionesUndo.pop();
        System.out.println("Rehaciendo: " + texto);
        escribir(texto);
    }

    public void Imprimir() {
        String salida = "";
        for (String accion : acciones) {
            salida += accion;
        }
        System.out.println(salida);
    }

    public int size() {
        return acciones.size();
    }

    public static void main(String[] args) {
        EditorTexto et = new EditorTexto();
        et.escribir("Hola ");
        et.escribir("Mundo ");
        et.escribir("Bienvenidos a ");
        et.escribir("Programacion ");
        et.escribir("en ");
        et.escribir("Java");

        System.out.println("Acciones: " + et.size());

        et.deshacer();
        et.deshacer();
        System.out.println("Acciones: " + et.size());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Ingrese el texto a escribir");
            String texto = scanner.next();

            if (texto.contains("!q")) {
                return;
            }

            if (texto.contains("!p")) {
                et.Imprimir();
                continue;
            }

            if (texto.contains("!u")) {
                et.deshacer();
                continue;
            }

            if (texto.contains("!r")) {
                et.rehacer();
                continue;
            }

            et.escribir(texto);
            System.out.println("Size:" + et.size());

        }
    }
}
