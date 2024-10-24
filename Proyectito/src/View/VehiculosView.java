package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.Box;
import javax.swing.JTree;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;

@SuppressWarnings("unused")
public class VehiculosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombrePropietario;
	private JTextField textApellidos;
	private JTextField textPlaca;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textLinea;
	private JTextField textSerie;
	private JTextField textCombustible;
	private JTextField textLlantas;
	private JTextField textMotor;
	private JTextField textEjeDir;
	private JTextField textEjeMotriz;
	private JTextField textCapCarga;
	private JTextField textAlto;
	private JTextField textAncho;
	private JTextField textLargo;
	private JTextField textEjeArrastre;
	private JTextField textCilindraje;
	private JTextField textEntidad;
	private JTextField textPlacaAnterior;
	private JTextField textCilindros;
	private JButton btnTarjetaCirculacion;
	private JButton btnEliminar;
	private JButton btnModificar ;
	private JButton btnLimpiar;
	private JButton btnVolver;
	private JButton btnBuscarVehiculo ;
	private JButton btnRegistrar ;
	private JButton btnGenerarPlaca;
	private JComboBox<String> opcModificaciones ;
	private JComboBox<String> opcTipoVehiculo ;
	private JComboBox<String> opcOrigen;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VehiculosView frame = new VehiculosView();
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
	public VehiculosView() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VehiculosView.class.getResource("/view/img/semaforo.png")));
		setTitle("Búsqueda y Registro de Vehículos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Búsqueda y Registro de Vehículos");
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 24));
		lblNewLabel.setBounds(51, 49, 414, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VehiculosView.class.getResource("/view/img/car_logoproject_med.png")));
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 24));
		lblNewLabel_1.setBounds(699, 35, 200, 70);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblDatosDelPropietario = new JLabel("Datos del Propietario");
		lblDatosDelPropietario.setFont(new Font("Poppins", Font.ITALIC, 18));
		lblDatosDelPropietario.setBounds(51, 113, 213, 32);
		contentPane.add(lblDatosDelPropietario);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(192, 192, 192));
		separator.setBounds(51, 155, 825, 2);
		contentPane.add(separator);
		
		JLabel lblNombres = new JLabel("Nombre(s):");
		lblNombres.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblNombres.setBounds(51, 167, 90, 32);
		contentPane.add(lblNombres);
		
		textNombrePropietario = new JTextField();
		lblNombres.setLabelFor(textNombrePropietario);
		textNombrePropietario.setFont(new Font("Poppins", Font.PLAIN, 12));
		textNombrePropietario.setBounds(153, 175, 229, 19);
		contentPane.add(textNombrePropietario);
		textNombrePropietario.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblApellidos.setBounds(412, 167, 90, 32);
		contentPane.add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setFont(new Font("Poppins", Font.PLAIN, 12));
		textApellidos.setColumns(10);
		textApellidos.setBounds(514, 175, 229, 19);
		contentPane.add(textApellidos);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(51, 273, 825, 2);
		contentPane.add(separator_1);
		
		JLabel lblDatosDelVehculo = new JLabel("Datos del Vehículo");
		lblDatosDelVehculo.setFont(new Font("Poppins", Font.ITALIC, 18));
		lblDatosDelVehculo.setBounds(51, 231, 213, 32);
		contentPane.add(lblDatosDelVehculo);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblPlaca.setBounds(51, 295, 90, 32);
		contentPane.add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setFont(new Font("Poppins", Font.PLAIN, 12));
		textPlaca.setColumns(10);
		textPlaca.setBounds(118, 303, 108, 19);
		contentPane.add(textPlaca);
		
		btnGenerarPlaca = new JButton("Generar");
		btnGenerarPlaca.setBorderPainted(false);
		btnGenerarPlaca.setBackground(new Color(255, 255, 255));
		btnGenerarPlaca.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnGenerarPlaca.setBounds(239, 302, 85, 21);
		contentPane.add(btnGenerarPlaca);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblMarca.setBounds(452, 351, 90, 32);
		contentPane.add(lblMarca);
		
		textMarca = new JTextField();
		textMarca.setFont(new Font("Poppins", Font.PLAIN, 12));
		textMarca.setColumns(10);
		textMarca.setBounds(519, 359, 108, 19);
		contentPane.add(textMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblModelo.setBounds(654, 351, 90, 32);
		contentPane.add(lblModelo);
		
		textModelo = new JTextField();
		textModelo.setFont(new Font("Poppins", Font.PLAIN, 12));
		textModelo.setColumns(10);
		textModelo.setBounds(733, 359, 108, 19);
		contentPane.add(textModelo);
		
		JLabel lblLinea = new JLabel("Linea:");
		lblLinea.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblLinea.setBounds(51, 408, 90, 32);
		contentPane.add(lblLinea);
		
		textLinea = new JTextField();
		textLinea.setFont(new Font("Poppins", Font.PLAIN, 12));
		textLinea.setColumns(10);
		textLinea.setBounds(118, 416, 108, 19);
		contentPane.add(textLinea);
		
		JLabel lblSerie = new JLabel("# Serie:");
		lblSerie.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblSerie.setBounds(252, 408, 90, 32);
		contentPane.add(lblSerie);
		
		textSerie = new JTextField();
		textSerie.setFont(new Font("Poppins", Font.PLAIN, 12));
		textSerie.setColumns(10);
		textSerie.setBounds(324, 416, 108, 19);
		contentPane.add(textSerie);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblTipo.setBounds(258, 351, 90, 32);
		contentPane.add(lblTipo);
		
		JLabel lblCombustible = new JLabel("Combustible:");
		lblCombustible.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblCombustible.setBounds(452, 408, 113, 32);
		contentPane.add(lblCombustible);
		
		textCombustible = new JTextField();
		textCombustible.setFont(new Font("Poppins", Font.PLAIN, 12));
		textCombustible.setColumns(10);
		textCombustible.setBounds(566, 416, 108, 19);
		contentPane.add(textCombustible);
		
		JLabel lblLlantas = new JLabel("# Llantas:");
		lblLlantas.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblLlantas.setBounds(697, 408, 113, 32);
		contentPane.add(lblLlantas);
		
		textLlantas = new JTextField();
		textLlantas.setFont(new Font("Poppins", Font.PLAIN, 12));
		textLlantas.setColumns(10);
		textLlantas.setBounds(788, 416, 108, 19);
		contentPane.add(textLlantas);
		
		JLabel lblMotor = new JLabel("# Motor:");
		lblMotor.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblMotor.setBounds(519, 465, 113, 32);
		contentPane.add(lblMotor);
		
		textMotor = new JTextField();
		textMotor.setFont(new Font("Poppins", Font.PLAIN, 12));
		textMotor.setColumns(10);
		textMotor.setBounds(582, 473, 108, 19);
		contentPane.add(textMotor);
		
		JLabel lblMods = new JLabel("Modificaciones:");
		lblMods.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblMods.setBounds(709, 465, 133, 32);
		contentPane.add(lblMods);
		
		opcModificaciones = new JComboBox<>();
		opcModificaciones.setMaximumRowCount(3);
		opcModificaciones.setFont(new Font("Poppins", Font.PLAIN, 12));
		opcModificaciones.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Si", "No"}));
		opcModificaciones.setBounds(852, 472, 47, 21);
		contentPane.add(opcModificaciones);
		
		JLabel lblEjeDir = new JLabel("Eje Dir:");
		lblEjeDir.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblEjeDir.setBounds(212, 465, 65, 32);
		contentPane.add(lblEjeDir);
		
		textEjeDir = new JTextField();
		textEjeDir.setFont(new Font("Poppins", Font.PLAIN, 12));
		textEjeDir.setColumns(10);
		textEjeDir.setBounds(279, 473, 54, 19);
		contentPane.add(textEjeDir);
		
		textEjeMotriz = new JTextField();
		textEjeMotriz.setFont(new Font("Poppins", Font.PLAIN, 12));
		textEjeMotriz.setColumns(10);
		textEjeMotriz.setBounds(448, 473, 54, 19);
		contentPane.add(textEjeMotriz);
		
		JLabel lblEjeMotriz = new JLabel("Eje Motriz:");
		lblEjeMotriz.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblEjeMotriz.setBounds(357, 465, 90, 32);
		contentPane.add(lblEjeMotriz);
		
		opcTipoVehiculo = new JComboBox<>();
		opcTipoVehiculo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Automovil", "Carga", "Moto"}));
		opcTipoVehiculo.setFont(new Font("Poppins", Font.PLAIN, 12));
		opcTipoVehiculo.setBounds(319, 358, 113, 21);
		contentPane.add(opcTipoVehiculo);
		
		JLabel lblCapacidadCarga = new JLabel("Capacidad Carga:");
		lblCapacidadCarga.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblCapacidadCarga.setBounds(458, 569, 156, 32);
		contentPane.add(lblCapacidadCarga);
		
		textCapCarga = new JTextField();
		textCapCarga.setFont(new Font("Poppins", Font.PLAIN, 12));
		textCapCarga.setColumns(10);
		textCapCarga.setBounds(620, 577, 54, 19);
		contentPane.add(textCapCarga);
		
		JLabel lblDimensionAlto = new JLabel("Dimensión Alto:");
		lblDimensionAlto.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblDimensionAlto.setBounds(279, 517, 133, 32);
		contentPane.add(lblDimensionAlto);
		
		textAlto = new JTextField();
		textAlto.setFont(new Font("Poppins", Font.PLAIN, 12));
		textAlto.setColumns(10);
		textAlto.setBounds(419, 525, 54, 19);
		contentPane.add(textAlto);
		
		JLabel lblDimensinAncho = new JLabel("Dimensión Ancho:");
		lblDimensinAncho.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblDimensinAncho.setBounds(51, 517, 156, 32);
		contentPane.add(lblDimensinAncho);
		
		textAncho = new JTextField();
		textAncho.setFont(new Font("Poppins", Font.PLAIN, 12));
		textAncho.setColumns(10);
		textAncho.setBounds(198, 525, 54, 19);
		contentPane.add(textAncho);
		
		JLabel lblDimensionLargo = new JLabel("Dimensión Largo:");
		lblDimensionLargo.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblDimensionLargo.setBounds(500, 517, 156, 32);
		contentPane.add(lblDimensionLargo);
		
		textLargo = new JTextField();
		textLargo.setFont(new Font("Poppins", Font.PLAIN, 12));
		textLargo.setColumns(10);
		textLargo.setBounds(647, 525, 54, 19);
		contentPane.add(textLargo);
		
		JLabel lblEjeArraste = new JLabel("Eje Arraste:");
		lblEjeArraste.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblEjeArraste.setBounds(51, 569, 100, 32);
		contentPane.add(lblEjeArraste);
		
		textEjeArrastre = new JTextField();
		textEjeArrastre.setFont(new Font("Poppins", Font.PLAIN, 12));
		textEjeArrastre.setColumns(10);
		textEjeArrastre.setBounds(156, 577, 54, 19);
		contentPane.add(textEjeArrastre);
		
		JLabel lblCilindraje = new JLabel("# Cilindraje:");
		lblCilindraje.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblCilindraje.setBounds(252, 569, 100, 32);
		contentPane.add(lblCilindraje);
		
		textCilindraje = new JTextField();
		textCilindraje.setFont(new Font("Poppins", Font.PLAIN, 12));
		textCilindraje.setColumns(10);
		textCilindraje.setBounds(357, 577, 54, 19);
		contentPane.add(textCilindraje);
		
		textEntidad = new JTextField();
		textEntidad.setFont(new Font("Poppins", Font.PLAIN, 12));
		textEntidad.setColumns(10);
		textEntidad.setBounds(705, 303, 54, 19);
		contentPane.add(textEntidad);
		
		JLabel lblEntidad = new JLabel("Entidad:");
		lblEntidad.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblEntidad.setBounds(622, 295, 73, 32);
		contentPane.add(lblEntidad);
		
		JLabel lblOrigen = new JLabel("Origen:");
		lblOrigen.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblOrigen.setBounds(51, 351, 90, 32);
		contentPane.add(lblOrigen);
		
		opcOrigen = new JComboBox<>();
		opcOrigen.setMaximumRowCount(3);
		opcOrigen.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Nacional", "Extranjero"}));
		opcOrigen.setFont(new Font("Poppins", Font.PLAIN, 12));
		opcOrigen.setBounds(123, 358, 113, 21);
		contentPane.add(opcOrigen);
		
		btnBuscarVehiculo = new JButton("Buscar");
		btnBuscarVehiculo.setBorderPainted(false);
		btnBuscarVehiculo.setBackground(new Color(255, 255, 255));
		btnBuscarVehiculo.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnBuscarVehiculo.setBounds(506, 625, 139, 32);
		contentPane.add(btnBuscarVehiculo);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(255, 255, 255));
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnRegistrar.setBounds(718, 625, 139, 32);
		contentPane.add(btnRegistrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnModificar.setBorderPainted(false);
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(76, 685, 139, 32);
		contentPane.add(btnModificar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnLimpiar.setBorderPainted(false);
		btnLimpiar.setBackground(Color.WHITE);
		btnLimpiar.setBounds(291, 685, 139, 32);
		contentPane.add(btnLimpiar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnVolver.setBorderPainted(false);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(506, 685, 139, 32);
		contentPane.add(btnVolver);
		
		JLabel lblPlacaAnterior = new JLabel("Placa Anterior:");
		lblPlacaAnterior.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblPlacaAnterior.setBounds(347, 295, 132, 32);
		contentPane.add(lblPlacaAnterior);
		
		textPlacaAnterior = new JTextField();
		textPlacaAnterior.setFont(new Font("Poppins", Font.PLAIN, 12));
		textPlacaAnterior.setColumns(10);
		textPlacaAnterior.setBounds(489, 303, 108, 19);
		contentPane.add(textPlacaAnterior);
		
		JLabel lblCilindros = new JLabel("Cilindros:");
		lblCilindros.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblCilindros.setBounds(51, 465, 100, 32);
		contentPane.add(lblCilindros);
		
		textCilindros = new JTextField();
		textCilindros.setFont(new Font("Poppins", Font.PLAIN, 12));
		textCilindros.setColumns(10);
		textCilindros.setBounds(138, 473, 54, 19);
		contentPane.add(textCilindros);
		
		btnTarjetaCirculacion = new JButton("Generar Tarjeta de Circulación");
		btnTarjetaCirculacion.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnTarjetaCirculacion.setBorderPainted(false);
		btnTarjetaCirculacion.setBackground(Color.WHITE);
		btnTarjetaCirculacion.setBounds(76, 625, 356, 32);
		contentPane.add(btnTarjetaCirculacion);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnEliminar.setBorderPainted(false);
		btnEliminar.setBackground(new Color(185, 0, 0));
		btnEliminar.setBounds(718, 685, 139, 32);
		contentPane.add(btnEliminar);
	}

	public JTextField getTextNombrePropietario() {
		return textNombrePropietario;
	}

	public void setTextNombrePropietario(JTextField textNombrePropietario) {
		this.textNombrePropietario = textNombrePropietario;
	}

	public JTextField getTextApellidos() {
		return textApellidos;
	}

	public void setTextApellidos(JTextField textApellidos) {
		this.textApellidos = textApellidos;
	}

	public JTextField getTextPlaca() {
		return textPlaca;
	}

	public void setTextPlaca(JTextField textPlaca) {
		this.textPlaca = textPlaca;
	}

	public JTextField getTextMarca() {
		return textMarca;
	}

	public void setTextMarca(JTextField textMarca) {
		this.textMarca = textMarca;
	}

	public JTextField getTextModelo() {
		return textModelo;
	}

	public void setTextModelo(JTextField textModelo) {
		this.textModelo = textModelo;
	}

	public JTextField getTextLinea() {
		return textLinea;
	}

	public void setTextLinea(JTextField textLinea) {
		this.textLinea = textLinea;
	}

	public JTextField getTextSerie() {
		return textSerie;
	}

	public void setTextSerie(JTextField textSerie) {
		this.textSerie = textSerie;
	}

	public JTextField getTextCombustible() {
		return textCombustible;
	}

	public void setTextCombustible(JTextField textCombustible) {
		this.textCombustible = textCombustible;
	}

	public JTextField getTextLlantas() {
		return textLlantas;
	}

	public void setTextLlantas(JTextField textLlantas) {
		this.textLlantas = textLlantas;
	}

	public JTextField getTextMotor() {
		return textMotor;
	}

	public void setTextMotor(JTextField textMotor) {
		this.textMotor = textMotor;
	}

	public JTextField getTextEjeDir() {
		return textEjeDir;
	}

	public void setTextEjeDir(JTextField textEjeDir) {
		this.textEjeDir = textEjeDir;
	}

	public JButton getBtnGenerarPlaca() {
		return btnGenerarPlaca;
	}

	public void setBtnGenerarPlaca(JButton btnGenerarPlaca) {
		this.btnGenerarPlaca = btnGenerarPlaca;
	}

	public JTextField getTextEjeMotriz() {
		return textEjeMotriz;
	}

	public void setTextEjeMotriz(JTextField textEjeMotriz) {
		this.textEjeMotriz = textEjeMotriz;
	}

	public JTextField getTextCapCarga() {
		return textCapCarga;
	}

	public void setTextCapCarga(JTextField textCapCarga) {
		this.textCapCarga = textCapCarga;
	}

	public JTextField getTextAlto() {
		return textAlto;
	}

	public void setTextAlto(JTextField textAlto) {
		this.textAlto = textAlto;
	}

	public JTextField getTextAncho() {
		return textAncho;
	}

	public void setTextAncho(JTextField textAncho) {
		this.textAncho = textAncho;
	}

	public JTextField getTextLargo() {
		return textLargo;
	}

	public void setTextLargo(JTextField textLargo) {
		this.textLargo = textLargo;
	}

	public JTextField getTextEjeArrastre() {
		return textEjeArrastre;
	}

	public void setTextEjeArrastre(JTextField textEjeArrastre) {
		this.textEjeArrastre = textEjeArrastre;
	}

	public JTextField getTextCilindraje() {
		return textCilindraje;
	}

	public void setTextCilindraje(JTextField textCilindraje) {
		this.textCilindraje = textCilindraje;
	}

	public JTextField getTextEntidad() {
		return textEntidad;
	}

	public void setTextEntidad(JTextField textEntidad) {
		this.textEntidad = textEntidad;
	}

	public JTextField getTextPlacaAnterior() {
		return textPlacaAnterior;
	}

	public void setTextPlacaAnterior(JTextField textPlacaAnterior) {
		this.textPlacaAnterior = textPlacaAnterior;
	}

	public JTextField getTextCilindros() {
		return textCilindros;
	}

	public void setTextCilindros(JTextField textCilindros) {
		this.textCilindros = textCilindros;
	}

	public JButton getBtnTarjetaCirculacion() {
		return btnTarjetaCirculacion;
	}

	public void setBtnTarjetaCirculacion(JButton btnTarjetaCirculacion) {
		this.btnTarjetaCirculacion = btnTarjetaCirculacion;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(JButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JButton getBtnBuscarVehiculo() {
		return btnBuscarVehiculo;
	}

	public void setBtnBuscarVehiculo(JButton btnBuscarVehiculo) {
		this.btnBuscarVehiculo = btnBuscarVehiculo;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	public JComboBox<String> getOpcModificaciones() {
		return opcModificaciones;
	}

	public void setOpcModificaciones(JComboBox<String> opcModificaciones) {
		this.opcModificaciones = opcModificaciones;
	}

	public JComboBox<String> getOpcTipoVehiculo() {
		return opcTipoVehiculo;
	}

	public void setOpcTipoVehiculo(JComboBox<String> opcTipoVehiculo) {
		this.opcTipoVehiculo = opcTipoVehiculo;
	}

	public JComboBox<String> getOpcOrigen() {
		return opcOrigen;
	}

	public void setOpcOrigen(JComboBox<String> opcOrigen) {
		this.opcOrigen = opcOrigen;
	}

	
}
