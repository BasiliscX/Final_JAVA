package com.tp_final.pronosticos_deporitvos.pronosticoJuegos.clases;

import lombok.Getter;
import lombok.Setter;

public class Pronostico {
	@Getter @Setter
	private Partido partido;
	@Getter @Setter
	private Equipo equipo;
	@Getter @Setter
	private ResultadoEnum resultado;
	public int puntos() {
		int puntos=0;
		return puntos;
	}
}
