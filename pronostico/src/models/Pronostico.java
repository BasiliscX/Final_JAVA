package models;

/**
 	Para usar en la tabla PRONOSTICOS
 	
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [ID_Participante] [int] NOT NULL,
    [ID_Resultado] [int] NOT NULL,
    [ID_Equipo] [int] NOT NULL,
    [Opcion_G_E_P] [char](1) NOT NULL,
    CONSTRAINT [PK_PRONOSTICOS] PRIMARY KEY CLUSTERED([Id] ASC),
    CONSTRAINT [FK_ID_Participante_Pronosticos] FOREIGN KEY ([ID_Participante]) REFERENCES [dbo].[PARTICIPANTES]([Id]),
    CONSTRAINT [FK_ID_Resultado_Pronosticos] FOREIGN KEY ([ID_Resultado]) REFERENCES [dbo].[RESULTADOS]([Id]),
    CONSTRAINT [FK_ID_Equipo_Pronosticos] FOREIGN KEY ([ID_Equipo]) REFERENCES [dbo].[PAISES]([Id])
 */
public class Pronostico {
	private int ID;
	private Participante participante;
	private Partido partido;
	private Equipo equipo;
	private char opcion;
	
	public int puntos() {
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

	public Participante getParticipante() {
		return participante;
	}
	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public char getOpcion() {
		return opcion;
	}

	public void setOpcion(char opcion) {
		this.opcion = opcion;
	}
}
