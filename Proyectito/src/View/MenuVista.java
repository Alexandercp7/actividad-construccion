package View;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCerrarSesion;
	private JButton btnMenuUsuarios;
	private JButton btnMenuPropietarios; 
	private JButton btnMenuVehiculos;
	

	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	public void setBtnCerrarSesion(JButton btnCerrarSesion) {
		this.btnCerrarSesion = btnCerrarSesion;
	}

	public JButton getBtnMenuUsuarios() {
		return btnMenuUsuarios;
	}

	public void setBtnMenuUsuarios(JButton btnMenuUsuarios) {
		this.btnMenuUsuarios = btnMenuUsuarios;
	}

	public JButton getBtnMenuPropietarios() {
		return btnMenuPropietarios;
	}

	public void setBtnMenuPropietarios(JButton btnMenuPropietarios) {
		this.btnMenuPropietarios = btnMenuPropietarios;
	}

	public JButton getBtnMenuVehiculos() {
		return btnMenuVehiculos;
	}

	public void setBtnMenuVehiculos(JButton btnMenuVehiculos) {
		this.btnMenuVehiculos = btnMenuVehiculos;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuVista frame = new MenuVista();
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
	public MenuVista() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuVista.class.getResource("/view/img/semaforo.png")));
		setTitle("Menú Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Menú Principal");
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(365, 115, 197, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Acciones con los Vehículos");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Poppins Medium", Font.ITALIC, 20));
		lblNewLabel_1.setBounds(304, 205, 319, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MenuVista.class.getResource("/view/img/car_logoproject_med.png")));
		lblNewLabel_2.setBounds(56, 58, 197, 65);
		contentPane.add(lblNewLabel_2);
		
		btnMenuVehiculos = new JButton("Busqueda y Registro de Vehículos");
		btnMenuVehiculos.setBorderPainted(false);
		btnMenuVehiculos.setBackground(new Color(255, 255, 255));
		btnMenuVehiculos.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		btnMenuVehiculos.setBounds(315, 252, 297, 43);
		contentPane.add(btnMenuVehiculos);
		
		btnMenuPropietarios = new JButton("Búsqueda y Registro de Propietarios");
		btnMenuPropietarios.setBorderPainted(false);
		btnMenuPropietarios.setBackground(new Color(255, 255, 255));
		btnMenuPropietarios.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		btnMenuPropietarios.setBounds(315, 379, 297, 43);
		contentPane.add(btnMenuPropietarios);
		
		JLabel lblNewLabel_1_1 = new JLabel("Acciones con los Propietarios");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Poppins Medium", Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(310, 332, 306, 37);
		contentPane.add(lblNewLabel_1_1);
		
		btnMenuUsuarios = new JButton("Busqueda y Registro de Usuarios");
		btnMenuUsuarios.setBackground(new Color(255, 255, 255));
		btnMenuUsuarios.setBorderPainted(false);
		btnMenuUsuarios.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		btnMenuUsuarios.setBounds(315, 514, 297, 43);
		contentPane.add(btnMenuUsuarios);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Acciones con los Usuarios");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Poppins Medium", Font.ITALIC, 20));
		lblNewLabel_1_1_1.setBounds(304, 467, 319, 37);
		contentPane.add(lblNewLabel_1_1_1);
		
		btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		btnCerrarSesion.setBorderPainted(false);
		btnCerrarSesion.setBackground(new Color(183, 0, 0));
		btnCerrarSesion.setBounds(748, 37, 148, 31);
		contentPane.add(btnCerrarSesion);
	}
}
