-- Cargar tablas:
USE pronosticos_db;

-- Cargar participantes
INSERT INTO participantes VALUES (DEFAULT, 'Guillermo');
INSERT INTO participantes VALUES (DEFAULT, 'Chechu');
INSERT INTO participantes VALUES (DEFAULT, 'Facuu');
INSERT INTO participantes VALUES (DEFAULT, 'Patricio');

-- Cargar paises
-- Grupo A: Catar, Ecuador, Senegal, Países Bajos
INSERT INTO paises VALUES (DEFAULT, 'Catar');
INSERT INTO paises VALUES (DEFAULT, 'Ecuador');
INSERT INTO paises VALUES (DEFAULT, 'Senegal');
INSERT INTO paises VALUES (DEFAULT, 'Países Bajos');

-- Grupo B: Inglaterra, República Islámica de Irán, Estados Unidos, Gales
INSERT INTO paises VALUES (DEFAULT, 'Inglaterra');
INSERT INTO paises VALUES (DEFAULT, 'Irán');
INSERT INTO paises VALUES (DEFAULT, 'Estados Unidos');
INSERT INTO paises VALUES (DEFAULT, 'Gales');

-- Grupo C: Argentina, Arabia Saudí, México, Polonia
INSERT INTO paises VALUES (DEFAULT, 'Argentina');
INSERT INTO paises VALUES (DEFAULT, 'Arabia Saudí');
INSERT INTO paises VALUES (DEFAULT, 'México');
INSERT INTO paises VALUES (DEFAULT, 'Polonia');

-- Grupo D: Francia, Australia, Dinamarca, Túnez
INSERT INTO paises VALUES (DEFAULT, 'Francia');
INSERT INTO paises VALUES (DEFAULT, 'Australia');
INSERT INTO paises VALUES (DEFAULT, 'Dinamarca');
INSERT INTO paises VALUES (DEFAULT, 'Túnez');

-- Grupo E: España, Costa Rica, Alemania, Japón
INSERT INTO paises VALUES (DEFAULT, 'España');
INSERT INTO paises VALUES (DEFAULT, 'Costa Rica');
INSERT INTO paises VALUES (DEFAULT, 'Alemania');
INSERT INTO paises VALUES (DEFAULT, 'Japón');

-- Grupo F: Bélgica, Canadá, Morruecos, Croacia
INSERT INTO paises VALUES (DEFAULT, 'Bélgica');
INSERT INTO paises VALUES (DEFAULT, 'Canadá');
INSERT INTO paises VALUES (DEFAULT, 'Morruecos');
INSERT INTO paises VALUES (DEFAULT, 'Croacia');

-- Grupo G: Brasil, Serbia, Suiza, Camerún
INSERT INTO paises VALUES (DEFAULT, 'Brasil');
INSERT INTO paises VALUES (DEFAULT, 'Serbia');
INSERT INTO paises VALUES (DEFAULT, 'Suiza');
INSERT INTO paises VALUES (DEFAULT, 'Camerún');

-- Grupo H: Portugal, Ghana, Uruguay, República de Corea
INSERT INTO paises VALUES (DEFAULT, 'Portugal');
INSERT INTO paises VALUES (DEFAULT, 'Ghana');
INSERT INTO paises VALUES (DEFAULT, 'Uruguay');
INSERT INTO paises VALUES (DEFAULT, 'Corea');

-- Cargar resultados
-- Resultados y marcadores del grupo A
-- Catar 0-2 Ecuador
INSERT INTO resultados VALUES (DEFAULT, 'A',1,0,2,2);
-- Senegal 0-2 Países Bajos
INSERT INTO resultados VALUES (DEFAULT, 'A',3,0,4,2);
-- Catar 1-3 Senegal
INSERT INTO resultados VALUES (DEFAULT, 'A',1,1,3,3);
-- Países Bajos 1-1 Ecuador
INSERT INTO resultados VALUES (DEFAULT, 'A',4,1,2,1);
-- Ecuador 1-2 Senegal
INSERT INTO resultados VALUES (DEFAULT, 'A',2,1,3,2);
-- Países Bajos 2-0 Catar
INSERT INTO resultados VALUES (DEFAULT, 'A',4,2,1,0);

-- resultados y marcadores del grupo B
-- Inglaterra 6-2 Irán
INSERT INTO resultados VALUES (DEFAULT, 'B',5,6,6,2);
-- Estados Unidos 1-1 Gales
INSERT INTO resultados VALUES (DEFAULT, 'B',7,1,8,1);
-- Gales 0-2 Irán
INSERT INTO resultados VALUES (DEFAULT, 'B',8,0,6,2);
-- Inglaterra 0-0 Estados Unidos
INSERT INTO resultados VALUES (DEFAULT, 'B',5,0,7,0);
-- Gales 0-3 Inglaterra
INSERT INTO resultados VALUES (DEFAULT, 'B',8,0,5,3);
-- Irán 0-1 Estados Unidos
INSERT INTO resultados VALUES (DEFAULT, 'B',6,0,7,1);

-- resultados y marcadores del grupo C
-- Argentina 1-2 Arabia Saudí
INSERT INTO resultados VALUES (DEFAULT, 'C',9,1,10,2);
-- México 0-0 Polonia
INSERT INTO resultados VALUES (DEFAULT, 'C',11,0,12,0);
-- Polonia 2-0 Arabia Saudí
INSERT INTO resultados VALUES (DEFAULT, 'C',12,2,10,0);
-- Argentina 2-0 México
INSERT INTO resultados VALUES (DEFAULT, 'C',9,2,11,0);
-- Polonia 0-2 Argentina
INSERT INTO resultados VALUES (DEFAULT, 'C',12,0,9,2);
-- Arabia Saudí 1-2 México
INSERT INTO resultados VALUES (DEFAULT, 'C',10,1,11,2);

-- resultados y marcadores del grupo D
-- Dinamarca 0-0 Túnez
INSERT INTO resultados VALUES (DEFAULT, 'D',15,0,16,0);
-- Francia 4-1 Australia
INSERT INTO resultados VALUES (DEFAULT, 'D',13,4,14,1);
-- Túnez 0-1 Australia
INSERT INTO resultados VALUES (DEFAULT, 'D',16,0,14,1);
-- Francia 2-1 Dinamarca
INSERT INTO resultados VALUES (DEFAULT, 'D',13,2,15,1);
-- Australia 1-0 Dinamarca
INSERT INTO resultados VALUES (DEFAULT, 'D',14,1,15,0);
-- Túnez 1-0 Francia
INSERT INTO resultados VALUES (DEFAULT, 'D',16,1,13,0);

-- resultados y marcadores del grupo E
-- Alemania 1-2 Japón
INSERT INTO resultados VALUES (DEFAULT, 'E',19,1,20,2);
-- España 7-0 Costa Rica
INSERT INTO resultados VALUES (DEFAULT, 'E',17,7,18,0);
-- Japón 0-1 Costa Rica
INSERT INTO resultados VALUES (DEFAULT, 'E',20,0,18,1);
-- España 1-1 Alemania
INSERT INTO resultados VALUES (DEFAULT, 'E',17,1,19,1);
-- Japón 2-1 España
INSERT INTO resultados VALUES (DEFAULT, 'E',20,2,17,1);
-- Costa Rica 2-4 Alemania
INSERT INTO resultados VALUES (DEFAULT, 'E',18,2,19,4);

-- resultados y marcadores del grupo F
-- Marruecos 0-0 Croacia
INSERT INTO resultados VALUES (DEFAULT, 'F',23,0,24,0);
-- Bélgica 1-0 Canadá
INSERT INTO resultados VALUES (DEFAULT, 'F',21,1,22,0);
-- Bélgica 0-2 Marruecos
INSERT INTO resultados VALUES (DEFAULT, 'F',21,0,23,2);
-- Croacia 4-1 Canadá
INSERT INTO resultados VALUES (DEFAULT, 'F',24,4,22,1);
-- Croacia 0-0 Bélgica
INSERT INTO resultados VALUES (DEFAULT, 'F',24,0,21,0);
-- Canadá 1-2 Marruecos
INSERT INTO resultados VALUES (DEFAULT, 'F',22,1,23,2);

-- resultados y marcadores del grupo G
-- Suiza 1-0 Camerún
INSERT INTO resultados VALUES (DEFAULT, 'G',27,1,28,0);
-- Brasil 2-0 Serbia
INSERT INTO resultados VALUES (DEFAULT, 'G',25,2,26,0);
-- Camerún 3-3 Serbia
INSERT INTO resultados VALUES (DEFAULT, 'G',28,3,26,3);
-- Brasil 1-0 Suiza
INSERT INTO resultados VALUES (DEFAULT, 'G',25,1,27,0);
-- Camerún 1-0 Brasil
INSERT INTO resultados VALUES (DEFAULT, 'G',28,1,25,0);
-- Serbia 2-3 Suiza
INSERT INTO resultados VALUES (DEFAULT, 'G',26,2,27,3);

-- resultados y marcadores del grupo H
-- Uruguay 0-0 República de Corea
INSERT INTO resultados VALUES (DEFAULT, 'H',31,0,32,0);
-- Ghana 2-3 Portugal
INSERT INTO resultados VALUES (DEFAULT, 'H',30,2,29,3);
-- República de Corea 2-3 Ghana
INSERT INTO resultados VALUES (DEFAULT, 'H',32,2,30,3);
-- Portugal 2-0 Uruguay
INSERT INTO resultados VALUES (DEFAULT, 'H',29,2,31,0);
-- República de Corea 2-1 Portugal
INSERT INTO resultados VALUES (DEFAULT, 'H',32,2,29,1);
-- Ghana 0-2 Uruguay
INSERT INTO resultados VALUES (DEFAULT, 'H',30,0,31,2);

-- pronosticos
INSERT INTO pronosticos VALUES (DEFAULT, 3,20,13,'E');
INSERT INTO pronosticos VALUES (DEFAULT, 1,12,6,'G');
INSERT INTO pronosticos VALUES (DEFAULT, 2,13,9,'G');
INSERT INTO pronosticos VALUES (DEFAULT, 4,44,30,'P');