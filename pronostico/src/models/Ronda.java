package models;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
	private int nro;
	private List<Partido> partido;
	
	public Ronda() {
		this.partido=new ArrayList<Partido>();
	}
	
	public String toString() {
		return this.nro + partido.toString();
	}
	
	public Ronda(int nro, List<Partido> partidos) {
		setNro(nro);
		this.partido=partidos;
	}
	private void setNro(int nro) {
		this.nro=nro;
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
