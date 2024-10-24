package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import DAO.PropietariosDAO;
import DAO.TarjetaCirculacionDAO;
import DAO.VehiculoDAO;
import View.TarjetaCirculacionVista;
import View.VehiculosView;
import model.Automovil;
import model.Motocicleta;
import model.Propietario;
import model.TarjetaCirculacion;
import model.Vehiculo;
import model.VehiculosDeCarga;

public class VehiculoControl implements ActionListener {
	private VehiculosView vehView;
	private Motocicleta motoModel;
	private Automovil autoModel;
	private VehiculosDeCarga cargaModel;
	private TarjetaCirculacion tarModel = new TarjetaCirculacion();
	VehiculoDAO vehicleDAO = new VehiculoDAO();
	PropietariosDAO propDAO = new PropietariosDAO();
	TarjetaCirculacionDAO tarDAO = new TarjetaCirculacionDAO();

	public VehiculoControl(VehiculosView vehView, Motocicleta motoModel, Automovil autoModel,
			VehiculosDeCarga cargaModel) {
		this.vehView = vehView;
		this.motoModel = motoModel;
		this.autoModel = autoModel;
		this.cargaModel = cargaModel;

		this.vehView.getBtnBuscarVehiculo().addActionListener(this);
		this.vehView.getBtnEliminar().addActionListener(this);
		this.vehView.getBtnLimpiar().addActionListener(this);
		this.vehView.getBtnModificar().addActionListener(this);
		this.vehView.getBtnRegistrar().addActionListener(this);
		this.vehView.getBtnTarjetaCirculacion().addActionListener(this);
		this.vehView.getBtnVolver().addActionListener(this);
		this.vehView.getBtnGenerarPlaca().addActionListener(this);

	}

	public void showVehicleMenu() {
		this.vehView.setVisible(true);
	}

	public void HideVehicleMenu() {
		this.vehView.getTextAlto().setText("");
		this.vehView.getTextAncho().setText("");
		this.vehView.getTextApellidos().setText("");
		this.vehView.getTextCapCarga().setText("");
		this.vehView.getTextCilindraje().setText("");
		this.vehView.getTextCilindros().setText("");
		this.vehView.getTextCombustible().setText("");
		this.vehView.getTextEjeArrastre().setText("");
		this.vehView.getTextEjeDir().setText("");
		this.vehView.getTextEjeMotriz().setText("");
		this.vehView.getTextEntidad().setText("");
		this.vehView.getTextLargo().setText("");
		this.vehView.getTextLinea().setText("");
		this.vehView.getTextSerie().setText("");
		this.vehView.getTextLlantas().setText("");
		this.vehView.getTextMarca().setText("");
		this.vehView.getTextModelo().setText("");
		this.vehView.getTextMotor().setText("");
		this.vehView.getTextNombrePropietario().setText("");
		this.vehView.getTextPlaca().setText("");
		this.vehView.getTextPlacaAnterior().setText("");
		this.vehView.getOpcModificaciones().setSelectedItem("");
		;
		this.vehView.getOpcOrigen().setSelectedItem("");
		this.vehView.getOpcTipoVehiculo().setSelectedItem("");
		this.vehView.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.vehView.getBtnGenerarPlaca() == e.getSource()) {
			String newPlaca = Vehiculo.placaNueva();
			this.vehView.getTextPlaca().setText(newPlaca);
		}

		if (this.vehView.getBtnBuscarVehiculo() == e.getSource()) {

			String placa = this.vehView.getTextPlaca().getText();
			String serie = this.vehView.getTextSerie().getText();
			Vehiculo vehiculo = vehicleDAO.getFromCSV("Placa", placa, "#Serie", serie);

			if (vehiculo == null) {
				UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
	        	UIManager.put("Button.background", Color.WHITE);
	            JOptionPane.showMessageDialog(null, "Vehiculo o Propietario no valido", "Datos Incorrectos", JOptionPane.PLAIN_MESSAGE);
			}
			if (vehiculo instanceof Automovil) {
				String cilindros = vehiculo.getCilindros();
				String entidad = vehiculo.getEntidad();
				String linea = vehiculo.getLinea();
				String marca = vehiculo.getMarca();
				String modelo = vehiculo.getModelo();
				String modificaciones = vehiculo.getModificaciones();
				String numeroDeLlantas = vehiculo.getNumeroDeLlantas();
				String numMotor = vehiculo.getNumMotor();
				String numSerie = vehiculo.getNumSerie();
				String origen = vehiculo.getOrigen();
				String placaActual = vehiculo.getPlacaActual();
				String placaAnterior = vehiculo.getPlacaAnterior();
				String apellidosPropietario = vehiculo.getPropietario().getApellidos();
				String nombresPropietario = vehiculo.getPropietario().getNombres();
				String tipoCombustible = vehiculo.getTipoCombustible();
				String tipoVehiculo = vehiculo.getTipoVehiculo();
				String EjeMotriz = ((Automovil) vehiculo).getEjeMotriz();
				String EjeDir = ((Automovil) vehiculo).getEjeDir();

				this.vehView.getTextApellidos().setText(apellidosPropietario);
				this.vehView.getTextCapCarga().setText("");
				this.vehView.getTextCilindraje().setText("");
				this.vehView.getTextCilindros().setText(cilindros);
				this.vehView.getTextCombustible().setText(tipoCombustible);
				this.vehView.getTextEjeArrastre().setText("");
				this.vehView.getTextEjeDir().setText(EjeDir);
				this.vehView.getTextEjeMotriz().setText(EjeMotriz);
				this.vehView.getTextEntidad().setText(entidad);
				this.vehView.getTextLargo().setText("");
				this.vehView.getTextLinea().setText(linea);
				this.vehView.getTextSerie().setText(numSerie);
				this.vehView.getTextLlantas().setText(numeroDeLlantas);
				this.vehView.getTextMarca().setText(marca);
				this.vehView.getTextModelo().setText(modelo);
				this.vehView.getTextMotor().setText(numMotor);
				this.vehView.getTextNombrePropietario().setText(nombresPropietario);
				this.vehView.getTextPlaca().setText(placaActual);
				this.vehView.getTextPlacaAnterior().setText(placaAnterior);
				this.vehView.getOpcModificaciones().setSelectedItem(modificaciones);
				this.vehView.getOpcOrigen().setSelectedItem(origen);
				this.vehView.getOpcTipoVehiculo().setSelectedItem(tipoVehiculo);
			}
			if (vehiculo instanceof VehiculosDeCarga) {

				String cilindros = vehiculo.getCilindros();
				String entidad = vehiculo.getEntidad();
				String linea = vehiculo.getLinea();
				String marca = vehiculo.getMarca();
				String modelo = vehiculo.getModelo();
				String modificaciones = vehiculo.getModificaciones();
				String numeroDeLlantas = vehiculo.getNumeroDeLlantas();
				String numMotor = vehiculo.getNumMotor();
				String numSerie = vehiculo.getNumSerie();
				String origen = vehiculo.getOrigen();
				String placaActual = vehiculo.getPlacaActual();
				String placaAnterior = vehiculo.getPlacaAnterior();
				String apellidosPropietario = vehiculo.getPropietario().getApellidos();
				String nombresPropietario = vehiculo.getPropietario().getNombres();
				String tipoCombustible = vehiculo.getTipoCombustible();
				String tipoVehiculo = vehiculo.getTipoVehiculo();
				String ejeMotriz = ((VehiculosDeCarga) vehiculo).getEjeMotriz();
				String ejeDir = ((VehiculosDeCarga) vehiculo).getEjeDir();
				String ejeArr = ((VehiculosDeCarga) vehiculo).getEjeArrastre();
				String capCarga = ((VehiculosDeCarga) vehiculo).getCapacidadCarga();
				String ancho = ((VehiculosDeCarga) vehiculo).getDimAncho();
				String largo = ((VehiculosDeCarga) vehiculo).getDimLargo();
				String alto = ((VehiculosDeCarga) vehiculo).getDimAlto();

				this.vehView.getTextAlto().setText(alto);
				this.vehView.getTextAncho().setText(ancho);
				this.vehView.getTextApellidos().setText(apellidosPropietario);
				this.vehView.getTextCapCarga().setText(capCarga);
				this.vehView.getTextCilindraje().setText("");
				this.vehView.getTextCilindros().setText(cilindros);
				this.vehView.getTextCombustible().setText(tipoCombustible);
				this.vehView.getTextEjeArrastre().setText(ejeArr);
				this.vehView.getTextEjeDir().setText(ejeDir);
				this.vehView.getTextEjeMotriz().setText(ejeMotriz);
				this.vehView.getTextEntidad().setText(entidad);
				this.vehView.getTextLargo().setText(largo);
				this.vehView.getTextLinea().setText(linea);
				this.vehView.getTextSerie().setText(numSerie);
				this.vehView.getTextLlantas().setText(numeroDeLlantas);
				this.vehView.getTextMarca().setText(marca);
				this.vehView.getTextModelo().setText(modelo);
				this.vehView.getTextMotor().setText(numMotor);
				this.vehView.getTextNombrePropietario().setText(nombresPropietario);
				this.vehView.getTextPlaca().setText(placaActual);
				this.vehView.getTextPlacaAnterior().setText(placaAnterior);
				this.vehView.getOpcModificaciones().setSelectedItem(modificaciones);
				this.vehView.getOpcOrigen().setSelectedItem(origen);
				this.vehView.getOpcTipoVehiculo().setSelectedItem(tipoVehiculo);

			}
			if (vehiculo instanceof Motocicleta) {
				String cilindros = vehiculo.getCilindros();
				String entidad = vehiculo.getEntidad();
				String linea = vehiculo.getLinea();
				String marca = vehiculo.getMarca();
				String modelo = vehiculo.getModelo();
				String modificaciones = vehiculo.getModificaciones();
				String numeroDeLlantas = vehiculo.getNumeroDeLlantas();
				String numMotor = vehiculo.getNumMotor();
				String numSerie = vehiculo.getNumSerie();
				String origen = vehiculo.getOrigen();
				String placaActual = vehiculo.getPlacaActual();
				String placaAnterior = vehiculo.getPlacaAnterior();
				String apellidosPropietario = vehiculo.getPropietario().getApellidos();
				String nombresPropietario = vehiculo.getPropietario().getNombres();
				String tipoCombustible = vehiculo.getTipoCombustible();
				String tipoVehiculo = vehiculo.getTipoVehiculo();
				String cilindraje = ((Motocicleta) vehiculo).getCilindraje();

				this.vehView.getTextAlto().setText("");
				this.vehView.getTextAncho().setText("");
				this.vehView.getTextApellidos().setText(apellidosPropietario);
				this.vehView.getTextCapCarga().setText("");
				this.vehView.getTextCilindraje().setText(cilindraje);
				this.vehView.getTextCilindros().setText(cilindros);
				this.vehView.getTextCombustible().setText(tipoCombustible);
				this.vehView.getTextEjeArrastre().setText("");
				this.vehView.getTextEjeDir().setText("");
				this.vehView.getTextEjeMotriz().setText("");
				this.vehView.getTextEntidad().setText(entidad);
				this.vehView.getTextLargo().setText("");
				this.vehView.getTextLinea().setText(linea);
				this.vehView.getTextSerie().setText(numSerie);
				this.vehView.getTextLlantas().setText(numeroDeLlantas);
				this.vehView.getTextMarca().setText(marca);
				this.vehView.getTextModelo().setText(modelo);
				this.vehView.getTextMotor().setText(numMotor);
				this.vehView.getTextNombrePropietario().setText(nombresPropietario);
				this.vehView.getTextPlaca().setText(placaActual);
				this.vehView.getTextPlacaAnterior().setText(placaAnterior);
				this.vehView.getOpcModificaciones().setSelectedItem(modificaciones);
				this.vehView.getOpcOrigen().setSelectedItem(origen);
				this.vehView.getOpcTipoVehiculo().setSelectedItem(tipoVehiculo);

			}

		}
		if (this.vehView.getBtnEliminar() == e.getSource()) {
			String placa = this.vehView.getTextPlaca().getText();
			String serie = this.vehView.getTextSerie().getText();
			
			
			
			if(vehicleDAO.deleteCSV("Placa", placa, "#Serie", serie) || tarDAO.deleteCSV("Placa Actual", placa, "#Serie", serie)) {
				UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
	        	UIManager.put("Button.background", Color.WHITE);
	            JOptionPane.showMessageDialog(null, "Vehiculo eliminado con éxito.", "Acción Exitosa", JOptionPane.PLAIN_MESSAGE);
			}else {
				UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
	        	UIManager.put("Button.background", Color.WHITE);
	            JOptionPane.showMessageDialog(null, "El vehiculo no se ha borrado exitosamente o no se ha encontrado.", "Error al borrar", JOptionPane.PLAIN_MESSAGE);
			}

			
		}

		if (this.vehView.getBtnLimpiar() == e.getSource()) {
			this.vehView.getTextAlto().setText("");
			this.vehView.getTextAncho().setText("");
			this.vehView.getTextApellidos().setText("");
			this.vehView.getTextCapCarga().setText("");
			this.vehView.getTextCilindraje().setText("");
			this.vehView.getTextCilindros().setText("");
			this.vehView.getTextCilindros().setText("");
			this.vehView.getTextCombustible().setText("");
			this.vehView.getTextEjeArrastre().setText("");
			this.vehView.getTextEjeDir().setText("");
			this.vehView.getTextEjeMotriz().setText("");
			this.vehView.getTextEntidad().setText("");
			this.vehView.getTextLargo().setText("");
			this.vehView.getTextLinea().setText("");
			this.vehView.getTextSerie().setText("");
			this.vehView.getTextLlantas().setText("");
			this.vehView.getTextMarca().setText("");
			this.vehView.getTextModelo().setText("");
			this.vehView.getTextMotor().setText("");
			this.vehView.getTextNombrePropietario().setText("");
			this.vehView.getTextPlaca().setText("");
			this.vehView.getTextPlacaAnterior().setText("");
			this.vehView.getOpcModificaciones().setSelectedItem("");
			;
			this.vehView.getOpcOrigen().setSelectedItem("");
			this.vehView.getOpcTipoVehiculo().setSelectedItem("");
		}
		if (this.vehView.getBtnModificar() == e.getSource()) {
			
			String alto = (this.vehView.getTextAlto().getText());
			String ancho = (this.vehView.getTextAncho().getText());
			String apellidos = this.vehView.getTextApellidos().getText();
			String capCarga = (this.vehView.getTextCapCarga().getText());
			String cilindraje = (this.vehView.getTextCilindraje().getText());
			String numCilindros = (this.vehView.getTextCilindros().getText());
			String tCombustible = this.vehView.getTextCombustible().getText();
			String ejeArr = this.vehView.getTextEjeArrastre().getText();
			String ejeDir = this.vehView.getTextEjeDir().getText();
			String ejeMot = this.vehView.getTextEjeMotriz().getText();
			String entidad = this.vehView.getTextEntidad().getText();
			String largo = (this.vehView.getTextLargo().getText());
			String linea = this.vehView.getTextLinea().getText();
			String serie = this.vehView.getTextSerie().getText();
			String numLlantas = (this.vehView.getTextLlantas().getText());
			String marca = this.vehView.getTextMarca().getText();
			String modelo = this.vehView.getTextModelo().getText();
			String motor = this.vehView.getTextMotor().getText();
			String nombresPropietario = this.vehView.getTextNombrePropietario().getText();
			String placaNueva = this.vehView.getTextPlaca().getText();
			String placaAnterior = this.vehView.getTextPlacaAnterior().getText();
			String mods = (String) this.vehView.getOpcModificaciones().getSelectedItem();
			String origen = (String) this.vehView.getOpcOrigen().getSelectedItem();
			String tipoDeVeh = (String) this.vehView.getOpcTipoVehiculo().getSelectedItem();

			
			Vehiculo vehiculo = vehicleDAO.getFromCSV("#Serie", serie);
			Propietario pro = propDAO.getFromCSV("Apellidos", apellidos, "Nombres", nombresPropietario);
			this.tarModel.setPropietario(pro);

			if (pro == null || vehiculo==null) {
				UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
	        	UIManager.put("Button.background", Color.WHITE);
	            JOptionPane.showMessageDialog(null, "Vehiculo o Propietario no valido", "Datos Incorrectos", JOptionPane.PLAIN_MESSAGE);
			} else {
				if ((String) this.vehView.getOpcTipoVehiculo().getSelectedItem() == "Moto") {
					motoModel = new Motocicleta(pro, placaNueva, marca, numLlantas, modelo, tCombustible, serie, motor,
							mods, linea, tipoDeVeh, numCilindros, cilindraje, entidad, origen, placaAnterior);
					if(vehicleDAO.updateCSV(motoModel)) {
						UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
			        	UIManager.put("Button.background", Color.WHITE);
			            JOptionPane.showMessageDialog(null, "Datos del vehículo actualizados correctamente", "Actualización exitosa", JOptionPane.PLAIN_MESSAGE);
					
					}else {
						UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
			        	UIManager.put("Button.background", Color.WHITE);
			            JOptionPane.showMessageDialog(null, "No se ha podido actualizar los datos del vehículo", "Actualización no exitosa", JOptionPane.PLAIN_MESSAGE);
					}
					this.tarModel.setVehiculo(motoModel);
				} else {
					if ((String) this.vehView.getOpcTipoVehiculo().getSelectedItem() == "Automovil") {
						autoModel = new Automovil(pro, placaNueva, marca, numLlantas, modelo, tCombustible, serie,
								motor, mods, linea, tipoDeVeh, numCilindros, entidad, origen, placaAnterior, ejeMot,
								ejeDir);
						if(vehicleDAO.updateCSV(autoModel)) {
							UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
				        	UIManager.put("Button.background", Color.WHITE);
				            JOptionPane.showMessageDialog(null, "Datos del vehículo actualizados correctamente", "Actualización exitosa", JOptionPane.PLAIN_MESSAGE);
						
						}else{
							UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
				        	UIManager.put("Button.background", Color.WHITE);
				            JOptionPane.showMessageDialog(null, "No se ha podido actualizar los datos del vehículo", "Actualización no exitosa", JOptionPane.PLAIN_MESSAGE);
						
						}
						this.tarModel.setVehiculo(autoModel);
					} else {
						cargaModel = new VehiculosDeCarga(pro, placaNueva, marca, numLlantas, modelo, tCombustible,
								serie, motor, mods, linea, tipoDeVeh, numCilindros, entidad, origen, placaAnterior,
								capCarga, ejeArr, largo, ancho, alto, ejeMot, ejeDir);
						if(vehicleDAO.updateCSV(cargaModel)) {
							UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
				        	UIManager.put("Button.background", Color.WHITE);
				            JOptionPane.showMessageDialog(null, "Datos del vehículo actualizados correctamente", "Actualización exitosa", JOptionPane.PLAIN_MESSAGE);
						
						}else {
							UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
				        	UIManager.put("Button.background", Color.WHITE);
				            JOptionPane.showMessageDialog(null, "No se ha podido actualizar los datos del vehículo", "Actualización no exitosa", JOptionPane.PLAIN_MESSAGE);
						
						}
						this.tarModel.setVehiculo(cargaModel);
					}
				}
			}
			tarDAO.updateCSV(tarModel);
		}

		if (this.vehView.getBtnRegistrar() == e.getSource()) {

			String alto = (this.vehView.getTextAlto().getText());
			String ancho = (this.vehView.getTextAncho().getText());
			String apellidos = this.vehView.getTextApellidos().getText();
			String capCarga = (this.vehView.getTextCapCarga().getText());
			String cilindraje = (this.vehView.getTextCilindraje().getText());
			String numCilindros = (this.vehView.getTextCilindros().getText());
			String tCombustible = this.vehView.getTextCombustible().getText();
			String ejeArr = this.vehView.getTextEjeArrastre().getText();
			String ejeDir = this.vehView.getTextEjeDir().getText();
			String ejeMot = this.vehView.getTextEjeMotriz().getText();
			String entidad = this.vehView.getTextEntidad().getText();
			String largo = (this.vehView.getTextLargo().getText());
			String linea = this.vehView.getTextLinea().getText();
			String serie = this.vehView.getTextSerie().getText();
			String numLlantas = (this.vehView.getTextLlantas().getText());
			String marca = this.vehView.getTextMarca().getText();
			String modelo = this.vehView.getTextModelo().getText();
			String motor = this.vehView.getTextMotor().getText();
			String nombresPropietario = this.vehView.getTextNombrePropietario().getText();
			String placaNueva = this.vehView.getTextPlaca().getText();
			String placaAnterior = this.vehView.getTextPlacaAnterior().getText();
			String mods = (String) this.vehView.getOpcModificaciones().getSelectedItem();
			String origen = (String) this.vehView.getOpcOrigen().getSelectedItem();
			String tipoDeVeh = (String) this.vehView.getOpcTipoVehiculo().getSelectedItem();

			Propietario pro = propDAO.getFromCSV("Apellidos", apellidos, "Nombres", nombresPropietario);
			this.tarModel.setPropietario(pro);
			if (pro == null) {
				UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
	        	UIManager.put("Button.background", Color.WHITE);
	            JOptionPane.showMessageDialog(null, "Vehiculo o Propietario no válido", "Datos Incorrectos", JOptionPane.PLAIN_MESSAGE);
			} else {
				if ((String) this.vehView.getOpcTipoVehiculo().getSelectedItem() == "Moto") {
					motoModel = new Motocicleta(pro, placaNueva, marca, numLlantas, modelo, tCombustible, serie, motor,
							mods, linea, tipoDeVeh, numCilindros, cilindraje, entidad, origen, placaAnterior);
					if(vehicleDAO.insertCSV(motoModel)){
						UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
			        	UIManager.put("Button.background", Color.WHITE);
			            JOptionPane.showMessageDialog(null, "Vehiculo registrado correctamente","Registro exitoso" ,JOptionPane.PLAIN_MESSAGE);
					}else {
						UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
			        	UIManager.put("Button.background", Color.WHITE);
			            JOptionPane.showMessageDialog(null, "El vehículo no se ha registrado correctamente", "Error de Registro", JOptionPane.PLAIN_MESSAGE);
					}
					this.tarModel.setVehiculo(motoModel);
				} else {
					if ((String) this.vehView.getOpcTipoVehiculo().getSelectedItem() == "Automovil") {
						autoModel = new Automovil(pro, placaNueva, marca, numLlantas, modelo, tCombustible, serie,
								motor, mods, linea, tipoDeVeh, numCilindros, entidad, origen, placaAnterior, ejeMot,
								ejeDir);
						
						if(vehicleDAO.insertCSV(autoModel)){
							UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
				        	UIManager.put("Button.background", Color.WHITE);
				            JOptionPane.showMessageDialog(null, "Vehiculo registrado correctamente","Registro exitoso" ,JOptionPane.PLAIN_MESSAGE);
						}else {
							UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
				        	UIManager.put("Button.background", Color.WHITE);
				            JOptionPane.showMessageDialog(null, "El vehículo no se ha registrado correctamente", "Error de Registro", JOptionPane.PLAIN_MESSAGE);
						}
						this.tarModel.setVehiculo(autoModel);
					} else {
						cargaModel = new VehiculosDeCarga(pro, placaNueva, marca, numLlantas, modelo, tCombustible,
								serie, motor, mods, linea, tipoDeVeh, numCilindros, entidad, origen, placaAnterior,
								capCarga, ejeArr, largo, ancho, alto, ejeMot, ejeDir);
						if(vehicleDAO.insertCSV(cargaModel)){
							UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
				        	UIManager.put("Button.background", Color.WHITE);
				            JOptionPane.showMessageDialog(null, "Vehiculo registrado correctamente","Registro exitoso" ,JOptionPane.PLAIN_MESSAGE);
						}else {
							UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
				        	UIManager.put("Button.background", Color.WHITE);
				            JOptionPane.showMessageDialog(null, "El vehículo no se ha registrado correctamente", "Error de Registro", JOptionPane.PLAIN_MESSAGE);
						}
						this.tarModel.setVehiculo(cargaModel);
					}
				}
			}
			tarDAO.insertCSV(tarModel);
		}

		if (this.vehView.getBtnTarjetaCirculacion() == e.getSource()) {

			String placa = this.vehView.getTextPlaca().getText();
			String serie = this.vehView.getTextSerie().getText();
			Vehiculo vehiculo = vehicleDAO.getFromCSV("Placa", placa, "#Serie", serie);
			String nombres = this.vehView.getTextNombrePropietario().getText();
			String apellidos = this.vehView.getTextApellidos().getText();
			Propietario propietario = propDAO.getFromCSV("Apellidos", apellidos, "Nombres", nombres);

			if (propietario != null || vehiculo != null) {
				TarjetaCirculacion tarCir = new TarjetaCirculacion(propietario, vehiculo);
				TarjetaCirculacionVista tarView = new TarjetaCirculacionVista();
				TarjetaCirculacionControl tarCon = new TarjetaCirculacionControl(tarView, tarCir);
				tarCon.showTarjetaView();
			} else {
				UIManager.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
	        	UIManager.put("Button.background", Color.WHITE);
	            JOptionPane.showMessageDialog(null, "Vehiculo o Propietario no válido", "Datos Incorrectos", JOptionPane.PLAIN_MESSAGE);
			}
		}

		if (this.vehView.getBtnVolver() == e.getSource()) {
			RegistroVehicularControl.switchToMainMenu();
		}
	}
}
