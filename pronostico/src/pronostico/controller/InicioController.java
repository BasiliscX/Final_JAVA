package pronostico.controller;


import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import pronostico.model.Equipo;
import pronostico.model.Participante;
import pronostico.model.Partido;
import pronostico.vista.Inicio;

public class InicioController {
	private static List<Participante> participantes;
	private static List<Equipo> equipos;
	private static List<Partido> partidos;
	
	public InicioController() {/** Desde este constructor se podrian cargar los
	 	objetos con los datos DB */
		
	// FORMA BURDA, PARA CAMBIAR POR CARGA DESDE BASE DE DATOS:
		algoAsiLoDebeHacerLaConexionALaDB();
	}
	
	public static void getVistaInicio() {
					
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio(participantes,equipos,partidos);// Envio a la capa vista los objetos cargados
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void algoAsiLoDebeHacerLaConexionALaDB() {
		// PARTICIPANTES:
		participantes=new ArrayList<Participante>();
		Participante aux=new Participante(1,"Guillermo");
		participantes.add(aux);
		aux=new Participante(2,"Chechu");
		participantes.add(aux);
		aux=new Participante(3,"facuu");
		participantes.add(aux);
		aux=new Participante(4,"Patricio");
		participantes.add(aux);
		aux=new Participante(5,"Nicolas");
		participantes.add(aux);
		aux=null;
		// EQUIPOS (PAISES):
		equipos=new ArrayList<Equipo>();
		Equipo aux1=new Equipo(1,"Catar");
		equipos.add(aux1);
		aux1=new Equipo(2,"Ecuador");
		equipos.add(aux1);
		aux1=new Equipo(3,"Senegal");
		equipos.add(aux1);
		aux1=new Equipo(4,"Países Bajos");
		equipos.add(aux1);
		aux1=new Equipo(5,"Inglaterra");
		equipos.add(aux1);
		aux1=new Equipo(6,"Irán");
		equipos.add(aux1);
		// PARTIDOS JUGADOS:
		partidos=new ArrayList<Partido>();
		// Cargo nuevamente los objetos equipo para partido:
		// A	Catar	0	Ecuador	2
		aux1=new Equipo(1,"Catar");
		Equipo aux2=new Equipo(2,"Ecuador");
		Partido aux3=new Partido(1,'A',aux1,0,aux2,1);
		partidos.add(aux3);
		// y repito:
		// A	Senegal	0	Países Bajos	2
		aux1=new Equipo(3,"Senegal");
		aux2=new Equipo(4,"Países Bajos");
		aux3=new Partido(1,'A',aux1,0,aux2,2);
		partidos.add(aux3);
		// A	Catar	1	Senegal	3
		aux1=new Equipo(1,"Catar");
		aux2=new Equipo(3,"Senegal");
		aux3=new Partido(1,'A',aux1,1,aux2,3);
		partidos.add(aux3);
		// A	Países Bajos	1	Ecuador	1
		aux1=new Equipo(4,"Países Bajos");
		aux2=new Equipo(2,"Ecuador");
		aux3=new Partido(1,'A',aux1,1,aux2,1);
		partidos.add(aux3);
		// A	Ecuador	1	Senegal	2
		aux1=new Equipo(2,"Ecuador");
		aux2=new Equipo(3,"Senegal");
		aux3=new Partido(1,'A',aux1,1,aux2,2);
		partidos.add(aux3);
		aux1=null;
		aux2=null;
		aux3=null;
	}
}

