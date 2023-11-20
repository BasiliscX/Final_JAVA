package com.mavenproyect.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Para trabajar con los datos en PAISES
 * 		[Id] [int] IDENTITY(1,1) NOT NULL,
 *	    [Nombre] [varchar](100) NOT NULL,
 *      CONSTRAINT [PK_PAISES] PRIMARY KEY CLUSTERED([Id] ASC)
 * */

@Data @NoArgsConstructor @AllArgsConstructor
public class Equipo {
	private int ID;
	private String nombre;

}
