package pronostico.model;

/**
 * Para trabajar con los datos en
 * 
 * 		PAISES
 * 		[Id] [int] IDENTITY(1,1) NOT NULL,
 *	    [Nombre] [varchar](100) NOT NULL,
 *      CONSTRAINT [PK_PAISES] PRIMARY KEY CLUSTERED([Id] ASC)
 * */
public class Equipo {
	private int ID;
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

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
}
