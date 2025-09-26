/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab2;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author grnar
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            String[] nombres = new String[3];
            int[] numeros; //Indico el tamaño del arreglo que es  posiciones
            //numeros [0] = 10;
            //numeros [1] = 20;
            //numeros [2] = 30/0;
            //numeros [3] = 40;
            //System.out.println(Arrays.toString(nombres));
            //System.out.println(Arrays.toString(numeros));
            
            // 1. preguntar tamaño del arreglo 
            int size = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del arreglo"));
            //se valida que el tamaño no sea mayor que 10
            while (size > 10) {
                JOptionPane.showMessageDialog(null, "El valor debe ser menor que 10 ");
                size = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del arreglo"));
                
            }
            // 2. inicializar el arreglo con el tamaño 
            numeros = new int [size];
            // 3. llenar el arreglo 
            for (int i = 0; i < numeros.length; i++) {
                String valor = JOptionPane.showInputDialog("Ingrese el valor del index " + i);
                int intValor = Integer.parseInt(valor);
                numeros[i] = intValor; 
                
            }
            
            
            JOptionPane.showMessageDialog(null, Arrays.toString(numeros));

        } 
        catch (ArrayIndexOutOfBoundsException e){
            //System.err.println("El arreglo se esta desbordando");
            JOptionPane.showMessageDialog(null, "El arreglo se esta desbordado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (ArithmeticException e){
            //System.err.println("El arreglo se esta desbordando");
            JOptionPane.showMessageDialog(null, "Division entre 0", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception e) {
           //System.err.println("Error: " + e);
           JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            
        } finally {
            System.out.println("Fin del programa");
        }
 
        
    }
    
}
