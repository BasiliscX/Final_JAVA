package com.tp_final.pronosticos_deporitvos.pronosticoJuegos.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Partido {
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;

	public String ToString(){
		return equipo1.toString() + " " + equipo2.toString() +" " + golesEquipo1 +" " + golesEquipo2;
	}
	public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
		setEquipo1(equipo1);
		setEquipo2(equipo2);
		setGolesEquipo1(golesEquipo1);
		setGolesEquipo2(golesEquipo2);		
	}
	public ResultadoEnum resultado(Equipo equipo) {
		ResultadoEnum resultado = null;
		return resultado;
	}
}
