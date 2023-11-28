package com.mavenproyect.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mavenproyect.model.*;
import com.mavenproyect.database.*;

public class Inicio extends JFrame {

	// Para guardar las listas del constructor
	private List<Participante> participantes;
	private List<Equipo> equipos;
	private List<Partido> partidos;
	private List<Pronostico> pronosticos;
	private Container contentPaneTables;
	
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	private JTable table;
	public Inicio(List<Participante> participantes, List<Equipo> equipos, List<Partido> partidos, List<Pronostico> pronosticos) {
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);// Centra la ventana
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Para mostrar en tablas:
		this.participantes=new ArrayList<Participante>();
		this.participantes.addAll(participantes);
		this.equipos=new ArrayList<Equipo>();
		this.equipos.addAll(equipos);
		this.partidos=new ArrayList<Partido>();
		this.partidos.addAll(partidos);
		this.pronosticos=new ArrayList<Pronostico>();
		pronosticos.addAll(pronosticos);
		
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
		
		JMenuItem mntmNewMenuItem_ListarPartidosPorCantidadDeGolesTotalesDelPartido = new JMenuItem("Por cantidad de goles totales");
		mnNewMenu_PartidosJugados_listar.add(mntmNewMenuItem_ListarPartidosPorCantidadDeGolesTotalesDelPartido);
	}
	
	
	private void cargarJTableJugadores() {
		DefaultTableModel tableModel = new DefaultTableModel() {
			 @Override
             public boolean isCellEditable(int row, int column) {
                 return false; // Hacer que todas las celdas sean de solo lectura
             }
		};
		table = new JTable(tableModel);
		
		
		tableModel.addColumn("Participante");
		
 		int aux=0;
 		ParticipanteDAO participantes = new ParticipanteDAO();
 		List<Participante> todosLosParticipantes = participantes.seleccionarTodos();
 		for(Participante participan:todosLosParticipantes) {
			String nombre=participan.getNombre();
			tableModel.insertRow(aux++, new Object[] { nombre});
		}
		int x=0,y=30;
		int w=100,h=470;
		table.setBounds(x, y, w, h);
		
		// Crear un panel para los títulos de las columnas
        JPanel headerPanel = new JPanel(new GridLayout(1, tableModel.getColumnCount()));
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            JLabel label = new JLabel(tableModel.getColumnName(i));
            headerPanel.add(label);
        }

        // Crear un JScrollPane que contiene la JTable
        JScrollPane scrollPane = new JScrollPane(table);

        // Configurar la ubicación y tamaño del JScrollPane en el contenedor
        scrollPane.setBounds(x, y, w, h);
        
        // Obtener el contenedor del JFrame
        contentPaneTables = getContentPane();

        // Agregar el panel de títulos y el JScrollPane al contenedor
        contentPaneTables.add(headerPanel, BorderLayout.NORTH);
        contentPaneTables.add(scrollPane, BorderLayout.CENTER);				
	}
	
	private void cargarJTableEquipos() {
		DefaultTableModel tableModel = new DefaultTableModel() {
			 @Override
             public boolean isCellEditable(int row, int column) {
                 return false; // Hacer que todas las celdas sean de solo lectura
             }
		};
		table = new JTable(tableModel);
		
		
		tableModel.addColumn("País");
		
 		int aux=0;
		for(Equipo equipo:equipos) {
			String nombre=equipo.getNombre();
			tableModel.insertRow(aux++, new Object[] { nombre});
				
		}
		int x=100,y=30;
		int w=100,h=470;
		table.setBounds(x, y, w, h);
		
		// Crear un panel para los títulos de las columnas
        JPanel headerPanel = new JPanel(new GridLayout(1, tableModel.getColumnCount()));
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            JLabel label = new JLabel(tableModel.getColumnName(i));
            headerPanel.add(label);
        }

        // Crear un JScrollPane que contiene la JTable
        JScrollPane scrollPane = new JScrollPane(table);

        // Configurar la ubicación y tamaño del JScrollPane en el contenedor
        scrollPane.setBounds(x, y, w, h);
        
        // Obtener el contenedor del JFrame
        contentPaneTables = getContentPane();

        // Agregar el panel de títulos y el JScrollPane al contenedor
        contentPaneTables.add(headerPanel, BorderLayout.NORTH);
        contentPaneTables.add(scrollPane, BorderLayout.CENTER);				
	}
	
	private void cargarJTablePartidos() {
		DefaultTableModel tableModel = new DefaultTableModel() {
			 @Override
             public boolean isCellEditable(int row, int column) {
                 return false; // Hacer que todas las celdas sean de solo lectura
             }
		};
		table = new JTable(tableModel);
		
		
		tableModel.addColumn("Grupo");
		tableModel.addColumn("País");
		tableModel.addColumn("Goles");
		tableModel.addColumn("País");
		tableModel.addColumn("Goles");
		
 		int aux=0;
		for(Partido partido:partidos) {
			char grupo=partido.getGrupo();
			String equipo1=partido.getEquipo1().getNombre();
			int golesEquipo1=partido.getGolesEquipo1();
			String equipo2=partido.getEquipo2().getNombre();
			int golesEquipo2=partido.getGolesEquipo2();
			tableModel.insertRow(aux++, new Object[] {grupo,equipo1,golesEquipo1,equipo2,golesEquipo2});
				
		}
		int x=200,y=30;
		int w=500,h=270;
		table.setBounds(x, y, w, h);
		
		// Crear un panel para los títulos de las columnas
        JPanel headerPanel = new JPanel(new GridLayout(1, tableModel.getColumnCount()));
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            JLabel label = new JLabel(tableModel.getColumnName(i));
            headerPanel.add(label);
        }

        // Crear un JScrollPane que contiene la JTable
        JScrollPane scrollPane = new JScrollPane(table);

        // Configurar la ubicación y tamaño del JScrollPane en el contenedor
        scrollPane.setBounds(x, y, w, h);
        
        // Obtener el contenedor del JFrame
        contentPaneTables = getContentPane();

        // Agregar el panel de títulos y el JScrollPane al contenedor
        contentPaneTables.add(headerPanel, BorderLayout.NORTH);
        contentPaneTables.add(scrollPane, BorderLayout.CENTER);				
	}
	private void cargarJTablePronosticos() {
		DefaultTableModel tableModel = new DefaultTableModel() {
			 @Override
             public boolean isCellEditable(int row, int column) {
                 return false; // Hacer que todas las celdas sean de solo lectura
             }
		};
		table = new JTable(tableModel);
		
		
		tableModel.addColumn("Participante");
		tableModel.addColumn("Partido (ID)");
		tableModel.addColumn("País");
		tableModel.addColumn("opcion");
		
 		int aux=0;
		for(Pronostico pronostico:pronosticos) {
			String participante=pronostico.getParticipante().getNombre();
			int partido=pronostico.getPartido().getID();
			String pais=pronostico.getEquipo().getNombre();
			char opcion=pronostico.getOpcion();
			tableModel.insertRow(aux++, new Object[] {participante,partido,pais,opcion});
				
		}
		int x=200,y=300;
		int w=500,h=200;
		table.setBounds(x, y, w, h);
		
		// Crear un panel para los títulos de las columnas
        JPanel headerPanel = new JPanel(new GridLayout(1, tableModel.getColumnCount()));
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            JLabel label = new JLabel(tableModel.getColumnName(i));
            headerPanel.add(label);
        }

        // Crear un JScrollPane que contiene la JTable
        JScrollPane scrollPane = new JScrollPane(table);

        // Configurar la ubicación y tamaño del JScrollPane en el contenedor
        scrollPane.setBounds(x, y, w, h);
        
        // Obtener el contenedor del JFrame
        contentPaneTables = getContentPane();

        // Agregar el panel de títulos y el JScrollPane al contenedor
        contentPaneTables.add(headerPanel, BorderLayout.NORTH);
        contentPaneTables.add(scrollPane, BorderLayout.CENTER);				
	}

}

/**
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
import javax.swing.JTable;

import com.mavenproyect.model.Equipo;
import com.mavenproyect.model.Participante;
import com.mavenproyect.model.Partido;


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
		this.participantes = participantes;
		this.equipos = equipos;
		this.partidos = partidos;
		
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
//				cargarJTableJugadores(); // TODO: No esta implementada la funcion
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
//				cargarJTablePronosticos(); // TODO: No esta implementada la funcion
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
//				cargarJTableJugadores(); // TODO: No esta implementada la funcion
//				cargarJTableEquipos(); // TODO: No esta implementada la funcion
//				cargarJTablePartidos(); // TODO: No esta implementada la funcion
//				cargarJTablePronosticos();	// TODO: No esta implementada la funcion
			}
		});
		menuBarSuperior.add(mntmNewMenuItemTodosLosDatos);
	}
	
	private void ListarTodosLosEquipos() {
		JMenuItem mntmNewMenuItemListarTodosLosEquipos = new JMenuItem("Todos");

		mntmNewMenuItemListarTodosLosEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				cargarJTableEquipos(); // TODO: No esta implementada la funcion
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
//				cargarJTablePartidos();	// TODO: No esta implementada la funcion
			}
		});
		mnNewMenu_PartidosJugados_listar.add(mntmNewMenuItemAgregarPartidosJugadosListarPorGrupos);



//		JMenuItem // TODO: Se esta reasignando variable ya existente
				mntmNewMenuItemAgregarPartidosJugadosListarPorGrupos = new JMenuItem("Por grupos");
		
		mnNewMenu_PartidosJugados_listar.add(mntmNewMenuItemAgregarPartidosJugadosListarPorGrupos);
		
		JMenuItem mntmNewMenuItem_ListarPartidosPorCantidadDeGolesTotalesDelPartido = new JMenuItem("Por cantidad de goles totales");
		mnNewMenu_PartidosJugados_listar.add(mntmNewMenuItem_ListarPartidosPorCantidadDeGolesTotalesDelPartido);
	}
}
 * */

