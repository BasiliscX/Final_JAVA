package com.tp_final.pronosticos_deporitvos.pronosticoJuegos.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Equipo {
	private String nombre;

	public Equipo(String nombre){
		this.setNombre(nombre);
	}
}
