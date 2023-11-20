-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS pronosticos_db;

-- Usar la base de datos
USE pronosticos_db;

-- Crear la tabla de paises
CREATE TABLE paises (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Crear la tabla de resultados
CREATE TABLE resultados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    grupo CHAR(1) NOT NULL,
    id_equipo_1 INT NOT NULL,
    cantidad_goles_1 INT NOT NULL,
    id_equipo_2 INT NOT NULL,
    cantidad_goles_2 INT NOT NULL,
    CONSTRAINT FK_id_equipo1 FOREIGN KEY (id_equipo_1) REFERENCES paises(id),
    CONSTRAINT FK_id_equipo2 FOREIGN KEY (id_equipo_2) REFERENCES paises(id)
);

-- Crear la tabla de participantes
CREATE TABLE participantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Crear la tabla de pronosticos
CREATE TABLE pronosticos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_participante INT NOT NULL,
    id_resultado INT NOT NULL,
    id_equipo INT NOT NULL,
    opcion_G_E_P CHAR(1) NOT NULL,
    CONSTRAINT FK_id_participante_pronosticos FOREIGN KEY (id_participante) REFERENCES participantes(id),
    CONSTRAINT FK_id_resultado_pronosticos FOREIGN KEY (id_resultado) REFERENCES resultados(id),
    CONSTRAINT FK_id_equipo_pronosticos FOREIGN KEY (id_equipo) REFERENCES paises(id)
);