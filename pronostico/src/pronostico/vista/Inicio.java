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
	
	//Variables para ser usadas por los metodos
	private JMenuBar menuBarSuperior = new JMenuBar();
	private JMenu mnNewMenuparticipantes = new JMenu("Participantes");
	private JMenu mnNewMenuEquipos = new JMenu("Equipos");
	private JMenu mnNewMenu_Equipos_listar = new JMenu("LIstar");
	private JMenu mnNewMenu_2Participantes = new JMenu("Acciones");
	private JMenu mnNewMenu_Pronostico = new JMenu("Acciones");
	
	
	private void MenuBarSuperiorComponentes() {
		menuBarSuperior.setBounds(0, 0, 789, 30);
		Participantes();
		Pronostico();
		Equipos();
		PartidosJugados();
		listarTodo();
	}	
	
	private void Participantes() {
		mnNewMenuparticipantes.add(mnNewMenu_2Participantes);
		AgregarParticipante();
		ListarParticipantes();
	}
	
	private void AgregarParticipante() {
		JMenuItem mntmNewMenuItemAgregarParticipante = new JMenuItem("Agregar participante");
		mntmNewMenuItemAgregarParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargarParticipantes cargarParticipantes=new CargarParticipantes();
				cargarParticipantes.setVisible(true);
			}
		});
		mnNewMenu_2Participantes.add(mntmNewMenuItemAgregarParticipante);
	}
	
	private void ListarParticipantes() {
		JMenuItem mntmNewMenuItem_ListarParticipantes = new JMenuItem("Listar participantes");
		mnNewMenu_2Participantes.add(mntmNewMenuItem_ListarParticipantes);
		mntmNewMenuItem_ListarParticipantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarJTableJugadores();
			}
		});
	}
	
	private void Pronostico() {
		JMenu mnPronostico = new JMenu("Pronostico");
		menuBarSuperior.add(mnNewMenuparticipantes);
		menuBarSuperior.add(mnPronostico);
		
		mnPronostico.add(mnNewMenu_Pronostico);
		AgregarPronostico();
		ListarPronostico();
	}
	
	private void AgregarPronostico() {
		JMenuItem mntmAgregarPronostico = new JMenuItem("Agregar pronostico");
		mntmAgregarPronostico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargarPronosticos cargarPronosticos = new CargarPronosticos();
				cargarPronosticos.setVisible(true);
			}
		});
		mnNewMenu_Pronostico.add(mntmAgregarPronostico);
	}
	
	private void ListarPronostico() {		
		JMenuItem mntmNewMenuItem_ListarPronosticos = new JMenuItem("Listar pronosticos");
		mntmNewMenuItem_ListarPronosticos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarJTablePronosticos();
			}
		});

		
		mnNewMenu_Pronostico.add(mntmNewMenuItem_ListarPronosticos);
		
		contentPane.add(menuBarSuperior);
	}
	
	private void Equipos() {
		menuBarSuperior.add(mnNewMenuEquipos);
		mnNewMenuEquipos.add(mnNewMenu_Equipos_listar);
		EquiposOrdenAlfabetico();
		EquiposOrdenCantidadGoles();
		ListarTodosLosEquipos();
	}
	
	private void listarTodo() {
		JMenuItem mntmNewMenuItemTodosLosDatos = new JMenuItem("Todo (Participantes, equipos, partidos jugados y pronosticos)");
		mntmNewMenuItemTodosLosDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarJTableJugadores();
				cargarJTableEquipos();
				cargarJTablePartidos();
				cargarJTablePronosticos();
			}
		});
		menuBarSuperior.add(mntmNewMenuItemTodosLosDatos);
	}
	
	private void ListarTodosLosEquipos() {
		JMenuItem mntmNewMenuItemListarTodosLosEquipos = new JMenuItem("Todos");
		mntmNewMenuItemListarTodosLosEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarJTableEquipos();
			}
		});
		mnNewMenu_Equipos_listar.add(mntmNewMenuItemListarTodosLosEquipos);
	}
	
	private void EquiposOrdenAlfabetico() {
		JMenu mnNewMenuEquiposAlfabetico = new JMenu("Por orden alfabetico");
		mnNewMenu_Equipos_listar.add(mnNewMenuEquiposAlfabetico);
		
		JMenuItem mntmNewMenuItemEquiposAlfabeticoAscendente = new JMenuItem("Ascendente");
		mnNewMenuEquiposAlfabetico.add(mntmNewMenuItemEquiposAlfabeticoAscendente);
		
		JMenuItem mntmNewMenuItemEquiposAlfabeticoDescendente = new JMenuItem("Descendente");
		mnNewMenuEquiposAlfabetico.add(mntmNewMenuItemEquiposAlfabeticoDescendente);
	}
	
	private void EquiposOrdenCantidadGoles() {
		
		JMenu mnNewMenuEquiposCantidadGoles = new JMenu("Por cantidad de goles");
		mnNewMenu_Equipos_listar.add(mnNewMenuEquiposCantidadGoles);
		
		JMenuItem mntmNewMenuItemEquiposCantidadGolesAscendente = new JMenuItem("Ascendente");
		mnNewMenuEquiposCantidadGoles.add(mntmNewMenuItemEquiposCantidadGolesAscendente);
		
		JMenuItem mntmNewMenuItemEquiposCantidadGolesDescendente = new JMenuItem("Descendente");
		mnNewMenuEquiposCantidadGoles.add(mntmNewMenuItemEquiposCantidadGolesDescendente);
	}
	
	private void PartidosJugados() {
		
		JMenuBar menuBar = new JMenuBar();
		mnNewMenu_Equipos_listar.add(menuBar);
		ListarPartidosJugados();
	}	
	private void ListarPartidosJugados() {
		JMenu mnNewMenupartido = new JMenu("Partidos jugados");
		menuBarSuperior.add(mnNewMenupartido);
		
		JMenu mnNewMenu_PartidosJugados_listar = new JMenu("Listar");
		mnNewMenupartido.add(mnNewMenu_PartidosJugados_listar);
		
		JMenuItem mntmNewMenuItemAgregarPartidosJugadosListarPorGrupos = new JMenuItem("Por grupos");
		mntmNewMenuItemAgregarPartidosJugadosListarPorGrupos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarJTablePartidos();
			}
		});
		mnNewMenu_PartidosJugados_listar.add(mntmNewMenuItemAgregarPartidosJugadosListarPorGrupos);
		
		
		
		JMenuItem mntmNewMenuItemAgregarPartidosJugadosListarPorGrupos = new JMenuItem("Por grupos");
		
		mnNewMenu_PartidosJugados_listar.add(mntmNewMenuItemAgregarPartidosJugadosListarPorGrupos);
		
		JMenuItem mntmNewMenuItem_ListarPartidosPorCantidadDeGolesTotalesDelPartido = new JMenuItem("Por cantidad de goles totales");
		mnNewMenu_PartidosJugados_listar.add(mntmNewMenuItem_ListarPartidosPorCantidadDeGolesTotalesDelPartido);
	}
	
}

