/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

/**
 *
 * @author grnar
 */
public class Garaje {
    private final int capacidad; 
    private final Carro[] espacios; //arreglo
    private int index;
    //Constructor
    public Garaje(int capacidad) {
        this.capacidad = capacidad;
        this.espacios = new Carro[capacidad];
    }
    
    //metodoos 
    public void aparcarCarro(Carro carro){
        if (index < capacidad) {
            this.espacios[index++] = carro;
            System.out.printf("Aparcando %s-%s%n", carro.getMarca(), carro.getModelo());
        }
        else{
            System.err.printf("Garaje lleno, capacidad maxima de %d%n", this.capacidad);
        }
    }
    
    public void listarCarros(){
        for (Carro espacio: espacios){
            System.out.printf("%s[%s]%n", espacio.getMarca(), espacio.getModelo());
        }
    }
}
