package models;

public class Pronostico {
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum resultado;
	
	public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
		setPartido(partido);
		setEquipo(equipo);
		setResultado(resultado);
	}
	public int puntos() {
		//Evaluo el nro de equipo con el ingresado
		if(partido.getEquipo1().getNombre().equalsIgnoreCase(equipo.getNombre())) {
			// Evaluo el resultado final con el pronosticado
			if(partido.getGolesEquipo1()>partido.getGolesEquipo2()) {
				resultado=ResultadoEnum.GANADOR;
				return 1;
			}
			else if(partido.getGolesEquipo1()==partido.getGolesEquipo2()) {
				resultado=ResultadoEnum.EMPATE;
				return 0;
			}
			else {
				resultado=ResultadoEnum.PERDEDOR;
				return -1;
			}
		}
		//Evaluo el nro de equipo con el ingresado
		if(partido.getEquipo2().getNombre().equalsIgnoreCase(equipo.getNombre())) {
			// Evaluo el resultado final con el pronosticado
			if(partido.getGolesEquipo2()>partido.getGolesEquipo1()) {
				resultado=ResultadoEnum.GANADOR;
				return 1;
			}
			else if(partido.getGolesEquipo2()==partido.getGolesEquipo1()) {
				resultado=ResultadoEnum.EMPATE;
				return 0;
			}
			else {
				resultado=ResultadoEnum.PERDEDOR;
				return -1;
			}
		}
		return -2;// HUBO UN ERROR DE LECTURA/COMPARACION
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

	
	public String toString() {
		return partido.ToString() + equipo.toString() + resultado;
	}
}
