package com.mavenproyect.vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import com.mavenproyect.database.EquipoDAO;
import com.mavenproyect.database.ParticipanteDAO;
import com.mavenproyect.database.PartidoDAO;
import com.mavenproyect.database.PronosticoDAO;
import com.mavenproyect.model.Equipo;
import com.mavenproyect.model.Participante;
import com.mavenproyect.model.Partido;
import com.mavenproyect.model.Pronostico;

public class CargarPronosticos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<Participante> participantes;
	private List<Equipo> equipos;
	private List<Partido> partidos;
	private List<Pronostico> pronosticos;
	private char eleccion;
	
	public CargarPronosticos(List<Participante> participantes,List<Partido> partidos,List<Equipo> equipos,List<Pronostico> pronosticos) {
		this.participantes=new ArrayList<Participante>();
		this.participantes.addAll(participantes);		
		this.equipos=new ArrayList<Equipo>();
		this.equipos.addAll(equipos);
		this.partidos=new ArrayList<Partido>();
		this.partidos.addAll(partidos);
		this.pronosticos=new ArrayList<Pronostico>();
		this.pronosticos.addAll(pronosticos);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 423, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);// Centra la ventana

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cargarLbls();
		cargarBotones();
		cargarJComboBox();
		cargarRadioButtons();
	}
	
	private void cargarLbls() {
		JLabel lblParticipante = new JLabel("Participante");
		lblParticipante.setBounds(59, 115, 74, 23);
		contentPane.add(lblParticipante);
		
		JLabel lblPartido = new JLabel("Partido");
		lblPartido.setBounds(59, 159, 74, 23);
		contentPane.add(lblPartido);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(59, 202, 74, 23);
		contentPane.add(lblEquipo);
		
		JLabel lblCargarPronostico = new JLabel("Pronostico");
		lblCargarPronostico.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCargarPronostico.setBounds(116, 11, 147, 49);
		contentPane.add(lblCargarPronostico);

	}
	
	//---------------- CARGAR COMPONENTES ---------------------//
	
	
	private void cargarBotones() {
		/**
		JButton btnCargarPronosticoAceptar = new JButton("Aceptar");
		contentPane.add(btnCargarPronosticoAceptar);
		 * */
		
		JButton btnCargarPronosticoCancelar = new JButton("Cancelar");
		btnCargarPronosticoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarPanel();
			}
		});
		btnCargarPronosticoCancelar.setBounds(10, 326, 180, 23);
        
		contentPane.add(btnCargarPronosticoCancelar);
		
	}
		
	
	private void cargarJComboBox() {
 		
		ParticipanteDAO participantes = new ParticipanteDAO();
 		List<Participante> todosLosParticipantes = participantes.seleccionarTodos();
 		String[]nombres=new String[todosLosParticipantes.size()];
 		int i=0;
 		for(Participante participan:todosLosParticipantes) {
			nombres[i++]=participan.getNombre();
 		}
		JComboBox<String> comboBoxParticipante = new JComboBox<>(nombres);
		comboBoxParticipante.setSelectedItem(null);
		comboBoxParticipante.setBounds(143, 115, 158, 22);
		contentPane.add(comboBoxParticipante);
		
 		String[]datosPartidos=new String[partidos.size()];
 		i=0;
 		for(Partido partido:partidos) {
 			datosPartidos[i++]=partido.getEquipo1().getNombre()+"/"+partido.getEquipo2().getNombre();
 		}
 		
 		
		JComboBox<String> comboBoxPartido = new JComboBox<>(datosPartidos);
		comboBoxPartido.setSelectedItem(null);		
		comboBoxPartido.setBounds(143, 159, 158, 22);
		contentPane.add(comboBoxPartido);
		
		JComboBox<String> comboBoxEquipo = new JComboBox<>();
		//String equiposSeleccionados=" / ";
 		comboBoxPartido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	comboBoxEquipo.removeAllItems();
            	comboBoxEquipo.setSelectedItem(null);

            	System.out.println("BANDERA: "+comboBoxPartido.getSelectedItem());
                
            	String equipos= (String) comboBoxPartido.getSelectedItem();
                String[]equipo1_2=new String[2];
                equipo1_2=equipos.split("/");
                comboBoxEquipo.addItem(equipo1_2[0]);
                comboBoxEquipo.addItem(equipo1_2[1]);                
            }
        });
		comboBoxEquipo.setBounds(143, 202, 158, 22);
		contentPane.add(comboBoxEquipo);
		
		BotonAceptar(datosPartidos,comboBoxParticipante,comboBoxEquipo);
	}
	
	/*
	 * Aqui cargaria en la DB los elementos seleccionados
	 * */
	private void BotonAceptar(String[]datosPartidos,JComboBox<String> comboBoxParticipante,JComboBox<String> comboBoxEquipo) {
		
		/*
		JButton btnCargarPronosticoAceptar = new JButton("Aceptar");
		contentPane.add(btnCargarPronosticoAceptar);
		 * */

		JButton btnCargarPronosticoAcepta = new JButton("Aceptar");
		btnCargarPronosticoAcepta.setBounds(217, 326, 180, 23);
		contentPane.add(btnCargarPronosticoAcepta);

		
		btnCargarPronosticoAcepta.addActionListener(new ActionListener() {

		
		
		
			public void actionPerformed(ActionEvent e) {
			ParticipanteDAO nuevoParticipante = new ParticipanteDAO();
			EquipoDAO nuevoEquipo=new EquipoDAO();
			PartidoDAO nuevoPartido=new PartidoDAO(nuevoEquipo); 
			PronosticoDAO nuevoPronostico= new PronosticoDAO(nuevoParticipante,nuevoPartido,nuevoEquipo);
			
			Participante participante=getParticipante((String)comboBoxParticipante.getSelectedItem());
			Partido partido=getPartido(datosPartidos);
			Equipo equipo=getEquipo((String)comboBoxEquipo.getSelectedItem());
			
			Pronostico pronostico= new Pronostico();
			pronostico.setParticipante(participante);
			pronostico.setPartido(partido);
			pronostico.setEquipo(equipo);
			eleccion='P';
			pronostico.setOpcion(eleccion);
			
			System.out.println(pronostico.toString());
			
			nuevoPronostico.insertar(pronostico);
			dispose();
			}
		});
	}
	

	private Participante getParticipante(String nombre) {
		Participante participante=new Participante();
		for(Participante reg:participantes) {
			if(reg.getNombre().equals(nombre)) {
				return reg;
			}
		}
		return participante;
	}

	private Partido getPartido(String[] datosPartidos) {
		Partido partido=new Partido();
		for(Partido reg:partidos) {
			if(reg.getEquipo1().getNombre().equals(datosPartidos[0]) &&
					reg.getEquipo2().getNombre().equals(datosPartidos[1])) {
				return reg;
			}
		}
		return partido;
	}
	
	private Equipo getEquipo(String nombre) {
		Equipo getEquipo=new Equipo();
		for(Equipo reg:equipos) {
			if(reg.getNombre().equals(nombre)) {
			
				System.out.println("BANDERA "+reg.getNombre()+" "+reg.getID());
				
				return reg;
			}
		}
		return getEquipo;
	}


	private void cargarRadioButtons() {
		final ButtonGroup group=new ButtonGroup();
		JRadioButton rdbtnNewRadioButtonGana = new JRadioButton("Gana");
		rdbtnNewRadioButtonGana.setBounds(74, 267, 66, 23);
		
		JRadioButton rdbtnPierde = new JRadioButton("Pierde");
		rdbtnPierde.setBounds(242, 267, 74, 23);
		
		JRadioButton rdbtnEmpata = new JRadioButton("Empata");
		rdbtnEmpata.setBounds(154, 267, 86, 23);

		group.add(rdbtnNewRadioButtonGana);
		group.add(rdbtnPierde);
		group.add(rdbtnEmpata);
		contentPane.add(rdbtnPierde);
		contentPane.add(rdbtnNewRadioButtonGana);
		contentPane.add(rdbtnEmpata);
		
		/*
		JButton btnCargarPronosticoAcepta = new JButton("Aceptar");
		btnCargarPronosticoAcepta.setBounds(217, 326, 180, 23);
		contentPane.add(btnCargarPronosticoAcepta);
		 * */
	}
	public void cerrarPanel() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de cancelar la carga?", "Confirmar Cierre", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
        	dispose();
        }
    }
}
