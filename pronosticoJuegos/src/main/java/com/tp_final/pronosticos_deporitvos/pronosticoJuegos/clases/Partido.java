package com.tp_final.pronosticos_deporitvos.pronosticoJuegos.clases;

import lombok.Getter;
import lombok.Setter;

public class Partido {
	@Getter @Setter
	private Equipo equipo1;
	@Getter @Setter
	private Equipo equipo2;
	@Getter @Setter
	private int golesEquipo1;
	@Getter @Setter
	private int golesEquipo2;
	
	public ResultadoEnum resultado(Equipo equipo) {
		ResultadoEnum resultado = null;
		return resultado;
	}
}