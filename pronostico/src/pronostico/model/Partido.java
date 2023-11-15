package pronostico.model;

/**
 * 	Para trabajar con la tabla RESULTADOS
 
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [Grupo] [char](1) NOT NULL,
    [Equipo_1] [int] NOT NULL,
    [Cantidad_goles_1] [int] NOT NULL,
    [Equipo_2] [int] NOT NULL,
    [Cantidad_goles_2] [int] NOT NULL,
    CONSTRAINT [PK_RESULTADOS] PRIMARY KEY CLUSTERED([Id] ASC),
    CONSTRAINT [FK_Equipo1] FOREIGN KEY ([Equipo_1]) REFERENCES [dbo].[PAISES]([Id]),
    CONSTRAINT [FK_Equipo2] FOREIGN KEY ([Equipo_2]) REFERENCES [dbo].[PAISES]([Id])
 * */
public class Partido {
	private int ID;
	private char grupo;
	private Equipo equipo1;
	private int golesEquipo1;
	private Equipo equipo2;
	private int golesEquipo2;

	public Partido(char grupo, Equipo equipo1, int golesEquipo1, Equipo equipo2, int golesEquipo2) {
		setGrupo(grupo);
		setEquipo1(equipo1);
		setGolesEquipo1(golesEquipo1);
		setEquipo2(equipo2);
		setGolesEquipo2(golesEquipo2);		
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public char getGrupo() {
		return grupo;
	}
	public void setGrupo(char grupo) {
		this.grupo = grupo;
	}

	public Equipo getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}
	public Equipo getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}
	public int getGolesEquipo1() {
		return golesEquipo1;
	}
	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}
	public int getGolesEquipo2() {
		return golesEquipo2;
	}
	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}
}
