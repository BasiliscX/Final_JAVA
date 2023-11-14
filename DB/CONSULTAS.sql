-- Algunas consultas
GO
USE PRONOSTICOS_DB
GO

-- Pariticipantes para los pronosticos
select P.Id, P.Nombre AS participante from PARTICIPANTES P

-- Paises de la copa
select P.Id, P.Nombre AS Pais from PAISES P

-- Resultados
SELECT R.Grupo, 
       P1.Nombre AS Pais, 
       R.Cantidad_goles_1 AS Goles, 
       P2.Nombre AS Pais, 
       R.Cantidad_goles_2 AS Goles
FROM RESULTADOS R
JOIN PAISES P1 ON P1.Id = R.ID_Equipo_1
JOIN PAISES P2 ON P2.Id = R.ID_Equipo_2;

-- Pronosticos
SELECT PAR.Nombre AS Participante,
	   P.ID_Resultado AS Partido,
	   PAI.Nombre AS Pais,
	   P.Opcion_G_E_P AS GanaPierdeEmpata
FROM PRONOSTICOS P
JOIN PARTICIPANTES PAR ON PAR.Id = p.ID_Participante
JOIN PAISES PAI ON PAI.Id = P.ID_Equipo

