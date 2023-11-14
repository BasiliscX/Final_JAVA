use master
go
create database PRONOSTICOS_DB
go
USE PRONOSTICOS_DB
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PAISES](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [Nombre] [varchar](100) NOT NULL,
    CONSTRAINT [PK_PAISES] PRIMARY KEY CLUSTERED([Id] ASC)
);
go
USE PRONOSTICOS_DB
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RESULTADOS](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [Grupo] [char](1) NOT NULL,
    [Equipo_1] [int] NOT NULL,
    [Cantidad_goles_1] [int] NOT NULL,
    [Equipo_2] [int] NOT NULL,
    [Cantidad_goles_2] [int] NOT NULL,
    CONSTRAINT [PK_RESULTADOS] PRIMARY KEY CLUSTERED([Id] ASC),
    CONSTRAINT [FK_Equipo1] FOREIGN KEY ([Equipo_1]) REFERENCES [dbo].[PAISES]([Id]),
    CONSTRAINT [FK_Equipo2] FOREIGN KEY ([Equipo_2]) REFERENCES [dbo].[PAISES]([Id])
);
GO
USE PRONOSTICOS_DB
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PARTICIPANTES](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [Nombre] [varchar](100) NOT NULL,
    CONSTRAINT [PK_PARTICIPANTES] PRIMARY KEY CLUSTERED([Id] ASC)
);
GO
USE PRONOSTICOS_DB
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PRONOSTICOS](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [Participante] [int] NOT NULL,
    [Equipo_1] [int] NOT NULL,
    [Equipo_2] [int] NOT NULL,
    [Opcion] [bit] NOT NULL,
    CONSTRAINT [PK_PRONOSTICOS] PRIMARY KEY CLUSTERED([Id] ASC),
    CONSTRAINT [FK_Participante_Pronosticos] FOREIGN KEY ([Participante]) REFERENCES [dbo].[PARTICIPANTES]([Id]),
    CONSTRAINT [FK_Equipo1_Pronosticos] FOREIGN KEY ([Equipo_1]) REFERENCES [dbo].[PAISES]([Id]),
    CONSTRAINT [FK_Equipo2_Pronosticos] FOREIGN KEY ([Equipo_2]) REFERENCES [dbo].[PAISES]([Id])
);