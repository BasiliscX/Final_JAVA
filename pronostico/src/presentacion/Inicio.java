package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Point;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mega\\Downloads\\trophy-photo-800x450.jpg"));
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 471);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);// Centra la ventana
		setContentPane(contentPane);
		
		JButton btnAgregarPronosticos = new JButton("Agregar Pronostico");
		btnAgregarPronosticos.setBounds(184, 185, 219, 71);
		btnAgregarPronosticos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargarPronosticos cargarPronosticos = new CargarPronosticos();
				cargarPronosticos.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnAgregarPronosticos.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAgregarPronosticos.setHorizontalTextPosition(SwingConstants.LEADING);
		contentPane.add(btnAgregarPronosticos);
		
		JLabel lblFondoInicio = new JLabel("New label");
		lblFondoInicio.setIcon(new ImageIcon("C:\\Users\\Mega\\Downloads\\trophy-photo-800x450.jpg"));
		lblFondoInicio.setBounds(0, 0, 796, 441);
		contentPane.add(lblFondoInicio);
	}
}
