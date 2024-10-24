package View;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UsuariosVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombreUsr;
	private JTextField textApellidoUsr;
	private JTextField textCargo;
	private JTextField textUsuario;
	private JTextField textFieldContraseña;
	
	private JButton btnEliminar;
	private JButton btnVolver;
	private JButton btnLimpiar;
	private JButton btnRegistrar;
	private JButton btnBuscarUsuario;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuariosVista frame = new UsuariosVista();
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
	public UsuariosVista() {
		setTitle("Búsqueda y Registro de Usuarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UsuariosVista.class.getResource("/view/img/semaforo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblBsquedaYRegistro = new JLabel("Búsqueda y Registro de Usuarios");
		lblBsquedaYRegistro.setFont(new Font("Poppins", Font.BOLD, 24));
		lblBsquedaYRegistro.setBounds(44, 61, 414, 42);
		contentPane.add(lblBsquedaYRegistro);
		
		JLabel lblDatosDelUsuario = new JLabel("Datos Personales del Usuario");
		lblDatosDelUsuario.setFont(new Font("Poppins", Font.ITALIC, 18));
		lblDatosDelUsuario.setBounds(44, 125, 354, 32);
		contentPane.add(lblDatosDelUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(UsuariosVista.class.getResource("/view/img/car_logoproject_med.png")));
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 24));
		lblNewLabel_1.setBounds(692, 47, 200, 70);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(44, 173, 825, 2);
		contentPane.add(separator);
		
		JLabel lblNombres = new JLabel("Nombre(s):");
		lblNombres.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblNombres.setBounds(44, 212, 90, 32);
		contentPane.add(lblNombres);
		
		textNombreUsr = new JTextField();
		textNombreUsr.setFont(new Font("Poppins", Font.PLAIN, 12));
		textNombreUsr.setColumns(10);
		textNombreUsr.setBounds(146, 220, 229, 19);
		contentPane.add(textNombreUsr);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblApellidos.setBounds(405, 212, 90, 32);
		contentPane.add(lblApellidos);
		
		textApellidoUsr = new JTextField();
		textApellidoUsr.setFont(new Font("Poppins", Font.PLAIN, 12));
		textApellidoUsr.setColumns(10);
		textApellidoUsr.setBounds(507, 220, 229, 19);
		contentPane.add(textApellidoUsr);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblCargo.setBounds(44, 272, 90, 32);
		contentPane.add(lblCargo);
		
		textCargo = new JTextField();
		textCargo.setFont(new Font("Poppins", Font.PLAIN, 12));
		textCargo.setColumns(10);
		textCargo.setBounds(146, 280, 229, 19);
		contentPane.add(textCargo);
		
		JLabel lblDatosDeAcceso = new JLabel("Datos de Acceso");
		lblDatosDeAcceso.setFont(new Font("Poppins", Font.ITALIC, 18));
		lblDatosDeAcceso.setBounds(44, 354, 354, 32);
		contentPane.add(lblDatosDeAcceso);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(44, 402, 825, 2);
		contentPane.add(separator_1);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblUsuario.setBounds(44, 439, 90, 32);
		contentPane.add(lblUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Poppins", Font.PLAIN, 12));
		textUsuario.setColumns(10);
		textUsuario.setBounds(133, 447, 114, 19);
		contentPane.add(textUsuario);
		
		JLabel lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblContrasena.setBounds(277, 439, 106, 32);
		contentPane.add(lblContrasena);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldContraseña.setColumns(10);
		textFieldContraseña.setBounds(403, 447, 114, 19);
		contentPane.add(textFieldContraseña);
		
		btnBuscarUsuario = new JButton("Buscar");
		btnBuscarUsuario.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnBuscarUsuario.setBorderPainted(false);
		btnBuscarUsuario.setBackground(Color.WHITE);
		btnBuscarUsuario.setBounds(730, 439, 139, 32);
		contentPane.add(btnBuscarUsuario);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setBounds(570, 439, 139, 32);
		contentPane.add(btnRegistrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnLimpiar.setBorderPainted(false);
		btnLimpiar.setBackground(Color.WHITE);
		btnLimpiar.setBounds(167, 533, 139, 32);
		contentPane.add(btnLimpiar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnVolver.setBorderPainted(false);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(382, 533, 139, 32);
		contentPane.add(btnVolver);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnEliminar.setBorderPainted(false);
		btnEliminar.setBackground(new Color(185, 0, 0));
		btnEliminar.setBounds(597, 533, 139, 32);
		contentPane.add(btnEliminar);
	}
	
	public JTextField getTextNombreUsr() {
		return textNombreUsr;
	}

	public void setTextNombreUsr(JTextField textNombreUsr) {
		this.textNombreUsr = textNombreUsr;
	}

	public JTextField getTextApellidoUsr() {
		return textApellidoUsr;
	}

	public void setTextApellidoUsr(JTextField textApellidoUsr) {
		this.textApellidoUsr = textApellidoUsr;
	}

	public JTextField getTextCargo() {
		return textCargo;
	}

	public void setTextCargo(JTextField textCargo) {
		this.textCargo = textCargo;
	}

	public JTextField getTextUsuario() {
		return textUsuario;
	}

	public void setTextUsuario(JTextField textUsuario) {
		this.textUsuario = textUsuario;
	}

	public JTextField getTextFieldContraseña() {
		return textFieldContraseña;
	}

	public void setTextFieldContraseña(JTextField textField) {
		this.textFieldContraseña = textField;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(JButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	public JButton getBtnBuscarUsuario() {
		return btnBuscarUsuario;
	}

	public void setBtnBuscarUsuario(JButton btnBuscarUsuario) {
		this.btnBuscarUsuario = btnBuscarUsuario;
	}
}
