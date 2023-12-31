-- Cargar tablas:
GO
USE PRONOSTICOS_DB
GO
------------ Cargar PARTICIPANTES
INSERT INTO PARTICIPANTES VALUES ('Guillermo')
INSERT INTO PARTICIPANTES VALUES ('Chechu')
INSERT INTO PARTICIPANTES VALUES ('Facuu')
INSERT INTO PARTICIPANTES VALUES ('Patricio')

------------ Cargar PAISES
-- Grupo A: Catar, Ecuador, Senegal, Pa�ses Bajos
INSERT INTO PAISES VALUES ('Catar')
INSERT INTO PAISES VALUES ('Ecuador')
INSERT INTO PAISES VALUES ('Senegal')
INSERT INTO PAISES VALUES ('Pa�ses Bajos')

-- Grupo B: Inglaterra, Rep�blica Isl�mica de Ir�n, Estados Unidos, Gales
INSERT INTO PAISES VALUES ('Inglaterra')
INSERT INTO PAISES VALUES ('Ir�n')
INSERT INTO PAISES VALUES ('Estados Unidos')
INSERT INTO PAISES VALUES ('Gales')

-- Grupo C: Argentina, Arabia Saud�, M�xico, Polonia
INSERT INTO PAISES VALUES ('Argentina')
INSERT INTO PAISES VALUES ('Arabia Saud�')
INSERT INTO PAISES VALUES ('M�xico')
INSERT INTO PAISES VALUES ('Polonia')

-- Grupo D: Francia, Australia, Dinamarca, T�nez
INSERT INTO PAISES VALUES ('Francia')
INSERT INTO PAISES VALUES ('Australia')
INSERT INTO PAISES VALUES ('Dinamarca')
INSERT INTO PAISES VALUES ('T�nez')

-- Grupo E: Espa�a, Costa Rica, Alemania, Jap�n
INSERT INTO PAISES VALUES ('Espa�a')
INSERT INTO PAISES VALUES ('Costa Rica')
INSERT INTO PAISES VALUES ('Alemania')
INSERT INTO PAISES VALUES ('Jap�n')

-- Grupo F: B�lgica, Canad�, Morruecos, Croacia
INSERT INTO PAISES VALUES ('B�lgica')
INSERT INTO PAISES VALUES ('Canad�')
INSERT INTO PAISES VALUES ('Morruecos')
INSERT INTO PAISES VALUES ('Croacia')

-- Grupo G: Brasil, Serbia, Suiza, Camer�n
INSERT INTO PAISES VALUES ('Brasil')
INSERT INTO PAISES VALUES ('Serbia')
INSERT INTO PAISES VALUES ('Suiza')
INSERT INTO PAISES VALUES ('Camer�n')

-- Grupo H: Portugal, Ghana, Uruguay, Rep�blica de Corea
INSERT INTO PAISES VALUES ('Portugal')
INSERT INTO PAISES VALUES ('Ghana')
INSERT INTO PAISES VALUES ('Uruguay')
INSERT INTO PAISES VALUES ('Corea')

---------- Cargar RESULTADOS
-- Resultados y marcadores del grupo A
-- Catar 0-2 Ecuador
INSERT INTO RESULTADOS VALUES ('A',1,0,2,2)
-- Senegal 0-2 Pa�ses Bajos
INSERT INTO RESULTADOS VALUES ('A',3,0,4,2)
-- Catar 1-3 Senegal
INSERT INTO RESULTADOS VALUES ('A',1,1,3,3)
-- Pa�ses Bajos 1-1 Ecuador
INSERT INTO RESULTADOS VALUES ('A',4,1,2,1)
-- Ecuador 1-2 Senegal
INSERT INTO RESULTADOS VALUES ('A',2,1,3,2)
-- Pa�ses Bajos 2-0 Catar
INSERT INTO RESULTADOS VALUES ('A',4,2,1,0)

-- Resultados y marcadores del grupo B
-- Inglaterra 6-2 Ir�n
INSERT INTO RESULTADOS VALUES ('B',5,6,6,2)
-- Estados Unidos 1-1 Gales
INSERT INTO RESULTADOS VALUES ('B',7,1,8,1)
-- Gales 0-2 Ir�n
INSERT INTO RESULTADOS VALUES ('B',8,0,6,2)
-- Inglaterra 0-0 Estados Unidos
INSERT INTO RESULTADOS VALUES ('B',5,0,7,0)
-- Gales 0-3 Inglaterra
INSERT INTO RESULTADOS VALUES ('B',8,0,5,3)
-- Ir�n 0-1 Estados Unidos
INSERT INTO RESULTADOS VALUES ('B',6,0,7,1)

-- Resultados y marcadores del grupo C
-- Argentina 1-2 Arabia Saud�
INSERT INTO RESULTADOS VALUES ('C',9,1,10,2)
-- M�xico 0-0 Polonia
INSERT INTO RESULTADOS VALUES ('C',11,0,12,0)
-- Polonia 2-0 Arabia Saud�
INSERT INTO RESULTADOS VALUES ('C',12,2,10,0)
-- Argentina 2-0 M�xico
INSERT INTO RESULTADOS VALUES ('C',9,2,11,0)
-- Polonia 0-2 Argentina
INSERT INTO RESULTADOS VALUES ('C',12,0,9,2)
-- Arabia Saud� 1-2 M�xico
INSERT INTO RESULTADOS VALUES ('C',10,1,11,2)

-- Resultados y marcadores del grupo D
-- Dinamarca 0-0 T�nez
INSERT INTO RESULTADOS VALUES ('D',15,0,16,0)
-- Francia 4-1 Australia
INSERT INTO RESULTADOS VALUES ('D',13,4,14,1)
-- T�nez 0-1 Australia
INSERT INTO RESULTADOS VALUES ('D',16,0,14,1)
-- Francia 2-1 Dinamarca
INSERT INTO RESULTADOS VALUES ('D',13,2,15,1)
-- Australia 1-0 Dinamarca
INSERT INTO RESULTADOS VALUES ('D',14,1,15,0)
-- T�nez 1-0 Francia
INSERT INTO RESULTADOS VALUES ('D',16,1,13,0)

-- Resultados y marcadores del grupo E
-- Alemania 1-2 Jap�n
INSERT INTO RESULTADOS VALUES ('E',19,1,20,2)
-- Espa�a 7-0 Costa Rica
INSERT INTO RESULTADOS VALUES ('E',17,7,18,0)
-- Jap�n 0-1 Costa Rica
INSERT INTO RESULTADOS VALUES ('E',20,0,18,1)
-- Espa�a 1-1 Alemania
INSERT INTO RESULTADOS VALUES ('E',17,1,19,1)
-- Jap�n 2-1 Espa�a
INSERT INTO RESULTADOS VALUES ('E',20,2,17,1)
-- Costa Rica 2-4 Alemania
INSERT INTO RESULTADOS VALUES ('E',18,2,19,4)

-- Resultados y marcadores del grupo F
-- Marruecos 0-0 Croacia
INSERT INTO RESULTADOS VALUES ('F',23,0,24,0)
-- B�lgica 1-0 Canad�
INSERT INTO RESULTADOS VALUES ('F',21,1,22,0)
-- B�lgica 0-2 Marruecos
INSERT INTO RESULTADOS VALUES ('F',21,0,23,2)
-- Croacia 4-1 Canad�
INSERT INTO RESULTADOS VALUES ('F',24,4,22,1)
-- Croacia 0-0 B�lgica
INSERT INTO RESULTADOS VALUES ('F',24,0,21,0)
-- Canad� 1-2 Marruecos
INSERT INTO RESULTADOS VALUES ('F',22,1,23,2)

-- Resultados y marcadores del grupo G
-- Suiza 1-0 Camer�n
INSERT INTO RESULTADOS VALUES ('G',27,1,28,0)
-- Brasil 2-0 Serbia
INSERT INTO RESULTADOS VALUES ('G',25,2,26,0)
-- Camer�n 3-3 Serbia
INSERT INTO RESULTADOS VALUES ('G',28,3,26,3)
-- Brasil 1-0 Suiza
INSERT INTO RESULTADOS VALUES ('G',25,1,27,0)
-- Camer�n 1-0 Brasil
INSERT INTO RESULTADOS VALUES ('G',28,1,25,0)
-- Serbia 2-3 Suiza
INSERT INTO RESULTADOS VALUES ('G',26,2,27,3)

-- Resultados y marcadores del grupo H
-- Uruguay 0-0 Rep�blica de Corea
INSERT INTO RESULTADOS VALUES ('H',31,0,32,0)
-- Ghana 2-3 Portugal
INSERT INTO RESULTADOS VALUES ('H',30,2,29,3)
-- Rep�blica de Corea 2-3 Ghana
INSERT INTO RESULTADOS VALUES ('H',32,2,30,3)
-- Portugal 2-0 Uruguay
INSERT INTO RESULTADOS VALUES ('H',29,2,31,0)
-- Rep�blica de Corea 2-1 Portugal
INSERT INTO RESULTADOS VALUES ('H',32,2,29,1)
-- Ghana 0-2 Uruguay
INSERT INTO RESULTADOS VALUES ('H',30,0,31,2)

-- Pronosticos
INSERT INTO PRONOSTICOS VALUES (3,20,13,'E')
INSERT INTO PRONOSTICOS VALUES (1,12,6,'G')
INSERT INTO PRONOSTICOS VALUES (2,13,9,'G')
INSERT INTO PRONOSTICOS VALUES (4,44,30,'P')