/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bubbleshort;
import javax.swing.JOptionPane;
/**
 *
 * @author grnar
 */
public class BubbleShort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
        int n = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos números desea ordenar?"));
        int[] numeros = new int[n];

        // Leer los números
        for (int i = 0; i < n; i++) {
            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número " + (i + 1)));
        }

        // Algoritmo burbuja
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    // Intercambiar
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }

        // Mostrar los números ordenados
        String resultado = "Números ordenados: ";
        for (int num : numeros) {
            resultado += num + " ";
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
    
}
