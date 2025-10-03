/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab03;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import poo.Carretera;
import poo.Carro;
import poo.Garaje;
/**
 *
 * @author grnar
 */
public class Lab03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        //objetos 
        Carro c1 = new Carro();
        c1.setMarca("Toyota");
        c1.setModelo("Yaris");
        c1.setColor("Verde");
        System.out.println(c1.toString());
        
        Carro c2 = new Carro("Ford", "Bronco", "Negro", 2024);
        System.out.println(c2.toString());
        
        Garaje miGaraje = new Garaje(2);
        miGaraje.aparcarCarro(c1);
        miGaraje.aparcarCarro(c2);
        miGaraje.aparcarCarro(c1);
        
        Carretera c = new Carretera("General Cañas");
        c.agregarCarro(c1);
        c.agregarCarro(c2);
        c.listarCarros();
        c.removerCarrosAntiguos();
    
    }
    
}
