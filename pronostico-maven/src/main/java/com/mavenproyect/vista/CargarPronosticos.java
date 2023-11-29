package com.mavenproyect.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mavenproyect.database.ParticipanteDAO;
import com.mavenproyect.model.Equipo;
import com.mavenproyect.model.Participante;
import com.mavenproyect.model.Partido;
import com.mavenproyect.model.Pronostico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class CargarPronosticos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public CargarPronosticos(List<Partido> partidos,List<Equipo> equipos,List<Pronostico> pronosticos) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 423, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);// Centra la ventana

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cargarLbls();
		cargarBotones();
		cargarJComboBox(partidos,pronosticos);
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
		JButton btnCargarPronosticoAceptar = new JButton("Aceptar");
		contentPane.add(btnCargarPronosticoAceptar);
		
		JButton btnCargarPronosticoCancelar = new JButton("Cancelar");
		btnCargarPronosticoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarPanel();
			}
		});
		btnCargarPronosticoCancelar.setBounds(10, 326, 180, 23);
        
		contentPane.add(btnCargarPronosticoCancelar);
		
	}
	private void cargarJComboBox(List<Partido> partidos,List<Pronostico> pronosticos) {
 		
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
		
		String equiposSeleccionados=new String(" / ");

		/*
 		comboBoxPartido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el elemento seleccionado
        		equiposSeleccionados=(String) comboBoxPartido.getSelectedItem();
                // Actualizar la etiqueta con el elemento seleccionado
                label.setText("Elemento seleccionado: " + elementoSeleccionado);
            }
        });
		 * */
 		String[]equipos=new String[2];
 		equipos=equiposSeleccionados.split("/");
		
		
 		JComboBox<String> comboBoxEquipo = new JComboBox<>(equipos);
		comboBoxEquipo.setSelectedItem(null);
		comboBoxEquipo.setBounds(143, 202, 158, 22);
		contentPane.add(comboBoxEquipo);		
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
		
		JButton btnCargarPronosticoAcepta = new JButton("Aceptar");
		btnCargarPronosticoAcepta.setBounds(217, 326, 180, 23);
		contentPane.add(btnCargarPronosticoAcepta);
	}
	public void cerrarPanel() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de cancelar la carga?", "Confirmar Cierre", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
        	dispose();
        }
    }
}
