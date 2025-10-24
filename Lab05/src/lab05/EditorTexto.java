/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab05;

import java.util.Stack;
import javax.swing.JOptionPane;

public class EditorTexto {

    private final Stack<String> acciones = new Stack<>();
    private final Stack<String> accionesUndo = new Stack<>();

   public void escribir(String texto) {
    acciones.push(texto);
    // cada vez que escribes algo nuevo, las posibilidades de "rehacer" anteriores se invalidan
    accionesUndo.clear();
    JOptionPane.showMessageDialog(null, "Escribiendo: " + texto);
}

public void deshacer() {
    if (acciones.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay acciones para deshacer.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String textDeshecho = acciones.pop();
    // guardo lo deshecho en la pila de undo/rehacer
    accionesUndo.push(textDeshecho);
    JOptionPane.showMessageDialog(null, "Deshaciendo: " + textDeshecho);
}

public void rehacer() {
    if (accionesUndo.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay acciones para rehacer.");
        return;
    }
    String texto = accionesUndo.pop();
    // lo vuelvo a aplicar en acciones
    acciones.push(texto);
    JOptionPane.showMessageDialog(null, "Rehaciendo: " + texto);
}


    public void Imprimir() {
        StringBuilder salida = new StringBuilder();
        for (String accion : acciones) {
            salida.append(accion);
        }
        JOptionPane.showMessageDialog(null, "Texto actual:\n" + salida.toString());
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

        JOptionPane.showMessageDialog(null, "Acciones iniciales: " + et.size());

        et.deshacer();
        et.deshacer();
        JOptionPane.showMessageDialog(null, "Acciones tras deshacer: " + et.size());

        while (true) {
            String texto = JOptionPane.showInputDialog(
                    null,
                    "Ingrese el texto a escribir\n"
                    + "(!q para salir, !p imprimir, !u deshacer, !r rehacer)"
            );

            if (texto == null || texto.contains("!q")) {
                JOptionPane.showMessageDialog(null, "Programa finalizado.");
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
            JOptionPane.showMessageDialog(null, "Total acciones: " + et.size());
        }
    }
}
