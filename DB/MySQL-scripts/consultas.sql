-- Algunas consultas
USE pronosticos_db;

-- participantes para los pronósticos
SELECT p.id, p.nombre AS participante FROM participantes p;

-- países de la copa
SELECT p.id, p.nombre AS pais FROM paises p;

-- resultados
SELECT r.grupo, 
       p1.nombre AS paisEquipo1, 
       r.cantidad_goles_1 AS GolesEquipo1, 
       p2.nombre AS paisEquipo2, 
       r.cantidad_goles_2 AS GolesEquipo2
FROM resultados r
JOIN paises p1 ON p1.id = r.id_equipo_1
JOIN paises p2 ON p2.id = r.id_equipo_2;

-- pronósticos
SELECT par.nombre AS participante,
	   p.id_resultado AS partido,
	   pai.nombre AS pais,
	   p.opcion_G_E_P AS GanapierdeEmpata
FROM pronosticos p
JOIN participantes par ON par.id = p.id_participante
JOIN paises pai ON pai.id = p.id_equipo;