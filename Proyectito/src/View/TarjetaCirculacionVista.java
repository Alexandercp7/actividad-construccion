package View;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class TarjetaCirculacionVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblFechaExpedicion;
	private JLabel lblFechaVigencia;
	private JLabel lblNombrePropietario;
	private JLabel lblLocalidad;
	private JLabel lblMunicipio;
	private JLabel lblPlacaActual;
	private JLabel lblPlacaAnterior;
	private JLabel lblNumEntidad;
	private JLabel lblOrigen;
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JLabel lblLinea;
	private JLabel lblCombustible;
	private JLabel lblTipoVehiculo;
	private JLabel lblCilindros;
	private JLabel lblCilindraje;
	private JLabel lblCarga;
	private JLabel lblEjeDir;
	private JLabel lblEjeMotriz;
	private JLabel lblEjeArrastre;
	private JLabel lblDimAncho;
	private JLabel lblDimAlto;
	private JLabel lblDimLargo;
	private JLabel lblNumeroMotor;
	private JLabel lblNumeroSerie;
	private JLabel lblFolio;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TarjetaCirculacionVista frame = new TarjetaCirculacionVista();
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
	public TarjetaCirculacionVista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TarjetaCirculacionVista.class.getResource("/View/img/semaforo.png")));
		setTitle("Tarjeta de Circulación");
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1082, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TarjetaCirculacionVista.class.getResource("/View/img/firmita.png")));
		lblNewLabel_1.setBounds(210, 478, 127, 57);
		contentPane.add(lblNewLabel_1);
		
		lblFechaExpedicion = new JLabel("Fecha Expedición");
		lblFechaExpedicion.setForeground(new Color(74, 74, 74));
		lblFechaExpedicion.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblFechaExpedicion.setBounds(201, 147, 136, 26);
		contentPane.add(lblFechaExpedicion);
		
		lblFechaVigencia = new JLabel("Fecha Vigencia");
		lblFechaVigencia.setForeground(new Color(74, 74, 74));
		lblFechaVigencia.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblFechaVigencia.setBounds(520, 147, 136, 26);
		contentPane.add(lblFechaVigencia);
		
		lblNombrePropietario = new JLabel("Nombre Propietario");
		lblNombrePropietario.setForeground(new Color(74, 74, 74));
		lblNombrePropietario.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNombrePropietario.setBounds(90, 236, 461, 26);
		contentPane.add(lblNombrePropietario);
		
		lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setForeground(new Color(74, 74, 74));
		lblLocalidad.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblLocalidad.setBounds(90, 299, 203, 26);
		contentPane.add(lblLocalidad);
		
		lblMunicipio = new JLabel("Municipio");
		lblMunicipio.setForeground(new Color(74, 74, 74));
		lblMunicipio.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblMunicipio.setBounds(333, 299, 203, 26);
		contentPane.add(lblMunicipio);
		
		lblPlacaActual = new JLabel("Placa Actual");
		lblPlacaActual.setForeground(new Color(74, 74, 74));
		lblPlacaActual.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblPlacaActual.setBounds(90, 365, 203, 26);
		contentPane.add(lblPlacaActual);
		
		lblPlacaAnterior = new JLabel("Placa Anterior");
		lblPlacaAnterior.setForeground(new Color(74, 74, 74));
		lblPlacaAnterior.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblPlacaAnterior.setBounds(333, 365, 203, 26);
		contentPane.add(lblPlacaAnterior);
		
		lblNumEntidad = new JLabel("Num Entidad");
		lblNumEntidad.setForeground(new Color(74, 74, 74));
		lblNumEntidad.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNumEntidad.setBounds(90, 429, 203, 26);
		contentPane.add(lblNumEntidad);
		
		lblOrigen = new JLabel("Origen");
		lblOrigen.setForeground(new Color(74, 74, 74));
		lblOrigen.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblOrigen.setBounds(333, 429, 203, 26);
		contentPane.add(lblOrigen);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setForeground(new Color(74, 74, 74));
		lblMarca.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblMarca.setBounds(655, 234, 154, 26);
		contentPane.add(lblMarca);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(new Color(74, 74, 74));
		lblModelo.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblModelo.setBounds(853, 234, 154, 26);
		contentPane.add(lblModelo);
		
		lblLinea = new JLabel("Línea");
		lblLinea.setForeground(new Color(74, 74, 74));
		lblLinea.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblLinea.setBounds(655, 287, 154, 26);
		contentPane.add(lblLinea);
		
		lblCombustible = new JLabel("Combustible");
		lblCombustible.setForeground(new Color(74, 74, 74));
		lblCombustible.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblCombustible.setBounds(853, 287, 154, 26);
		contentPane.add(lblCombustible);
		
		lblTipoVehiculo = new JLabel("Tipo Vehic");
		lblTipoVehiculo.setForeground(new Color(74, 74, 74));
		lblTipoVehiculo.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblTipoVehiculo.setBounds(643, 346, 75, 26);
		contentPane.add(lblTipoVehiculo);
		
		lblCilindros = new JLabel("Cilindros");
		lblCilindros.setForeground(new Color(74, 74, 74));
		lblCilindros.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblCilindros.setBounds(739, 346, 75, 26);
		contentPane.add(lblCilindros);
		
		lblCilindraje = new JLabel("Cilindraje");
		lblCilindraje.setForeground(new Color(74, 74, 74));
		lblCilindraje.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblCilindraje.setBounds(839, 346, 75, 26);
		contentPane.add(lblCilindraje);
		
		lblCarga = new JLabel("Carga");
		lblCarga.setForeground(new Color(74, 74, 74));
		lblCarga.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblCarga.setBounds(939, 346, 75, 26);
		contentPane.add(lblCarga);
		
		lblEjeDir = new JLabel("Eje Dir");
		lblEjeDir.setForeground(new Color(74, 74, 74));
		lblEjeDir.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblEjeDir.setBounds(643, 401, 75, 26);
		contentPane.add(lblEjeDir);
		
		lblEjeMotriz = new JLabel("Eje Motriz");
		lblEjeMotriz.setForeground(new Color(74, 74, 74));
		lblEjeMotriz.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblEjeMotriz.setBounds(772, 401, 75, 26);
		contentPane.add(lblEjeMotriz);
		
		lblEjeArrastre = new JLabel("Eje Arrastre");
		lblEjeArrastre.setForeground(new Color(74, 74, 74));
		lblEjeArrastre.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblEjeArrastre.setBounds(906, 401, 101, 26);
		contentPane.add(lblEjeArrastre);
		
		lblDimAncho = new JLabel("Dim Ancho");
		lblDimAncho.setForeground(new Color(74, 74, 74));
		lblDimAncho.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblDimAncho.setBounds(643, 460, 101, 26);
		contentPane.add(lblDimAncho);
		
		lblDimAlto = new JLabel("Dim Alto");
		lblDimAlto.setForeground(new Color(74, 74, 74));
		lblDimAlto.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblDimAlto.setBounds(772, 460, 101, 26);
		contentPane.add(lblDimAlto);
		
		lblDimLargo = new JLabel("Dim Largo");
		lblDimLargo.setForeground(new Color(74, 74, 74));
		lblDimLargo.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblDimLargo.setBounds(906, 460, 101, 26);
		contentPane.add(lblDimLargo);
		
		lblNumeroMotor = new JLabel("Numero Motor");
		lblNumeroMotor.setForeground(new Color(74, 74, 74));
		lblNumeroMotor.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNumeroMotor.setBounds(839, 509, 166, 26);
		contentPane.add(lblNumeroMotor);
		
		lblNumeroSerie = new JLabel("Numero Serie");
		lblNumeroSerie.setForeground(new Color(74, 74, 74));
		lblNumeroSerie.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNumeroSerie.setBounds(643, 509, 166, 26);
		contentPane.add(lblNumeroSerie);
		
		lblFolio = new JLabel("Folio");
		lblFolio.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFolio.setForeground(new Color(74, 74, 74));
		lblFolio.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblFolio.setBounds(815, 67, 50, 26);
		contentPane.add(lblFolio);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 5, 1058, 553);
		lblNewLabel.setIcon(new ImageIcon(TarjetaCirculacionVista.class.getResource("/View/img/TarjCirculacion.png")));
		contentPane.add(lblNewLabel);
	}

	public JLabel getLblFechaExpedicion() {
		return lblFechaExpedicion;
	}

	public void setLblFechaExpedicion(JLabel lblFechaExpedicion) {
		this.lblFechaExpedicion = lblFechaExpedicion;
	}

	public JLabel getLblFechaVigencia() {
		return lblFechaVigencia;
	}

	public void setLblFechaVigencia(JLabel lblFechaVigencia) {
		this.lblFechaVigencia = lblFechaVigencia;
	}

	public JLabel getLblNombrePropietario() {
		return lblNombrePropietario;
	}

	public void setLblNombrePropietario(JLabel lblNombrePropietario) {
		this.lblNombrePropietario = lblNombrePropietario;
	}

	public JLabel getLblLocalidad() {
		return lblLocalidad;
	}

	public void setLblLocalidad(JLabel lblLocalidad) {
		this.lblLocalidad = lblLocalidad;
	}

	public JLabel getLblMunicipio() {
		return lblMunicipio;
	}

	public void setLblMunicipio(JLabel lblMunicipio) {
		this.lblMunicipio = lblMunicipio;
	}

	public JLabel getLblPlacaActual() {
		return lblPlacaActual;
	}

	public void setLblPlacaActual(JLabel lblPlacaActual) {
		this.lblPlacaActual = lblPlacaActual;
	}

	public JLabel getLblPlacaAnterior() {
		return lblPlacaAnterior;
	}

	public void setLblPlacaAnterior(JLabel lblPlacaAnterior) {
		this.lblPlacaAnterior = lblPlacaAnterior;
	}

	public JLabel getLblNumEntidad() {
		return lblNumEntidad;
	}

	public void setLblNumEntidad(JLabel lblNumEntidad) {
		this.lblNumEntidad = lblNumEntidad;
	}

	public JLabel getLblOrigen() {
		return lblOrigen;
	}

	public void setLblOrigen(JLabel lblOrigen) {
		this.lblOrigen = lblOrigen;
	}

	public JLabel getLblMarca() {
		return lblMarca;
	}

	public void setLblMarca(JLabel lblMarca) {
		this.lblMarca = lblMarca;
	}

	public JLabel getLblModelo() {
		return lblModelo;
	}

	public void setLblModelo(JLabel lblModelo) {
		this.lblModelo = lblModelo;
	}

	public JLabel getLblLinea() {
		return lblLinea;
	}

	public void setLblLinea(JLabel lblLinea) {
		this.lblLinea = lblLinea;
	}

	public JLabel getLblCombustible() {
		return lblCombustible;
	}

	public void setLblCombustible(JLabel lblCombustible) {
		this.lblCombustible = lblCombustible;
	}

	public JLabel getLblTipoVehiculo() {
		return lblTipoVehiculo;
	}

	public void setLblTipoVehiculo(JLabel lblTipoVehiculo) {
		this.lblTipoVehiculo = lblTipoVehiculo;
	}

	public JLabel getLblCilindros() {
		return lblCilindros;
	}

	public void setLblCilindros(JLabel lblCilindros) {
		this.lblCilindros = lblCilindros;
	}

	public JLabel getLblCilindraje() {
		return lblCilindraje;
	}

	public void setLblCilindraje(JLabel lblCilindraje) {
		this.lblCilindraje = lblCilindraje;
	}

	public JLabel getLblCarga() {
		return lblCarga;
	}

	public void setLblCarga(JLabel lblCarga) {
		this.lblCarga = lblCarga;
	}

	public JLabel getLblEjeDir() {
		return lblEjeDir;
	}

	public void setLblEjeDir(JLabel lblEjeDir) {
		this.lblEjeDir = lblEjeDir;
	}

	public JLabel getLblEjeMotriz() {
		return lblEjeMotriz;
	}

	public void setLblEjeMotriz(JLabel lblEjeMotriz) {
		this.lblEjeMotriz = lblEjeMotriz;
	}

	public JLabel getLblEjeArrastre() {
		return lblEjeArrastre;
	}

	public void setLblEjeArrastre(JLabel lblEjeArrastre) {
		this.lblEjeArrastre = lblEjeArrastre;
	}

	public JLabel getLblDimAncho() {
		return lblDimAncho;
	}

	public void setLblDimAncho(JLabel lblDimAncho) {
		this.lblDimAncho = lblDimAncho;
	}

	public JLabel getLblDimAlto() {
		return lblDimAlto;
	}

	public void setLblDimAlto(JLabel lblDimAlto) {
		this.lblDimAlto = lblDimAlto;
	}

	public JLabel getLblDimLargo() {
		return lblDimLargo;
	}

	public void setLblDimLargo(JLabel lblDimLargo) {
		this.lblDimLargo = lblDimLargo;
	}

	public JLabel getLblNumeroMotor() {
		return lblNumeroMotor;
	}

	public void setLblNumeroMotor(JLabel lblNumeroMotor) {
		this.lblNumeroMotor = lblNumeroMotor;
	}

	public JLabel getLblNumeroSerie() {
		return lblNumeroSerie;
	}

	public void setLblNumeroSerie(JLabel lblNumeroSerie) {
		this.lblNumeroSerie = lblNumeroSerie;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public JLabel getLblFolio() {
		return lblFolio;
	}

	public void setLblFolio(JLabel lblFolio) {
		this.lblFolio = lblFolio;
	}
}
