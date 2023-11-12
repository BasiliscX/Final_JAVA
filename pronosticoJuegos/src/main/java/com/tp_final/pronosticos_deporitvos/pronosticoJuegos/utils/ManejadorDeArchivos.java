package com.tp_final.pronosticos_deporitvos.pronosticoJuegos.utils;

import com.tp_final.pronosticos_deporitvos.pronosticoJuegos.models.*;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ManejadorDeArchivos {

	@SuppressWarnings("resource")
	private static List<String[]> getRecords(String fileName) throws IOException, CsvException {
        return (new CSVReader( new FileReader(fileName) )).readAll();
    }

    public static List<Ronda> parsearArchivoResultados(String fileName) throws IOException, CsvException {
        List<String[]> records = getRecords(fileName);

        List<Ronda> rondas = new ArrayList<>();
        
        for (int i = 1; i < records.size(); i++) {
            List<Partido> partidos = new ArrayList<>();
            String[] fila = records.get(i);
            
            Equipo equipo1 = new Equipo(fila[1], fila[1].toLowerCase());
            int golesEquipo1 = Integer.parseInt(fila[2]);

            Equipo equipo2 = new Equipo(fila[4], fila[4].toLowerCase());
            int golesEquipo2 = Integer.parseInt(fila[3]);

            Partido partido = new Partido(equipo1, equipo2, golesEquipo1, golesEquipo2);

            Ronda ronda = new Ronda(fila[0], partidos);

            rondas.add(ronda);
            partidos.add(partido);
        }

        return rondas;
    }

    public static HashMap<String, List<Pronostico>> parsearArchivoPronosticos(String fileName) throws IOException, CsvException {
        List<String[]> records = getRecords(fileName);

        HashMap<String, List<Pronostico>> forecastHashMap = new HashMap<>();

        for (int i = 1; i < records.size(); i++) {
            String[] row = records.get(i);

            String competitor = row[0];
            List<Pronostico> pronosticos = forecastHashMap.get(competitor);

            Pronostico pronostico = getPronostico(row);

            if(pronosticos != null){
                pronosticos.add(pronostico);
            }
            else {
                pronosticos = new ArrayList<>();
                pronosticos.add(pronostico);
                forecastHashMap.put(competitor, pronosticos);
            }
        }

        return forecastHashMap;
    }

    private static Pronostico getPronostico(String[] row) {
        Equipo equipo1 = new Equipo(row[1], row[1].toLowerCase());
        Equipo equipo2 = new Equipo(row[5], row[5].toLowerCase());
        Partido partido = null;
        Pronostico pronostico = null;

        if(row[2].equalsIgnoreCase("X")){
            partido = new Partido(equipo1, equipo2, 1, 0);
            pronostico = new Pronostico(partido, equipo1, ResultadoEnum.GANADOR);
        }
        else if (row[3].equalsIgnoreCase("X")) {
            partido = new Partido(equipo1, equipo2, 0, 0);
            pronostico = new Pronostico(partido, equipo1, ResultadoEnum.EMPATE);
        }
        else if(row[4].equalsIgnoreCase("X")){
            partido = new Partido(equipo1, equipo2, 0, 1);
            pronostico = new Pronostico(partido, equipo1, ResultadoEnum.PERDEDOR);
        }

        return pronostico;
    }


}
