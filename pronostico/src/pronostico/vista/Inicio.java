package pronostico.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pronostico.model.Equipo;
import pronostico.model.Participante;
import pronostico.model.Partido;
import javax.swing.JTable;

public class Inicio extends JFrame {

	// Para guardar las listas del constructor
	private List<Participante> participantes;
	private List<Equipo> equipos;
	private List<Partido> partidos;
	private JTable tablaPersonas;
	
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	public Inicio(List<Participante> participantes, List<Equipo> equipos, List<Partido> partidos) {
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 471);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);// Centra la ventana
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Para mostrar en tablas:
		this.participantes=new ArrayList<Participante>();
		this.participantes=participantes;
		this.equipos=new ArrayList<Equipo>();
		this.equipos=equipos;
		this.partidos=new ArrayList<Partido>();
		this.partidos=partidos;
		
		MenuBarSuperiorComponentes();
	}

	private void MenuBarSuperiorComponentes() {
		JMenuBar menuBarSuperior = new JMenuBar();
		menuBarSuperior.setBounds(0, 0, 789, 30);
		JMenu mnNewMenuparticipantes = new JMenu("Participantes");
		
		JMenu mnNewMenu_2Participantes = new JMenu("Acciones");
		mnNewMenuparticipantes.add(mnNewMenu_2Participantes);
		
		JMenuItem mntmNewMenuItemAgregarParticipante = new JMenuItem("Agregar participante");
		mntmNewMenuItemAgregarParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargarParticipantes cargarParticipantes=new CargarParticipantes();
				cargarParticipantes.setVisible(true);
			}
		});
		mnNewMenu_2Participantes.add(mntmNewMenuItemAgregarParticipante);
		
		JMenuItem mntmNewMenuItem_ListarParticipantes = new JMenuItem("Listar participantes");
		mnNewMenu_2Participantes.add(mntmNewMenuItem_ListarParticipantes);
		
		JMenu mnPronostico = new JMenu("Pronostico");
		menuBarSuperior.add(mnNewMenuparticipantes);
		menuBarSuperior.add(mnPronostico);
		
		JMenu mnNewMenu_Pronostico = new JMenu("Acciones");
		mnPronostico.add(mnNewMenu_Pronostico);
		
		JMenuItem mntmAgregarPronostico = new JMenuItem("Agregar pronostico");
		mntmAgregarPronostico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargarPronosticos cargarPronosticos = new CargarPronosticos();
				cargarPronosticos.setVisible(true);
			}
		});
		mnNewMenu_Pronostico.add(mntmAgregarPronostico);
		
		JMenuItem mntmNewMenuItem_ListarPronosticos = new JMenuItem("Listar pronosticos");
		mnNewMenu_Pronostico.add(mntmNewMenuItem_ListarPronosticos);
		
		contentPane.add(menuBarSuperior);
		
		JMenu mnNewMenuEquipos = new JMenu("Equipos");
		menuBarSuperior.add(mnNewMenuEquipos);
		
		JMenu mnNewMenu_Equipos_listar = new JMenu("LIstar");
		mnNewMenuEquipos.add(mnNewMenu_Equipos_listar);
		
		JMenu mnNewMenuEquiposAlfabetico = new JMenu("Por orden alfabetico");
		mnNewMenu_Equipos_listar.add(mnNewMenuEquiposAlfabetico);
		
		JMenuItem mntmNewMenuItemEquiposAlfabeticoAscendente = new JMenuItem("Ascendente");
		mnNewMenuEquiposAlfabetico.add(mntmNewMenuItemEquiposAlfabeticoAscendente);
		
		JMenuItem mntmNewMenuItemEquiposAlfabeticoDescendente = new JMenuItem("Descendente");
		mnNewMenuEquiposAlfabetico.add(mntmNewMenuItemEquiposAlfabeticoDescendente);
		
		JMenu mnNewMenuEquiposCantidadGoles = new JMenu("Por cantidad de goles");
		mnNewMenu_Equipos_listar.add(mnNewMenuEquiposCantidadGoles);
		
		JMenuItem mntmNewMenuItemEquiposCantidadGolesAscendente = new JMenuItem("Ascendente");
		mnNewMenuEquiposCantidadGoles.add(mntmNewMenuItemEquiposCantidadGolesAscendente);
		
		JMenuItem mntmNewMenuItemEquiposCantidadGolesDescendente = new JMenuItem("Descendente");
		mnNewMenuEquiposCantidadGoles.add(mntmNewMenuItemEquiposCantidadGolesDescendente);
		
		JMenuBar menuBar = new JMenuBar();
		mnNewMenu_Equipos_listar.add(menuBar);
		
		JMenu mnNewMenupartido = new JMenu("Partidos jugados");
		menuBarSuperior.add(mnNewMenupartido);
		
		JMenu mnNewMenu_PartidosJugados_listar = new JMenu("Listar");
		mnNewMenupartido.add(mnNewMenu_PartidosJugados_listar);
		
		JMenuItem mntmNewMenuItemAgregarPartidosJugadosListarPorGrupos = new JMenuItem("Por grupos");
		mnNewMenu_PartidosJugados_listar.add(mntmNewMenuItemAgregarPartidosJugadosListarPorGrupos);
		
		JMenuItem mntmNewMenuItem_ListarPartidosPorCantidadDeGolesTotalesDelPartido = new JMenuItem("Por cantidad de goles totales");
		mnNewMenu_PartidosJugados_listar.add(mntmNewMenuItem_ListarPartidosPorCantidadDeGolesTotalesDelPartido);
				
	}
}
