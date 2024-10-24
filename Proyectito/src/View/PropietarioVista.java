package View;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Toolkit;

public class PropietarioVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> opcTipoLicencia;
	private JTextField textNombreProp;
	private JTextField textApellidos;
	private JTextField txtFechaNacimiento;
	private JTextField textContacto;
	private JTextField textLocalidad;
	private JTextField textMunicipio;
	private JTextField textDirección;
	private JButton btnLimpiarProp;
	private JButton btnVolverMenu;
	private JButton btnModificarProp;
	private JButton btnRegistrarProp;
	private JButton btnBuscarProp;
	private JButton btnEliminar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PropietarioVista frame = new PropietarioVista();
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
	public PropietarioVista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PropietarioVista.class.getResource("/View/img/semaforo.png")));
		setTitle("Búsqueda y Registro de Propietarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblBsquedaYRegistro = new JLabel("Búsqueda y Registro de Propietarios");
		lblBsquedaYRegistro.setFont(new Font("Poppins", Font.BOLD, 24));
		lblBsquedaYRegistro.setBounds(41, 38, 495, 42);
		contentPane.add(lblBsquedaYRegistro);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PropietarioVista.class.getResource("/view/img/car_logoproject_med.png")));
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 24));
		lblNewLabel_1.setBounds(680, 38, 200, 70);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblDatosDelPropietario = new JLabel("Datos del Propietario");
		lblDatosDelPropietario.setFont(new Font("Poppins", Font.ITALIC, 18));
		lblDatosDelPropietario.setBounds(41, 141, 213, 32);
		contentPane.add(lblDatosDelPropietario);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(41, 183, 825, 2);
		contentPane.add(separator);
		
		JLabel lblNombres = new JLabel("Nombre(s):");
		lblNombres.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblNombres.setBounds(41, 207, 90, 32);
		contentPane.add(lblNombres);
		
		textNombreProp = new JTextField();
		textNombreProp.setFont(new Font("Poppins", Font.PLAIN, 12));
		textNombreProp.setColumns(10);
		textNombreProp.setBounds(143, 215, 229, 19);
		contentPane.add(textNombreProp);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblApellidos.setBounds(402, 207, 90, 32);
		contentPane.add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setFont(new Font("Poppins", Font.PLAIN, 12));
		textApellidos.setColumns(10);
		textApellidos.setBounds(504, 215, 229, 19);
		contentPane.add(textApellidos);
		
		JLabel lblNombres_1 = new JLabel("Fecha de Nacimiento:");
		lblNombres_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblNombres_1.setBounds(41, 274, 174, 32);
		contentPane.add(lblNombres_1);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setToolTipText("DD/MM/AAAA");
		txtFechaNacimiento.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(240, 282, 132, 19);
		contentPane.add(txtFechaNacimiento);
		
		JLabel lblNombres_1_1 = new JLabel("Contacto:");
		lblNombres_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblNombres_1_1.setBounds(314, 411, 100, 32);
		contentPane.add(lblNombres_1_1);
		
		textContacto = new JTextField();
		textContacto.setToolTipText("");
		textContacto.setFont(new Font("Poppins", Font.PLAIN, 12));
		textContacto.setColumns(10);
		textContacto.setBounds(416, 419, 132, 19);
		contentPane.add(textContacto);
		
		JLabel lblNombres_1_2 = new JLabel("Tipo de Licencia:");
		lblNombres_1_2.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblNombres_1_2.setBounds(402, 274, 174, 32);
		contentPane.add(lblNombres_1_2);
		
		opcTipoLicencia = new JComboBox<>();
		opcTipoLicencia.setFont(new Font("Poppins", Font.PLAIN, 12));
		opcTipoLicencia.setModel(new DefaultComboBoxModel<String>(new String[] {"", "A", "B", "C"}));
		opcTipoLicencia.setBounds(601, 281, 132, 21);
		contentPane.add(opcTipoLicencia);
		
		JLabel lblNombres_1_1_1 = new JLabel("Localidad:");
		lblNombres_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblNombres_1_1_1.setBounds(41, 411, 100, 32);
		contentPane.add(lblNombres_1_1_1);
		
		textLocalidad = new JTextField();
		textLocalidad.setToolTipText("");
		textLocalidad.setFont(new Font("Poppins", Font.PLAIN, 12));
		textLocalidad.setColumns(10);
		textLocalidad.setBounds(143, 419, 132, 19);
		contentPane.add(textLocalidad);
		
		JLabel lblNombres_1_1_1_1 = new JLabel("Municipio:");
		lblNombres_1_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblNombres_1_1_1_1.setBounds(499, 342, 100, 32);
		contentPane.add(lblNombres_1_1_1_1);
		
		textMunicipio = new JTextField();
		textMunicipio.setToolTipText("");
		textMunicipio.setFont(new Font("Poppins", Font.PLAIN, 12));
		textMunicipio.setColumns(10);
		textMunicipio.setBounds(601, 350, 132, 19);
		contentPane.add(textMunicipio);
		
		JLabel lblNombres_1_1_1_1_1 = new JLabel("Dirección:");
		lblNombres_1_1_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblNombres_1_1_1_1_1.setBounds(41, 342, 174, 32);
		contentPane.add(lblNombres_1_1_1_1_1);
		
		textDirección = new JTextField();
		textDirección.setToolTipText("");
		textDirección.setFont(new Font("Poppins", Font.PLAIN, 12));
		textDirección.setColumns(10);
		textDirección.setBounds(143, 350, 321, 19);
		contentPane.add(textDirección);
		
		btnBuscarProp = new JButton("Buscar");
		btnBuscarProp.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnBuscarProp.setBorderPainted(false);
		btnBuscarProp.setBackground(Color.WHITE);
		btnBuscarProp.setBounds(594, 411, 139, 32);
		contentPane.add(btnBuscarProp);
		
		btnRegistrarProp = new JButton("Registrar");
		btnRegistrarProp.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnRegistrarProp.setBorderPainted(false);
		btnRegistrarProp.setBackground(Color.WHITE);
		btnRegistrarProp.setBounds(220, 518, 139, 32);
		contentPane.add(btnRegistrarProp);
		
		btnModificarProp = new JButton("Modificar");
		btnModificarProp.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnModificarProp.setBorderPainted(false);
		btnModificarProp.setBackground(Color.WHITE);
		btnModificarProp.setBounds(399, 518, 139, 32);
		contentPane.add(btnModificarProp);
		
		btnLimpiarProp = new JButton("Limpiar");
		btnLimpiarProp.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnLimpiarProp.setBorderPainted(false);
		btnLimpiarProp.setBackground(Color.WHITE);
		btnLimpiarProp.setBounds(578, 518, 139, 32);
		contentPane.add(btnLimpiarProp);
		
		btnVolverMenu = new JButton("Volver");
		btnVolverMenu.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnVolverMenu.setBorderPainted(false);
		btnVolverMenu.setBackground(Color.WHITE);
		btnVolverMenu.setBounds(757, 518, 139, 32);
		contentPane.add(btnVolverMenu);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnEliminar.setBorderPainted(false);
		btnEliminar.setBackground(new Color(185, 0, 0));
		btnEliminar.setBounds(41, 518, 139, 32);
		contentPane.add(btnEliminar);
	}

	public JTextField getTextNombreProp() {
		return textNombreProp;
	}

	public void setTextNombreProp(JTextField textNombreProp) {
		this.textNombreProp = textNombreProp;
	}

	public JTextField getTextApellidos() {
		return textApellidos;
	}

	public void setTextApellidos(JTextField textApellidos) {
		this.textApellidos = textApellidos;
	}

	public JTextField getTxtFechaNacimiento() {
		return txtFechaNacimiento;
	}

	public void setTxtFechaNacimiento(JTextField txtFechaNacimiento) {
		this.txtFechaNacimiento = txtFechaNacimiento;
	}

	public JTextField getTextContacto() {
		return textContacto;
	}

	public void setTextContacto(JTextField textContacto) {
		this.textContacto = textContacto;
	}

	public JTextField getTextLocalidad() {
		return textLocalidad;
	}

	public void setTextLocalidad(JTextField textLocalidad) {
		this.textLocalidad = textLocalidad;
	}

	public JTextField getTextMunicipio() {
		return textMunicipio;
	}

	public void setTextMunicipio(JTextField textMunicipio) {
		this.textMunicipio = textMunicipio;
	}

	public JTextField getTextDirección() {
		return textDirección;
	}

	public void setTextDirección(JTextField textDirección) {
		this.textDirección = textDirección;
	}

	public JButton getBtnLimpiarProp() {
		return btnLimpiarProp;
	}

	public void setBtnLimpiarProp(JButton btnLimpiarProp) {
		this.btnLimpiarProp = btnLimpiarProp;
	}

	public JButton getBtnVolverMenu() {
		return btnVolverMenu;
	}

	public void setBtnVolverMenu(JButton btnVolverMenu) {
		this.btnVolverMenu = btnVolverMenu;
	}

	public JButton getBtnModificarProp() {
		return btnModificarProp;
	}

	public void setBtnModificarProp(JButton btnModificarProp) {
		this.btnModificarProp = btnModificarProp;
	}

	public JButton getBtnRegistrarProp() {
		return btnRegistrarProp;
	}

	public void setBtnRegistrarProp(JButton btnRegistrarProp) {
		this.btnRegistrarProp = btnRegistrarProp;
	}

	public JButton getBtnBuscarProp() {
		return btnBuscarProp;
	}

	public void setBtnBuscarProp(JButton btnBuscarProp) {
		this.btnBuscarProp = btnBuscarProp;
	}

	public JComboBox<String> getOpcTipoLicencia() {
		return opcTipoLicencia;
	}

	public void setOpcTipoLicencia(JComboBox<String> opcTipoLicencia) {
		this.opcTipoLicencia = opcTipoLicencia;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
	
}