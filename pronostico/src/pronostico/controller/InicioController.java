package pronostico.controller;

import java.awt.EventQueue;

import pronostico.vista.Inicio;

public class InicioController {

	public static void getVistaInicio() {
		EventQueue.invokeLater(new Runnable() {// Este bloque en conexion
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
