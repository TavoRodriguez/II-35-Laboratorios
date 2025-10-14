/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab04;

/**
 *
 * @author grnar
 */
public class PilaCarros extends PilaList<Carro> {

    public PilaCarros() {
        super();
    }

    public void AgregarCarro(Carro carro) {
        push(carro);
    }

    public Carro EliminarCarro() {
        return pop();
    }

    public Carro ConsultarCarro() {
        return peek();
    }

    public static void main(String[] args) {
        PilaCarros pc = new PilaCarros();
        
        Carro c2 = new Carro("Ford", "Bronco", "Negro", 2024);
        System.out.println(c2.toString());
        pc.AgregarCarro(c2);
        
        System.out.println(pc);
    }
}
