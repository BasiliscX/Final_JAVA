package com.mavenproyect.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data @AllArgsConstructor @NoArgsConstructor
public class Partido {

	private int ID;
	private char grupo;
	private Equipo equipo1;
	private int golesEquipo1;
	private Equipo equipo2;
	private int golesEquipo2;

}
