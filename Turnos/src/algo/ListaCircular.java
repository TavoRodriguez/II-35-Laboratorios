/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fbarg
 */
/**
 * Lista doblemente enlazada circular con soporte para turno actual. Conserva la
 * estructura original, agregando navegación paso a paso.
 */
public class ListaCircular<T> {

    private NodoDoble<T> cabeza = null; // Primer nodo de la lista
    private NodoDoble<T> cola = null;   // Último nodo de la lista
    private NodoDoble<T> actual = null; // Nodo actual o seleccionado (turno activo)

    public NodoDoble<T> getCabeza() {
        return cabeza;
    }

    /**
     * Agrega un nuevo nodo al final de la lista circular. Si la lista está
     * vacía, el nuevo nodo se conecta consigo mismo. Si ya contiene nodos, se
     * enlaza al final y se mantiene la circularidad.
     * @param dato
     */  
    public void agregarTurno(T dato) {
        NodoDoble nuevo = new NodoDoble(dato);

        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
            actual = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            nuevo.siguiente = cabeza;   
            nuevo.anterior = cola;      

            cola.siguiente = nuevo;     
            cabeza.anterior = nuevo;    

            cola = nuevo;               
        }

    }

    /**
     * Devuelve el dato almacenado en el nodo actual.
     *
     * @return Dato del nodo actual, o null si la lista está vacía.
     */
    public T obtenerActual() {
        if (estaVacia() || actual == null) {
            return null;
        }
        return actual.dato;
    }

    /**
     * Avanza al siguiente nodo en la lista circular.
     *
     * @return El dato del nodo siguiente, o null si la lista está vacía.
     */
    public T avanzar() {
        actual = actual.siguiente;
        return actual.dato;
    }

    //Pendiente
    /**
     * Retrocede al nodo anterior en la lista circular.
     *
     * @return El dato del nodo anterior, o null si la lista está vacía.
     */
    public T retroceder() {
        actual = actual.anterior;
        return actual.dato;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si no hay nodos; false si hay al menos uno.
     */
    public boolean estaVacia() {
       return cabeza == null;
    }

    public List<T> obtenerAdelante() {
        List<T> lista = new ArrayList<>();

        if (cabeza == null) {
            return lista;
        }

        NodoDoble<T> nodo = cabeza;

        do {
            lista.add(nodo.dato);
            nodo = nodo.siguiente;
        } while (nodo != cabeza);

        return lista;
    }

    public List<T> obtenerAtras() {
        List<T> lista = new ArrayList<>();

        if (cola == null) {
            return lista;
        }

        NodoDoble<T> nodo = cola;

        do {
            lista.add(nodo.dato);
            nodo = nodo.anterior;
        } while (nodo != cola);

        return lista;
    }
    
    //Pendiente
    public List<T> obtenerDesdeActual() {
        List<T> lista = new ArrayList<>();

        if (estaVacia() || actual == null) {
            return lista;
        }

        NodoDoble<T> nodo = actual;

        do {
            lista.add(nodo.dato);
            nodo = nodo.siguiente;
        } while (nodo != actual);

        return lista;
    }

    //No modificar
    public List<T> obtenerTodos(boolean adelante) {
        return adelante ? obtenerAdelante() : obtenerAtras();
    }

}
