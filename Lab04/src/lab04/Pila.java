/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab04;

import java.util.EmptyStackException;

/**
 *
 * @author fbarg
 */
public class Pila {

    private final int maxSize;
    private final int[] elements;
    private int top;

    public Pila(int size) {
        this.elements = new int[size];
        this.maxSize = size;
        this.top = -1;
    }

    public void push(int value) {
        if (top + 1 == maxSize) {
            System.err.println("La pila esta llena, no se agregar mas elementos.");
            return;
        }
        this.elements[++top] = value;
        System.out.println("Elemento agregado: " + value);
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int temp = this.elements[top];
        this.elements[top--] = 0;
        return temp;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return this.elements[top];
    }

    public int size() {
        return this.top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Elementos de la Pila{[]}";
        }
        StringBuilder sb = new StringBuilder("Elementos de la Pila\n{");
        for (int i = top; i >= 0; i--) {
            sb.append("\n\t[").append(elements[i]).append("]");
            if (i == top) {
                sb.append("<= top");
            }
        }
        sb.append("\n}");
        return sb.toString();
    }

    public static void main(String[] args) {
        Pila p = new Pila(3);
        System.out.println(p.toString());
        p.push(10);
        p.push(20);
        p.push(30);

        System.out.println("Eliminando el elemento: " + p.pop());
        p.push(40);
        System.out.println("El elemento en el top es: " + p.peek());
        System.out.println("Elementos en la pila: " + p.size());

        System.out.println(p.toString());
    }
}
