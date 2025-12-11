/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import algo.ListaCircular;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author fbarg
 */
/**
 * Clase auxiliar para importar turnos desde un archivo de texto. Cada línea
 * representa un turno y se carga en una lista circular proporcionada.
 */
public class CargadorDeTurnos {

    /**
     * Carga turnos desde un archivo predefinido ubicado en la carpeta "datos".
     * Cada línea del archivo se considera un turno.
     *
     * @param listaTurnos Instancia de ListaCircular donde se agregarán los
     * turnos.
     * @param nombreArchivo Nombre del archivo (sin extensión .txt) a cargar.
     * @param componentePadre Componente Swing que actúa como padre para los
     * diálogos (puede ser null).
     */
    public static void cargarDesdeArchivo(ListaCircular listaTurnos, String nombreArchivo, java.awt.Component componentePadre) {
        File archivo = new File("datos/" + nombreArchivo + ".txt");

        if (!archivo.exists()) {
            JOptionPane.showMessageDialog(componentePadre,
                    "El archivo no existe: " + archivo.getPath(),
                    "Archivo no encontrado",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty()) {
                    listaTurnos.agregarTurno(linea);
                    contador++;
                }
            }

            JOptionPane.showMessageDialog(componentePadre,
                    "Se cargaron " + contador + " turnos desde el archivo.",
                    "Importación exitosa",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(componentePadre,
                    "Error al leer el archivo: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void guardarEnArchivo(ListaCircular<String> listaTurnos, String nombreArchivo) {
        File archivo = new File("datos/" + nombreArchivo + ".txt");

        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            if (listaTurnos.estaVacia()) {
                writer.println("");
            }
            for (String turno : listaTurnos.obtenerTodos(true)) {
                writer.println(turno);
            }
            //JOptionPane.showMessageDialog(null, "Turnos guardados en: " + archivo.getPath());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + e.getMessage());
        }
    }

}
