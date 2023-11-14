package presentacion;

import models.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CargarPronosticos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldParticipante;
	private JTextField textFieldEquipo1;
	private JTextField textFieldEquipo2;

	public CargarPronosticos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);// Centra la ventana

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cargarLbls();
		cargarTextFields();
		cargarRadioButtons();
		cargarBotones();
	}
	
	private void cargarLbls() {
		JLabel lblParticipante = new JLabel("Participante");
		lblParticipante.setBounds(59, 115, 74, 23);
		contentPane.add(lblParticipante);
		
		JLabel lblEquipo_1 = new JLabel("Equipo 1");
		lblEquipo_1.setBounds(59, 159, 74, 23);
		contentPane.add(lblEquipo_1);
		
		JLabel lblEquipo_2 = new JLabel("Equipo 2");
		lblEquipo_2.setBounds(59, 202, 74, 23);
		contentPane.add(lblEquipo_2);
		
		JLabel lblCargarPronostico = new JLabel("Pronostico");
		lblCargarPronostico.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCargarPronostico.setBounds(154, 11, 147, 49);
		contentPane.add(lblCargarPronostico);

	}
	//---------------- CARGAR COMPONENTES ---------------------//
	private void cargarTextFields() {
		textFieldParticipante = new JTextField();
		textFieldParticipante.setBounds(159, 118, 154, 20);
		contentPane.add(textFieldParticipante);
		textFieldParticipante.setColumns(10);
		
		textFieldEquipo1 = new JTextField();
		textFieldEquipo1.setColumns(10);
		textFieldEquipo1.setBounds(159, 162, 154, 20);
		contentPane.add(textFieldEquipo1);
		
		
		textFieldEquipo2 = new JTextField();
		textFieldEquipo2.setColumns(10);
		textFieldEquipo2.setBounds(159, 205, 154, 20);
		contentPane.add(textFieldEquipo2);
	}
	
	private void cargarRadioButtons() {
		JRadioButton rdbtnNewRadioButtonGana1 = new JRadioButton("gana 1");
		rdbtnNewRadioButtonGana1.setBounds(77, 267, 109, 23);
		contentPane.add(rdbtnNewRadioButtonGana1);
		
		JRadioButton rdbtnGana2 = new JRadioButton("gana 2");
		rdbtnGana2.setBounds(188, 267, 109, 23);
		contentPane.add(rdbtnGana2);
		
		JRadioButton rdbtnEmpata = new JRadioButton("Empata");
		rdbtnEmpata.setBounds(304, 267, 109, 23);
		contentPane.add(rdbtnEmpata);
		
	}
	
	private void cargarBotones() {
		JButton btnCargarPronosticoAceptar = new JButton("Aceptar");
		btnCargarPronosticoAceptar.addActionListener(new ActionListener() {
			
			// Evento "Aceptar"
			public void actionPerformed(ActionEvent e) {
				// Cargo los objetos con los datos ingresados en el formulario
				String nombre=textFieldParticipante.getText();
				Equipo e1=new Equipo();
				e1.setNombre(textFieldEquipo1.getText());
				Equipo e2=new Equipo();
				e2.setNombre(textFieldEquipo2.getText());
				/**
				 * debo consultar en la base de datos que ambos equipos
				 * jugaran/jugaron.
				 * si no juegan entonces arrojo exeption
				 * si juegan entonces traigo de la base de datos
				 * y cargo en un objeto partido.
				 * */
				// Partido partido=new Partido( traigo de la DB );
				
				// CREO UNA INSTANCIA DE PARITDO PARA PROBAR:
				Equipo prueba1=new Equipo("Argentina");
				Equipo prueba2=new Equipo("Arabia Saudita");
				//Partido partido=new Partido(prueba1,prueba2,1,2);
				// CREO UNA INSTANCIA DE PRONOSTICO PARA PROBAR:
				//Pronostico pronosticoPrueba=new Pronostico(partido,);
				
				//Emito resultado
				int resultado=0;// pronostico.resultado(equipo);
				String resultadoMensaje="";
				switch(resultado) {
				case 1 : resultadoMensaje="ganado"; break;
				case 0 : resultadoMensaje="empatado"; break;
				case -1: resultadoMensaje="perdido"; break;
				default: break;
				}
				JOptionPane.showMessageDialog(null,nombre+" has "+resultadoMensaje+"!");
			}
		});
		
		btnCargarPronosticoAceptar.setBounds(250, 326, 180, 23);
		contentPane.add(btnCargarPronosticoAceptar);
		
		JButton btnCargarPronosticoCancelar = new JButton("Cancelar");
		btnCargarPronosticoCancelar.setBounds(39, 326, 180, 23);
		contentPane.add(btnCargarPronosticoCancelar);		
	}
	
	
	//---------------------- EVENTOS ------------------------//

}
