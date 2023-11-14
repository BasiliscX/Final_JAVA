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
JOIN PAISES P1 ON P1.Id = R.Equipo_1
JOIN PAISES P2 ON P2.Id = R.Equipo_2;
