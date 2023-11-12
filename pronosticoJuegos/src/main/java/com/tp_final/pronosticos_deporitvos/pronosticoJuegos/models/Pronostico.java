package com.tp_final.pronosticos_deporitvos.pronosticoJuegos.models;

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
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public ResultadoEnum getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoEnum resultado) {
		this.resultado = resultado;
	}
}
