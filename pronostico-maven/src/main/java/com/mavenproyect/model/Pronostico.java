package com.mavenproyect.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data @NoArgsConstructor @AllArgsConstructor
public class Pronostico {
	private int ID;
	private Participante participante;
	private Partido partido;
	private Equipo equipo;
	private char opcion;

	@Override
	public String toString() {
		return "Participante: "+participante.getNombre()+" - Partido: "+partido.getEquipo1().getNombre()+" / "+partido.getEquipo2().getNombre()+" Equipo: "+equipo.getNombre()+" Eleccion: "+opcion;
	}

	public int puntos() {
		return -2;// HUBO UN ERROR DE LECTURA/COMPARACION
	}

}
