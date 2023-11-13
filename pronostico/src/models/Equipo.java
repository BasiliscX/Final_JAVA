package models;

public class Equipo {
	private String nombre;

	public Equipo(String nombre){
		this.setNombre(nombre);
	}

	public Equipo() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
