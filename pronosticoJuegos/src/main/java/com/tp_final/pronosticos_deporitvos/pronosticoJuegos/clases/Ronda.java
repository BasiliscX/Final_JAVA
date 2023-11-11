package com.tp_final.pronosticos_deporitvos.pronosticoJuegos.clases;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class Ronda {
	@Getter @Setter
	private int nro;
	private List<Partido> partido;
	
	public Ronda() {
		this.partido=new ArrayList<Partido>();
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
