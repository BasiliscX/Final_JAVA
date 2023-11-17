package pronostico.model;

/**
 	Para usar con PARTICIPANTES
 	
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [Nombre] [varchar](100) NOT NULL,
    CONSTRAINT [PK_PARTICIPANTES] PRIMARY KEY CLUSTERED([Id] ASC)
 * */
public class Participante {
	private int ID;
	private String nombre;
	
	public Participante(int ID, String nombre) {
		this.ID=ID;
		this.nombre=nombre;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
