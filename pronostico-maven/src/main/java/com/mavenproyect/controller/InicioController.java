package com.mavenproyect.controller;


import java.awt.EventQueue;
import java.util.List;

import com.mavenproyect.database.EquipoDAO;
import com.mavenproyect.database.ParticipanteDAO;
import com.mavenproyect.database.PartidoDAO;
import com.mavenproyect.database.PronosticoDAO;
import com.mavenproyect.model.Equipo;
import com.mavenproyect.model.Participante;
import com.mavenproyect.model.Partido;
import com.mavenproyect.vista.Inicio;
import com.mavenproyect.model.Pronostico;

public class InicioController {
	private static EquipoDAO equipoDAO;
	private static ParticipanteDAO participanteDAO;
	private static PartidoDAO partidoDAO;
	private static PronosticoDAO pronosticoDAO;
	private static List<Participante> participantes;
	private static List<Equipo> equipos;
	private static List<Partido> partidos;
	private static List<Pronostico> pronosticos;
	
	public static void getVistaInicio() {
		participanteDAO = new ParticipanteDAO();
		equipoDAO = new EquipoDAO();
		partidoDAO = new PartidoDAO(equipoDAO);
		pronosticoDAO = new PronosticoDAO(participanteDAO, partidoDAO, equipoDAO);

		participantes = participanteDAO.seleccionarTodos();
		equipos = equipoDAO.seleccionarTodos();
		partidos = partidoDAO.seleccionarTodos();
		pronosticos = pronosticoDAO.seleccionarTodos();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio(participantes, equipos, partidos, pronosticos);// Envio a la capa vista los objetos cargados
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

