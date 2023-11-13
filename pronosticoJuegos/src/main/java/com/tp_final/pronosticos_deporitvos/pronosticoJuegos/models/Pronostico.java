package com.tp_final.pronosticos_deporitvos.pronosticoJuegos.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Pronostico {
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum resultado;
	
	public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
		setPartido(partido);
		setEquipo(equipo);
		setResultado(resultado);
	}
	
	public String toString() {
		return partido.ToString() + equipo.toString() + resultado;
	}
	
	public int puntos() {
		int puntos=0;
		return puntos;
	}
}
