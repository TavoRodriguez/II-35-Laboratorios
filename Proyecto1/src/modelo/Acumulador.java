/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author fbarg
 */
public class Acumulador {

    private int total;
    Stack<Operacion> pilaUndo;
    Stack<Operacion> pilaRedo;

    public Acumulador() {
        pilaUndo = new Stack<>();
        pilaRedo = new Stack<>();
    }

    public int getTotal() {
        return total;
    }

    public Stack<Operacion> getUndoStack() {
        return pilaUndo;
    }

    public Stack<Operacion> getRedoStack() {
        return pilaRedo;
    }

    /**
     * para los metodos undo y redo hacer una validacion, si la pila undo esta vacio agregar 
     * un mensaje "No hay operaciones por deshacer" 
     * El undo va a eliminar de la pila de Undo, el elemento que este al tope y la va a insertar en el elemento de Redo
     * 
     * paso 1. desapilar de pilaUndo
     * paso 2. Apilar en pilaRedo, la inversa de la operacion ejemplo yo en undo sumo 5, 10 y 20, resto -2 entonces en pilaRedo ese
     * menos dos pasa a 2 postivo 
     * tras un undo y una nueva operacion, la pilaRedo debe vaciarse
     */
    public void undo() {
        if (pilaUndo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay operaciones por deshacer");
            return;
        }

        // Paso 1: desapilar de pilaUndo
        Operacion op = pilaUndo.pop();

        // Paso 2: apilar la inversa en pilaRedo
        pilaRedo.push(op.inversa());

        // Recalcular el total
        recalcularTotal();
    }

    public void redo() {
        if (pilaRedo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay operaciones por rehacer");
            return;
        }

        // Desapilar de pilaRedo
        Operacion op = pilaRedo.pop();

        // Apilar la operación original nuevamente en pilaUndo
        pilaUndo.push(op);

        // Recalcular total
        recalcularTotal();
    }

    // puede ser positivo o negativo
    public void aplicar(Operacion valor) {
        // Tras un undo y una nueva operación, la pilaRedo debe vaciarse
        if (!pilaRedo.isEmpty()) {
            pilaRedo.clear();
        }

        pilaUndo.add(valor);
        recalcularTotal();

        System.out.println("Total:" + total);
        System.out.println("undoStack:" + pilaUndo);
    }

    private void recalcularTotal() {
        total = 0;
        for (Operacion v : pilaUndo) {
            if (v.getTipo() == TipoOperacion.SUMA) {
                total += v.getValor();
            }
            if (v.getTipo() == TipoOperacion.RESTA) {
                total -= v.getValor();
            }
        }
    }

    public void estado() {
        JOptionPane.showMessageDialog(null,
                "UNDO:\n" + getHistorialUndo() + "\n" + "REDO:\n" + getHistorialRedo());
    }

    /* para el historial debe verse con formato de pila ejemplo y en texto si fue SUMA o RESTA
    Pila Undo: 
    5 SUMA
    2 RESTA
    5 SUMA
    
    Pila Redo: 
    5 SUMA
    2 RESTA
    5 SUMA
    */
    public String getHistorialUndo() {
        StringBuilder sb = new StringBuilder();
        for (int i = pilaUndo.size() - 1; i >= 0; i--) {
            Operacion op = pilaUndo.get(i);
            sb.append(op.getValor()).append(" ").append(op.getTipo()).append("\n");
        }
        return sb.toString();
    }

    public String getHistorialRedo() {
        StringBuilder sb = new StringBuilder();
        for (int i = pilaRedo.size() - 1; i >= 0; i--) {
            Operacion op = pilaRedo.get(i);
            sb.append(op.getValor()).append(" ").append(op.getTipo()).append("\n");
        }
        return sb.toString();
    }
}
