package control;


import View.TarjetaCirculacionVista;
import model.Automovil;
import model.Motocicleta;
import model.Propietario;
import model.TarjetaCirculacion;
import model.Vehiculo;
import model.VehiculosDeCarga;


public class TarjetaCirculacionControl{
	private TarjetaCirculacionVista tarView;
	private TarjetaCirculacion tarModel = new TarjetaCirculacion();
	private Vehiculo vehiculoModel;
	private Propietario proModel;
	
	public TarjetaCirculacionControl(TarjetaCirculacionVista tarView, TarjetaCirculacion tarModel) {
		
		this.tarView = tarView;
		this.tarModel = tarModel;

		this.proModel = tarModel.getPropietario();
		this.vehiculoModel = tarModel.getVehiculo();
		CrearTarjeta();
		showTarjetaView();
	}
	
	public void showTarjetaView() {
		this.tarView.setVisible(true);
	}
	
	public void CrearTarjeta() {
		
		if(vehiculoModel instanceof Motocicleta) {
			
			this.tarView.getLblFechaExpedicion().setText(this.tarModel.getFechaExpedicion());
			this.tarView.getLblFechaVigencia().setText(this.tarModel.getFechaVigencia());
			this.tarView.getLblFolio().setText(String.valueOf(this.tarModel.getNumFolio()));
			this.tarView.getLblNombrePropietario().setText(proModel.getApellidos()+" "+proModel.getNombres());
			this.tarView.getLblLocalidad().setText(proModel.getLocalidad());
			this.tarView.getLblMunicipio().setText(proModel.getMunicipio());
			this.tarView.getLblPlacaActual().setText(this.vehiculoModel.getPlacaActual());
			this.tarView.getLblPlacaAnterior().setText(this.vehiculoModel.getPlacaAnterior());
			this.tarView.getLblNumEntidad().setText(this.vehiculoModel.getEntidad());
			this.tarView.getLblOrigen().setText(this.vehiculoModel.getOrigen());
			this.tarView.getLblMarca().setText(this.vehiculoModel.getMarca());
			this.tarView.getLblModelo().setText(this.vehiculoModel.getModelo());
			this.tarView.getLblLinea().setText(this.vehiculoModel.getLinea());
			this.tarView.getLblCombustible().setText(this.vehiculoModel.getTipoCombustible());
			this.tarView.getLblTipoVehiculo().setText(this.vehiculoModel.getTipoVehiculo());
			this.tarView.getLblCilindros().setText(this.vehiculoModel.getCilindros());
			this.tarView.getLblCilindraje().setText(((Motocicleta)this.vehiculoModel).getCilindraje());
			this.tarView.getLblCarga().setText("");
			this.tarView.getLblEjeDir().setText("");
			this.tarView.getLblEjeMotriz().setText("");
			this.tarView.getLblEjeArrastre().setText("");
			this.tarView.getLblDimAncho().setText("");
			this.tarView.getLblDimAlto().setText("");
			this.tarView.getLblDimLargo().setText("");
			this.tarView.getLblNumeroSerie().setText(this.vehiculoModel.getNumSerie());
			this.tarView.getLblNumeroMotor().setText(this.vehiculoModel.getNumMotor());
		
		}if(vehiculoModel instanceof VehiculosDeCarga) {
			
			this.tarView.getLblFechaExpedicion().setText(this.tarModel.getFechaExpedicion());
			this.tarView.getLblFechaVigencia().setText(this.tarModel.getFechaVigencia());
			this.tarView.getLblFolio().setText(String.valueOf(this.tarModel.getNumFolio()));
			this.tarView.getLblNombrePropietario().setText(proModel.getApellidos()+" "+proModel.getNombres());
			this.tarView.getLblLocalidad().setText(proModel.getLocalidad());
			this.tarView.getLblMunicipio().setText(proModel.getMunicipio());
			this.tarView.getLblPlacaActual().setText(this.vehiculoModel.getPlacaActual());
			this.tarView.getLblPlacaAnterior().setText(this.vehiculoModel.getPlacaAnterior());
			this.tarView.getLblNumEntidad().setText(this.vehiculoModel.getEntidad());
			this.tarView.getLblOrigen().setText(this.vehiculoModel.getOrigen());
			this.tarView.getLblMarca().setText(this.vehiculoModel.getMarca());
			this.tarView.getLblModelo().setText(this.vehiculoModel.getModelo());
			this.tarView.getLblLinea().setText(this.vehiculoModel.getLinea());
			this.tarView.getLblCombustible().setText(this.vehiculoModel.getTipoCombustible());
			this.tarView.getLblTipoVehiculo().setText(this.vehiculoModel.getTipoVehiculo());
			this.tarView.getLblCilindros().setText(this.vehiculoModel.getCilindros());
			this.tarView.getLblCilindraje().setText("");
			this.tarView.getLblCarga().setText(((VehiculosDeCarga)this.vehiculoModel).getCapacidadCarga());
			this.tarView.getLblEjeDir().setText(((VehiculosDeCarga)this.vehiculoModel).getEjeDir());
			this.tarView.getLblEjeMotriz().setText(((VehiculosDeCarga)this.vehiculoModel).getEjeMotriz());
			this.tarView.getLblEjeArrastre().setText(((VehiculosDeCarga)this.vehiculoModel).getEjeArrastre());
			this.tarView.getLblDimAncho().setText(((VehiculosDeCarga)this.vehiculoModel).getDimAncho());
			this.tarView.getLblDimAlto().setText(((VehiculosDeCarga)this.vehiculoModel).getDimAlto());
			this.tarView.getLblDimLargo().setText(((VehiculosDeCarga)this.vehiculoModel).getDimLargo());
			this.tarView.getLblNumeroSerie().setText(this.vehiculoModel.getNumSerie());
			this.tarView.getLblNumeroMotor().setText(this.vehiculoModel.getNumMotor());
		}
		if(vehiculoModel instanceof Automovil) {	
			this.tarView.getLblFechaExpedicion().setText(this.tarModel.getFechaExpedicion());
			this.tarView.getLblFechaVigencia().setText(this.tarModel.getFechaVigencia());
			this.tarView.getLblFolio().setText(String.valueOf(this.tarModel.getNumFolio()));
			this.tarView.getLblNombrePropietario().setText(proModel.getApellidos()+" "+proModel.getNombres());
			this.tarView.getLblLocalidad().setText(proModel.getLocalidad());
			this.tarView.getLblMunicipio().setText(proModel.getMunicipio());
			this.tarView.getLblPlacaActual().setText(this.vehiculoModel.getPlacaActual());
			this.tarView.getLblPlacaAnterior().setText(this.vehiculoModel.getPlacaAnterior());
			this.tarView.getLblNumEntidad().setText(this.vehiculoModel.getEntidad());
			this.tarView.getLblOrigen().setText(this.vehiculoModel.getOrigen());
			this.tarView.getLblMarca().setText(this.vehiculoModel.getMarca());
			this.tarView.getLblModelo().setText(this.vehiculoModel.getModelo());
			this.tarView.getLblLinea().setText(this.vehiculoModel.getLinea());
			this.tarView.getLblCombustible().setText(this.vehiculoModel.getTipoCombustible());
			this.tarView.getLblTipoVehiculo().setText(this.vehiculoModel.getTipoVehiculo());
			this.tarView.getLblCilindros().setText(this.vehiculoModel.getCilindros());
			this.tarView.getLblCilindraje().setText("");
			this.tarView.getLblCarga().setText("");
			this.tarView.getLblEjeDir().setText(((Automovil)this.vehiculoModel).getEjeDir());
			this.tarView.getLblEjeMotriz().setText(((Automovil)this.vehiculoModel).getEjeMotriz());
			this.tarView.getLblEjeArrastre().setText("");
			this.tarView.getLblDimAncho().setText("");
			this.tarView.getLblDimAlto().setText("");
			this.tarView.getLblDimLargo().setText("");
			this.tarView.getLblNumeroSerie().setText(this.vehiculoModel.getNumSerie());
			this.tarView.getLblNumeroMotor().setText(this.vehiculoModel.getNumMotor());
			
		}
	}
	
}