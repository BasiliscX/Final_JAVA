package pronostico.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CargarParticipantes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	public CargarParticipantes() {
		setTitle("Cargar participante");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 264, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);// Centra la ventana

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Participante");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(27, 11, 186, 62);
		contentPane.add(lblNewLabel);
		
		JLabel lblParticipanteNombre = new JLabel("Nombre");
		lblParticipanteNombre.setBounds(10, 95, 46, 14);
		contentPane.add(lblParticipanteNombre);
		
		textField = new JTextField();
		textField.setBounds(56, 92, 157, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarPanel();
			}
		});
		btnCancelar.setBounds(10, 138, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(137, 138, 89, 23);
		contentPane.add(btnAceptar);
	}
	public void cerrarPanel() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de cancelar la carga?", "Confirmar Cierre", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
        	dispose();
        }
    }
}
