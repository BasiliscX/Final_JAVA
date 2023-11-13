package com.tp_final.pronosticos_deporitvos.pronosticoJuegos.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Ronda {
	private String nro;
	private List<Partido> partido;
	
	public Ronda() {
		this.partido=new ArrayList<Partido>();
	}
	
	public String toString() {
		return this.nro + partido.toString();
	}
	
	public Ronda(String nro, List<Partido> partidos) {
		setNro(nro);
		this.partido=partidos;
	}
	public void agregarPartido(Partido partido) {
		this.partido.add(partido);
	}
	public void removerPartido(Partido partido) {
		this.partido.remove(partido);
	}
	public List<Partido> getPartidos(){
		return this.partido;
	}
}
