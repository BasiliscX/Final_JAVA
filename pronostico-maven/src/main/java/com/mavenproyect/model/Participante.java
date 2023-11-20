package com.mavenproyect.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 	Para usar con PARTICIPANTES
 	
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [Nombre] [varchar](100) NOT NULL,
    CONSTRAINT [PK_PARTICIPANTES] PRIMARY KEY CLUSTERED([Id] ASC)
 * */
@Data @NoArgsConstructor @AllArgsConstructor
public class Participante {

	private int ID;
	private String nombre;

}
