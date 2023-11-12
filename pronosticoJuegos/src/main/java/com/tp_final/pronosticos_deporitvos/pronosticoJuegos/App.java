package com.tp_final.pronosticos_deporitvos.pronosticoJuegos;

import java.util.List;
import java.util.Map;

import com.tp_final.pronosticos_deporitvos.pronosticoJuegos.models.Ronda;
import com.tp_final.pronosticos_deporitvos.pronosticoJuegos.utils.ManejadorDeArchivos;

public class App {

    public static void main(String[] args) {
        // Hardcodeo de archivos de entrada.
        String csvResultados = "resources/resultados.csv";
        String csvPronosticos = "resources/pronosticos.csv";

        try {
            List<Ronda> rondas = ManejadorDeArchivos.parsearArchivoResultados( csvResultados );
            rondas.forEach(System.out::println);
            
            Map<String, ?> pronosticos = ManejadorDeArchivos.parsearArchivoPronosticos(csvPronosticos);
            pronosticos.forEach((clave, valor) -> System.out.println("Clave: " +clave + ", Valor: " + valor));
        } catch (Exception e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }
}